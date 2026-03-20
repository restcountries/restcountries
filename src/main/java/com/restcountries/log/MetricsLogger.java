package com.restcountries.log;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
public class MetricsLogger {

    private final RequestCounter counter;
    private final AtomicLong globalCounter = new AtomicLong(0);

    private final AtomicLong dailyCounter = new AtomicLong(0);
    private LocalDate currentDay = LocalDate.now();

    public MetricsLogger(RequestCounter counter) {
        this.counter = counter;
    }

    @Scheduled(fixedRate = "6h")
    void logStats() {
        long requests = counter.getTotalRequests();

        if (requests == 0) {
            return;
        }

        long totalRequests = globalCounter.addAndGet(requests);
        dailyCounter.addAndGet(requests);

        int windowMinutes = 360;
        double avgRps = requests / (windowMinutes * 60.0);

        LocalDateTime now = LocalDateTime.now();

        writeLine(
                now,
                windowMinutes,
                requests,
                totalRequests,
                avgRps,
                ""
        );

        counter.reset();

        checkDailySummary(now);
    }

    private void checkDailySummary(LocalDateTime now) {
        LocalDate today = now.toLocalDate();

        if (!today.equals(currentDay)) {
            writeDailySummary();
            dailyCounter.set(0);
            currentDay = today;
        }
    }

    private void writeDailySummary() {
        long dailyTotal = dailyCounter.get();

        double avgRps = dailyTotal / 86400.0; // 24h

        LocalDateTime endOfDay = currentDay.atTime(23, 59, 59);

        writeLine(
                endOfDay,
                1440,
                dailyTotal,
                null,
                avgRps,
                "DAILY_SUMMARY"
        );
    }

    private void writeLine(
            LocalDateTime timestamp,
            int windowMinutes,
            Long requests,
            Long totalRequests,
            double avgRps,
            String notes
    ) {
        String line = String.join(",",
                timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                String.valueOf(windowMinutes),
                String.valueOf(requests),
                totalRequests != null ? String.valueOf(totalRequests) : "",
                String.format("%.2f", avgRps),
                notes
        ) + "\n";

        File file = new File("/tmp/request-stats.csv");
        boolean writeHeader = !file.exists();

        try (FileWriter fw = new FileWriter(file, true)) {
            if (writeHeader) {
                fw.write("timestamp,window_minutes,requests,total_requests,avg_rps,notes\n");
            }
            fw.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

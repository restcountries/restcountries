package com.restcountries.log;

import jakarta.inject.Singleton;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
public class RequestCounter {

    private final AtomicLong totalRequests = new AtomicLong(0);
    private final ConcurrentHashMap<String, AtomicLong> endpointCounts = new ConcurrentHashMap<>();

    public void increment(String path) {
        totalRequests.incrementAndGet();
        endpointCounts
                .computeIfAbsent(path, k -> new AtomicLong(0))
                .incrementAndGet();
    }

    public long getTotalRequests() {
        return totalRequests.get();
    }

    public ConcurrentHashMap<String, AtomicLong> getEndpointCounts() {
        return endpointCounts;
    }

    public List<Map.Entry<String, Long>> getTopEndpoints() {
        return endpointCounts.entrySet()
                .stream()
                .map(e -> Map.entry(e.getKey(), e.getValue().get()))
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue())) // DESC
                .toList();
    }

    public void reset() {
        totalRequests.set(0);
        endpointCounts.clear();
    }
}

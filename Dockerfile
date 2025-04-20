FROM maven:3-openjdk-17-slim as build
WORKDIR /
COPY . .
RUN mvn --batch-mode package

FROM openjdk:17-alpine
COPY --from=build target/com.restcountries-*.jar com.restcountries.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "com.restcountries.jar"]
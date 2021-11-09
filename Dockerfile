FROM maven:3-openjdk-17-slim as build
WORKDIR /
COPY . .
RUN mvn --batch-mode package

FROM openjdk:14-alpine
COPY --from=build target/dev.amatos.restcountries-*.jar dev.amatos.restcountries.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "dev.amatos.restcountries.jar"]
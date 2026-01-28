FROM maven:3-openjdk-17-slim as build
WORKDIR /
COPY . .
RUN mvn --batch-mode package

FROM openjdk:17-ea-slim
COPY --from=build target/restcountries-*.jar restcountries.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "restcountries.jar"]
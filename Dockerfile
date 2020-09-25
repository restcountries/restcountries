FROM openjdk:14-alpine
COPY target/dev.amatos.restcountries-*.jar dev.amatos.restcountries.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "dev.amatos.restcountries.jar"]
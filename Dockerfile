FROM openjdk:17-jdk-alpine

COPY target/api-0.0.1-SNAPSHOT.jar api-1.0.0.jar

ENTRYPOINT [ "java", "-jar", "api-0.0.1-SNAPSHOT.jar" ]
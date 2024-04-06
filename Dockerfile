FROM openjdk:21-jdk-slim

COPY target/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar

WORKDIR /app

ENTRYPOINT [ "java", "-jar", "api-0.0.1-SNAPSHOT.jar" ]

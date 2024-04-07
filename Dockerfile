FROM openjdk:21-jdk-slim
COPY target/api-0.0.1-SNAPSHOT.jar api-1.0.0.jar
CMD [ "java", "-jar", "api-1.0.0.jar" ]
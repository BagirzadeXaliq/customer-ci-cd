FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/ms-customer-ci-cd-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
#FROM eclipse-temurin:17-jdk-alpine
#ARG JAR_FILE=build/libs/ms-customer-ci-cd-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#ENV PORT=8080
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM openjdk:17-jdk-slim
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
# Base Image

FROM eclipse-temurin:17-jdk
LABEL maintainer="AT&T sample assignment"
WORKDIR /app
COPY target/ATT-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
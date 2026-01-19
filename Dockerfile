FROM eclipse-temurin:25-jdk-alpine

WORKDIR /app
COPY target/dev-1.0.0.jar app.jar
COPY database.db database.db

ENTRYPOINT ["java","-jar","/app/app.jar"]

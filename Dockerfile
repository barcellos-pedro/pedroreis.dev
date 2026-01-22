# Reference: https://spring.io/guides/gs/spring-boot-docker

# Stage 1: Extract JAR layers for better Docker caching
FROM eclipse-temurin:25-jdk-alpine AS extractor
WORKDIR /extraction
COPY target/dev-1.0.0.jar app.jar
RUN jar xf app.jar

# Stage 2: Runtime image with non-root user
FROM eclipse-temurin:25-jre-alpine

# Add non-root user for security
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

WORKDIR /app

# Copy extracted JAR layers (dependencies layer cached separately)
COPY --from=extractor --chown=spring:spring /extraction/BOOT-INF/lib /app/lib
COPY --from=extractor --chown=spring:spring /extraction/META-INF /app/META-INF
COPY --from=extractor --chown=spring:spring /extraction/BOOT-INF/classes /app/classes

# Copy database file
COPY --chown=spring:spring database.db /app/database.db

ENTRYPOINT ["java","-cp","classes:lib/*","com.pedroreis.dev.WebApplication"]

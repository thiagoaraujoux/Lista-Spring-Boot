FROM eclipse-temurin:21-jdk-jammy AS builder

WORKDIR /app
COPY . .
RUN chmod +x gradlew && ./gradlew build --no-daemon

FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
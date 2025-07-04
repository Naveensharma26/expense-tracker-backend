# ---------- Stage 1: Build the application ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies (cache step)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- Stage 2: Create a lightweight image ----------
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]

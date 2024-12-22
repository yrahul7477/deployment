
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Use a Java runtime as base image
FROM openjdk:17.0.1-jdk-slim

# Copy the Spring Boot application JAR file into the container
COPY --from=build /target/MangalaMuhurtham-0.0.1-SNAPSHOT.jar MangalaMuhurtham

# Expose the port your Spring Boot application uses (e.g., 8080)
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "MangalaMuhurtham-0.0.1-SNAPSHOT.jar"]
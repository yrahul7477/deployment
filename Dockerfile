# Use Maven to build the project
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use a minimal JDK image for the runtime
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/MangalaMuhurtham-0.0.1-SNAPSHOT.jar MangalaMuhurtham.jar

# Expose the port your Spring Boot application uses
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "MangalaMuhurtham.jar"]

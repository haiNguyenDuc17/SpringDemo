# Use a base image with JDK 17
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the target directory
COPY target/SpringDemo-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 80

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
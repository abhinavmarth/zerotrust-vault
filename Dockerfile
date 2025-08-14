# Use official OpenJDK image as base
FROM openjdk:17-jdk-alpine

# Set working directory inside the container
WORKDIR /zerotrust

# Copy the jar file into the container
COPY target/zerotrust-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that Spring Boot will use
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

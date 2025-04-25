# Use JDK 24 as the base image
FROM openjdk:24-jdk

# Set working directory
WORKDIR /app

# Add Spring Boot app
COPY target/thymleafDemo-0.0.1-SNAPSHOT.jar /app.jar

# Expose the app port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "/app.jar"]

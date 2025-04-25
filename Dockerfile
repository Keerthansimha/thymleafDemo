FROM debian:bullseye-slim

# Install dependencies
RUN apt-get update && apt-get install -y tar gzip && rm -rf /var/lib/apt/lists/*

# Add JDK 24
COPY jdk-24_linux-x64_bin.tar.gz /tmp/
RUN mkdir -p /opt/jdk && \
    tar -xzf /tmp/jdk-24_linux-x64_bin.tar.gz -C /opt/jdk && \
    rm /tmp/jdk-24_linux-x64_bin.tar.gz

# Set environment variables
ENV JAVA_HOME=/opt/jdk/jdk-24
ENV PATH="$JAVA_HOME/bin:$PATH"

# Set working dir
WORKDIR /app

# Copy app
COPY target/thymleafDemo-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]

FROM amazonlinux:2023

# Install dependencies
RUN yum install -y tar gzip

# Add JDK 24
COPY jdk-24_linux-x64_bin.tar.gz /tmp/
RUN mkdir -p /opt/jdk && \
    tar -xzf /tmp/jdk-24_linux-x64_bin.tar.gz -C /opt/jdk && \
    rm /tmp/jdk-24_linux-x64_bin.tar.gz

# Set JAVA_HOME and PATH
ENV JAVA_HOME=/opt/jdk/jdk-24
ENV PATH="$JAVA_HOME/bin:$PATH"

# Add Spring Boot app
COPY target/thymleafDemo-0.0.1-SNAPSHOT.jar /app.jar

# Expose the app port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "/app.jar"]

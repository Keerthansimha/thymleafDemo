FROM tomcat:latest

# Copy the WAR file to Tomcat webapps directory
COPY target/thymleafDemo-0.0.1-SNAPSHOT /opt/tomcat/webapps/thymleafDemo-0.0.1-SNAPSHOT

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]

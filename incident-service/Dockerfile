# Use the official JDK image
FROM openjdk:17-jdk-slim

# Folder inside the container
WORKDIR /app

# Copy jar file (You need first to build the jar)
COPY target/incident-service-*.jar app.jar

ARG DEFAULT_PORT=8081

ENV PORT $DEFAULT_PORT

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "app.jar"]

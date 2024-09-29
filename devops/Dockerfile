# Use Eclipse Temurin Java 22 as the base image for the build stage
FROM eclipse-temurin:22-jdk-jammy AS build
WORKDIR /workspace/app

RUN apt-get update && apt-get install -y maven

# Copy the entire project, including all POMs, to the Docker build context
COPY . /workspace/app

# Build the project, ensuring parent POMs are accessible, and skip tests
RUN --mount=type=cache,target=/root/.m2 mvn clean package spring-boot:repackage -DskipTests -X
WORKDIR /workspace/app/devops

COPY target/*.war .
CMD ["java", "-jar", "devops-1.0-SNAPSHOT.war"]
EXPOSE 8083

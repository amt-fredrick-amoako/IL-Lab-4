FROM openjdk:21-jdk-slim AS builder
EXPOSE 8083
ADD labs/target/devops-1.0-SNAPSHOT.war devops-1.0-SNAPSHOT.war
ENTRYPOINT ["java","-jar","devops-1.0-SNAPSHOT.war"]

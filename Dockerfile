FROM openjdk:8-jdk-alpine
MAINTAINER oscar.barahona04@gmail.com
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} VerifyADN-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar", "/VerifyADN-0.0.1-SNAPSHOT.jar" ]
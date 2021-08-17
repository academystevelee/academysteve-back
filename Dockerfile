FROM openjdk:8-jdk-alpine
ADD target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

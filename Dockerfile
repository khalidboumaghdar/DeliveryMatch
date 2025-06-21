FROM openjdk:17-jdk-alpine
COPY target/DeliveryMatch1-0.0.1-SNAPSHOT.jar DeliveryMatch.jar
ENTRYPOINT ["java", "-jar", "/DeliveryMatch.jar"]
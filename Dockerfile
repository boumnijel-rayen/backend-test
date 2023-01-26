FROM openjdk:17-jdk-alpine
ADD target/*.jar myAppli-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","myAppli-0.0.1-SNAPSHOT.jar"]
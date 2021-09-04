FROM openjdk:8-alpine
EXPOSE 8080
ADD target/spring-mongo-docker.jar spring-mongo-docker.jar
ENTRYPOINT ["java" ,"-jar","/spring-mongo-docker.jar"]
FROM openjdk:8
ADD target/spring-boot-ws.jar spring-boot-ws.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-ws.jar"]
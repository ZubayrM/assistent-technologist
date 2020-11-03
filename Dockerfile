FROM openjdk:8
EXPOSE 80
ADD target/dockerspring.jar dockerspring.jar
ENTRYPOINT ["java", "-jar", "/assistantTechnologist.jar"]
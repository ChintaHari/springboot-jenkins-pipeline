FROM openjdk:17
COPY target/springboot-jenkins-pipeline.jar springboot-jenkins-pipeline.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springboot-jenkins-pipeline.jar"]

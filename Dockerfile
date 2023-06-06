FROM openjdk:19
ADD /target/employee-service.jar employee-service.jar
ENTRYPOINT ["java", "-jar", "employee-service.jar"]

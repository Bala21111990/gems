FROM openjdk:11
ADD target/employee-gems.jar employee-gems.jar
ENTRYPOINT ["java","-jar","employee-gems.jar"]
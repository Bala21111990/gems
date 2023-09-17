FROM openjdk:11
ADD target/aws-sample.jar aws-sample.jar
ENTRYPOINT ["java","-jar","aws-sample.jar"]
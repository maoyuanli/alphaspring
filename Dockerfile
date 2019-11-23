FROM openjdk:8-jdk-alpine
ADD target/alphaspring.jar alphaspring.jar
ENTRYPOINT ["sh","-c","java -jar /alphaspring.jar"]
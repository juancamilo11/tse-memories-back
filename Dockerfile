FROM openjdk:11.0.13
EXPOSE 8080
ADD target/tse-memories.jar tse-memories.jar
ENTRYPOINT ["java", "-jar", "/tse-memories.jar"]
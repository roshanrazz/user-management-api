FROM openjdk:17

EXPOSE 8080

ADD ./target/*.jar user-api.jar

ENTRYPOINT [ "java","-jar","user-api.jar"]

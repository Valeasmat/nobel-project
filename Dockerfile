FROM openjdk:8
EXPOSE 7070
ADD target/nobel-project.jar nobel-project.jar
ENTRYPOINT ["java","-jar","/nobel-project.jar"]
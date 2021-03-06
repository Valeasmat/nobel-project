FROM maven:3.6-jdk-8-alpine AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package
FROM openjdk:8-jre-alpine
RUN apk add --no-cache tzdata
ENV TZ=America/Lima
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY --from=builder /app/target/nobel-project.jar /
EXPOSE 9090
#NO PONER EXPOSE PARA KUBECTL
#CMD ["java","-jar","/nobel-project.jar"] PARA KUBCTL
ENTRYPOINT ["java","-jar","/nobel-project.jar"]
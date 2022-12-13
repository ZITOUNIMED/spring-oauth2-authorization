FROM amazoncorretto:11-alpine-jdk
VOLUME /tmpGateway
COPY target/*.jar app.jar 
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
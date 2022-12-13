FROM amazoncorretto:11-alpine-jdk
VOLUME /tmpClient
COPY target/*.jar app.jar 
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]
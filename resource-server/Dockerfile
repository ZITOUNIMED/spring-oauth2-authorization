FROM amazoncorretto:11-alpine-jdk
VOLUME /tmpResource
COPY target/*.jar app.jar 
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app.jar"]
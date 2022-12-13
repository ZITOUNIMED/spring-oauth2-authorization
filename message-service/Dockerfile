FROM amazoncorretto:11-alpine-jdk
VOLUME /tmpMessage
COPY target/*.jar app.jar 
EXPOSE 8091
ENTRYPOINT ["java","-jar","/app.jar"]
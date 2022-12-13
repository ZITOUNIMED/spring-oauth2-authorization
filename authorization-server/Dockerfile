FROM amazoncorretto:11-alpine-jdk
VOLUME /tmpAuth
COPY target/*.jar app.jar 
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app.jar"]
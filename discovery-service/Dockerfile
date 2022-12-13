FROM amazoncorretto:11-alpine-jdk
VOLUME /tmpDiscovery
COPY target/*.jar app.jar 
EXPOSE 8761
ENTRYPOINT ["java","-jar","/app.jar"]
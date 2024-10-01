FROM amazoncorretto:17-alpine

COPY target/wedding-0.0.1-SNAPSHOT.jar target_app.jar

ENTRYPOINT ["java", "-jar", "/target_app.jar"]
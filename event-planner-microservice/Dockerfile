FROM openjdk:17
EXPOSE 8090
ADD target/eventsplanner-0.0.1-SNAPSHOT.jar events.jar
ENTRYPOINT ["java","-jar","events.jar"]
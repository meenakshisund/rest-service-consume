FROM openjdk:8
COPY target/webservice-call-0.0.1-SNAPSHOT.jar webservice-call-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","webservice-call-0.0.1-SNAPSHOT.jar"]
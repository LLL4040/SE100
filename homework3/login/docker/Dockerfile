FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD login-1.0-SNAPSHOT.jar app.jar
ADD dictionary.txt dictionary.txt
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 9090

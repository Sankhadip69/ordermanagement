FROM bellsoft/liberica-openjdk-alpine:17.0.5

WORKDIR /usr/share/app

COPY target/ordermanagement-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar","app.jar"]

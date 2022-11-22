FROM adoptopenjdk/openjdk8:alpine-jre

ARG JAR_NAME=discovery-server-0.0.1-SNAPSHOT.jar

WORKDIR /etc/school21-app
COPY target/${JAR_NAME} ${JAR_NAME}

ENTRYPOINT ["java","-jar","discovery-server-0.0.1-SNAPSHOT.jar"]
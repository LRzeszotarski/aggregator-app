FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} aggregator-app.jar
ENTRYPOINT ["java","-jar","/aggregator-app.jar"]

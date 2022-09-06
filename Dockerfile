FROM openjdk:17-jdk-alpine
##ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} springreadyapp.jar
EXPOSE 8081
ADD build/libs/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"]
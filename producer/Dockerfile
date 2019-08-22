FROM openjdk:10-jre-slim
RUN mkdir -p /usr/build/producer
COPY ./build/libs/producer-1.0-SNAPSHOT.jar /usr/build/producer
WORKDIR /usr/build/producer
EXPOSE 8081
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "producer-1.0-SNAPSHOT.jar"]
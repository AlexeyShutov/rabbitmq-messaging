FROM openjdk:10-jre-slim
RUN mkdir -p /usr/build/consumer
COPY ./build/libs/consumer-1.0-SNAPSHOT.jar /usr/build/consumer
WORKDIR /usr/build/consumer
EXPOSE 8082
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "consumer-1.0-SNAPSHOT.jar"]
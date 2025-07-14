FROM openjdk:17-jdk-alpine
ARG PORT_APP=8085
WORKDIR /app
COPY ./target/api-client-0.0.1.jar .
ENV PORT $PORT_APP
EXPOSE $PORT
CMD ["java", "-jar", "api-client-0.0.1.jar"]
FROM maven:3.9.9-eclipse-temurin-21 AS builder
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN --mount=type=cache,target=/root/.m2 $HOME/products-service/mvnw -f $HOME/products-service/pom.xml clean package

FROM eclipse-temurin:21-jre
ARG JAR_FILE=/usr/app/products-service/target/*.jar
COPY --from=builder $JAR_FILE /app/runner.jar
ENTRYPOINT java -jar /app/runner.jar
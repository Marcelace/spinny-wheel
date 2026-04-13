FROM gradle:8.5-jdk21 AS build
WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew build

FROM registry.access.redhat.com/ubi9/openjdk-21-runtime:1.24

ENV LANGUAGE='en_US:en'n

WORKDIR /deployments

COPY --from=build --chown=185 /app/build/quarkus-app/ /deployments/

EXPOSE 8080
USER 185

CMD ["java", "-jar", "quarkus-run.jar"]

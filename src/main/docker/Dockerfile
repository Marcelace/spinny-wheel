FROM gradle:8.5-jdk21 AS build
WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew build

FROM registry.access.redhat.com/ubi9/openjdk-21-runtime:1.24

ENV LANGUAGE='en_US:en'n

COPY --from=build --chown=185 /app/build/quarkus-app/lib/ lib/
COPY --from=build --chown=185 /app/build/quarkus-app/*.jar ./
COPY --from=build --chown=185 /app/build/quarkus-app/app/ app/
COPY --from=build --chown=185 /app/build/quarkus-app/quarkus/ quarkus/

EXPOSE 8080
USER 185
ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

ENTRYPOINT [ "/opt/jboss/container/java/run/run-java.sh" ]

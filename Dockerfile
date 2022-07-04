FROM maven:3.8.3-amazoncorretto-17 as BUILDER
ARG VERSION=0.0.1-SNAPSHOT

WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/

COPY target/recommendation-${VERSION}.jar /build/target/application.jar
RUN mvn clean package

FROM amazoncorretto:17-alpine3.15-jdk
WORKDIR /app/

COPY --from=BUILDER /build/target/*.jar application.jar
CMD java -jar /app/application.jar
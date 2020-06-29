FROM maven:3.3-jdk-8 AS build
COPY pom.xml /build
WORKDIR /build
COPY src /build/src
RUN mvn package

FROM openjdk:8-jre-slim
RUN mkdir /app
COPY --from=build /build/target/ /app
WORKDIR /app
CMD ["java", "-jar", "spreadsheet-1.0-SNAPSHOT.jar"]

FROM maven:3.3-jdk-8 AS install-deps
COPY postfixgen_for_students.jar /root
RUN mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=/root/postfixgen_for_students.jar

FROM install-deps AS build
RUN mkdir /build
COPY pom.xml /build
WORKDIR /build
RUN mvn package

FROM openjdk:8-jre-slim
RUN mkdir /app
COPY --from=build /build/target/ /app
WORKDIR /app
CMD ["java", "-jar", "spreadsheet-1.0-SNAPSHOT.jar"]

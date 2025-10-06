FROM maven:3.9.11-eclipse-temurin-21 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21.0.8_9-jre AS runtime

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
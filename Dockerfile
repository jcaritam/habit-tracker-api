FROM maven:3.8.6-openjdk-18 as Build
COPY . ./app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
COPY --from=Build /app/target/*.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
# Use an official Maven image as the base image
FROM maven:3.9.5 AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
# Build the application using Maven
RUN mvn clean package -DskipTests
# Use an official OpenJDK image as the base image
FROM openjdk
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/*.jar app.jar
# Set the command to run the application with prod profile
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]
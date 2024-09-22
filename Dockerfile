# Use an official Maven image as a build environment
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies (this is a separate step for caching purposes)
COPY pom.xml .

# Download dependencies only, without building the project
RUN mvn dependency:go-offline

# Copy the rest of the project files to the container
COPY src ./src

# Build the project
RUN mvn clean install -DskipTests

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "target/calculator-1.0.0-SNAPSHOT.jar"]

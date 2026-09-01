# Stage 1: Build the Application
# Use official Maven image with Temurin JDK 25 as the build environment
FROM maven:3.9-eclipse-temurin-25 AS builder

# Set the working directory for the build stage
WORKDIR /build

# Copy project definition and source code
COPY pom.xml .
COPY src ./src

# Compile and package the artifact, ignoring tests for pipeline speed
RUN mvn clean package -DskipTests

# Stage 2: Create Final Minimal Docker Image
# Use a minimal JRE/JDK image for the final container
FROM eclipse-temurin:25

# Set the working directory for the runtime container
WORKDIR /app

USER root
# Apply all security updates and clean up cache
RUN apt-get update && apt-get upgrade -y && rm -rf /var/lib/apt/lists/*


# Ensure the Docker image doesn't run as root
# Create a dedicated non-root user and group
RUN groupadd -r appgroup && useradd -r -g appgroup appuser

# Switch to the non-root user
USER appuser

# Copy only the compiled artifact from the builder stage and set ownership
COPY --from=builder --chown=appuser:appgroup /build/target/*.jar app.jar

# Define execution command to start the application
ENTRYPOINT ["java", "-jar", "app.jar"]

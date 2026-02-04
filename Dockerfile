# Use Java 17
FROM eclipse-temurin:17-jdk

# Create app directory
WORKDIR /app

# Copy project files
COPY . .

# Build the jar
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Expose port (Render provides PORT env variable)
EXPOSE 8080

# Run the jar
CMD ["sh", "-c", "java -jar target/*.jar --server.port=${PORT}"]

FROM maven:3.9.11-eclipse-temurin-21

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]

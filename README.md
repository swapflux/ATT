# Middleware API B2B Gateway ATT Assignment

## Project Overview

This project is a Spring Boot based middleware API gateway simulation designed to process purchase order requests from legacy B2B systems.
The service accepts JSON payloads, validates input using Hibernate Validator, performs asynchronous transformation, and generates flat file output inside a server directory.

-----------------------------------------

## Architecture Components

- REST Controller Layer
- Service Layer with Async Processing
- Custom Validation using Hibernate Validator
- OAuth2 Security (JWT Resource Server)
- Flat File Middleware Transformation
- Unit Testing using JUnit 5 and Mockito
- Docker Containerization
- Jenkins Pipeline Support

-----------------------------------------

## Technologies Used

- Java 17
- Spring Boot 3
- Hibernate Validator
- Spring Security OAuth2
- JUnit 5
- Mockito
- Docker
- Maven

-----------------------------------------

## How to Build Project

### Step 1: Clean Build Project

```bash
mvn clean install

###  Run Using Java Command
java -jar target/ATT-1.0-SNAPSHOT.jar

###  Build Docker Image
docker build -t assignment-app .

###  Run Container
docker run -d -p 8080:8080 b2b-gateway

###  Purchase Order API

POST http://localhost:8080/api/v1/orders

###  Sample Curl Command

curl -X POST http://localhost:8080/api/v1/orders \
-H "Content-Type: application/json" \
-H "Authorization: Bearer <JWT_TOKEN>" \
-d '{
"purchaseOrderNumber":"PO1001",
"productCode":"ROUTER-9000",
"quantity":2,
"price":100.0,
"totalAmount":200.0
}'


##  Output File Location

output/

### Testing

mvn test


### CI/CD Pipeline

The project supports declarative pipeline automation.

Included files:
	•	Dockerfile
	•	Jenkinsfile

Pipeline stages include:
	•	Build
	•	Test
	•	Docker Image Creation

###  Author

Swapnil Jagtap

###   License AT&T
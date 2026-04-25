# Product REST API - Spring Boot

A RESTful API built with Spring Boot and JPA for managing products.

## Tech Stack
- Java 21 + Spring Boot 3
- Spring Data JPA
- H2 Database
- Swagger UI / OpenAPI

## Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/home/products` | Get all products |
| GET | `/home/product/{id}` | Get product by ID |
| GET | `/home/product?name=xyz` | Search products by name |
| POST | `/home` | Create a new product |
| PUT | `/home/product/{id}` | Update a product |
| DELETE | `/home/product/{id}` | Delete a product |

## Example Request

**POST** `/home`
```json
{
  "name": "Laptop",
  "price": 999
}
```

## Run Locally

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPO.git
cd YOUR_REPO
.\mvnw.cmd spring-boot:run
```

API will be available at `http://localhost:8080`

## API Documentation
Once running, visit Swagger UI to explore and test all endpoints:
```
http://localhost:8080/swagger-ui/index.html
```
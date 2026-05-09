# 🛒 Product API

A RESTful product management API built with Java Spring Boot and PostgreSQL.

## 🚀 Tech Stack
- **Java 21** + **Spring Boot 3.5**
- **PostgreSQL** — persistent database
- **Spring Data JPA** / Hibernate — ORM
- **Spring Boot Validation** — input validation
- **Maven** — build tool

## 📁 Architecture
```
Controller → Service → Repository → PostgreSQL
```
- **DTO pattern** — `ProductRequestDTO` for input, `ProductResponseDTO` for output. Entities never exposed directly.
- **Global Exception Handler** — centralized error handling with proper HTTP status codes
- **@Valid** — input validation at the controller boundary before reaching service layer
- **Constructor injection** — over field injection for testability

## 📦 Endpoints
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1/products` | Get all products |
| GET | `/api/v1/products/{id}` | Get by ID |
| GET | `/api/v1/products/search?name=` | Search by name |
| POST | `/api/v1/products` | Create product |
| PUT | `/api/v1/products/{id}` | Update product |
| DELETE | `/api/v1/products/{id}` | Delete product |

## 🔍 Example
```json
POST /api/v1/products
{ "name": "iPhone 15", "price": 999.99 }

Response 201:
{ "id": 1, "name": "iPhone 15", "price": 999.99 }

Validation error 400:
{ "name": "Name cannot be blank", "price": "Price must be greater than 0" }
```

## ⚙️ Run Locally
**Prerequisites:** Java 21, Maven, PostgreSQL

```bash
git clone https://github.com/Kostia20034/Product-api.git
cd Product-api
```

Create database:
```sql
CREATE DATABASE product_api;
```

Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/product_api
spring.datasource.username=postgres
spring.datasource.password=your_password
```

```bash
./mvnw spring-boot:run
```
API runs at `http://localhost:8080`

## 🔮 Roadmap
- [ ] Spring Security + JWT authentication
- [ ] Pagination and sorting
- [ ] Docker containerization
- [ ] Unit + integration tests
- [ ] CI/CD with GitHub Actions

## 🖥️ Frontend
React + Tailwind frontend → [product-frontend](https://github.com/Kostia20034/product-frontend)

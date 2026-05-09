# 🛒 Product API

A RESTful API for managing products built with Java Spring Boot and PostgreSQL. Built to learn and demonstrate backend development fundamentals including layered architecture, data validation, and proper REST design.

---

## 🚀 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3.5 |
| Database | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| Validation | Spring Boot Validation |
| Build Tool | Maven |

---

## 📦 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1/products` | Get all products |
| GET | `/api/v1/products/{id}` | Get product by ID |
| GET | `/api/v1/products/search?name=` | Search by name |
| POST | `/api/v1/products` | Create a product |
| PUT | `/api/v1/products/{id}` | Update a product |
| DELETE | `/api/v1/products/{id}` | Delete a product |

---

## 🔍 Example

**Request:**
```json
POST /api/v1/products
{
  "name": "iPhone 15",
  "price": 999.99
}
```
**Response:**
```json
{
  "id": 1,
  "name": "iPhone 15",
  "price": 999.99
}
```

---

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

Edit `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/product_api
spring.datasource.username=postgres
spring.datasource.password=your_password
```

Run:
```bash
./mvnw spring-boot:run
```

---

## 🏗️ Architecture

```
Controller → Service → Repository → PostgreSQL
```

- **DTO pattern** — separates internal entities from API responses
- **Global Exception Handler** — centralized error handling
- **@Valid** — input validation before reaching service layer
- **Constructor injection** — for better testability

---

## 🔮 Future Improvements

- [ ] Spring Security + JWT
- [ ] Pagination and sorting
- [ ] Docker
- [ ] Unit tests
- [ ] CI/CD

---

## 🖥️ Frontend

[product-frontend](https://github.com/Kostia20034/product-frontend)

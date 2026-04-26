# Product REST API — Spring Boot Backend Project

## What is this project?

Product REST API is a fully functional backend REST API built with Java and Spring Boot. The goal of this project was to build a real backend system from scratch that handles complete product management — creating, reading, updating, and deleting products stored in a database. This was my first complete backend project where I designed and implemented the full architecture myself, from the database layer all the way up to the API endpoints.

## What does it do?

The API allows any client (browser, Postman, frontend app) to manage a list of products. Each product has an ID, a name, and a price. You can create new products, retrieve all products or a single product by ID, search products by name, update an existing product, and delete a product. The API also includes a built-in Swagger UI page that lets you interact with and test all endpoints directly from the browser without any extra tools.

## How was it built?

I built this project using a clean 3-layer architecture following standard Spring Boot conventions. The **Controller layer** handles incoming HTTP requests and returns appropriate responses. The **Service layer** contains the business logic. The **Repository layer** communicates directly with the database using Spring Data JPA. This separation of concerns makes the code maintainable and easy to extend in the future.

## Tools and Technologies Used

- **Java 21** — primary programming language
- **Spring Boot 3** — backend framework
- **Spring Data JPA / Hibernate** — database access and ORM
- **H2 Database** — lightweight embedded database (data stored locally)
- **Maven** — build tool and dependency management
- **Swagger UI / SpringDoc OpenAPI** — auto-generated interactive API documentation
- **Git / GitHub** — version control

## Steps Taken

1. Set up the Spring Boot project with the necessary dependencies (JPA, H2, Web, SpringDoc)
2. Designed the `Product` entity with `id`, `name`, and `price` fields
3. Created the `Repo` interface extending `JpaRepository` with a custom search method
4. Implemented the `ProductService` class with all CRUD operations
5. Built the `Controller` class with all 6 REST endpoints
6. Added Swagger UI for interactive API documentation
7. Tested all endpoints locally using Swagger UI and PowerShell

## Bugs Fixed

- **NullPointerException on POST** — `p.getName().equals(null)` throws an exception when name is null. Fixed by changing to `p.getName() == null`
- **Service/Controller mismatch** — Service used `orElseThrow()` which throws an exception, but Controller checked for `null`. Fixed by changing to `orElse(null)` for consistent behavior
- **Class naming conflict** — Class named `Service` conflicted with Spring's own `@Service` annotation. Fixed by renaming to `ProductService`
- **Typo in method name** — `updataProduct` renamed to `updateProduct`
- **Java version mismatch** — Project required Java 21 but system had Java 8. Fixed by installing JDK 21 and setting `JAVA_HOME`

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/home/products` | Get all products |
| GET | `/home/product/{id}` | Get product by ID |
| GET | `/home/product?name=xyz` | Search products by name |
| POST | `/home` | Create a new product |
| PUT | `/home/product/{id}` | Update a product |
| DELETE | `/home/product/{id}` | Delete a product |

## Demo Video

▶️ **[Watch the full demo here](PASTE_YOUR_VIDEO_LINK_HERE)**

> In this video I walk through the project architecture, explain each layer of the code, and demonstrate all 6 API endpoints live using Swagger UI.

## How to Run Locally

```bash
git clone https://github.com/Kostia20034/Product-api.git
cd Product-api
.\mvnw.cmd spring-boot:run
```

Then open your browser and go to:
```
http://localhost:8080/swagger-ui/index.html
```

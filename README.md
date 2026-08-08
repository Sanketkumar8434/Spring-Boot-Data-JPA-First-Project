# Spring Boot Data JPA — First Project

A beginner-friendly Spring Boot project demonstrating how to use **Spring Data JPA** to perform database operations with minimal boilerplate. The app defines a simple `Student` entity and inserts a sample record at startup using an `ApplicationRunner`.

## Tech Stack

- Java 17
- Spring Boot 4.1.0
- Spring Data JPA
- Hibernate (ORM)
- MySQL (dev profile)
- H2 in-memory database (test profile)
- Lombok
- Maven

## Project Structure

```
src/main/java/com/sanket
├── SpringbootDataJpaDemoApplication.java   # Main entry point
├── entity/
│   └── Student.java                        # JPA entity (Student_Info table)
├── Repository/
│   └── IStudentRepo.java                   # Spring Data CrudRepository
├── Service/
│   ├── IStudentService.java                # Service interface
│   └── StudentServiceImpl.java             # Service implementation
└── Runner/
    └── StudentRunner.java                  # Inserts a sample student on startup

src/main/resources
├── application.properties                  # Active profile config
├── application-dev.properties              # MySQL datasource config
└── application-test.properties             # H2 datasource config
```

## How It Works

1. On application startup, `StudentRunner` builds a `Student` object and passes it to `IStudentService`.
2. `StudentServiceImpl` calls `IStudentRepo.save(...)`, which Spring Data JPA implements automatically — no manual SQL required.
3. The record is persisted to the `Student_Info` table, and a confirmation message is printed to the console.

## Getting Started

### Prerequisites

- JDK 17+
- Maven (or use the included `mvnw` wrapper)
- MySQL server (only if running with the `dev` profile)

### Clone the repository

```bash
git clone https://github.com/Sanketkumar8434/Spring-Boot-Data-JPA-First-Project.git
cd Spring-Boot-Data-JPA-First-Project
```

### Run with the default (test / H2) profile

By default, `spring.profiles.active=test` in `application.properties`, so the app runs against an in-memory H2 database — no setup needed.

```bash
./mvnw spring-boot:run
```

You should see console output similar to:

```
Student infomation inserted successfully with ID number: 1
```

The H2 console is available at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`).

### Run with the MySQL (dev) profile

1. Create a database matching the one configured in `application-dev.properties` (default: `spring_test`).
2. Update `spring.datasource.username` / `spring.datasource.password` in `application-dev.properties` to match your local MySQL setup.
3. Run with the `dev` profile active:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

> **Note:** `application-dev.properties` currently contains a hardcoded username/password. For any real or shared project, move credentials to environment variables or a `.gitignore`d config file instead of committing them.

## Build

```bash
./mvnw clean package
java -jar target/Springboot_Data_JPA_Demo-0.0.1-SNAPSHOT.jar
```

## Roadmap / Ideas for Extension

- [ ] Add a REST controller to expose CRUD endpoints for `Student`
- [ ] Add `findByStudName`, `findByStudAddrs` custom query methods
- [ ] Add validation annotations (`@NotNull`, `@Size`, etc.)
- [ ] Add unit/integration tests for the repository and service layers

## License

No license specified yet — add one (e.g. MIT) if you intend for others to reuse this code.

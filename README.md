# 📚 Library API

API REST desenvolvida para gerenciamento de livros de uma biblioteca.

## 🚀 Tecnologias
- **Java 17**
- **Spring Boot 3** (Web, Data JPA, Validation)
- **PostgreSQL** (via Docker)
- **Swagger / OpenAPI 3** (Documentação)
- **Lombok**

## ⚙️ Como Rodar

1. Clone o repositório
2. Suba o banco de dados com Docker:
   ```bash
   docker run --name library-db -e POSTGRES_PASSWORD=senha_secreta -e POSTGRES_DB=library -p 5432:5432 -d postgres
Execute o projeto via VS Code ou Maven:

Bash

./mvnw spring-boot:run
Acesse o Swagger: http://localhost:8080/swagger-ui/index.html

🧪 Endpoints Principais
POST /livros: Cadastra um novo livro.

GET /livros: Lista todos os livros.

PUT /livros/{id}: Atualiza dados.

DELETE /livros/{id}: Remove um livro.

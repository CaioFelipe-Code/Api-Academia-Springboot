# API Academia - Spring Boot

Projeto desenvolvido como parte do meu portfólio para demonstrar conhecimentos em Java, Spring Boot, Spring Data JPA e desenvolvimento de API RESTful.

## Sobre o projeto

Esta API gerencia alunos e matrículas de uma academia de ginástica. Contém operações CRUD completas para alunos e matrículas, além de tratamento básico de erros.

## Tecnologias usadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 / MySQL (conforme configuração)
- Maven
- Postman (para testes)

## Endpoints principais

- `GET /alunos` — listar alunos
- `POST /alunos` — cadastrar novo aluno
- `GET /alunos/{id}` — buscar aluno por ID
- `PUT /alunos/{id}` — atualizar aluno
- `DELETE /alunos/{id}` — remover aluno

- `GET /matriculas` — listar matrículas
- `POST /matriculas` — criar matrícula
- `GET /matriculas/{id}` — buscar matrícula por ID
- `PUT /matriculas/{id}` — atualizar matrícula
- `DELETE /matriculas/{id}` — remover matrícula

# Gym Control 

Este projeto consiste em uma **API** de  **Gerenciamento de uma academia**. A aplicação foi construída utilizando **Java** com o framework **Spring Boot** e o banco de dados relacional **PostregSQL** e com o versionamento do banco de dados utilizando o **FLYWAY**, com foco em segurança e facilidade de utilização do usuário.
> Projeto de portfólio construído para demonstrar competências práticas de back-end aplicadas a um cenário de mercado: autenticação com JWT e tratamento de exceções.

## Stack 

* Java 17
* Spring Boot 3
* Spring Web
* Spring Security
* Spring Data JPA
* PostgreSQL
* Arquitetura em camadas (controller, services, model, repository, config, DTOs)
* Flyway
* Maven
* Swagger

## Principais funcionalidades

* Cadrastamento de alunos, professores e planos da academia
* Criação automática de matrícula dos alunos
* Autenticação com JWT
* Chaves públicas e privadas
* Tratamento de exceções
  
## Arquitetura e organização do projeto

* **Camadas:** Controller → Services → Repository
* **DTOs:** para abstração da comunicação entre solicitação de login e resposta de login
* **Percistencia:** **JPA**
* **Banco de Dados:** **PostgreSQL**
* **Versionamento do banco:** **Flyway**

```text
src/main/java/com.mateus.crudeauth
├── config
├── controller
├── dto
├── model
├── repository
├── services
└── resources
    ├── db.migration
        ├──  V1_create_table_usuario.sql
        ├──  V2_create_table_professor.sql
        ├──  V3_create_table_admin.sql
        ├──  V4_create_table_registration.sql
        ├──  V5_create_table_plans.sql               
    
```

## Documentação dos endpoints
![Documentação GYMCONTROL](https://github.com/user-attachments/assets/3451faaa-f492-4c1c-8bf4-fac8a81b2d54)

## Possíveis evoluções

* Conteinerização com Docker da aplicação e do banco de dados
* Sistema de filas e mensagerias com **RabbitMQ**
* Adaptação para um projeto FullStack com **Angular**





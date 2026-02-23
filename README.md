🚀 Project Management API

Spring Boot • JWT • Role-Based Authorization • Clean Architecture

API REST desenvolvida em Java + Spring Boot com autenticação JWT e controle de acesso baseado em roles (USER / ADMIN).
Projeto focado em boas práticas de arquitetura backend, segurança e separação de responsabilidades.

🎯 Objetivo

Construir uma API segura e escalável para gerenciamento de usuários e projetos, aplicando:

Arquitetura em camadas

Autenticação stateless com JWT

Autorização baseada em roles

Validação de dados

Boas práticas de segurança com Spring Security

🏗️ Arquitetura

O projeto segue uma estrutura baseada em separação de responsabilidades:

Controller → Service → Repository → Database

Controller → Camada de exposição REST

Service → Regras de negócio

Repository → Acesso a dados via JPA

DTOs → Controle de entrada e saída de dados

Security Layer → Autenticação e autorização

Essa estrutura facilita manutenção, testes e escalabilidade.

🔐 Segurança e Autorização
Autenticação

Implementação de JWT (JSON Web Token)

Sistema stateless

Senhas criptografadas com PasswordEncoder

Autorização

Controle baseado em roles utilizando:

@PreAuthorize("hasRole('ADMIN')")
Perfis disponíveis:
Role	Permissões
USER	Consultar projetos
ADMIN	Criar, editar e deletar projetos
⚙️ Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Security

JWT (io.jsonwebtoken)

Spring Data JPA

Hibernate

PostgreSQL

Maven

👤 Bootstrap de Administrador

A aplicação cria automaticamente um usuário ADMIN na inicialização, utilizando @PostConstruct, garantindo acesso inicial ao sistema.

Email: admin@gmail.com
Senha: 123456789
Role: ROLE_ADMIN
📦 Principais Funcionalidades
✔ Cadastro de usuários com senha criptografada
✔ Login com geração de JWT
✔ Controle de acesso baseado em roles
✔ CRUD completo de projetos
✔ Validação de dados com Bean Validation
✔ Tratamento de exceções estruturado
📌 Conceitos Demonstrados

RESTful API Design

Clean Code

Injeção de Dependência

Separação de camadas

Segurança stateless

Controle granular de autorização

Encapsulamento via DTO

Princípios básicos de SOLID

▶️ Como Executar
git clone https://github.com/seu-usuario/seu-repositorio.git
cd projeto
mvn spring-boot:run

Configure o banco de dados no application.properties.

🚀 Próximas Evoluções Planejadas

Paginação e ordenação

Documentação com Swagger

Testes unitários (JUnit + Mockito)

Refresh Token

Deploy em nuvem

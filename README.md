# 🧠 Clínica Psicológica API

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.4-brightgreen.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue.svg)
![JWT](https://img.shields.io/badge/Security-JWT-black.svg)
![Architecture](https://img.shields.io/badge/Architecture-MVC-yellow.svg)

## Link: (https://cognisyss.netlify.app)
## 📌 Sobre o Projeto

O **Clínica Psicológica API** é o backend de um sistema de gerenciamento de clínicas de psicologia. Desenvolvido como projeto acadêmico, o sistema visa digitalizar e organizar o fluxo de pacientes e profissionais, garantindo segurança no acesso aos dados sensíveis através de autenticação por tokens.

A API foi projetada para ser consumida por uma aplicação frontend (SPA) desenvolvida em Angular, possuindo políticas de CORS já configuradas para integrações locais.

## 🏛️ Arquitetura

O projeto foi estruturado utilizando o padrão arquitetural **MVC (Model-View-Controller)** adaptado para APIs REST, dividindo responsabilidades de forma clara:
* **Controllers:** Gerenciam as requisições HTTP e roteamento.
* **Services:** Concentram as regras de negócio (ex: `BuscarPacienteService`, `CadastroPsicologa`).
* **Repositories (Data Source):** Interfaces Spring Data JPA para comunicação com o banco de dados.
* **Security:** Camada de interceptação e validação de tokens JWT.

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Framework Web:** Spring Boot 4.0.4
* **Banco de Dados:** PostgreSQL
* **Autenticação:** Spring Security + JWT (JSON Web Tokens)
* **Documentação:** SpringDoc OpenAPI 3 (Swagger)
* **Gerenciador de Dependências:** Maven

## ⚙️ Principais Funcionalidades

O sistema expõe rotas protegidas para as seguintes operações:

🔐 **Autenticação & Autorização (`/auth`)**
* `POST /auth/login`: Autenticação de usuários cadastrados retornando o token JWT.
* `POST /auth/registro`: Criação de novos usuários no sistema.

🧑‍⚕️ **Gestão de Psicólogos (`/psi`)**
* `GET /psi/psicologas`: Listagem de todos os profissionais.
* `GET /psi/psicologa/id/{id}`: Busca detalhada de um profissional.
* `POST /psi/psicologa/save`: Cadastro de novos profissionais.
* `DELETE /psi/psicologa/delete/{id}`: Exclusão de registros.

🛋️ **Gestão de Pacientes (`/pac`)**
* `GET /pac/pacientes`: Listagem de todos os pacientes.
* `GET /pac/paciente/id/{id}`: Busca de prontuário/dados de um paciente específico.
* `POST /pac/paciente/save`: Cadastro de novos pacientes.
* `PUT /pac/paciente/editar/{id}`: Atualização de dados cadastrais.
* `DELETE /pac/paciente/delete/{id}`: Remoção de pacientes do sistema.

## 📚 Documentação da API (Swagger)

A aplicação conta com documentação automatizada listando todos os *endpoints*, schemas e métodos de requisição. 

Com a aplicação em execução, acesse:
👉 `http://localhost:8080/swagger-ui.html`

## 🛠️ Como Executar o Projeto

### Pré-requisitos
* Java 21 instalado.
* Maven instalado.
* Instância do PostgreSQL em execução (o banco de dados deve ser configurado no `application.properties`).

### Passos para execução
**1. Clone o repositório:**

```bash
git clone https://github.com/ChristianDavid/clinica-psicologia-api.git
2. Acesse a pasta do projeto:

Bash
cd clinica-psicologia-api
3. Compile e instale as dependências:

Bash
mvn clean install
4. Execute o servidor:

Bash
mvn spring-boot:run
A API estará disponível em http://localhost:8080. O frontend Angular deve ser executado na porta 4200 para compatibilidade com o CORS configurado.
```

Desenvolvido por Christian David, Anderson Soares e Victor Guilherme.

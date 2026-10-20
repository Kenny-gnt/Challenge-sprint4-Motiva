# Challenge Sprint 4 - Motiva

## 📌 Descrição do Projeto

Este projeto dá continuidade ao sistema **MOTIVA**, desenvolvido para simular um sistema inteligente de monitoramento e priorização de manutenção de vegetação em rodovias.

Nesta Sprint 4, o sistema foi evoluído com **Spring Boot, Spring Data JPA e API REST**, substituindo o modelo de aplicação via console e JDBC utilizado na Sprint anterior. A aplicação permite cadastrar, consultar, atualizar e excluir informações, além de gerar e consultar relatórios de prioridade por meio de requisições HTTP.

A persistência dos dados continua utilizando o **Oracle Database**, agora com acesso realizado pelo Spring Data JPA.

---

# Integrantes 👤

Ana Luiza Santos Bertão RM 563171

Gisleine Muñoz Ticona RM 563804

Larissa Machado Silva RM 564168

Raira de Teves Costa RM 564850

Sofia Bill Franken RM 562767

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Oracle Database
- Oracle JDBC Driver
- Maven
- Eclipse IDE
- Git e GitHub
- Programação Orientada a Objetos (POO)
- API REST

---

## 💡 Conceitos Aplicados

- Herança e Encapsulamento
- Organização em Pacotes
- Arquitetura em Camadas
- Spring Boot
- Spring Data JPA
- Mapeamento Objeto-Relacional (ORM)
- Entidades JPA
- Interfaces Repository
- Operações CRUD
- API REST
- Requisições HTTP
- Validação de Dados
- Tratamento Global de Exceções
- Persistência de Dados
- Consultas ao Banco de Dados

---

## ⚙️ Funcionalidades

### Gerenciamento de Equipes

Permite realizar operações por meio da API REST:

- Cadastro de equipes
- Consulta de equipe por ID
- Listagem de equipes
- Atualização de equipes
- Exclusão de equipes

### Gerenciamento de Trechos

O sistema permite cadastrar e gerenciar trechos rodoviários, armazenando informações como:

- Quilômetro da rodovia
- Nível de vegetação
- Tipo de trecho

As operações disponíveis incluem cadastro, consulta, atualização e exclusão de trechos.

### Gerenciamento de Intervenções

Permite cadastrar e gerenciar intervenções operacionais, incluindo:

- Roçada
- Pulverização

Cada intervenção possui informações sobre o tipo de operação e a equipe responsável.

### Relatório de Prioridade

O sistema analisa o nível de vegetação dos trechos e classifica automaticamente a prioridade de manutenção.

| Nível de Vegetação | Prioridade |
|---------------------|------------|
| ≥ 8 | URGENTE |
| ≥ 6 | CRÍTICO |
| ≥ 4 | ATENÇÃO |
| < 4 | NORMAL |

Os relatórios gerados são armazenados no banco de dados e podem ser consultados posteriormente.

### Histórico de Relatórios

A aplicação permite:

- Gerar novos relatórios de prioridade
- Consultar os relatórios registrados
- Consultar relatórios por período

---

## 🗄️ Banco de Dados

O sistema utiliza o **Oracle Database**, integrado à aplicação por meio do Spring Data JPA e do driver JDBC da Oracle.

As tabelas utilizadas no sistema são:

- `EQUIPE_MANUTENCAO`
- `TRECHO_RODOVIA`
- `INTERVENCAO_OPERACIONAL`
- `RELATORIO_PRIORIDADE`

O mapeamento entre as classes Java e as tabelas do banco é realizado por meio de entidades JPA, utilizando anotações como `@Entity`, `@Table`, `@Id` e `@GeneratedValue`.

As credenciais de acesso ao banco são configuradas por variáveis de ambiente, evitando a exposição de informações sensíveis no código-fonte.

---

## 🔌 Spring Data JPA e Repositories

Nesta Sprint, o acesso aos dados foi reorganizado utilizando o **Spring Data JPA**, substituindo a implementação manual de consultas SQL e operações JDBC da Sprint anterior.

Os repositories estendem a interface `JpaRepository`, disponibilizando operações de persistência, consulta, atualização e exclusão.

A aplicação utiliza consultas derivadas dos nomes dos métodos dos repositories quando necessário, permitindo buscar informações sem precisar implementar manualmente cada consulta SQL.

---

## 🏗️ Arquitetura da Aplicação

O projeto está organizado em camadas para facilitar a manutenção e a separação das responsabilidades.

### Controller

Responsável por receber as requisições HTTP e disponibilizar os endpoints da API REST.

### Service

Responsável pelas regras de negócio, validações e execução das operações solicitadas.

### Repository

Responsável pelo acesso e pela persistência dos dados utilizando Spring Data JPA.

### Model

Contém as entidades que representam os dados persistidos no banco de dados.

### DTO

Contém objetos utilizados para transportar dados entre as requisições e a aplicação, quando necessário.

### Tratamento de Exceções

O tratamento global de exceções padroniza as respostas de erro da API, facilitando a identificação de problemas durante as requisições.

---

## 🌐 Endpoints da API REST

A aplicação disponibiliza endpoints para gerenciamento dos recursos do sistema.

| Recurso | Endpoint principal | Operações |
|---------|--------------------|-----------|
| Trechos | `/api/trechos` | GET, POST, PUT, DELETE |
| Equipes | `/api/equipes` | GET, POST, PUT, DELETE |
| Intervenções | `/api/intervencoes` | GET, POST, PUT, DELETE |
| Relatórios | `/api/relatorios` | GET, POST |

Também é possível consultar relatórios por período utilizando o endpoint:

```text
GET /api/relatorios/periodo?inicio=DATA_INICIAL&fim=DATA_FINAL
```

As respostas da API utilizam códigos HTTP adequados, como `200 OK`, `201 Created`, `204 No Content`, `400 Bad Request` e `404 Not Found`.

---

## 📂 Estrutura do Projeto

```text
src/
│
├── main/
│   ├── java/
│   │   └── br/com/motiva/
│   │       ├── MotivaApplication.java
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── service/
│   │       └── GlobalExceptionHandler.java
│   │
│   └── resources/
│       └── application.properties
│
└── test/
    └── java/
        └── br/com/motiva/
            └── MotivaApplicationTests.java

evidencias/
├── 01-listar-trechos.png
├── 02-cadastrar-trecho.png
├── 03-atualizar-trecho.png
├── 04-excluir-equipe.png
├── 05-consultar-relatorios.png
└── 06-tratamento-erro.png
```

---

## ▶️ Como Executar

### Pré-requisitos

- Java 17
- Maven
- Oracle Database
- Eclipse IDE ou outra IDE compatível

### Configuração

1. Clone o repositório do projeto.
2. Configure as variáveis de ambiente para o acesso ao Oracle:
   - `DB_URL`
   - `DB_USERNAME`
   - `DB_PASSWORD`
3. Verifique as configurações de conexão no arquivo `application.properties`.
4. Execute a aplicação Spring Boot.

Para executar pelo terminal, utilize:

```bash
./mvnw spring-boot:run
```

Para executar os testes automatizados:

```bash
./mvnw clean test
```

Após iniciar a aplicação, a API estará disponível localmente na porta `8080`.

> **Importante:** as credenciais do Oracle devem ser configuradas localmente e não devem ser publicadas no repositório.

---

## 🧪 Testes Realizados

A aplicação foi executada e testada, incluindo:

- Testes automatizados da aplicação
- Listagem de trechos
- Cadastro de trechos
- Atualização de registros
- Exclusão de equipes
- Consulta de relatórios
- Validação de requisições
- Tratamento de erros e registros não encontrados
- Verificação dos códigos de resposta HTTP

As evidências dos testes estão disponíveis na pasta `evidencias/`.

---

## 📚 Projeto Acadêmico

**MOTIVA — Challenge Sprint 4**

Projeto desenvolvido para aplicação prática de conceitos de **Java, Spring Boot, Spring Data JPA, Oracle Database, arquitetura em camadas e desenvolvimento de APIs REST**, dando continuidade à evolução do sistema MOTIVA.

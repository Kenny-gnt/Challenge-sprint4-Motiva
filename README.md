# Challenge Sprint 4 - Motiva

## 📌 Descrição do Projeto 

Este projeto dá continuidade ao sistema **MOTIVA**, desenvolvido para simular um sistema inteligente de monitoramento e priorização de manutenção de vegetação em rodovias.

Nesta Sprint 4, o sistema foi evoluído com **Spring Boot, Spring Data JPA e API REST**, substituindo a persistência com JDBC puro utilizada na Sprint 3. A aplicação permite realizar operações CRUD, gerar relatórios de prioridade e consultar o histórico de relatórios por meio de requisições HTTP.

A persistência dos dados continua utilizando o **Oracle Database**, agora com acesso gerenciado pelo Spring Data JPA, reduzindo a necessidade de código SQL e JDBC manual.

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
- Spring Boot 4.1.x
- Spring Web
- Spring Data JPA
- Oracle Database FIAP
- Oracle JDBC Driver (`ojdbc17`)
- Maven
- Eclipse IDE
- Git e GitHub
- cURL
- Programação Orientada a Objetos (POO)

---

## 💡 Conceitos Aplicados

- Encapsulamento e organização em pacotes
- Arquitetura em camadas
- Entidades JPA
- Mapeamento Objeto-Relacional (ORM)
- Interfaces `JpaRepository`
- Padrão DAO aplicado por meio dos Repositories
- Operações CRUD
- API REST e requisições HTTP
- Validação de dados
- Tratamento global de exceções
- Persistência de dados
- Consultas derivadas do Spring Data JPA
- Testes automatizados

---

## ⚙️ Funcionalidades

### Gerenciamento de Equipes

A API permite realizar operações de:

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

As operações disponíveis incluem cadastro, consulta, atualização e exclusão por meio de endpoints REST.

### Gerenciamento de Intervenções

Permite cadastrar e gerenciar intervenções operacionais, incluindo:

- Roçada
- Pulverização

Cada intervenção contém informações sobre o tipo de operação e a equipe responsável.

### Relatório de Prioridade

O sistema analisa os níveis de vegetação dos trechos e classifica as prioridades de manutenção conforme as regras de negócio implementadas no Service.

| Nível de Vegetação | Prioridade |
|---------------------|------------|
| ≥ 8 | URGENTE |
| ≥ 6 e < 8 | CRÍTICO |
| ≥ 4 e < 6 | ATENÇÃO |
| < 4 | NORMAL |

Os relatórios gerados são persistidos no Oracle Database, permitindo consultar os resultados posteriormente.

*Observação: os limites acima devem corresponder às regras efetivamente implementadas no projeto.*

### Histórico de Relatórios

A aplicação permite:

- Gerar um relatório de prioridade a partir dos trechos cadastrados
- Armazenar os resultados no banco de dados
- Consultar o histórico de relatórios
- Buscar relatórios por período

---

## 🗄️ Banco de Dados

O sistema utiliza o **Oracle Database FIAP**, integrado à aplicação por meio do Spring Data JPA e do driver JDBC da Oracle.

As tabelas utilizadas no sistema são:

- `EQUIPE_MANUTENCAO`
- `TRECHO_RODOVIA`
- `INTERVENCAO_OPERACIONAL`
- `RELATORIO_PRIORIDADE`

As classes Java são mapeadas para as tabelas do banco por meio de entidades JPA, utilizando anotações como `@Entity`, `@Table`, `@Id`, `@GeneratedValue` e `@SequenceGenerator`.

A configuração da conexão é realizada pelo arquivo `application.properties`, utilizando variáveis de ambiente para evitar a exposição das credenciais no repositório.

---

## 🔌 Spring Data JPA e Repositories

Nesta Sprint, o acesso aos dados foi migrado das classes DAO com JDBC manual para interfaces que estendem `JpaRepository`.

O Spring Data JPA disponibiliza operações como:

- `save()` — salvar ou atualizar registros
- `findAll()` — listar registros
- `findById()` — consultar por ID
- `deleteById()` — excluir por ID

Também é possível utilizar **derived queries**, métodos cujos nomes descrevem os critérios de busca. O Spring Data JPA interpreta esses nomes e gera as consultas correspondentes.

Dessa forma, a aplicação reduz o código necessário para acessar o banco e mantém as operações de persistência separadas das regras de negócio.

---

## 🏗️ Arquitetura da Aplicação

O projeto utiliza arquitetura em camadas, separando as responsabilidades de cada componente.

### Model

Contém as entidades que representam os dados persistidos no banco de dados.

### Repository

Responsável pelo acesso aos dados utilizando interfaces `JpaRepository`, sem necessidade de implementar manualmente cada operação CRUD.

### Service

Responsável pelas regras de negócio, validações e geração dos relatórios de prioridade.

### Controller

Recebe as requisições HTTP, encaminha as operações para a camada Service e retorna as respostas da API REST.

### DTO

Contém objetos utilizados para transportar dados entre as requisições e a aplicação, separando os dados de entrada e saída das entidades quando necessário.

### Tratamento Global de Exceções

A classe `GlobalExceptionHandler` centraliza o tratamento de erros, permitindo retornar respostas HTTP apropriadas para situações como dados inválidos ou registros não encontrados.

O fluxo principal da aplicação é:

`Controller → Service → Repository → Oracle Database`

---

## 🌐 Endpoints da API REST

A API disponibiliza endpoints para gerenciamento de trechos, equipes, intervenções e relatórios.

| Método HTTP | Endpoint | Ação | Resposta esperada |
|---|---|---|---|
| GET | `/api/trechos` | Listar trechos | 200 OK |
| GET | `/api/trechos/{id}` | Buscar trecho por ID | 200 OK / 404 Not Found |
| POST | `/api/trechos` | Cadastrar trecho | 201 Created |
| PUT | `/api/trechos/{id}` | Atualizar trecho | 200 OK / 404 Not Found |
| DELETE | `/api/trechos/{id}` | Excluir trecho | 204 No Content / 404 Not Found |
| GET | `/api/equipes` | Listar equipes | 200 OK |
| GET | `/api/equipes/{id}` | Buscar equipe por ID | 200 OK / 404 Not Found |
| POST | `/api/equipes` | Cadastrar equipe | 201 Created |
| PUT | `/api/equipes/{id}` | Atualizar equipe | 200 OK / 404 Not Found |
| DELETE | `/api/equipes/{id}` | Excluir equipe | 204 No Content / 404 Not Found |
| GET | `/api/intervencoes` | Listar intervenções | 200 OK |
| GET | `/api/intervencoes/{id}` | Buscar intervenção por ID | 200 OK / 404 Not Found |
| POST | `/api/intervencoes` | Cadastrar intervenção | 201 Created |
| PUT | `/api/intervencoes/{id}` | Atualizar intervenção | 200 OK / 404 Not Found |
| DELETE | `/api/intervencoes/{id}` | Excluir intervenção | 204 No Content / 404 Not Found |
| POST | `/api/relatorios` | Gerar e persistir relatório | 200 OK ou código implementado |
| GET | `/api/relatorios` | Consultar histórico | 200 OK |
| GET | `/api/relatorios/periodo?inicio=...&fim=...` | Consultar por período | 200 OK |

Requisições com dados inválidos podem retornar `400 Bad Request`, conforme as validações implementadas.

---

## 📡 Exemplos de Requisições cURL

Com a aplicação em execução na porta `8080`, é possível testar os endpoints pelo terminal.

### Listar trechos

```bash
curl -i http://localhost:8080/api/trechos
```

### Cadastrar um trecho

```bash
curl -i -X POST http://localhost:8080/api/trechos \
  -H "Content-Type: application/json" \
  -d "{\"km\":80,\"nivelVegetacao\":15,\"tipo\":\"RURAL\"}"
```

### Atualizar um trecho

```bash
curl -i -X PUT http://localhost:8080/api/trechos/1 \
  -H "Content-Type: application/json" \
  -d "{\"km\":80,\"nivelVegetacao\":20,\"tipo\":\"RURAL\"}"
```

Substitua `1` pelo ID de um trecho existente e utilize os campos exigidos pelo projeto.

### Excluir uma equipe

```bash
curl -i -X DELETE http://localhost:8080/api/equipes/9999
```

Para testar a exclusão com sucesso, substitua `9999` pelo ID de uma equipe existente. Um ID inexistente pode ser utilizado para verificar o tratamento de erros.

### Gerar relatório de prioridade

```bash
curl -i -X POST http://localhost:8080/api/relatorios
```

### Consultar o histórico de relatórios

```bash
curl -i http://localhost:8080/api/relatorios
```

### Consultar relatórios por período

```bash
curl -i "http://localhost:8080/api/relatorios/periodo?inicio=2026-10-01T00:00:00&fim=2026-10-31T23:59:59"
```

Os exemplos devem ser executados com a aplicação iniciada. Os campos enviados e os formatos de data devem corresponder aos aceitos pela API.

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
- Oracle Database FIAP
- Eclipse IDE ou outra IDE compatível

### Configuração

1. Clone o repositório do projeto.
2. Configure as variáveis de ambiente para a conexão com o Oracle:
   - `DB_URL`
   - `DB_USERNAME`
   - `DB_PASSWORD`
3. Confira as configurações de conexão no arquivo `application.properties`.
4. Verifique se o banco está acessível e se as tabelas e sequences necessárias já existem.
5. Execute a aplicação Spring Boot.

Para iniciar a aplicação pelo terminal:

```bash
./mvnw spring-boot:run
```

Para executar os testes automatizados:

```bash
./mvnw clean test
```

Após iniciar a aplicação, a API estará disponível em:

```text
http://localhost:8080
```

> **Importante:** não publique senhas reais nem outras credenciais do Oracle no repositório. Configure os valores localmente por meio de variáveis de ambiente.

---

## 🧪 Testes Realizados

Foram realizados testes da aplicação e das operações disponibilizadas pela API, incluindo:

- Testes automatizados com Spring Boot e MockMvc
- Listagem de trechos
- Cadastro de trechos
- Atualização de registros
- Exclusão de equipes
- Consulta de relatórios
- Tratamento de registros não encontrados
- Verificação das respostas HTTP

As evidências das requisições estão disponíveis na pasta `evidencias/`.

---

## 💭 Perguntas de Reflexão

### 1. Por que o `Repository` é uma interface e não uma classe? Quem escreve a implementação e quando?

O `Repository` é uma interface porque define as operações de acesso aos dados sem precisar implementar manualmente cada método. O Spring Data JPA cria a implementação automaticamente em tempo de execução, disponibilizando operações como `save()`, `findAll()`, `findById()` e `deleteById()`.

Dessa forma, o código fica mais simples, organizado e fácil de manter.

### 2. O pattern DAO da Sprint 3 morreu na migração ou só mudou de forma?

O pattern DAO não morreu, apenas mudou de forma. Na Sprint 3, criamos classes DAO manualmente para executar comandos SQL utilizando JDBC. Na Sprint 4, essa responsabilidade passou para os Repositories do Spring Data JPA, que fornecem métodos de acesso aos dados sem a necessidade de escrever manualmente todo o código JDBC.

Assim, a separação entre acesso aos dados e regras de negócio continua existindo, mas com menos código e maior produtividade.

### 3. Por que a validação de `nivelVegetacao >= 0` deve ficar no Service e não no Controller?

A validação deve fazer parte das regras de negócio do Service, pois essa camada é responsável por garantir que os dados respeitem as condições definidas pelo sistema, independentemente do endpoint utilizado.

O Controller recebe as requisições HTTP e encaminha os dados ao Service. Essa separação evita duplicação de regras e facilita a manutenção. Validações de entrada também podem ser complementadas com Bean Validation, utilizando anotações como `@PositiveOrZero` e `@Valid`.

### 4. No JDBC puro vocês escreviam SQL. Onde está o SQL do `findByTipo()`? Quem o gerou?

No Spring Data JPA, o SQL não precisa ser escrito manualmente para consultas derivadas. Quando um método como `findByTipo()` é declarado em um Repository, o Spring Data JPA interpreta seu nome e prepara a consulta correspondente em tempo de execução, utilizando o provedor JPA, como o Hibernate, para executar a operação no banco de dados.

Assim, é possível buscar registros por tipo sem escrever manualmente a consulta SQL.

---

## 📚 Projeto Acadêmico

**MOTIVA — Challenge Sprint 4**

Projeto desenvolvido para aplicação prática de conceitos de **Java, Spring Boot, Spring Data JPA, Oracle Database, arquitetura em camadas e desenvolvimento de APIs REST**, dando continuidade à evolução do sistema MOTIVA.

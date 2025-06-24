# 🎬 MovieProject - Backend

Este é o backend do projeto **MovieProject**, uma API REST desenvolvida com **Spring Boot**, que gerencia filmes, avaliações e favoritos. Ele foi projetado para se integrar com um frontend (como um app em Angular ou React) consumindo os endpoints via HTTP.

---

## 📦 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security (básico, com CORS liberado)**
- **Bean Validation (Jakarta Validation)**
- **Lombok**
- **PostgreSQL**

---

## 🚀 Como Executar Localmente

### ⚙️ Pré-requisitos

- [Java 17 ou superior](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/) rodando localmente
- (Opcional) IDE como IntelliJ ou VSCode

---

### 📥 Clone o Repositório

```bash
git clone https://github.com/erickguedes03/movieproject-be.git
cd movieproject-be
```

---

### 🛠️ Configure o PostgreSQL

Certifique-se de que o PostgreSQL está rodando.

Crie um banco chamado `movie_project`:

```sql
CREATE DATABASE movie_project;
```

---

### ⚙️ `application.properties`

Verifique se o arquivo `src/main/resources/application.properties` contém:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/movie_project
spring.datasource.username=postgres
spring.datasource.password=senha do seu banco
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

### ▶️ Executando a Aplicação

Na raiz do projeto:

```bash
./mvnw spring-boot:run
```
Ou, se preferir usar sua IDE:

1. Importe o projeto como **Maven Project**.  
2. Rode a classe `MovieProjectApplication`.

A API será iniciada em [http://localhost:8080](http://localhost:8080).

---

## 🔗 Endpoints da API

### 🎥 /filmes

- `GET /filmes`: Lista todos os filmes  
- `GET /filmes/{id}`: Busca filme por ID  
- `GET /filmes/genero/{genero}`: Filtra por gênero  
- `GET /filmes/buscar/{titulo}`: Busca por título  
- `PATCH /filmes/{id}/favorito?favorito=true|false`: Marca/desmarca como favorito  

### 🌟 /favoritos

- `POST /favoritos/{usuarioId}/{filmeId}`: Marca filme como favorito  
- `DELETE /favoritos/{usuarioId}/{filmeId}`: Remove dos favoritos  
- `GET /favoritos/{usuarioId}`: Lista favoritos do usuário  

### 📝 /avaliacoes

- `POST /avaliacoes/{filmeId}`: Avalia um filme  
- `GET /avaliacoes/{filmeId}`: Lista avaliações de um filme  

---

## 🔐 Segurança

A autenticação **não está habilitada** (todos os endpoints são públicos), mas o projeto utiliza **Spring Security** com **CORS** configurado para permitir requisições do frontend (por padrão: [http://localhost:4200](http://localhost:4200)).

---

## 📁 Estrutura de Pacotes
```
com.movieproject.MovieProject
├── config             # Configurações de segurança e CORS
├── controller         # Controllers REST
├── model              # Entidades JPA
├── repository         # Interfaces JPA
├── service            # Lógica de negócio
```

---

## 🧠 Melhorias Futuras

- Autenticação com JWT  
- Testes unitários e de integração  
- Paginação e ordenação de resultados  
- Documentação com Swagger  
- Deploy em nuvem (Render, Railway, Heroku)  
- Upload de imagens para filmes  

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir **issues** e **pull requests** com sugestões ou melhorias.

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Consulte o arquivo `LICENSE` para mais informações.

# Baozi Store REST API

Projeto desenvolvido para a atividade pratica de Desenvolvimento Web Back-End.

## Requisitos do PDF

- Java
- Spring Boot
- Spring Data JPA
- Banco relacional H2
- JSON nos endpoints
- Padrao MVC do Spring
- Packages `model`, `repository` e `controller`
- CRUD REST para `Cliente`, `Produto` e `Pedido`

## Entidades criadas

### Cliente

- `id: Long`
- `nome: String`
- `clienteDesde: LocalDate`

### Produto

- `id: Long`
- `nome: String`
- `preco: BigDecimal`
- `estoque: Boolean`

### Pedido

- `id: Long`
- `clienteId: Long`
- `produtoId: Long`
- `quantidade: Integer`

## Endpoints implementados

### Clientes

- `POST /clientes`
- `GET /clientes`
- `GET /clientes/{id}`
- `PUT /clientes/{id}`
- `DELETE /clientes/{id}`

### Produtos

- `POST /produtos`
- `GET /produtos`
- `GET /produtos/{id}`
- `PUT /produtos/{id}`
- `DELETE /produtos/{id}`

### Pedidos

- `POST /pedidos`
- `GET /pedidos`
- `GET /pedidos/{id}`
- `PUT /pedidos/{id}`
- `DELETE /pedidos/{id}`

## Como executar

```bash
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Com Docker Compose:

```bash
docker compose up --build
```

- A API sobe em `http://localhost:8080` e o MySQL em `localhost:3306`.
- A API usa H2 por padrao fora do Docker e MySQL no Compose via variaveis de ambiente

## Banco H2

- URL: `jdbc:h2:mem:baozistore`
- Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:baozistore`
- User: `sa`

## Banco MySQL

- JDBC URL: `jdbc:mysql://localhost:3306/baozistore`
- Database: `baozistore`
- User: `baozi`
- Password: `baozi`

## Dados iniciais

O projeto sobe com um cliente, um produto e um pedido pre-cadastrados em `src/main/resources/data.sql`.

## Postman

A collection do postman esta em `src/main/resources/postman/baozi-store.postman_collection.json`.
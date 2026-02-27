# Listagem de Dívidas - WireMock + API REST Java (Feign + Swagger + Hexagonal)

Projeto com:
- **WireMock** em Docker simulando a API de listagem de dívidas
- **Aplicação REST Java** (Spring Boot) que consome essa API via **Feign** e expõe endpoint com **Swagger**, em **arquitetura hexagonal**

## Estrutura

```
feign/
├── docker-compose.yml          # Sobe o WireMock na porta 8080
├── wiremock/
│   └── mappings/               # Stubs da API mockada
│       ├── listagem-dividas.json
│       └── health.json
└── listagem-dividas-java/      # API REST Java
    ├── pom.xml
    └── src/main/java/.../br/com/bradesco/listagemdividas/
        ├── ListagemDividasApplication.java
        ├── core/               # Núcleo (hexagonal)
        │   ├── domain/         # Porta de saída + request de domínio
        │   └── usecase/        # Caso de uso
        └── adapter/
            ├── input/          # Controller REST + DTOs (Swagger)
            └── output/         # Cliente Feign + adaptador da porta
```

## Como rodar

### 1. Subir o WireMock

```bash
docker-compose up -d
```

A API mockada fica em **http://localhost:8080**:
- `POST /api/listagem-dividas` → retorna listagem de dívidas (JSON em snake_case)
- `GET /api/listagem-dividas/health` → health check

### 2. Rodar a aplicação Java

Requer **Maven** instalado (ou use a sua IDE para rodar `ListagemDividasApplication`).

```bash
cd listagem-dividas-java
mvn spring-boot:run
```

A API Java sobe em **http://localhost:9090**:
- **Swagger UI:** http://localhost:9090/swagger-ui.html
- **Endpoint:** `POST http://localhost:9090/api/listagem-dividas`  
  Corpo de exemplo (JSON em snake_case):

```json
{
  "codigo_filial_cnpj_cliente": "0001",
  "controle_cpf_cnpj_cliente": "0",
  "cpf_cnpj_assessoria": "12345678901",
  "codigo_filial_cnpj_assessoria": "0001",
  "controle_cpf_cnpj_assessoria": "0",
  "codigo_tipo_canal": 1,
  "portfolios": ["banco", "cartao"]
}
```

A aplicação Java chama o WireMock via Feign e repassa a resposta no formato `DefaultResponse<ListagemDividasResponseDTO>`.

## Arquitetura hexagonal

- **Core (domain):** `ListagemDividasPort` (porta de saída), `ListagemDividasRequest`
- **Core (usecase):** `ListagemDividasUseCase` orquestra a porta
- **Adapter input:** `ListagemDividasController` (REST), DTOs de request/response, Swagger
- **Adapter output:** `ListagemDividasFeignClient` (Feign) + `ListagemDividasFeignAdapter` (implementa a porta)

## Tecnologias

- Java 17, Spring Boot 3.2, Spring Cloud OpenFeign
- SpringDoc OpenAPI (Swagger 3)
- WireMock 3.3.1 (Docker)
- Lombok, Jackson (snake_case para contrato da API)

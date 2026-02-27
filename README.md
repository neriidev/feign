# WireMock standalone (JAR)

Esta pasta permite rodar o WireMock **via JAR** (sem Docker), na porta **8080**.

## Estrutura

```
wiremock-jar/
├── mappings/          # Stubs (listagem-dividas, health)
├── __files/           # Arquivos estáticos (opcional)
├── run.bat            # Executa no Windows
├── run.sh             # Executa no Linux/macOS
└── README.md
```

## Pré-requisito

- **Java 11+** no PATH.

## 1. Baixar o JAR do WireMock

Baixe o JAR standalone (uma vez) e coloque nesta pasta:

- **Maven Central:**  
  [wiremock-standalone-3.3.1.jar](https://repo1.maven.org/maven2/org/wiremock/wiremock-standalone/3.3.1/wiremock-standalone-3.3.1.jar)

- **PowerShell (baixar direto):**
  ```powershell
  cd wiremock-jar
  Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/org/wiremock/wiremock-standalone/3.3.1/wiremock-standalone-3.3.1.jar" -OutFile "wiremock-standalone-3.3.1.jar"
  ```

## 2. Executar

- **Windows:** dê duplo clique em `run.bat` ou no terminal:
  ```cmd
  cd wiremock-jar
  run.bat
  ```

- **Linux/macOS:**
  ```bash
  cd wiremock-jar
  chmod +x run.sh
  ./run.sh
  ```

O WireMock sobe em **http://localhost:8080** com os mesmos stubs da pasta Docker (`POST /api/listagem-dividas`, `GET /api/listagem-dividas/health`). A aplicação Java pode usar a mesma URL (`http://localhost:8080`) no `application.yml`.

## Exemplo de Request/Response (`POST /api/listagem-dividas`)

**Request:**

```json
{
  "codigo_filial_cnpj_cliente": "0001",
  "controle_cpf_cnpj_cliente": "0",
  "cpf_cnpj_assessoria": "149473164261472601595890479118260607570912546699854916514021124342251992384077",
  "codigo_filial_cnpj_assessoria": "283925109560421935645703960072773362459484834231929486019647005838258736346",
  "controle_cpf_cnpj_assessoria": "4117989216660878221083235",
  "codigo_tipo_canal": 0,
  "portfolios": [
    "banco",
    "cartao"
  ]
}
```

**Response:**

```json
{
  "mensagem": "Listagem obtida com sucesso",
  "sucesso": true,
  "dados": {
    "numero_acordo": 12345,
    "tipo_pessoa": "F",
    "cpf_cnpj_cliente": 12345678901,
    "codigo_filial_cnpj_cliente": 1,
    "controle_cpf_cnpj_cliente": 0,
    "nome_cliente": "Cliente Teste",
    "flag_evento": "S",
    "score": "A",
    "composicao_realizada_p2": "N",
    "composicao_realizada_b2k": "N",
    "contrato": [
      {
        "numero_controle_contrato": 1001,
        "produto_vinculado_contrato": "CDC",
        "valor_vencido_contrato": 1000,
        "valor_total_divida_contrato": 6000,
        "valor_no_vencimento_contrato": 5000,
        "codigo_estado_operacional_contrato": "AT",
        "dias_atraso_contrato": 0,
        "quantidade_parcelas_vencer_contrato": 10,
        "quantidade_parcelas_vencidas_contrato": 0,
        "quantidade_parcelas_pagas": 0,
        "data_celebracao_contrato": "2024-01-15",
        "valor_principal_contrato": 5500
      }
    ]
  },
  "campos": [],
  "timestamp": "2026-02-27 11:15:50"
}
```

---

## Rodar pelo terminal (sem scripts)

Sem usar `run.bat` nem `run.sh`, apenas comandos no terminal.

### 1. Baixar o JAR (uma vez)

No **PowerShell**:

```powershell
cd wiremock-jar
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/org/wiremock/wiremock-standalone/3.3.1/wiremock-standalone-3.3.1.jar" -OutFile "wiremock-standalone-3.3.1.jar" -UseBasicParsing
```

Ou baixe manualmente o [wiremock-standalone-3.3.1.jar](https://repo1.maven.org/maven2/org/wiremock/wiremock-standalone/3.3.1/wiremock-standalone-3.3.1.jar) e coloque na pasta `wiremock-jar`.

### 2. Subir o WireMock

No **PowerShell** ou **CMD**:

```powershell
cd wiremock-jar
java -jar wiremock-standalone-3.3.1.jar --port 8080 --root-dir . --global-response-templating --verbose
```

Para encerrar: **Ctrl+C**.

### 3. Rodar a API Java

Em **outro** terminal:

```powershell
cd listagem-dividas-java
mvn spring-boot:run
```

Swagger: **http://localhost:9090/swagger-ui.html**

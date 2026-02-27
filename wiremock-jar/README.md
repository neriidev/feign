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

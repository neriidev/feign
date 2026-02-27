@echo off
setlocal
set JAR=wiremock-standalone-3.3.1.jar
set ROOT_DIR=%~dp0

if not exist "%ROOT_DIR%%JAR%" (
    echo JAR do WireMock nao encontrado: %JAR%
    echo.
    echo Baixe em: https://repo1.maven.org/maven2/org/wiremock/wiremock-standalone/3.3.1/%JAR%
    echo Ou: https://github.com/wiremock/wiremock/releases/tag/3.3.1
    echo.
    echo Salve o arquivo nesta pasta: %ROOT_DIR%
    pause
    exit /b 1
)

echo Iniciando WireMock na porta 8080 (root-dir: %ROOT_DIR%)...
echo Acesse: http://localhost:8080
echo Encerre com Ctrl+C
echo.

cd /d "%ROOT_DIR%"
java -jar "%JAR%" --port 8080 --root-dir "%ROOT_DIR%" --global-response-templating --verbose

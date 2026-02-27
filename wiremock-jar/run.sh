#!/usr/bin/env bash
set -e
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
JAR="wiremock-standalone-3.3.1.jar"

if [ ! -f "$SCRIPT_DIR/$JAR" ]; then
  echo "JAR do WireMock não encontrado: $JAR"
  echo ""
  echo "Baixe em: https://repo1.maven.org/maven2/org/wiremock/wiremock-standalone/3.3.1/$JAR"
  echo "Ou: https://github.com/wiremock/wiremock/releases/tag/3.3.1"
  echo ""
  echo "Salve o arquivo nesta pasta: $SCRIPT_DIR"
  exit 1
fi

echo "Iniciando WireMock na porta 8080 (root-dir: $SCRIPT_DIR)..."
echo "Acesse: http://localhost:8080"
echo "Encerre com Ctrl+C"
echo ""

cd "$SCRIPT_DIR"
exec java -jar "$JAR" --port 8080 --root-dir "$SCRIPT_DIR" --global-response-templating --verbose

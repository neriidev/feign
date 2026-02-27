# Baixa o WireMock standalone JAR (3.3.1) para esta pasta
$jar = "wiremock-standalone-3.3.1.jar"
$url = "https://repo1.maven.org/maven2/org/wiremock/wiremock-standalone/3.3.1/$jar"
$out = Join-Path $PSScriptRoot $jar

if (Test-Path $out) {
    Write-Host "JAR já existe: $out"
    exit 0
}

Write-Host "Baixando $url ..."
Invoke-WebRequest -Uri $url -OutFile $out -UseBasicParsing
Write-Host "Salvo em: $out"
Write-Host "Execute: .\run.bat"

package br.com.bradesco.listagemdividas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI listagemDividasOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Listagem de Dívidas API")
                        .description("API REST que consome a API mockada (WireMock) via Feign e expõe os endpoints de listagem de dívidas. Arquitetura hexagonal.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Bradesco")
                                .email("api@bradesco.com.br")));
    }
}

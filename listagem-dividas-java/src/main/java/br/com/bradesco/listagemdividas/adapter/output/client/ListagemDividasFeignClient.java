package br.com.bradesco.listagemdividas.adapter.output.client;

import br.com.bradesco.listagemdividas.adapter.input.controller.dto.request.ListagemDividasRequestDTO;
import br.com.bradesco.listagemdividas.core.dto.DefaultResponse;
import br.com.bradesco.listagemdividas.core.dto.ListagemDividasResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Cliente Feign que consome a API mockada pelo WireMock.
 * Adaptador de saída (output adapter) na arquitetura hexagonal.
 */
@FeignClient(
    name = "listagemDividasWiremock",
    url = "${listagem-dividas.wiremock.url}"
)
public interface ListagemDividasFeignClient {

    @PostMapping(value = "/api/listagem-dividas", consumes = "application/json", produces = "application/json")
    DefaultResponse<ListagemDividasResponseDTO> listar(@RequestBody ListagemDividasRequestDTO request);
}

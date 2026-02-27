package br.com.bradesco.listagemdividas.adapter.input.controller;

import br.com.bradesco.listagemdividas.adapter.input.controller.dto.request.ListagemDividasRequestDTO;
import br.com.bradesco.listagemdividas.core.dto.DefaultResponse;
import br.com.bradesco.listagemdividas.core.dto.ListagemDividasResponseDTO;
import br.com.bradesco.listagemdividas.core.domain.ListagemDividasRequest;
import br.com.bradesco.listagemdividas.core.usecase.ListagemDividasUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller REST (adaptador de entrada) - expõe a API de listagem de dívidas.
 * Documentado com Swagger/OpenAPI.
 */
@RestController
@RequestMapping("/api/listagem-dividas")
@RequiredArgsConstructor
@Tag(name = "Listagem de Dívidas", description = "Endpoints que consomem a API mockada (WireMock) e expõem listagem de dívidas")
public class ListagemDividasController {

    private final ListagemDividasUseCase listagemDividasUseCase;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Listar dívidas", description = "Envia a requisição para a API mockada via Feign e retorna a listagem")
    public DefaultResponse<ListagemDividasResponseDTO> listar(@Valid @RequestBody ListagemDividasRequestDTO requestDTO) {
        ListagemDividasRequest request = ListagemDividasRequest.builder()
                .codigoFilialCnpjCliente(requestDTO.getCodigoFilialCnpjCliente())
                .controleCpfCnpjCliente(requestDTO.getControleCpfCnpjCliente())
                .cpfCnpjAssessoria(requestDTO.getCpfCnpjAssessoria())
                .codigoFilialCnpjAssessoria(requestDTO.getCodigoFilialCnpjAssessoria())
                .controleCpfCnpjAssessoria(requestDTO.getControleCpfCnpjAssessoria())
                .codigoTipoCanal(requestDTO.getCodigoTipoCanal())
                .portfolios(requestDTO.getPortfolios())
                .build();
        return listagemDividasUseCase.executar(request);
    }
}

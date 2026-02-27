package br.com.bradesco.listagemdividas.adapter.output;

import br.com.bradesco.listagemdividas.core.dto.DefaultResponse;
import br.com.bradesco.listagemdividas.core.dto.ListagemDividasResponseDTO;
import br.com.bradesco.listagemdividas.adapter.input.controller.dto.request.ListagemDividasRequestDTO;
import br.com.bradesco.listagemdividas.adapter.output.client.ListagemDividasFeignClient;
import br.com.bradesco.listagemdividas.core.domain.ListagemDividasPort;
import br.com.bradesco.listagemdividas.core.domain.ListagemDividasRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Implementação da porta de saída usando Feign.
 * Chama a API mockada no WireMock e mapeia request de domínio para DTO.
 */
@Component
@RequiredArgsConstructor
public class ListagemDividasFeignAdapter implements ListagemDividasPort {

    private final ListagemDividasFeignClient feignClient;

    @Override
    public DefaultResponse<ListagemDividasResponseDTO> listar(ListagemDividasRequest request) {
        ListagemDividasRequestDTO dto = toRequestDTO(request);
        return feignClient.listar(dto);
    }

    private ListagemDividasRequestDTO toRequestDTO(ListagemDividasRequest request) {
        ListagemDividasRequestDTO dto = new ListagemDividasRequestDTO();
        dto.setCodigoFilialCnpjCliente(request.getCodigoFilialCnpjCliente());
        dto.setControleCpfCnpjCliente(request.getControleCpfCnpjCliente());
        dto.setCpfCnpjAssessoria(request.getCpfCnpjAssessoria());
        dto.setCodigoFilialCnpjAssessoria(request.getCodigoFilialCnpjAssessoria());
        dto.setControleCpfCnpjAssessoria(request.getControleCpfCnpjAssessoria());
        dto.setCodigoTipoCanal(request.getCodigoTipoCanal());
        dto.setPortfolios(request.getPortfolios());
        return dto;
    }
}

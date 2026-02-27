package br.com.bradesco.listagemdividas.core.usecase;

import br.com.bradesco.listagemdividas.core.dto.DefaultResponse;
import br.com.bradesco.listagemdividas.core.dto.ListagemDividasResponseDTO;
import br.com.bradesco.listagemdividas.core.domain.ListagemDividasPort;
import br.com.bradesco.listagemdividas.core.domain.ListagemDividasRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Caso de uso: obter listagem de dívidas.
 * Orquestra a porta de saída (serviço externo via Feign).
 */
@Service
@RequiredArgsConstructor
public class ListagemDividasUseCase {

    private final ListagemDividasPort listagemDividasPort;

    public DefaultResponse<ListagemDividasResponseDTO> executar(ListagemDividasRequest request) {
        return listagemDividasPort.listar(request);
    }
}

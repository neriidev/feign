package br.com.bradesco.listagemdividas.core.domain;

import br.com.bradesco.listagemdividas.core.dto.DefaultResponse;
import br.com.bradesco.listagemdividas.core.dto.ListagemDividasResponseDTO;

/**
 * Porta de saída (output port) - contrato para obter listagem de dívidas do serviço externo.
 * Arquitetura hexagonal: o core define o que precisa, o adaptador Feign implementa.
 */
public interface ListagemDividasPort {

    DefaultResponse<ListagemDividasResponseDTO> listar(ListagemDividasRequest request);
}

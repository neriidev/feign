package br.com.bradesco.listagemdividas.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Objeto de entrada do caso de uso (request do domínio).
 */
@Data
@Builder
public class ListagemDividasRequest {

    private String codigoFilialCnpjCliente;
    private String controleCpfCnpjCliente;
    private String cpfCnpjAssessoria;
    private String codigoFilialCnpjAssessoria;
    private String controleCpfCnpjAssessoria;
    private Integer codigoTipoCanal;
    private List<String> portfolios;
}

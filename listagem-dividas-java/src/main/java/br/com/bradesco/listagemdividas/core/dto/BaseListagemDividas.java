package br.com.bradesco.listagemdividas.core.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "Dados base da listagem de dívidas")
public class BaseListagemDividas {

    private Long numeroAcordo;
    private String tipoPessoa;
    private Long cpfCnpjCliente;
    private Integer codigoFilialCnpjCliente;
    private Integer controleCpfCnpjCliente;
    private String nomeCliente;
    private String flagEvento;
    private String score;
    private String composicaoRealizadaP2;
    private String composicaoRealizadaB2k;
}

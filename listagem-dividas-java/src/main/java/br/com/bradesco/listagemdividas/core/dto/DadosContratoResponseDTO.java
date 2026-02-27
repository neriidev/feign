package br.com.bradesco.listagemdividas.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "Dados de contrato na listagem de dívidas")
public class DadosContratoResponseDTO {

    private Long numeroControleContrato;
    private Long codigoEmpresa;
    private String descricaoEmpresa;
    private Integer codigoBanco;
    private Integer codigoAgencia;
    private Long contaContratoOrigem;
    private String codigoCarteira;
    private Long contratoOrigem;
    private Integer codigoProdutoOrigem;
    private String produtoVinculadoContrato;
    private BigDecimal valorAVencerContrato;
    private BigDecimal valorVencidoContrato;
    private BigDecimal valorTotalDividaContrato;
    private BigDecimal valorNoVencimentoContrato;
    private String codigoEstadoOperacionalContrato;
    private String identificadorGarantiaContrato;
    private Integer diasAtrasoContrato;
    private Integer quantidadeParcelasVencerContrato;
    private Integer quantidadeParcelasVencidasContrato;
    private Integer quantidadeParcelasPagas;
    private String dataCelebracaoContrato;
    private Integer codigoPeriodicidadeTaxaJuros;
    private BigDecimal taxaJurosContrato;
    private BigDecimal valorPrincipalContrato;
    private BigDecimal valorDespesasJudiciais;
    private BigDecimal valorMulta;
    private BigDecimal valorCorrigido;
    private String descricaoBandeira;
    private String identificadorContratoAjuizado;
    private Integer codigoOperacaoNovacao;
}

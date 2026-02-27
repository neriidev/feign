package br.com.bradesco.listagemdividas.adapter.input.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "Requisição para listagem de dívidas")
public class ListagemDividasRequestDTO {

    @Schema(description = "Código filial CNPJ cliente", example = "0001")
    @Pattern(regexp = "\\d+", message = "deve conter apenas dígitos")
    private String codigoFilialCnpjCliente;

    @Schema(description = "Controle CPF/CNPJ cliente", example = "0")
    @Pattern(regexp = "\\d+", message = "deve conter apenas dígitos")
    private String controleCpfCnpjCliente;

    @NotNull(message = "é obrigatório")
    @Schema(description = "CPF/CNPJ assessoria")
    @Pattern(regexp = "\\d+", message = "deve conter apenas dígitos")
    private String cpfCnpjAssessoria;

    @Schema(description = "Código filial CNPJ assessoria")
    @Pattern(regexp = "\\d+", message = "deve conter apenas dígitos")
    private String codigoFilialCnpjAssessoria;

    @Schema(description = "Controle CPF/CNPJ assessoria")
    @Pattern(regexp = "\\d+", message = "deve conter apenas dígitos")
    private String controleCpfCnpjAssessoria;

    @PositiveOrZero(message = "deve ser zero ou positivo")
    @Schema(description = "Código tipo canal")
    private Integer codigoTipoCanal;

    @Schema(description = "Portfólios a serem consultados", example = "[\"banco\", \"cartao\"]")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> portfolios;
}

package br.com.bradesco.listagemdividas.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Resposta padrão da API")
public class DefaultResponse<T> {

    @Schema(description = "Mensagem de retorno")
    private String mensagem;

    @Schema(description = "Indica se a operação foi bem-sucedida")
    private boolean sucesso;

    @Schema(description = "Dados da resposta")
    private T dados;

    @Schema(description = "Lista de campos com detalhes ou erros")
    private List<CampoDTO> campos;

    @Schema(description = "Timestamp da resposta")
    private String timestamp;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CampoDTO {
        private String nome;
        private String mensagem;
    }
}

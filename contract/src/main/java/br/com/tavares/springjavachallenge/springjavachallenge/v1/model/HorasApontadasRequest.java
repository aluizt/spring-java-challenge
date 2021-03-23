package br.com.tavares.springjavachallenge.springjavachallenge.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HorasApontadasRequest {

    @NotNull(message = "Obrigatório informar a mátricula do usuário!")
    @Schema(description = "Identificação do usuário", example = "3")
    private Integer matriculaUsuario;

    @NotNull(message = "Obrigatório informar o ID do projeto!")
    @Schema(description = "Identificação do projeto", example = "2")
    private Integer idProjeto;

    @NotNull(message = "Obrigatório informar as horas utilizadas!")
    @Schema(description = "Horas trabalhadas", example = "08:00")
    private String tempo;

    @NotNull(message = "Obrigatório informar a data de lançamento das horas!")
    @Schema(description = "Dia onde as horas foram consumidas", example = "23-03-2021")
    private String dataApontamento;
}

package br.com.tavares.springjavachallenge.springjavachallenge.v1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HorasApontadasRequest {
    @NotNull
    private Integer matriculaUsuario;
    private Integer idProjeto;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime tempo;
    private LocalDate dataApontamento;
}

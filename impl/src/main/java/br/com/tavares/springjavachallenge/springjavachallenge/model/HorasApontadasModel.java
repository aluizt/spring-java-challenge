package br.com.tavares.springjavachallenge.springjavachallenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HorasApontadasModel {
    private Integer matriculaUsuario;
    private Integer idProjeto;
    private LocalTime horas;
    private String totalDeHoras;
    private LocalDate dataApontamento;
}

package br.com.tavares.springjavachallenge.springjavachallenge.v1.model;

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
public class HorasApontadasResponse {
    private Integer matriculaUsuario;
    private Integer idProjeto;
    private LocalTime tempo;
    private String totalDeHoras;
    private LocalDate dataApontamento;
}

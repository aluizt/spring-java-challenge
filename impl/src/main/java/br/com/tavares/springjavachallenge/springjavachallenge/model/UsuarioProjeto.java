package br.com.tavares.springjavachallenge.springjavachallenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioProjeto {
    private Integer matriculaUsuario;
    private Double horas;
    private LocalDate dataApontamento;
}

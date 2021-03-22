package br.com.tavares.springjavachallenge.springjavachallenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {
    private Integer matriculaUsuario;
    private String nomeUsuario;
    private Integer tipoUsuario;
}

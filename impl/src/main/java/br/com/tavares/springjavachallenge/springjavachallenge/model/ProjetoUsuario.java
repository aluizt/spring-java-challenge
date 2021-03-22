package br.com.tavares.springjavachallenge.springjavachallenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoUsuario {
    private Integer matriculaUsuario;
    private Integer idProjeto;
}

package br.com.tavares.springjavachallenge.springjavachallenge.v1.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
    @NotNull(message = "A matrícula do usuário é obrigatória para esta consulta!")
    private Integer matriculaUsuario;
}

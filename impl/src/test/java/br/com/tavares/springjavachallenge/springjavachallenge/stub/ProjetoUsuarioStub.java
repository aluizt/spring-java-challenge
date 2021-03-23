package br.com.tavares.springjavachallenge.springjavachallenge.stub;

import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoUsuario;

import java.util.Arrays;
import java.util.List;

public class ProjetoUsuarioStub {

    public static List<ProjetoUsuario> getProjetoUsuarioList() {
        return Arrays.asList(getProjetoUsuario());
    }

    public static ProjetoUsuario getProjetoUsuario() {
        return ProjetoUsuario.builder()
                .matriculaUsuario(1)
                .idProjeto(1)
                .build();
    }
}

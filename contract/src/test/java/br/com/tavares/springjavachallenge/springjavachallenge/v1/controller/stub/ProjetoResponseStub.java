package br.com.tavares.springjavachallenge.springjavachallenge.v1.controller.stub;

import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.ProjetosResponse;

public class ProjetoResponseStub {

    public static ProjetosResponse getProjetosResponse() {
        return ProjetosResponse.builder()
                .projetos(ProjetoModelStub.getProjetoModelList())
                .build();
    }
}

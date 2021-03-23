package br.com.tavares.springjavachallenge.springjavachallenge.v1.mapper;

import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.ProjetosResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProjetoMapper {

    public static ProjetosResponse maptoProjetoResponse(List<ProjetoModel> projetosModel) {
        return ProjetosResponse.builder()
                .projetos(projetosModel)
                .build();

    }
}

package br.com.tavares.springjavachallenge.springjavachallenge.v1.model;

import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjetosResponse {
    private List<ProjetoModel> projetos;
}

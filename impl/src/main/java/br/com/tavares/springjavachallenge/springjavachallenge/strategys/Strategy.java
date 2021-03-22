package br.com.tavares.springjavachallenge.springjavachallenge.strategys;

import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;

import java.util.List;

public interface Strategy {

    Boolean selecionaUsuario(Integer matriculaUsuario);

    List<ProjetoModel> buscarProjetos(Integer matriculaUsuario);
}

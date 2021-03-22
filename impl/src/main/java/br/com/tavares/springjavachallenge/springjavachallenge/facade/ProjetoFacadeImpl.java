package br.com.tavares.springjavachallenge.springjavachallenge.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoUsuario;
import br.com.tavares.springjavachallenge.springjavachallenge.service.ProjetoService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjetoFacadeImpl {

    private final ProjetoService projetoService;

    public ProjetoFacadeImpl(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    public List<ProjetoUsuario> buscaProjetosDoUsuario(Integer matriculaUsuario) {
        return projetoService.buscarProjetos(matriculaUsuario);
    }
}

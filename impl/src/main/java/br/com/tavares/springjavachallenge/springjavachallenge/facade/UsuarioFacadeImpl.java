package br.com.tavares.springjavachallenge.springjavachallenge.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import br.com.tavares.springjavachallenge.springjavachallenge.model.UsuarioModel;
import br.com.tavares.springjavachallenge.springjavachallenge.service.UsuarioService;
import br.com.tavares.springjavachallenge.springjavachallenge.strategys.ProjetoStrategyService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioFacadeImpl {
    private UsuarioService usuarioService;
    private ProjetoStrategyService projetoStrategyService;

    public UsuarioFacadeImpl(UsuarioService usuarioServicey, ProjetoStrategyService projetoStrategyService) {
        this.usuarioService = usuarioServicey;
        this.projetoStrategyService = projetoStrategyService;
    }

    public UsuarioModel buscaUsuario(Integer matriculaUsuario) {
        return usuarioService.buscaUsuario(matriculaUsuario);
    }

    public List<ProjetoModel> buscaProjetosDoUsuario(Integer matriculaUsuario) {
        return projetoStrategyService.buscarProjetosStrategy(buscaUsuario(matriculaUsuario));
    }
}

package br.com.tavares.springjavachallenge.springjavachallenge.v1.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.facade.UsuarioFacadeImpl;
import br.com.tavares.springjavachallenge.springjavachallenge.model.UsuarioModel;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.ProjetosResponse;
import org.springframework.stereotype.Component;

import static br.com.tavares.springjavachallenge.springjavachallenge.v1.mapper.ProjetoMapper.maptoProjetoResponse;

@Component
public class UsuarioFacade {

    private UsuarioFacadeImpl usuarioFacadeImpl;

    public UsuarioFacade(UsuarioFacadeImpl usuarioFacadeImpl) {
        this.usuarioFacadeImpl = usuarioFacadeImpl;
    }

    public ProjetosResponse buscaProjetosDoUsuario(Integer matriculaUsuario) {
        return maptoProjetoResponse(usuarioFacadeImpl.buscaProjetosDoUsuario(matriculaUsuario));
    }

    public UsuarioModel buscaUsuario(Integer matriculaUsuario) {
        return usuarioFacadeImpl.buscaUsuario(matriculaUsuario);
    }

}

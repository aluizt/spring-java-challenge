package br.com.tavares.springjavachallenge.springjavachallenge.v1.controller;

import br.com.tavares.springjavachallenge.springjavachallenge.v1.facade.UsuarioFacade;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.ProjetosResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/usuarios")
@Tag(name = "Usuario Controller", description = "Responsável por gerenciar usuários e seus projetos")
public class UsuarioController {

    private final UsuarioFacade usuarioFacade;

    public UsuarioController(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    @GetMapping("/{matriculaUsuario}/projetos")
    @ResponseStatus(HttpStatus.OK)
    public ProjetosResponse buscaProjetosDoUsuario(@PathVariable("matriculaUsuario") Integer matriculaUsuario) {
        return usuarioFacade.buscaProjetosDoUsuario(matriculaUsuario);
    }


}

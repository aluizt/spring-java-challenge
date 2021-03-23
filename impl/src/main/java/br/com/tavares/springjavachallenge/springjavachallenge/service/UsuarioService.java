package br.com.tavares.springjavachallenge.springjavachallenge.service;

import br.com.tavares.springjavachallenge.springjavachallenge.model.UsuarioModel;
import br.com.tavares.springjavachallenge.springjavachallenge.repository.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel buscaUsuario(Integer matriculaUsuario) {
        return usuarioRepository.buscarUsuario(matriculaUsuario);
    }
}

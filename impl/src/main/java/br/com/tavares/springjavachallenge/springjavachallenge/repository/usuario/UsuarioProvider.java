package br.com.tavares.springjavachallenge.springjavachallenge.repository.usuario;

import java.util.Map;

public class UsuarioProvider {

    public String buscarUsuario(Map<?, ?> params) {
        Integer matriculaUsuario = (Integer) params.get("matriculaUsuario");
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * FROM USUARIOS ");
        sb.append(" WHERE MATRICULA_USUARIO = ").append(matriculaUsuario);
        return sb.toString();
    }
}

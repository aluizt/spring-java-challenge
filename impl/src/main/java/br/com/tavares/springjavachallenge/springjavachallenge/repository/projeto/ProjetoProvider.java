package br.com.tavares.springjavachallenge.springjavachallenge.repository.projeto;

import java.util.Map;
import java.util.Objects;

public class ProjetoProvider {

    public String buscarProjetosPorUsuario(Map<?, ?> params) {
        Integer matriculaUsuario = (Integer) params.get("matriculaUsuario");
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * FROM USUARIOS_PROJETOS ");
        if (Objects.nonNull(matriculaUsuario)) {
            sb.append(" WHERE MATRICULA_USUARIO = ").append(matriculaUsuario);
        }
        return sb.toString();
    }
}

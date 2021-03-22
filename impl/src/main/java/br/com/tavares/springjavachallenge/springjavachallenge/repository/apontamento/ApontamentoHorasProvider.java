package br.com.tavares.springjavachallenge.springjavachallenge.repository.apontamento;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;

import java.util.Map;
import java.util.Objects;

public class ApontamentoHorasProvider {
    public String adicionarHoras(Map<?, ?> params) {
        HorasApontadasModel horasApontadasModel = (HorasApontadasModel) params.get("horasApontadasModel");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO HORAS_APONTADAS ");
        sb.append("VALUES(").append(horasApontadasModel.getMatriculaUsuario()).append(",");
        sb.append(horasApontadasModel.getIdProjeto()).append(",'");
        sb.append(horasApontadasModel.getHoras()).append("','");
        sb.append(horasApontadasModel.getDataApontamento()).append("')");
        return sb.toString();
    }

    public String buscarHoras(Map<?, ?> params) {
        Integer matriculaUsuario = (Integer) params.get("matriculaUsuario");
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * FROM HORAS_APONTADAS ");
        if (Objects.nonNull(matriculaUsuario)) {
            sb.append("WHERE MATRICULA_USUARIO = ").append(matriculaUsuario);
        }
        return sb.toString();
    }
}

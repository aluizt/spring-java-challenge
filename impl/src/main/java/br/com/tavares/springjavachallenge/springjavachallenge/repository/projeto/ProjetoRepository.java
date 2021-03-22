package br.com.tavares.springjavachallenge.springjavachallenge.repository.projeto;

import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoUsuario;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjetoRepository {

    @SelectProvider(type = ProjetoProvider.class, method = "buscarProjetosPorUsuario")
    @Results(value = {
            @Result(column = "MATRICULA_USUARIO", property = "matriculaUsuario"),
            @Result(column = "ID_PROJETO", property = "idProjeto")
    })
    List<ProjetoUsuario> buscarProjetosPorUsuario(@Param("matriculaUsuario") Integer matriculaUsuario);
}

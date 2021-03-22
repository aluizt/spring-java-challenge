package br.com.tavares.springjavachallenge.springjavachallenge.repository.apontamento;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApontamentoHorasRepository {

    @InsertProvider(type = ApontamentoHorasProvider.class, method = "adicionarHoras")
    Integer adicionarHoras(@Param("horasApontadasModel") HorasApontadasModel horasApontadasModel);

    @SelectProvider(type = ApontamentoHorasProvider.class, method = "buscarHoras")
    @Results(value = {
            @Result(column = "MATRICULA_USUARIO", property = "matriculaUsuario"),
            @Result(column = "ID_PROJETO", property = "idProjeto"),
            @Result(column = "HORAS_APONTADAS", property = "horas")
    })
    List<HorasApontadasModel> bucarHorasProjeto(@Param("matriculaUsuario") Integer matriculaUsuario);
}

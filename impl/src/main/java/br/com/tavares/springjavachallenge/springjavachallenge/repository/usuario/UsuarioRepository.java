package br.com.tavares.springjavachallenge.springjavachallenge.repository.usuario;

import br.com.tavares.springjavachallenge.springjavachallenge.model.UsuarioModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UsuarioRepository {

    @SelectProvider(type = UsuarioProvider.class, method = "buscarUsuario")
    @Results(value = {
            @Result(column = "MATRICULA_USUARIO", property = "matriculaUsuario"),
            @Result(column = "NOME_USUARIO", property = "nomeUsuario"),
            @Result(column = "TIPO_USUARIO", property = "tipoUsuario")
    })
    UsuarioModel buscarUsuario(@Param("matriculaUsuario") Integer matriculaUsuario);
}

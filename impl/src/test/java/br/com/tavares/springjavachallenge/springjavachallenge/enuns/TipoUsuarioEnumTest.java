package br.com.tavares.springjavachallenge.springjavachallenge.enuns;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class TipoUsuarioEnumTest {

    /**
     * Dado que o metodo [getTipoUsuario] do enum USUARIO
     * Deve retornar o valor 2
     */
    @Test
    void deve_retornar_o_tipo_de_usuario_2() {
        Assert.assertEquals(java.util.Optional.of(2).get(), TipoUsuarioEnum.USUARIO.getTipoUsuario());
    }

    /**
     * Dado que o metodo [getTipoUsuario] do enum ADMINISTRADOR
     * Deve retornar o valor 1
     */
    @Test
    void deve_retornar_o_tipo_de_usuario_1() {
        Assert.assertEquals(java.util.Optional.of(1).get(), TipoUsuarioEnum.ADMINISTRADOR.getTipoUsuario());
    }
}
package br.com.tavares.springjavachallenge.springjavachallenge.service;

import br.com.tavares.springjavachallenge.springjavachallenge.model.UsuarioModel;
import br.com.tavares.springjavachallenge.springjavachallenge.repository.usuario.UsuarioRepository;
import br.com.tavares.springjavachallenge.springjavachallenge.stub.UsuarioModelStub;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;
    @InjectMocks
    private UsuarioService usuarioService;

    /**
     * Dado que o metodo [buscaUsuario] seja chamado ...
     * Deve retornar um UsuarioModel
     */
    @Test
    public void deve_retornar_um_usuariomodel() {
        when(usuarioRepository.buscarUsuario(any())).thenReturn(UsuarioModelStub.getUsuarioModel());
        UsuarioModel response = usuarioService.buscaUsuario(1);
        Assert.assertEquals(UsuarioModelStub.getUsuarioModel(), response);
    }
}
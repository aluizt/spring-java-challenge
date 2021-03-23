package br.com.tavares.springjavachallenge.springjavachallenge.strategys;

import br.com.tavares.springjavachallenge.springjavachallenge.facade.stub.HorasApontadasModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.facade.stub.ProjetoModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import br.com.tavares.springjavachallenge.springjavachallenge.service.ApontamentoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class UsuarioStrategyTest {
    @Mock
    private ApontamentoService apontamentoService;

    @InjectMocks
    private UsuarioStrategy usuarioStrategy;

    /**
     * Dado que o metodo [selecionauUsuario] seja chamado...
     * Dado que seja passado o usuario 2
     * Deve retornar true
     */
    @Test
    void deve_retornar_true() {
        Assert.assertTrue(usuarioStrategy.selecionaUsuario(2));
    }

    /**
     * Dado que o metodo [selecionauUsuario] seja chamado...
     * Dado que seja passado o usuario diferente de 2
     * Deve retornar false
     */
    @Test
    void deve_retornar_false() {
        Assert.assertFalse(usuarioStrategy.selecionaUsuario(1));
    }

    /**
     * Dado que o metodo [buscarProjetos] seja chaamdo...
     * Deve retornar uma lista de ProjetoModel
     */
    @Test
    void deve_retornar_uma_lista_de_projetomodel() {
        when(apontamentoService.buscarHorasPorUsuario(any()))
                .thenReturn(HorasApontadasModelStub.getHorasApontadasModelList());
        List<ProjetoModel> response = usuarioStrategy.buscarProjetos(1);
        Assert.assertEquals(ProjetoModelStub.getProjetoModelListSemProjeto(), response);
    }
}
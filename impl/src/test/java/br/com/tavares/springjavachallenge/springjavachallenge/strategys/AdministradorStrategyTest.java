package br.com.tavares.springjavachallenge.springjavachallenge.strategys;

import br.com.tavares.springjavachallenge.springjavachallenge.facade.stub.HorasApontadasModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.facade.stub.ProjetoModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import br.com.tavares.springjavachallenge.springjavachallenge.service.ApontamentoService;
import br.com.tavares.springjavachallenge.springjavachallenge.util.AgrupadorDeProjetos;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest
class AdministradorStrategyTest {
    @Mock
    private ApontamentoService apontamentoService;
    @Mock
    private AgrupadorDeProjetos agrupadorDeProjetos;
    @InjectMocks
    private AdministradorStrategy administradorStrategy;

    /**
     * Dado que o metodo [selecionauUsuario] seja chamado...
     * Dado que seja passado o usuario 1
     * Deve retornar true
     */
    @Test
    void deve_retornar_true() {
        Assert.assertTrue(administradorStrategy.selecionaUsuario(1));
    }

    /**
     * Dado que o metodo [selecionauUsuario] seja chamado...
     * Dado que seja passado o usuario diferente de 1
     * Deve retornar false
     */
    @Test
    void deve_retornar_false() {
        Assert.assertFalse(administradorStrategy.selecionaUsuario(2));
    }

    /**
     * Dado que o metodo [buscarProjetos] seja chaamdo...
     * Deve retornar uma lista de ProjetoModel
     */
    @Test
    void deve_retornar_uma_lista_de_projetomodel() {
        when(apontamentoService.buscarHorasPorUsuario(any()))
                .thenReturn(HorasApontadasModelStub.getHorasApontadasModelList());
        when(agrupadorDeProjetos.agrupaProjetos(any())).thenReturn(ProjetoModelStub.getProjetoModelList());
        List<ProjetoModel> response = administradorStrategy.buscarProjetos(1);
        Assert.assertEquals(ProjetoModelStub.getProjetoModelList(), response);
    }
}
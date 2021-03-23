package br.com.tavares.springjavachallenge.springjavachallenge.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.facade.stub.ProjetoModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import br.com.tavares.springjavachallenge.springjavachallenge.model.UsuarioModel;
import br.com.tavares.springjavachallenge.springjavachallenge.service.UsuarioService;
import br.com.tavares.springjavachallenge.springjavachallenge.strategys.ProjetoStrategyService;
import br.com.tavares.springjavachallenge.springjavachallenge.stub.UsuarioModelStub;
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
class UsuarioFacadeImplTest {
    @Mock
    private UsuarioService usuarioService;
    @Mock
    private ProjetoStrategyService projetoStrategyService;
    @InjectMocks
    private UsuarioFacadeImpl usuarioFacade;

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Deve retornar uma lista de ProjetoModel
     */
    @Test
    public void deve_retornar_uma_lista_de_projetomodel() {
        UsuarioModel usuarioModel = UsuarioModelStub.getUsuarioModel();
        when(usuarioService.buscaUsuario(any())).thenReturn(usuarioModel);
        when(projetoStrategyService.buscarProjetosStrategy(usuarioModel))
                .thenReturn(ProjetoModelStub.getProjetoModelList());
        List<ProjetoModel> response = usuarioFacade.buscaProjetosDoUsuario(2);
        Assert.assertEquals(ProjetoModelStub.getProjetoModelList(), response);
    }
}
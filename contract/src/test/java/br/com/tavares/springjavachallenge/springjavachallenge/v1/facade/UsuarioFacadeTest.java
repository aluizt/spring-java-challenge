package br.com.tavares.springjavachallenge.springjavachallenge.v1.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.facade.UsuarioFacadeImpl;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.controller.stub.ProjetoModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.ProjetosResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class UsuarioFacadeTest {

    @Mock
    private UsuarioFacadeImpl usuarioFacadeImpl;
    @InjectMocks
    private UsuarioFacade usuarioFacade;

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Deve retornar um objeto ProjetosResponse
     */
    @Test
    void deve_retonar_um_projetoresponse() {
        List<ProjetoModel> projetoModelList = ProjetoModelStub.getProjetoModelList();
        when(usuarioFacadeImpl.buscaProjetosDoUsuario(any())).thenReturn(projetoModelList);
        ProjetosResponse response = usuarioFacade.buscaProjetosDoUsuario(2);
        Assert.assertEquals(
                projetoModelList.get(0).getHorasApontadas(), response.getProjetos().get(0).getHorasApontadas()
        );
        Assert.assertEquals(projetoModelList.get(0).getProjeto(), response.getProjetos().get(0).getProjeto());
    }
}
package br.com.tavares.springjavachallenge.springjavachallenge.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoUsuario;
import br.com.tavares.springjavachallenge.springjavachallenge.service.ProjetoService;
import br.com.tavares.springjavachallenge.springjavachallenge.stub.ProjetoUsuarioStub;
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
class ProjetoFacadeImplTest {
    @Mock
    private ProjetoService projetoService;
    @InjectMocks
    private ProjetoFacadeImpl projetoFacade;

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Deve retornar uma lista de ProjetoUsuario
     */
    @Test
    void deve_retornar_uma_lista_de_projetosusuario() {
        when(projetoService.buscarProjetos(any())).thenReturn(ProjetoUsuarioStub.getProjetoUsuarioList());
        List<ProjetoUsuario> response = projetoFacade.buscaProjetosDoUsuario(2);
        Assert.assertEquals(ProjetoUsuarioStub.getProjetoUsuarioList(), response);
    }
}
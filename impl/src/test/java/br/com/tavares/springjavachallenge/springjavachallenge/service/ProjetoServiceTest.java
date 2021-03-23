package br.com.tavares.springjavachallenge.springjavachallenge.service;

import br.com.tavares.springjavachallenge.springjavachallenge.exception.GenericException;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoUsuario;
import br.com.tavares.springjavachallenge.springjavachallenge.repository.projeto.ProjetoRepository;
import br.com.tavares.springjavachallenge.springjavachallenge.stub.ProjetoUsuarioStub;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProjetoServiceTest {

    @Mock
    private ProjetoRepository projetoRepository;
    @InjectMocks
    private ProjetoService projetoService;

    /**
     * Dado que o metodo [buscarProjetos] seja chamado..
     * Deve retornar uma lista de ProjetoUsuario
     */
    @Test
    void teste_retornar_uma_lista_de_projetousuario() {
        when(projetoRepository.buscarProjetosPorUsuario(any())).thenReturn(ProjetoUsuarioStub.getProjetoUsuarioList());
        List<ProjetoUsuario> response = projetoService.buscarProjetos(2);
        Assert.assertEquals(ProjetoUsuarioStub.getProjetoUsuarioList(), response);
    }

    /**
     * Dado que o metodo [buscarProjetos] seja chamado..
     * Dado que ocorra uma DataAccessException
     * Deve retornar uma GenericException
     */
    @Test
    void deve_retornar_uma_genericException() {
        when(projetoRepository.buscarProjetosPorUsuario(any())).thenThrow(new DataAccessException("") {
        });
        Assert.assertThrows(GenericException.class, () -> projetoService.buscarProjetos(2));
    }

}
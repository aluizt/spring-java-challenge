package br.com.tavares.springjavachallenge.springjavachallenge.service;

import br.com.tavares.springjavachallenge.springjavachallenge.exception.GenericException;
import br.com.tavares.springjavachallenge.springjavachallenge.facade.ProjetoFacadeImpl;
import br.com.tavares.springjavachallenge.springjavachallenge.facade.stub.HorasApontadasModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoUsuario;
import br.com.tavares.springjavachallenge.springjavachallenge.repository.apontamento.ApontamentoHorasRepository;
import br.com.tavares.springjavachallenge.springjavachallenge.stub.ProjetoUsuarioStub;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest
class ApontamentoServiceTest {
    @Mock
    private ApontamentoHorasRepository apontamentoHorasRepository;
    @Mock
    private ProjetoFacadeImpl projetoFacadeImpl;
    @InjectMocks
    private ApontamentoService apontamentoService;

    /**
     * Dado que o metodo [adicionarHoras] seja chamado...
     * Deve verificar se o metodo [adicionarHoras] da classe ApontamentoHorasRepository foi chamado
     */
    @Test
    void deve_verificar_se_o_metodo_adicionarHoras_foi_executado() {
        HorasApontadasModel horasApontadasModel = HorasApontadasModelStub.getHorasApontadasModel();
        when(apontamentoHorasRepository.adicionarHoras(any())).thenReturn(1);
        apontamentoService.adicionarHoras(horasApontadasModel);
        verify(apontamentoHorasRepository, times(1)).adicionarHoras(any());
    }

    /**
     * Dado que o metodo [adicionarHoras] seja chamado...
     * Dado que ocorra uma DataAccessException
     * Deve retornar uma GenericException
     */
    @Test
    void deve_retornar_genericException() {
        HorasApontadasModel horasApontadasModel = HorasApontadasModelStub.getHorasApontadasModel();
        when(apontamentoHorasRepository.adicionarHoras(any())).thenThrow(new DataAccessException("") {
        });
        Assert.assertThrows(GenericException.class, () -> apontamentoService.adicionarHoras(horasApontadasModel));
    }

    /**
     * Dado que o metodo [buscarHorasPorUsuario] seja chamado...
     * Deve retornar uma lista de HorasApontadas
     */
    @Test
    void deve_retornar_uma_lista_de_horas_apontadas() {
        when(apontamentoHorasRepository.bucarHorasProjeto(any()))
                .thenReturn(HorasApontadasModelStub.getHorasApontadasModelList());
        List<HorasApontadasModel> response = apontamentoService.buscarHorasPorUsuario(2);
        Assert.assertEquals(HorasApontadasModelStub.getHorasApontadasModelList(), response);
    }

    /**
     * Dado que o metodo [buscarHorasPorUsuario] seja chamado...
     * Dado que ocorra uma DataAccessException
     * Deve retornar uma GenericException
     */
    @Test
    void deve_retornar_uma_genericException_quando_ocorrer_dataAccessException() {
        when(apontamentoHorasRepository.bucarHorasProjeto(any())).thenThrow(new DataAccessException("") {
        });
        Assert.assertThrows(GenericException.class, () -> apontamentoService.buscarHorasPorUsuario(2));
    }

    /**
     * Dado que o metodo [validarProjeto] seja chamado
     * Deve retornar um objeto ProjetoUsuario
     */
    @Test
    public void deve_retornar_um_projetousuario() {
        when(projetoFacadeImpl.buscaProjetosDoUsuario(any())).thenReturn(ProjetoUsuarioStub.getProjetoUsuarioList());
        ProjetoUsuario response = apontamentoService.validarProjeto(HorasApontadasModelStub.getHorasApontadasModel());
        Assert.assertEquals(ProjetoUsuarioStub.getProjetoUsuarioList().get(0), response);
    }

    /**
     * Dado que o metodo [validarProjeto] seja chamado
     * Deve retornar uma GenericException
     */
    @Test
    public void deve_retornar_uma_genericException() {
        List<ProjetoUsuario> projetoUsuarioList = ProjetoUsuarioStub.getProjetoUsuarioList();
        projetoUsuarioList.get(0).setIdProjeto(10);
        when(projetoFacadeImpl.buscaProjetosDoUsuario(any())).thenReturn(projetoUsuarioList);
        Assert.assertThrows(
                GenericException.class, () -> apontamentoService.validarProjeto(
                        HorasApontadasModelStub.getHorasApontadasModel()));
    }
}
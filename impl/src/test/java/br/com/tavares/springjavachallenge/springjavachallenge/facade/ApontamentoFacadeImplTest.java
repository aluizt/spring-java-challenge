package br.com.tavares.springjavachallenge.springjavachallenge.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.facade.stub.HorasApontadasModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import br.com.tavares.springjavachallenge.springjavachallenge.service.ApontamentoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest
class ApontamentoFacadeImplTest {
    @Mock
    private ApontamentoService apontamentoService;
    @InjectMocks
    private ApontamentoFacadeImpl apontamentoFacade;

    /**
     * Dado que o metodo [adicionarHoras] seja chamado...
     * Deve verificar se o metodo [adicionarHoras] da classe ApontamentoService foi executado
     */
    @Test
    void deve_verificar_se_adicionarHoras_foi_executado() {
        HorasApontadasModel horasApontadasModel = HorasApontadasModelStub.getHorasApontadasModel();
        when(apontamentoService.adicionarHoras(any())).thenReturn(1);
        apontamentoFacade.adicionarHoras(horasApontadasModel);
        verify(apontamentoService, times(1)).adicionarHoras(any());
    }
}
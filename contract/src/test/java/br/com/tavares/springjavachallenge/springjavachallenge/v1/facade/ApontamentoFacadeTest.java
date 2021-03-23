package br.com.tavares.springjavachallenge.springjavachallenge.v1.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.facade.ApontamentoFacadeImpl;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.controller.stub.HorasApontadasModelStub;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootConfiguration
@SpringBootTest
class ApontamentoFacadeTest {

    @Mock
    private ApontamentoFacadeImpl apontamentoFacadeImpl;
    @InjectMocks
    private ApontamentoFacade apontamentoFacade;

    /**
     * Dado que o metodo[adicionarHoras] seja chamado...
     * Deve verificar se o metodo [adicionarHoras] da classe ApontamentoFacadeImpl foi executado
     */
    @Test
    public void deve_verifiar_se_metodo_adicionarhoras_foi_executado() {
        when(apontamentoFacadeImpl.adicionarHoras(any())).thenReturn(1);
        apontamentoFacade.adicionarHoras(HorasApontadasModelStub.getHorasApontadasModel());
        verify(apontamentoFacadeImpl, times(1)).adicionarHoras(any());
    }
}
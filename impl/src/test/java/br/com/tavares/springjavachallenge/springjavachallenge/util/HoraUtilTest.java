package br.com.tavares.springjavachallenge.springjavachallenge.util;

import br.com.tavares.springjavachallenge.springjavachallenge.facade.stub.HorasApontadasModelStub;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
class HoraUtilTest {
    private HoraUtil horaUtil = new HoraUtil();

    /**
     * Dado que o metodo [acumularHoras] seja chamado...
     * Deve retornar a soma das horas
     */
    @Test
    void deve_retornar_a_soma_das_horas() {
        assertEquals("10:00", horaUtil.acumularHoras(HorasApontadasModelStub.getHorasApontadasModelList()));
    }
}
package br.com.tavares.springjavachallenge.springjavachallenge.util;

import br.com.tavares.springjavachallenge.springjavachallenge.facade.stub.HorasApontadasModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.facade.stub.ProjetoModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest
class AgrupadorDeProjetosTest {
    @Mock
    private HoraUtil horaUtil;
    @InjectMocks
    private AgrupadorDeProjetos agrupadorDeProjetos;

    /**
     * Dado que o metodo [agrupaProjetos] seja chamado
     * Deve retornar uma lista de ProjetoModel
     */
    @Test
    void deve_retornar_uma_lista_de_projetomodel() {
        List<ProjetoModel> projetoModel = ProjetoModelStub.getProjetoModelListSemHoras();
        List<ProjetoModel> response = agrupadorDeProjetos.agrupaProjetos(HorasApontadasModelStub
                .getHorasApontadasModelList());
        Assert.assertEquals(projetoModel, response);
    }
}
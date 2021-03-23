package br.com.tavares.springjavachallenge.springjavachallenge.v1.mapper;

import br.com.tavares.springjavachallenge.springjavachallenge.v1.controller.stub.ProjetoModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.controller.stub.ProjetoResponseStub;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.ProjetosResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class ProjetoMapperTest {

    /**
     * Dado que o metodo [maptoProjetoResponse] seja chamado ...
     * Deve retornar um objeto ProjetosResponse
     */
    @Test
    public void deve_retornar_um_objeto_projetosresponse() {
        ProjetosResponse projetosResponse = ProjetoResponseStub.getProjetosResponse();
        ProjetosResponse response = ProjetoMapper.maptoProjetoResponse(ProjetoModelStub.getProjetoModelList());
        Assert.assertEquals(projetosResponse, response);
    }
}
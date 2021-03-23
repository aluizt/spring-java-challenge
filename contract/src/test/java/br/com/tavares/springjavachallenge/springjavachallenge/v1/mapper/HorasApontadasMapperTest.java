package br.com.tavares.springjavachallenge.springjavachallenge.v1.mapper;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.controller.stub.HorasApontadasModelStub;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.facade.HorasApontadasRequestStub;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class HorasApontadasMapperTest {

    /**
     * Dado que o metodo [mapToHorasApontadasModel] seja chamado ...
     * Deve retornar um objeto do tipo HorasApontadasModel
     */
    @Test
    public void deve_retornar_um_objeto_horasapontadasmodel() {
        HorasApontadasModel horasApontadasModel = HorasApontadasModelStub.getHorasApontadasModel();
        HorasApontadasModel response = HorasApontadasMapper
                .mapToHorasApontadasModel(HorasApontadasRequestStub.getHorasApontadasRequest());
        Assert.assertEquals(horasApontadasModel.getMatriculaUsuario(), response.getMatriculaUsuario());
        Assert.assertEquals(horasApontadasModel.getIdProjeto(), response.getIdProjeto());
        Assert.assertEquals(horasApontadasModel.getHoras(), response.getHoras());
        Assert.assertEquals(horasApontadasModel.getDataApontamento(), response.getDataApontamento());
    }
}
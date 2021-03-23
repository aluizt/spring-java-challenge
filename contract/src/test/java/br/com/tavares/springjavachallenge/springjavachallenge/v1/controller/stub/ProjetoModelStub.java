package br.com.tavares.springjavachallenge.springjavachallenge.v1.controller.stub;

import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;

import java.util.Arrays;
import java.util.List;

public class ProjetoModelStub {

    public static List<ProjetoModel> getProjetoModelList() {
        return Arrays.asList(getProjetoModel());
    }

    public static ProjetoModel getProjetoModel() {
        return ProjetoModel.builder()
                .horasApontadas(HorasApontadasModelStub.getHorasApontadasModelList())
                .projeto(1)
                .build();
    }
}

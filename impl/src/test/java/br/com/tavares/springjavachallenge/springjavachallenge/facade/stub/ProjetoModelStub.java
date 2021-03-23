package br.com.tavares.springjavachallenge.springjavachallenge.facade.stub;

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

    public static List<ProjetoModel> getProjetoModelListSemProjeto() {
        return Arrays.asList(getProjetoModelSemprojeto());
    }

    public static ProjetoModel getProjetoModelSemprojeto() {
        return ProjetoModel.builder()
                .horasApontadas(HorasApontadasModelStub.getHorasApontadasModelList())
                .build();
    }

    public static List<ProjetoModel> getProjetoModelListSemHoras() {
        return Arrays.asList(getProjetoModelSemHoras());
    }

    public static ProjetoModel getProjetoModelSemHoras() {
        return ProjetoModel.builder()
                .horasApontadas(HorasApontadasModelStub.getHorasApontadasModelListSemHoras())
                .projeto(1)
                .build();
    }
}

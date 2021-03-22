package br.com.tavares.springjavachallenge.springjavachallenge.mapper;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProjetoModelMapper {
    public static List<ProjetoModel> mapToProjetoModelList(List<HorasApontadasModel> lista) {
        return Arrays.asList(ProjetoModel.builder()
                .horasApontadas(lista)
                .build());
    }
    public static ProjetoModel mapToProjetoModel(List<HorasApontadasModel> lista) {
        return ProjetoModel.builder()
                .horasApontadas(lista)
                .build();
    }
}

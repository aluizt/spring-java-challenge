package br.com.tavares.springjavachallenge.springjavachallenge.v1.mapper;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.HorasApontadasResponse;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.ProjetosResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProjetoMapper {

    public static ProjetosResponse maptoProjetoResponse(List<ProjetoModel> projetosModel) {
        return ProjetosResponse.builder()
                .projetos(projetosModel)
                .build();

    }

//    private static ProjetosResponse mapToProjetoResponse(ProjetoModel projetoModel) {
//        return ProjetosResponse.builder()
//                .projetos(projetoModel)
//                .build();
//
//    }

    private static List<HorasApontadasResponse> mapToHorasApontadasResponseList(List<HorasApontadasModel> lista) {
        return lista.stream().map(ProjetoMapper::mapToHorasApontadasResponse).collect(Collectors.toList());
    }

    private static HorasApontadasResponse mapToHorasApontadasResponse(HorasApontadasModel horasApontadasModel) {
        if (Objects.isNull(horasApontadasModel)) {
            return null;
        }
        return HorasApontadasResponse.builder()
                .dataApontamento(horasApontadasModel.getDataApontamento())
                .idProjeto(horasApontadasModel.getIdProjeto())
                .matriculaUsuario(horasApontadasModel.getMatriculaUsuario())
                .tempo(horasApontadasModel.getHoras())
                .totalDeHoras(horasApontadasModel.getTotalDeHoras())
                .build();
    }
}

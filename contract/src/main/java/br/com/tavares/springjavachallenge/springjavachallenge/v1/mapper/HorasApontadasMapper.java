package br.com.tavares.springjavachallenge.springjavachallenge.v1.mapper;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.HorasApontadasRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HorasApontadasMapper {
    public static HorasApontadasModel mapToHorasApontadasModel(HorasApontadasRequest horasApontadasRequest) {
        return HorasApontadasModel.builder()
                .dataApontamento(horasApontadasRequest.getDataApontamento())
                .idProjeto(horasApontadasRequest.getIdProjeto())
                .matriculaUsuario(horasApontadasRequest.getMatriculaUsuario())
                .horas(horasApontadasRequest.getTempo())
                .build();
    }
}

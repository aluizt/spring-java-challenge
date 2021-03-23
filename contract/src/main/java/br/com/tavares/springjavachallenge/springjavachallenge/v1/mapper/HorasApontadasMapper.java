package br.com.tavares.springjavachallenge.springjavachallenge.v1.mapper;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.HorasApontadasRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

import static java.time.format.DateTimeFormatter.ofPattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HorasApontadasMapper {
    public static HorasApontadasModel mapToHorasApontadasModel(HorasApontadasRequest horasApontadasRequest) {
        return HorasApontadasModel.builder()
                .dataApontamento(LocalDate.parse(horasApontadasRequest.getDataApontamento(), ofPattern("dd-MM-yyyy")))
                .idProjeto(horasApontadasRequest.getIdProjeto())
                .matriculaUsuario(horasApontadasRequest.getMatriculaUsuario())
                .horas(LocalTime.parse(horasApontadasRequest.getTempo()))
                .build();
    }
}

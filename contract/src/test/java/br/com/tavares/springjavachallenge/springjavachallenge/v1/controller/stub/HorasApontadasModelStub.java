package br.com.tavares.springjavachallenge.springjavachallenge.v1.controller.stub;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class HorasApontadasModelStub {

    public static List<HorasApontadasModel> getHorasApontadasModelList() {
        return Arrays.asList(getHorasApontadasModel());
    }

    public static HorasApontadasModel getHorasApontadasModel() {
        return HorasApontadasModel.builder()
                .horas(LocalTime.parse("10:00"))
                .idProjeto(1)
                .matriculaUsuario(2)
                .dataApontamento(LocalDate.parse("2021-03-23"))
                .totalDeHoras("10:00")
                .build();
    }
}

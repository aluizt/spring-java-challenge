package br.com.tavares.springjavachallenge.springjavachallenge.facade.stub;

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
                .dataApontamento(LocalDate.of(2021, 03, 23))
                .totalDeHoras("10:00")
                .build();
    }

    public static List<HorasApontadasModel> getHorasApontadasModelListSemHoras() {
        return Arrays.asList(getHorasApontadasModelSemHoras());
    }

    public static HorasApontadasModel getHorasApontadasModelSemHoras() {
        return HorasApontadasModel.builder()
                .horas(null)
                .idProjeto(1)
                .matriculaUsuario(2)
                .dataApontamento(null)
                .totalDeHoras(null)
                .build();
    }

}

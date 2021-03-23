package br.com.tavares.springjavachallenge.springjavachallenge.v1.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class HorasApontadasModelStub {

    public static List<HorasApontadasModel> getHorasApontadasModelList() {
        return Arrays.asList(getHorasApontadasModel());
    }

    public static HorasApontadasModel getHorasApontadasModel() {
        return HorasApontadasModel.builder()
                .matriculaUsuario(2)
                .idProjeto(1)
                .dataApontamento(LocalDate.parse("23-03-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .horas(LocalTime.parse("08:00"))
                .build();
    }
}

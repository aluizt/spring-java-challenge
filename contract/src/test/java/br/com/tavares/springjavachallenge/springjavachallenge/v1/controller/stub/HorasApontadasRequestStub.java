package br.com.tavares.springjavachallenge.springjavachallenge.v1.controller.stub;

import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.HorasApontadasRequest;

import java.time.LocalTime;

public class HorasApontadasRequestStub {
    public static HorasApontadasRequest getHorasApontadasRequest() {
        return HorasApontadasRequest.builder()
                .dataApontamento("23-03-2021")
                .idProjeto(1)
                .matriculaUsuario(2)
                .tempo("08:00")
                .build();
    }
}

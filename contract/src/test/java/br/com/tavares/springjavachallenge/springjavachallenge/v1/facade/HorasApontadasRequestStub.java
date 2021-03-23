package br.com.tavares.springjavachallenge.springjavachallenge.v1.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.HorasApontadasRequest;

public class HorasApontadasRequestStub {

    public static HorasApontadasRequest getHorasApontadasRequest() {
        return HorasApontadasRequest.builder()
                .matriculaUsuario(2)
                .idProjeto(1)
                .dataApontamento("23-03-2021")
                .tempo("10:00")
                .build();
    }
}

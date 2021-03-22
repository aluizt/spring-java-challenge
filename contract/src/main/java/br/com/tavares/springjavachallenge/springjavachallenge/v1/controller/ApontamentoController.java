package br.com.tavares.springjavachallenge.springjavachallenge.v1.controller;

import br.com.tavares.springjavachallenge.springjavachallenge.v1.facade.ApontamentoFacade;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.HorasApontadasRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.tavares.springjavachallenge.springjavachallenge.v1.mapper.HorasApontadasMapper.mapToHorasApontadasModel;

@RestController
@RequestMapping("v1/apontamento")
public class ApontamentoController {
    private ApontamentoFacade apontamentoFacade;

    public ApontamentoController(ApontamentoFacade apontamentoFacade) {
        this.apontamentoFacade = apontamentoFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarHoras(@Valid @RequestBody HorasApontadasRequest horasApontadasRequest) {
        apontamentoFacade.adicionarHoras(mapToHorasApontadasModel(horasApontadasRequest));
    }
}

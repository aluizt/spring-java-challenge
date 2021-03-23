package br.com.tavares.springjavachallenge.springjavachallenge.v1.controller;

import br.com.tavares.springjavachallenge.springjavachallenge.v1.facade.ApontamentoFacade;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.HorasApontadasRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.tavares.springjavachallenge.springjavachallenge.v1.mapper.HorasApontadasMapper.mapToHorasApontadasModel;

@RestController
@RequestMapping("v1/apontamento")
@Tag(name = "Apontamento Controller", description = "Responsável por geranciar as horas trabalhadas")
public class ApontamentoController {
    private ApontamentoFacade apontamentoFacade;

    public ApontamentoController(ApontamentoFacade apontamentoFacade) {
        this.apontamentoFacade = apontamentoFacade;
    }

    @Operation(summary = "Adiciona horas trabalhadas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Horas trabalhadas adicionadas com sucesso",
                    content = @Content(schema = @Schema(implementation = HorasApontadasRequest.class))
            )
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarHoras(@Valid @RequestBody HorasApontadasRequest horasApontadasRequest) {
        System.out.println( apontamentoFacade.adicionarHoras(mapToHorasApontadasModel(horasApontadasRequest)));

    }
}

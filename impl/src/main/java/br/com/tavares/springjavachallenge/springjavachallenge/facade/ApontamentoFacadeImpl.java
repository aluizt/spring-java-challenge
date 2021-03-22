package br.com.tavares.springjavachallenge.springjavachallenge.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import br.com.tavares.springjavachallenge.springjavachallenge.service.ApontamentoService;
import org.springframework.stereotype.Component;

@Component
public class ApontamentoFacadeImpl {

    private ApontamentoService apontamentoService;

    public ApontamentoFacadeImpl(ApontamentoService apontamentoService) {
        this.apontamentoService = apontamentoService;
    }

    public Integer adicionarHoras(HorasApontadasModel horasApontadasModel) {
        apontamentoService.validarProjeto(horasApontadasModel);
        return apontamentoService.adicionarHoras(horasApontadasModel);
    }
}

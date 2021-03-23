package br.com.tavares.springjavachallenge.springjavachallenge.v1.facade;

import br.com.tavares.springjavachallenge.springjavachallenge.facade.ApontamentoFacadeImpl;
import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import org.springframework.stereotype.Component;

@Component
public class ApontamentoFacade {
    private ApontamentoFacadeImpl apontamentoFacade;

    ApontamentoFacade(ApontamentoFacadeImpl apontamentoFacade) {
        this.apontamentoFacade = apontamentoFacade;
    }

    public Integer adicionarHoras(HorasApontadasModel horasApontadasModel) {
        return apontamentoFacade.adicionarHoras(horasApontadasModel);
    }
}

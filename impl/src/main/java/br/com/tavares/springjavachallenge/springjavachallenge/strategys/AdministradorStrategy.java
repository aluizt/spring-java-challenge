package br.com.tavares.springjavachallenge.springjavachallenge.strategys;

import br.com.tavares.springjavachallenge.springjavachallenge.enuns.TipoUsuarioEnum;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import br.com.tavares.springjavachallenge.springjavachallenge.service.ApontamentoService;
import br.com.tavares.springjavachallenge.springjavachallenge.util.AgrupadorDeProjetos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdministradorStrategy implements Strategy {

    private ApontamentoService apontamentoService;
    private AgrupadorDeProjetos agrupadorDeProjetos;

    public AdministradorStrategy(ApontamentoService apontamentoService, AgrupadorDeProjetos agrupadorDeProjetos) {
        this.apontamentoService = apontamentoService;
        this.agrupadorDeProjetos = agrupadorDeProjetos;
    }

    @Override
    public Boolean selecionaUsuario(Integer matriculaUsuario) {
        return matriculaUsuario.equals(TipoUsuarioEnum.ADMINISTRADOR.getTipoUsuario());
    }

    @Override
    public List<ProjetoModel> buscarProjetos(Integer matriculaUsuario) {
        return agrupadorDeProjetos.agrupaProjetos(apontamentoService.buscarHorasPorUsuario(null));
    }

}

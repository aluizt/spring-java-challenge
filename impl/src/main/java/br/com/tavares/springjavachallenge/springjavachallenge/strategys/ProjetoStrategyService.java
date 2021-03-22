package br.com.tavares.springjavachallenge.springjavachallenge.strategys;

import br.com.tavares.springjavachallenge.springjavachallenge.exception.GenericException;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import br.com.tavares.springjavachallenge.springjavachallenge.model.UsuarioModel;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Component
public class ProjetoStrategyService {

    private List<Strategy> strategies;

    public ProjetoStrategyService(List<Strategy> strategies) {
        this.strategies = strategies;
    }

    public List<ProjetoModel> buscarProjetosStrategy(UsuarioModel usuarioModel) {
        return buscarStrategy(usuarioModel.getTipoUsuario())
                .buscarProjetos(usuarioModel.getMatriculaUsuario());
    }

    private Strategy buscarStrategy(Integer matriculaUsuario) {
        return strategies.stream()
                .filter(strategy -> strategy.selecionaUsuario(matriculaUsuario))
                .findFirst()
                .orElseThrow(() -> new GenericException("", INTERNAL_SERVER_ERROR));
    }
}

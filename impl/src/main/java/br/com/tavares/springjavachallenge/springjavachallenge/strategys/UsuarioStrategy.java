package br.com.tavares.springjavachallenge.springjavachallenge.strategys;

import br.com.tavares.springjavachallenge.springjavachallenge.enuns.TipoUsuarioEnum;
import br.com.tavares.springjavachallenge.springjavachallenge.mapper.ProjetoModelMapper;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import br.com.tavares.springjavachallenge.springjavachallenge.service.ApontamentoService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioStrategy implements Strategy {
    private ApontamentoService apontamentoService;

    public UsuarioStrategy(ApontamentoService apontamentoService) {
        this.apontamentoService = apontamentoService;
    }

    @Override
    public Boolean selecionaUsuario(Integer matriculaUsuario) {
        return matriculaUsuario.equals(TipoUsuarioEnum.USUARIO.getTipoUsuario());
    }

    @Override
    public List<ProjetoModel> buscarProjetos(Integer matriculaUsuario) {
        return ProjetoModelMapper.mapToProjetoModelList(apontamentoService.buscarHorasPorUsuario(matriculaUsuario));
    }
}

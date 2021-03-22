package br.com.tavares.springjavachallenge.springjavachallenge.service;

import br.com.tavares.springjavachallenge.springjavachallenge.exception.GenericException;
import br.com.tavares.springjavachallenge.springjavachallenge.facade.ProjetoFacadeImpl;
import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoUsuario;
import br.com.tavares.springjavachallenge.springjavachallenge.repository.apontamento.ApontamentoHorasRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
public class ApontamentoService {
    private final ApontamentoHorasRepository apontamentoHorasRepository;
    private final ProjetoFacadeImpl projetoFacadeImpl;

    public ApontamentoService(
            ApontamentoHorasRepository apontamentoHorasRepository,
            ProjetoFacadeImpl projetoFacadeImpl
    ) {
        this.apontamentoHorasRepository = apontamentoHorasRepository;
        this.projetoFacadeImpl = projetoFacadeImpl;
    }

    public Integer adicionarHoras(HorasApontadasModel horasApontadasModel) {
        try {
            return apontamentoHorasRepository.adicionarHoras(horasApontadasModel);
        } catch (DataAccessException erro) {
            throw new GenericException("Erro ao acessar o bando de dados!", erro.getMessage(), INTERNAL_SERVER_ERROR);
        }
    }

    public List<HorasApontadasModel> buscarHorasPorUsuario(Integer matriculaUsuario) {
        try {
            return apontamentoHorasRepository.bucarHorasProjeto(matriculaUsuario);
        } catch (DataAccessException erro) {
            throw new GenericException("Erro ao acessar o bando de dados!", erro.getMessage(), INTERNAL_SERVER_ERROR);
        }
    }

    public ProjetoUsuario validarProjeto(HorasApontadasModel horasApontadasModel) {
        return projetoFacadeImpl.buscaProjetosDoUsuario(horasApontadasModel.getMatriculaUsuario()).stream()
                .filter(projetoUsuario -> projetoUsuario.getIdProjeto().equals(horasApontadasModel.getIdProjeto()))
                .findFirst()
                .orElseThrow(() -> new GenericException(
                        String.format("Projeto %s não acessível para este usuario",
                                horasApontadasModel.getIdProjeto()
                        ),
                        BAD_REQUEST));
    }
}

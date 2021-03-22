package br.com.tavares.springjavachallenge.springjavachallenge.service;

import br.com.tavares.springjavachallenge.springjavachallenge.exception.GenericException;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoUsuario;
import br.com.tavares.springjavachallenge.springjavachallenge.repository.projeto.ProjetoRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
public class ProjetoService {

    private ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public List<ProjetoUsuario> buscarProjetos(Integer matriculaUsuario) {
        try {
            return projetoRepository.buscarProjetosPorUsuario(matriculaUsuario);
        } catch (DataAccessException erro) {
            throw new GenericException("Erro ao buscar projetos do usuario!", erro.getMessage(), INTERNAL_SERVER_ERROR);
        }
    }

}

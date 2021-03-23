package br.com.tavares.springjavachallenge.springjavachallenge.v1.controller;

import br.com.tavares.springjavachallenge.springjavachallenge.v1.controller.stub.ProjetoResponseStub;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.facade.UsuarioFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
class UsuarioControllerTest {

    @Mock
    private UsuarioFacade usuarioFacade;
    @InjectMocks
    private UsuarioController usuarioController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
    }

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Dado que seja passado uma request com a matricula do usuario
     * Deve retornar status code 200
     */
    @Test
    void deve_retornar_status_200() throws Exception {
        when(usuarioFacade.buscaProjetosDoUsuario(any())).thenReturn(ProjetoResponseStub.getProjetosResponse());
        this.mockMvc.perform(get("/v1/usuarios/2/projetos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Dado que seja passado uma request sem a matricula do usuario
     * Deve retornar status code 404
     */
    @Test
    void deve_retornar_status_400() throws Exception {
        when(usuarioFacade.buscaProjetosDoUsuario(any())).thenReturn(ProjetoResponseStub.getProjetosResponse());
        this.mockMvc.perform(get("/v1/usuarios/projetos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
    }

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Dado que seja passado uma request com a matricula do usuario
     * Deve retornar um objeto ProjetosResponse
     */
    @Test
    void deve_retornar_projetosresponse_com_dados_do_projeto() throws Exception {
        when(usuarioFacade.buscaProjetosDoUsuario(any())).thenReturn(ProjetoResponseStub.getProjetosResponse());
        this.mockMvc.perform(get("/v1/usuarios/2/projetos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(getString()));
    }

    private String getString() {
        return "{\"projetos\":[{\"projeto\":1,\"horasApontadas\":"
                + "[{\"matriculaUsuario\":2,\"idProjeto\":1,\"horas\":[10,0],\"totalDeHoras\":\"10:00\","
                + "\"dataApontamento\":[2021,3,23]}]}]}";
    }
}
package br.com.tavares.springjavachallenge.springjavachallenge.v1.controller;

import br.com.tavares.springjavachallenge.springjavachallenge.v1.controller.stub.HorasApontadasRequestStub;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.facade.ApontamentoFacade;
import br.com.tavares.springjavachallenge.springjavachallenge.v1.model.HorasApontadasRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
class ApontamentoControllerTest {
    @Mock
    private ApontamentoFacade apontamentoFacade;
    @InjectMocks
    private ApontamentoController apontamentoController;

    private ObjectMapper objectMapper;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(apontamentoController).build();
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Dado que seja passado uma request com o valor do tempo null
     * Deve retornar o HttpStatus 400
     */
    @Test
    void deve_retornar_status_code_400_quando_tempo_igual_null() throws Exception {
        HorasApontadasRequest request = HorasApontadasRequestStub.getHorasApontadasRequest();
        request.setTempo(null);
        this.mockMvc.perform(post("/v1/apontamento")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is(400));
    }

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Dado que seja passado uma request com o valor do idPorjeto null
     * Deve retornar o HttpStatus 400
     */
    @Test
    void deve_etornar_status_code_400_quando_idprojeto_igual_null() throws Exception {
        HorasApontadasRequest request = HorasApontadasRequestStub.getHorasApontadasRequest();
        request.setIdProjeto(null);
        String json = objectMapper.writeValueAsString(request);
        this.mockMvc.perform(post("/v1/apontamento")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().is(400));
    }

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Dado que seja passado uma request com o valor do dataApontamento null
     * Deve retornar o HttpStatus 400
     */
    @Test
    void deve_retornar_status_code_400_quando_dataapontamento_igual_null() throws Exception {
        HorasApontadasRequest request = HorasApontadasRequestStub.getHorasApontadasRequest();
        request.setDataApontamento(null);
        this.mockMvc.perform(post("/v1/apontamento")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is(400));
    }

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Dado que seja passado uma request com o valor do matriculaUsuario null
     * Deve retornar o HttpStatus 400
     */
    @Test
    void deve_retornar_status_code_400_quando_matriculausuario_igual_null() throws Exception {
        HorasApontadasRequest request = HorasApontadasRequestStub.getHorasApontadasRequest();
        request.setMatriculaUsuario(null);
        String json = objectMapper.writeValueAsString(request);
        this.mockMvc.perform(post("/v1/apontamento")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().is(400));
    }

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Dado que seja passado uma request com todos os atributos
     * Deve retornar o HttpStatus 201
     */
    @Test
    void deve_retornar_status_code_201() throws Exception {
        HorasApontadasRequest request = HorasApontadasRequestStub.getHorasApontadasRequest();
        when(apontamentoFacade.adicionarHoras(any())).thenReturn(1);
        String json = objectMapper.writeValueAsString(request);
        this.mockMvc.perform(post("/v1/apontamento")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().is(201));
    }

    /**
     * Dado que o metodo [buscaProjetosDoUsuario] seja chamado...
     * Dado que seja passado uma request com todos os atributos
     * Deve verificar se o metodo[adicionarHoras] foi executado
     */
    @Test
    void deve_verificar_se_foi_chamado_o_metodo_adicionarHoras() throws Exception {
        HorasApontadasRequest request = HorasApontadasRequestStub.getHorasApontadasRequest();
        when(apontamentoFacade.adicionarHoras(any())).thenReturn(1);
        String json = objectMapper.writeValueAsString(request);
        this.mockMvc.perform(post("/v1/apontamento")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));
        verify(apontamentoFacade, times(1)).adicionarHoras(any());
    }
}
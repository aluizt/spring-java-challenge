package br.com.tavares.springjavachallenge.springjavachallenge.stub;


import br.com.tavares.springjavachallenge.springjavachallenge.model.UsuarioModel;

public class UsuarioModelStub {

    public static UsuarioModel getUsuarioModel() {
        return UsuarioModel.builder()
                .matriculaUsuario(1)
                .nomeUsuario("Joao")
                .tipoUsuario(1)
                .build();
    }
}

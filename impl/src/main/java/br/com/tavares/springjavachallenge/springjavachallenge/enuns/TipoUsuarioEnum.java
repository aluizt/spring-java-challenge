package br.com.tavares.springjavachallenge.springjavachallenge.enuns;

public enum TipoUsuarioEnum {
    ADMINISTRADOR(1),
    USUARIO(2);

    private final Integer tipoUsuario;

    TipoUsuarioEnum(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }
}

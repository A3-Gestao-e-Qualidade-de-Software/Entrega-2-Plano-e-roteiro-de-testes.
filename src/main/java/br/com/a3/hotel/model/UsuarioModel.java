package br.com.a3.hotel.model;
/**
 * Representa um usuário do sistema do hotel.
 */
public class UsuarioModel {
    private String nomeUsuario;
    private String funcional;
    private String senhaUsuario; 
    /**
     * Construtor da classe UsuarioModel.
     *
     * @param nomeUsuario   Nome do usuário.
     * @param funcional     Funcional do usuário.
     * @param senhaUsuario  Senha do usuário.
     */
    public UsuarioModel(String nomeUsuario, String funcional, String senhaUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.funcional = funcional;
        this.senhaUsuario = senhaUsuario;
    }

    //  Getters and Setters
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getFuncional() {
        return funcional;
    }

    public void setFuncional(String funcional) {
        this.funcional = funcional;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
}

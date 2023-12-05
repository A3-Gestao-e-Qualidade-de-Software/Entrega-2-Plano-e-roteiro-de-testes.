package br.com.a3.hotel.model;

import java.util.Date;

public class HospedesModel{
    private String nome;
    private String sobrenome;
    private String dtNascimento;
    private String cpf;
    private String genero;
    private String endereco;
    private String telefone;
    private String email;
   /**
     * Construtor da classe HospedesModel que recebe todas as informações do hóspede.
     *
     * @param nome         Nome do hóspede.
     * @param sobrenome    Sobrenome do hóspede.
     * @param dtNascimento Data de nascimento do hóspede no formato DD/MM/AAAA.
     * @param cpf          CPF do hóspede.
     * @param genero       Gênero do hóspede (Masculino/Feminino/Outro).
     * @param endereco     Endereço do hóspede.
     * @param telefone     Número de telefone do hóspede.
     * @param email        Endereço de e-mail do hóspede.
     */
    public HospedesModel(String nome, String sobrenome, String dtNascimento, String cpf, String genero, String endereco, String telefone, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.genero = genero;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    //  Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

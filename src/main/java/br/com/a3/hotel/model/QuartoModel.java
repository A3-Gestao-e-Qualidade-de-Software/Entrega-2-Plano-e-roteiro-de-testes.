package br.com.a3.hotel.model;

/**
 * Representa as informações de um quarto do hotel.
 */

public class QuartoModel {
    private int ID_Quarto;
    private int Num_Quarto;
    private int Andar_Quarto;
    private String Tipo_Quarto;
    private double Preco_Noite;
    private String Status_Ocupacao;
    private String Descricao;

    /**
     * Construtor da classe QuartoModel.
     *
     * @param ID_Quarto       Identificador único do quarto.
     * @param num_Quarto      Número do quarto.
     * @param andar_Quarto    Andar onde o quarto está localizado.
     * @param tipo_Quarto     Tipo do quarto.
     * @param preco_Noite     Preço por noite do quarto.
     * @param status_Ocupacao Status de ocupação do quarto.
     * @param descricao       Descrição do quarto.
     */
    
    public QuartoModel(int ID_Quarto, int num_Quarto, int andar_Quarto, String tipo_Quarto, double preco_Noite, String status_Ocupacao, String descricao) {
        this.ID_Quarto = ID_Quarto;
        Num_Quarto = num_Quarto;
        Andar_Quarto = andar_Quarto;
        Tipo_Quarto = tipo_Quarto;
        Preco_Noite = preco_Noite;
        Status_Ocupacao = status_Ocupacao;
        Descricao = descricao;
    }

    public int getID_Quarto() {
        return ID_Quarto;
    }

    public void setID_Quarto(int ID_Quarto) {
        this.ID_Quarto = ID_Quarto;
    }

    public int getNum_Quarto() {
        return Num_Quarto;
    }

    public void setNum_Quarto(int num_Quarto) {
        Num_Quarto = num_Quarto;
    }

    public int getAndar_Quarto() {
        return Andar_Quarto;
    }

    public void setAndar_Quarto(int andar_Quarto) {
        Andar_Quarto = andar_Quarto;
    }

    public String getTipo_Quarto() {
        return Tipo_Quarto;
    }

    public void setTipo_Quarto(String tipo_Quarto) {
        Tipo_Quarto = tipo_Quarto;
    }

    public double getPreco_Noite() {
        return Preco_Noite;
    }

    public void setPreco_Noite(double preco_Noite) {
        Preco_Noite = preco_Noite;
    }

    public String getStatus_Ocupacao() {
        return Status_Ocupacao;
    }

    public void setStatus_Ocupacao(String status_Ocupacao) {
        Status_Ocupacao = status_Ocupacao;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}

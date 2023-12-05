package br.com.a3.hotel.model;

public class ReservasModel {
    private int id;
    private int ID_Hospede;
    private int ID_Quarto;
    private String Data_checkIN;
    private String Data_checkOUT;
    private String Data_Reserva;
    private int ID_Status_Reserva;
    private int Status_Ativa;

    /**
     * Construtor da classe ReservasModel.
     *
     * @param id               Identificador único da reserva.
     * @param ID_Hospede      ID do hóspede associado à reserva.
     * @param ID_Quarto       ID do quarto associado à reserva.
     * @param data_checkIN     Data de check-in da reserva.
     * @param data_checkOUT    Data de check-out da reserva.
     * @param data_Reserva     Data de criação da reserva.
     * @param ID_Status_Reserva ID do status da reserva.
     * @param status_Ativa     Status de ativação da reserva.
     */
    
    public ReservasModel(int id, int ID_Hospede, int ID_Quarto, String data_checkIN, String data_checkOUT, String data_Reserva, int ID_Status_Reserva, int status_Ativa) {
        this.id = id;
        this.ID_Hospede = ID_Hospede;
        this.ID_Quarto = ID_Quarto;
        Data_checkIN = data_checkIN;
        Data_checkOUT = data_checkOUT;
        Data_Reserva = data_Reserva;
        this.ID_Status_Reserva = ID_Status_Reserva;
        Status_Ativa = status_Ativa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getID_Hospede() {
        return ID_Hospede;
    }

    public void setID_Hospede(int ID_Hospede) {
        this.ID_Hospede = ID_Hospede;
    }

    public int getID_Quarto() {
        return ID_Quarto;
    }

    public void setID_Quarto(int ID_Quarto) {
        this.ID_Quarto = ID_Quarto;
    }

    public String getData_checkIN() {
        return Data_checkIN;
    }

    public void setData_checkIN(String data_checkIN) {
        Data_checkIN = data_checkIN;
    }

    public String getData_checkOUT() {
        return Data_checkOUT;
    }

    public void setData_checkOUT(String data_checkOUT) {
        Data_checkOUT = data_checkOUT;
    }

    public String getData_Reserva() {
        return Data_Reserva;
    }

    public void setData_Reserva(String data_Reserva) {
        Data_Reserva = data_Reserva;
    }

    public int getID_Status_Reserva() {
        return ID_Status_Reserva;
    }

    public void setID_Status_Reserva(int ID_Status_Reserva) {
        this.ID_Status_Reserva = ID_Status_Reserva;
    }

    public int getStatus_Ativa() {
        return Status_Ativa;
    }

    public void setStatus_Ativa(int status_Ativa) {
        Status_Ativa = status_Ativa;
    }
}

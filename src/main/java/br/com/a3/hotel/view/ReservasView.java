package br.com.a3.hotel.view;

import br.com.a3.hotel.DAO.QuartoDAO;
import br.com.a3.hotel.controller.HospedesController;
import br.com.a3.hotel.model.HospedesModel;
import br.com.a3.hotel.model.QuartoModel;
import br.com.a3.hotel.model.ReservasModel;
import br.com.a3.hotel.utils.Metodos_Utils;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


/**
 * A classe ReservasView contém métodos relacionados à exibição e interação com reservas.
 */
public class ReservasView {
        /**
     * Exibe um menu de opções relacionadas às reservas.
     *
     * @return O número da opção selecionada pelo usuário.
     */
    public static int mostrarMenuReservas(){
        int resposta = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Hospede: \n" +
                "[1] Nova Reserva\n" +
                "[2] Deletar Reserva\n" +
                "[3] Editar Reserva\n" +
                "[4] Listar reservas\n" +
                "[5] Voltar"));
        return resposta;
    }
    /**
     * Permite cadastrar uma nova reserva no sistema.
     *
     * @return O objeto ReservasModel com os detalhes da nova reserva.
     * @throws SQLException            Exceção relacionada a problemas com a base de dados.
     * @throws ClassNotFoundException Exceção relacionada a problemas ao carregar classes.
     */
    public static ReservasModel cadastrarNovaReserva() throws SQLException, ClassNotFoundException {
        int ID = 0;
        // Listando Hospedes e solicitando CPF do Hospede a efetuar reserva:
        List<HospedesModel> listaHospedes = DAO.HospedesDAO.listarHospedes();
        JOptionPane.showMessageDialog(null, "A seguir copie o N° de CPF do hóspede a efetuar reserva.");
        HospedesView.mostrarListaHospedes(listaHospedes);
        String CPF = (JOptionPane.showInputDialog(null, "CPF (Apenas dígitos):"));
        int ID_Hospede = 0;


        // Solicitando datas de check-in e check-out desejadas:
        String sol_data_checkIn = new Metodos_Utils().solicitarDataCheckIn();
        String data_checkIn = padronizarDataString(sol_data_checkIn);
        String sol_data_checkOut = new Metodos_Utils().solicitarDataCheckOut();
        String data_checkOut = padronizarDataString(sol_data_checkOut);


        // Listando apenas quartos disponíveis para o período desejado e solicitando ID do quarto:
        List<QuartoModel> listaQuartosDisponiveis = QuartoDAO.listarQuartosDisponiveis(data_checkIn, data_checkOut);
        JOptionPane.showMessageDialog(null, "A seguir copie o N° ID do quarto desejado para hospedagem.");
        QuartoView.mostrarListaQuartos(listaQuartosDisponiveis);
        int ID_Quarto = Integer.parseInt((JOptionPane.showInputDialog(null, "Nº ID do Quarto desejado:")));


        // Obtendo a data de hoje e formatando para String:
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data_Hoje = hoje.format(formatador);
        JOptionPane.showMessageDialog(null, "Data da reserva: " + data_Hoje);


        int id_Status_Reserva = 1;
        int id_Status_Ativa = 1;


        return new ReservasModel(ID, ID_Hospede, ID_Quarto, data_checkIn, data_checkOut, data_Hoje, id_Status_Reserva, id_Status_Ativa);
    }


    // Retorna a data no padrão yyyy-mm-dd para tornar possível a comparação
    // dos quartos disponíveis na Query SQL em QuartosDAO:
        /**
     * Padroniza uma string de data para o formato yyyy-MM-dd.
     *
     * @param data A string de data a ser padronizada (formato dd/MM/yyyy).
     * @return A data padronizada no formato yyyy-MM-dd.
     */
    public static String padronizarDataString(String data){
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = inputFormat.parse(data);
            String dataConvertida = outputFormat.format(date);

            return dataConvertida;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

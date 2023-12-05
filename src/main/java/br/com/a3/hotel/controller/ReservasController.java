package br.com.a3.hotel.controller;

import br.com.a3.hotel.view.ReservasView;

import java.sql.SQLException;

public class ReservasController {

    public static void cadastrarReserva() throws SQLException, ClassNotFoundException {
        // Cria uma nova instância da view para cadastro de reservas
        ReservasView reservasView = new ReservasView();
        // Chama o método na view para cadastrar uma nova reserva
        ReservasView.cadastrarNovaReserva();
    }
}

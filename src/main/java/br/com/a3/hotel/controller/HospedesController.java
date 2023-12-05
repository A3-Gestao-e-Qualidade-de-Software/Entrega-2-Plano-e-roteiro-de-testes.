package br.com.a3.hotel.controller;

import br.com.a3.hotel.DAO.*;
import br.com.a3.hotel.model.*;
import br.com.a3.hotel.view.*;
import br.com.a3.hotel.utils.*;

import java.sql.SQLException;
import java.util.List;

public class HospedesController {

    public int cadastrarHospede() throws SQLException, ClassNotFoundException {
        // Cria uma nova instância da view para cadastro de hóspedes
        HospedesView hospedesView = new HospedesView();
        // Coleta as informações do novo hóspede através da view
        HospedesModel hospede = hospedesView.cadastrarNovoHospede();
        // Chama o método do DAO para cadastrar o hóspede no banco de dados
        DAO.HospedesDAO hospedesDAO = new DAO.HospedesDAO();
        hospedesDAO.cadastrarHospede(hospede);
        return 1;
    }

    public int deletarHospede() throws SQLException, ClassNotFoundException {
        HospedesView hospedesView = new HospedesView();
        // Exibe o menu para deletar hóspedes e espera uma resposta válida
        int resposta_menuDeletarHospede = HospedesView.menuDeletarHospede();
        while (resposta_menuDeletarHospede < 1 || resposta_menuDeletarHospede > 3){
            resposta_menuDeletarHospede = HospedesView.menuDeletarHospede();
        }
        switch (resposta_menuDeletarHospede) {
            case 1: // Visualizar hóspedes
                // Lista todos os hóspedes cadastrados
                List<HospedesModel> listaHospedes = DAO.HospedesDAO.listarHospedes();
                HospedesView.mostrarListaHospedes(listaHospedes);
                break;
            case 2: // Deletar hóspede
                // Mostra tela para inserir o CPF do hóspede a ser deletado
                String cpfHospede = HospedesView.mostrarTelaDeletarHospede();
                // Chama o método do DAO para deletar o hóspede do banco de dados
                DAO.HospedesDAO.deletarHospede(cpfHospede);
                break;
        }
        return 1;
    }

    public int editarHospede() throws SQLException, ClassNotFoundException {
        HospedesView hospedesView = new HospedesView();
        // Solicita o CPF do hóspede que será editado
        String cpf = hospedesView.solicitarCPFEditar();

        // Verifica se o CPF foi inserido e não está vazio
        if (cpf != null && !cpf.equalsIgnoreCase("")) {
            String campoEditar = hospedesView.mostrarOpcoesEditarHospede();
            String[] camposString = {"Nome", "Sobrenome", "Endereco", "Telefone", "Email"};

            // Itera sobre as opções de edição de informações do hóspede
            for (String valor : camposString) {
                if (campoEditar.equals(valor)) {
                    String novoValor = hospedesView.inserirNovoValorString(campoEditar);
                    if (novoValor != null && !novoValor.equalsIgnoreCase("")) {
                        // Chama o método do DAO para editar informações do hóspede
                        DAO.HospedesDAO.editarHospedeString(cpf, campoEditar, novoValor);
                    }
                }
            }

            if (campoEditar.equals("Genero")) {
                // Solicita novo gênero ao usuário e edita no banco de dados
                String novoValor = new Metodos_Utils().selecionarGenero();
                if (novoValor != null && !novoValor.equalsIgnoreCase("")) {
                    DAO.HospedesDAO.editarHospedeString(cpf, campoEditar, novoValor);
                }
            }

            if (campoEditar.equals("DT_Nascimento")) {
                // Solicita nova data de nascimento ao usuário e edita no banco de dados
                String novoValor = new Metodos_Utils().solicitarData();
                if (novoValor != null) {
                    DAO.HospedesDAO.editarHospedeData(cpf, campoEditar, novoValor);
                }
            }
        }
        return 1;
    }
}

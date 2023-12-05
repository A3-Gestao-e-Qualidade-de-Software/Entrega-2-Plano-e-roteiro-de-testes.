package DAO;


import br.com.a3.hotel.DAO.ConexaoDAO;
import br.com.a3.hotel.model.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HospedesDAO {
    static Connection conn;

        /**
     * Cadastra um novo hóspede no banco de dados.
     *
     * @param objHospedesModel O objeto HospedesModel contendo as informações do hóspede a ser cadastrado.
     * @return true se o cadastro for bem-sucedido, false caso contrário.
     * @throws SQLException             Se ocorrer um erro durante a execução da operação no banco de dados.
     * @throws ClassNotFoundException Se o driver JDBC não puder ser carregado.
     */

    public boolean cadastrarHospede(HospedesModel objHospedesModel) throws SQLException, ClassNotFoundException {
        new ConexaoDAO();
        conn = ConexaoDAO.conectaBD();

        try {
            String sql =
                    "INSERT INTO" +
                            " Hospedes (Nome, Sobrenome, DT_Nascimento, CPF, Genero, Endereco, Telefone, Email)" +
                            " VALUES (?, ?, STR_TO_DATE(?, '%d/%m/%Y'), ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objHospedesModel.getNome());
            pstm.setString(2, objHospedesModel.getSobrenome());
            pstm.setString(3, objHospedesModel.getDtNascimento());
            pstm.setString(4, objHospedesModel.getCpf());
            pstm.setString(5, objHospedesModel.getGenero());
            pstm.setString(6, objHospedesModel.getEndereco());
            pstm.setString(7, objHospedesModel.getTelefone());
            pstm.setString(8, objHospedesModel.getEmail());

            int rowsaffected = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hospede cadastrado com sucesso!");
            return rowsaffected > 0;
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Hospede não cadastrado." +
                    " Digite as informações corretamente.\n\n" +
                    "Erro:\n" +
                    "HospedesDAO: " + erro.getMessage());
            return false;
        }
    }

    /**
     * Lista todos os hóspedes cadastrados no banco de dados.
     *
     * @return Uma lista de HospedesModel contendo informações de todos os hóspedes.
     * @throws SQLException             Se ocorrer um erro durante a execução da operação no banco de dados.
     * @throws ClassNotFoundException Se o driver JDBC não puder ser carregado.
     */

    public static List<HospedesModel> listarHospedes() throws SQLException, ClassNotFoundException {
        new ConexaoDAO();
        conn = ConexaoDAO.conectaBD();

        List<HospedesModel> listaHospedes = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            String sql =
                    "SELECT " +
                            "Nome, Sobrenome, DATE_FORMAT(DT_Nascimento, '%d/%m/%Y') AS DT_Nascimento, " +
                            "CPF, Genero, Endereco, Telefone, Email " +
                            "FROM Hospedes";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String generoChar = rs.getString("Genero");
                String genero = generoChar.toUpperCase();

                HospedesModel hospedesModel = new HospedesModel(
                        rs.getString("Nome"),
                        rs.getString("Sobrenome"),
                        rs.getString("DT_Nascimento"),
                        rs.getString("CPF"),
                        genero,
                        rs.getString("Endereco"),
                        rs.getString("Telefone"),
                        rs.getString("Email")
                );
                listaHospedes.add(hospedesModel);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "HospedesDAO: " + erro.getMessage());
            // adicionar método recursivo
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listaHospedes;
    }

    /**
     * Deleta um hóspede do banco de dados com base no CPF.
     *
     * @param cpfHospede O CPF do hóspede a ser deletado.
     * @return true se o hóspede foi deletado com sucesso, false caso contrário.
     * @throws SQLException             Se ocorrer um erro durante a execução da operação no banco de dados.
     * @throws ClassNotFoundException Se o driver JDBC não puder ser carregado.
     */

    public static boolean deletarHospede(String cpfHospede) throws SQLException, ClassNotFoundException {
        new ConexaoDAO();
        conn = ConexaoDAO.conectaBD();
        PreparedStatement pstm = null;
        boolean retorno = false;

        try {
            String sql = "DELETE FROM Hospedes WHERE CPF = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cpfHospede);
            int rowsAffected = pstm.executeUpdate();
            retorno = rowsAffected > 0;

            if (retorno == true){
                JOptionPane.showMessageDialog(null, "Hospede de CPF: " +cpfHospede+ ", deletado com sucesso!");
            } else if (retorno == false) {
                JOptionPane.showMessageDialog(null, "CPF não corresponde a nenhum hospede cadastrado.\n" +
                        "Verifique e tente novamente.");
            }
            return retorno;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "HospedesDAO: " + erro.getMessage());
            retorno = false;
            return retorno;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

        /**
     * Edita um atributo específico de um hóspede (string) no banco de dados.
     *
     * @param cpf       O CPF do hóspede cujo atributo será editado.
     * @param campo     O campo a ser editado.
     * @param novoValor O novo valor a ser atribuído ao campo.
     * @throws SQLException             Se ocorrer um erro durante a execução da operação no banco de dados.
     * @throws ClassNotFoundException Se o driver JDBC não puder ser carregado.
     */

    public static void editarHospedeString (String cpf, String campo, String novoValor) throws SQLException, ClassNotFoundException {
        conn = ConexaoDAO.conectaBD();
        PreparedStatement pstm = null;

        try {
            String sql = "UPDATE Hospedes SET " + campo + " = ? WHERE CPF = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, novoValor);
            pstm.setString(2, cpf);

            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Edição realizada com sucesso!!\n" +
                        campo + " do hospede de CPF: " + cpf + " alterado.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Atenção!\nInformações incorretas, verifique e tente novamente.");
            }
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "HospedesDAO: " + erro.getMessage());
        }
    }


    /**
     * Edita a data de nascimento de um hóspede no banco de dados.
     *
     * @param cpf       O CPF do hóspede cuja data de nascimento será editada.
     * @param campo     O campo a ser editado.
     * @param novoValor O novo valor da data de nascimento a ser atribuído.
     * @throws SQLException             Se ocorrer um erro durante a execução da operação no banco de dados.
     * @throws ClassNotFoundException Se o driver JDBC não puder ser carregado.
     */
    
    public static void editarHospedeData(String cpf, String campo, String novoValor) throws SQLException, ClassNotFoundException {
        conn = ConexaoDAO.conectaBD();
        PreparedStatement pstm = null;

        try{
            String sql = "UPDATE Hospedes SET " + campo + " = STR_TO_DATE(?, '%d/%m/%Y') WHERE CPF = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, novoValor);
            pstm.setString(2, cpf);

            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0){
                JOptionPane.showMessageDialog(null, "Edição realizada com sucesso!!\n" +
                        "Data de nascimento do hospede de CPF: " + cpf + " alterada.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Atenção!\nInformações incorretas, verifique e tente novamente.");
            }
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "HospedesDAO: " + erro.getMessage());
        }
    }
}

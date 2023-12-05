package br.com.a3.hotel.DAO;

import br.com.a3.hotel.model.*;
import br.com.a3.hotel.controller.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsável por operações relacionadas aos usuários no banco de dados.
 */

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO() {
        this.conn = conn;
    }

    /**
     * Cadastra um novo usuário no banco de dados.
     *
     * @param objUsuarioModel O objeto UsuarioModel contendo as informações do usuário a ser cadastrado.
     * @return true se o cadastro for bem-sucedido, false caso contrário.
     * @throws SQLException             Se ocorrer um erro durante a execução da operação no banco de dados.
     * @throws ClassNotFoundException Se o driver JDBC não puder ser carregado.
     */
    
    public boolean cadastrarUsuario(UsuarioModel objUsuarioModel) throws SQLException, ClassNotFoundException {
        new ConexaoDAO();
        conn = ConexaoDAO.conectaBD();

        try {
            String sql = "INSERT INTO usuario (NomeUsuario, Funcional, Senha) VALUES (?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUsuarioModel.getNomeUsuario());
            pstm.setString(2, objUsuarioModel.getFuncional());
            pstm.setString(3, objUsuarioModel.getSenhaUsuario());

            int rowsaffected = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            AppController ac = new AppController();
            ac.iniciar();
            return rowsaffected > 0;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro.getMessage());
            AppController ac = new AppController();
            ac.iniciar();
            return false;
        }
    }


    /**
     * Autentica um usuário no sistema.
     *
     * @param objUsuarioModel O objeto UsuarioModel contendo as informações do usuário para autenticação.
     * @return Um ResultSet com os dados do usuário autenticado.
     * @throws SQLException             Se ocorrer um erro durante a execução da operação no banco de dados.
     * @throws ClassNotFoundException Se o driver JDBC não puder ser carregado.
     */
    
    public ResultSet autenticarUsuario(UsuarioModel objUsuarioModel) throws SQLException, ClassNotFoundException {
        new ConexaoDAO();
        conn = ConexaoDAO.conectaBD();

        try {
            String sql = "SELECT * FROM usuario WHERE funcional = ? AND senha = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUsuarioModel.getFuncional());
            pstm.setString(2, objUsuarioModel.getSenhaUsuario());

            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro.getMessage());
            return null;
        }
    }
}

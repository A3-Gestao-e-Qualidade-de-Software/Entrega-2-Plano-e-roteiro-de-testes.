package br.com.a3.hotel.DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por criar e gerenciar a conexão com o banco de dados.
 */
public class ConexaoDAO {

    /**
     * Estabelece uma conexão com o banco de dados.
     *
     * @return A conexão estabelecida.
     * @throws SQLException             Se ocorrer um erro durante a conexão.
     * @throws ClassNotFoundException Se o driver JDBC não puder ser carregado.
     */
    public static Connection conectaBD() throws SQLException, ClassNotFoundException {
        // Carrega o driver JDBC para o MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        // URL de conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/hotel?user=root&password=admin";
        Connection conn = null;

        try {
            // Estabelece a conexão com o banco de dados
            conn = DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null, "Conexão com o BD bem sucedida");
            return conn;
        } catch (SQLException erro) {
            // Exibe uma mensagem de erro em caso de falha na conexão
            JOptionPane.showMessageDialog(null, "DAO.ConexaoDAO: " + erro.getMessage());
            System.out.println("Erro");
            return conn;
        }
    }
}
 }
}

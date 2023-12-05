package br.com.a3.hotel.controller;

import br.com.a3.hotel.DAO.*;
import br.com.a3.hotel.model.*;
import br.com.a3.hotel.view.*;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioController {

    // Método para realizar o login do usuário
    public int fazerLogin() throws SQLException, ClassNotFoundException {
        // Cria uma instância da view para autenticação do usuário
        UsuarioView usuario_view = new UsuarioView();
        // Recebe os dados de login inseridos pelo usuário
        UsuarioModel Usuario = usuario_view.autenticarUsuario();
        // Cria uma instância do DAO para lidar com a autenticação
        UsuarioDAO usuario_DAO = new UsuarioDAO();
        // Realiza a consulta no banco de dados para autenticar o usuário
        ResultSet resultSet = usuario_DAO.autenticarUsuario(Usuario);

        // Verifica se a consulta retornou algum resultado válido
        if (resultSet.next()) {
            // Exibe uma mensagem de login bem-sucedido
            JOptionPane.showMessageDialog(null, "Login feito com sucesso!!");
            // Exibe o menu para o usuário logado e aguarda uma resposta válida
            int menu = View.AppView.menuLogado();
            while (menu < 1 || menu > 4) {
                menu = View.AppView.menuLogado();
            }
            return menu; // Retorna o menu escolhido pelo usuário
        } else {
            // Caso a autenticação falhe, exibe uma mensagem e redireciona para o início do aplicativo
            JOptionPane.showMessageDialog(null, "Funcional e/ou Senha Inválida!");
            AppController ac = new AppController();
            ac.iniciar(); // Redireciona para o início do aplicativo
            return 4; // Retorna a opção de encerrar o sistema
        }
    }
}


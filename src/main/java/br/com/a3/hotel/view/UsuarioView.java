package br.com.a3.hotel.view;

import br.com.a3.hotel.model.*;

import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * A classe UsuarioView contém métodos relacionados à interação com usuários no sistema.
 */
public class UsuarioView {
        /**
     * Solicita e cadastra um novo usuário no sistema.
     *
     * @return Um objeto UsuarioModel com os detalhes do novo usuário.
     */
    public UsuarioModel cadastrarNovoUsuario() {

        String usuario = JOptionPane.showInputDialog(null, "Nome Completo:");
        String funcional = JOptionPane.showInputDialog(null, "Funcional (9 dígitos):");
        // Exibir a caixa de diálogo de senha de forma segura
        char[] senhaChars = mostrarCampoSenhaSeguro();
        String senha = null;
        if (senhaChars != null) {
            senha = new String(senhaChars);
            while (senha.contains(" ") || senha.length() < 5){
                JOptionPane.showMessageDialog(null, "- A senha deve conter no mínimo 5 dígitos\n" +
                        "- A senha não pode conter caracteres em branco.");
                senhaChars = mostrarCampoSenhaSeguro();
                if (senhaChars != null) {
                    senha = new String(senhaChars);}
            }

            senha = hashSenha(senha);
        }
        return new UsuarioModel(usuario, funcional, senha);
    }

    /**
     * Autentica um usuário no sistema solicitando seu funcional e senha.
     *
     * @return Um objeto UsuarioModel com os detalhes do usuário autenticado.
     */
    public UsuarioModel autenticarUsuario() {
        String funcional = JOptionPane.showInputDialog(null, "Funcional (9 dígitos):");
        // Exibir a caixa de diálogo de senha de forma segura
        char[] senhaChars = mostrarCampoSenhaSeguro();
        String senha = null;
        if (senhaChars != null) {
            senha = new String(senhaChars);

            senha = hashSenha(senha);
        }
        return new UsuarioModel(null,funcional, senha);
    }





    //  Método para mostrar o diálogo de senha de forma segura
        /**
     * Mostra um campo de senha seguro usando um componente JPasswordField.
     *
     * @return Um array de caracteres representando a senha digitada pelo usuário.
     */
    private char[] mostrarCampoSenhaSeguro() {
        JPasswordField cxSenha = new JPasswordField();
        int resultado = JOptionPane.showConfirmDialog(null, cxSenha, "Senha:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (resultado == JOptionPane.OK_OPTION) {
//            String senha = new String(cxSenha.getPassword());

//            if(senha.contains(" ") || senha.length() < 5){
//                JOptionPane.showMessageDialog(null, "- A senha deve conter no mínimo 5 dígitos\n" +
//                        "- A senha não pode conter caracteres em branco.");
//                return mostrarCampoSenhaSeguro();
//            } else {
            return cxSenha.getPassword();
//            }
        } else {
            return null; // O usuário cancelou
        }
    }


    //  Método para criptografar senha
        /**
     * Gera um hash SHA-256 para a senha fornecida.
     *
     * @param senha A senha a ser criptografada.
     * @return O hash SHA-256 da senha.
     */
    public static String hashSenha(String senha) {
        try {
            // Cria uma instância de MessageDigest com o algoritmo SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Converte a senha em bytes
            byte[] bytes = senha.getBytes();

            // Atualiza o MessageDigest com os bytes da senha
            md.update(bytes);

            // Obtem o hash da senha
            byte[] senhaHashBytes = md.digest();

            // Converte o hash em uma representação hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : senhaHashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

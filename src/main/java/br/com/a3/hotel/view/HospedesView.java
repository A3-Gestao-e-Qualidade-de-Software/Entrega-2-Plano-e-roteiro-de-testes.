package br.com.a3.hotel.view;

import br.com.a3.hotel.model.*;
import br.com.a3.hotel.utils.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * A classe HospedesView contém métodos relacionados à interação com os hóspedes.
 */

public class  HospedesView {

        /**
     * Exibe o menu de opções para Hóspedes.
     *
     * @return Um número inteiro correspondente à escolha do usuário.
     */

    public static int menuHospede(){
        int resposta = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Hospede: \n" +
                "[1] Cadastrar Hospede\n" +
                "[2] Deletar Hospede\n" +
                "[3] Editar Hospede\n" +
                "[4] Listar Hospedes\n" +
                "[5] Voltar"));
        return resposta;
    }

    /**
     * Coleta informações para cadastrar um novo hóspede.
     *
     * @return Um objeto HospedesModel com os dados do novo hóspede.
     */
    public HospedesModel cadastrarNovoHospede() {
        String nome = JOptionPane.showInputDialog(null, "Primeiro Nome:");
        String sobrenome = JOptionPane.showInputDialog(null, "Sobrenome:");
        String data_nascimento = new Metodos_Utils().solicitarData();
        String cpf = JOptionPane.showInputDialog(null, "CPF (Apenas dígitos):");
        String genero = new Metodos_Utils().selecionarGenero();
        String endereco = JOptionPane.showInputDialog(null, "Endereço (Estado, Cidade, Rua, nº):");
        String telefone = JOptionPane.showInputDialog(null, "Telefone:");
        String email = JOptionPane.showInputDialog(null, "Email:");

        System.out.println(data_nascimento);
        System.out.println(genero);

        return new HospedesModel(nome, sobrenome, data_nascimento, cpf, genero, endereco, telefone, email);
    }
    /**
     * Exibe o menu de opções para deletar um hóspede.
     *
     * @return Um número inteiro correspondente à escolha do usuário.
     */
    public static int menuDeletarHospede(){
        try {
            int resposta = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Deletar Hospede:\n\n" +
                    "[1] Visualizar Hospedes\n" +
                    "[2] Deletar Hospede\n" +
                    "[3] Voltar"));
            return resposta;
        }catch (Exception erro){
            return 3; // Em caso de exception, voltar para tela anterior.
        }
    }
    /**
     * Mostra a lista de hóspedes em uma caixa de diálogo.
     *
     * @param listaHospedes Lista de objetos HospedesModel a serem exibidos.
     */
    public static void mostrarListaHospedes(java.util.List<HospedesModel> listaHospedes) {
        // Criando um JTextArea para exibir os dados
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Impede que o usuário edite o texto
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        // Criando um JScrollPane para adicionar a barra de rolagem
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300)); // Tamanho da janela de visualização

        // Construindo a lst_hospedes formatada
        StringBuilder lst_hospedes = new StringBuilder("Lista de Hóspedes:\n\n");

        for (HospedesModel hospedesModel : listaHospedes) {
            lst_hospedes.append("Nome: ").append(hospedesModel.getNome()).append("\n");
            lst_hospedes.append("Sobrenome: ").append(hospedesModel.getSobrenome()).append("\n");
            lst_hospedes.append("Data de Nascimento: ").append(hospedesModel.getDtNascimento()).append("\n");
            lst_hospedes.append("CPF: ").append(hospedesModel.getCpf()).append("\n");
            lst_hospedes.append("Gênero: ").append(hospedesModel.getGenero()).append("\n");
            lst_hospedes.append("Endereço: ").append(hospedesModel.getEndereco()).append("\n");
            lst_hospedes.append("Telefone: ").append(hospedesModel.getTelefone()).append("\n");
            lst_hospedes.append("Email: ").append(hospedesModel.getEmail()).append("\n\n" +
                    "-------------------------------------------------------------\n\n");
        }

        // Configurando o texto no JTextArea
        textArea.setText(lst_hospedes.toString());

        // Exibindo a caixa de diálogo com a barra de rolagem
        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Hóspedes", JOptionPane.PLAIN_MESSAGE);
    }
    /**
     * Mostra uma caixa de diálogo para inserir o CPF do hóspede a ser deletado.
     *
     * @return O CPF do hóspede a ser deletado.
     */
    public static String mostrarTelaDeletarHospede(){
        String cpfHospede = JOptionPane.showInputDialog(null, "Deletar Hospede:\n\nDigite o CPF do Hospede a ser deletado:");
        return cpfHospede;
    }

    public String solicitarCPFEditar(){
        return JOptionPane.showInputDialog("Editar informações\n\nDigite o CPF do hospede: ");
    }

    public String mostrarOpcoesEditarHospede(){
        try {
            Object[] opcoes = {"Nome", "Sobrenome", "DT_Nascimento", "Genero", "Endereco", "Telefone", "Email"};
            String retorno = (String) JOptionPane.showInputDialog(null, "Selecione o campo a ser atualizado:",
                    "Escolha o Campo", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            return Objects.requireNonNullElse(retorno, "x");
        }catch (Exception erro){
            return "x";
        }
    }

    public String inserirNovoValorString(String campo){
        return JOptionPane.showInputDialog("Alterar valor de " + campo + " para:");
    }


}

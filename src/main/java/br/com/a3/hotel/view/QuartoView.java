package br.com.a3.hotel.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import br.com.a3.hotel.model.*;

/**
 * A classe QuartoView contém métodos relacionados à exibição e interação com quartos.
 */

public class QuartoView {

        /**
     * Mostra uma lista de quartos em uma caixa de diálogo.
     *
     * @param listaQuartos Lista de objetos QuartoModel a serem exibidos.
     */

    public static void mostrarListaQuartos(List<QuartoModel> listaQuartos){
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Impede que o usuário edite o texto
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        // Criando um JScrollPane para adicionar a barra de rolagem
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300)); // Tamanho da janela de visualização

        // Construindo a lst_quartos formatada
        StringBuilder lst_quartos = new StringBuilder("Lista de Quartos:\n\n");

        for(QuartoModel quartomodel: listaQuartos){
            lst_quartos.append("id: ").append(quartomodel.getID_Quarto()).append("\n");
            lst_quartos.append("Nº: ").append(quartomodel.getNum_Quarto()).append("\n");
            lst_quartos.append("Andar: ").append(quartomodel.getAndar_Quarto()).append("\n");
            lst_quartos.append("Modelo: ").append(quartomodel.getTipo_Quarto()).append("\n");
            lst_quartos.append("Preço: ").append(quartomodel.getPreco_Noite()).append("\n");
            lst_quartos.append("Status: ").append(quartomodel.getStatus_Ocupacao()).append("\n\n");
            lst_quartos.append("Descrição: ").append(quartomodel.getDescricao()).append("\n\n" +
                    "-------------------------------------------------------------\n\n");

        }

        // Configurando o texto no JTextArea
        textArea.setText(lst_quartos.toString());

        // Exibindo a caixa de diálogo com a barra de rolagem
        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Quartos", JOptionPane.PLAIN_MESSAGE);

    }
}

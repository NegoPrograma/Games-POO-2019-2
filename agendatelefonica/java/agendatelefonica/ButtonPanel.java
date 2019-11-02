/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonica;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author pc janete
 */
public class ButtonPanel {

    private static ArrayList<JButton> listaDeBotoes = new ArrayList<>();
    
    public static void inicializaBotoes(){
        listaDeBotoes.add(new JButton("Adiciona"));
        listaDeBotoes.add(new JButton("Remove"));
        listaDeBotoes.add(new JButton("Atualiza"));
        //adicionando o contato
        listaDeBotoes.get(0).addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    Mediador.addItem();
                }
        });
        //removendo o contato
        listaDeBotoes.get(1).addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    Mediador.removeItem();
                }
        });
        //atualizando o contato
        listaDeBotoes.get(2).addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    Mediador.updateItem();
                }
        });    
    
    }
    
   
    
    public static JPanel retornaPainel(){
        JPanel painelDeBotoes = new JPanel();
        painelDeBotoes.setLayout(new FlowLayout());
        inicializaBotoes();
        painelDeBotoes.add(listaDeBotoes.get(0));
        painelDeBotoes.add(listaDeBotoes.get(1));
        painelDeBotoes.add(listaDeBotoes.get(2));

        return painelDeBotoes;
    }
    
    
    
}

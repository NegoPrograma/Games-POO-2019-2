/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonica;

import javax.swing.*;

/**
 *
 * @author pc janete
 */
public class Janela {
    public static void main(String[] args){
        JFrame janela = new JFrame("Agênda telefônica");
        janela.setJMenuBar(MenuPanel.retornaMenu());
        janela.add(Agenda.retorna());
        janela.setSize(700, 700); 
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}

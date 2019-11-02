/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estudojavaswing;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author pc janete
 */
public class Test {
    
    private JFrame window;
    private JPanel insideWindow;
    private JButton button;
    private JLabel label;
    
    public Test(){
        startWindow();
    }

    public void startWindow() {
        window = new JFrame("Interface Gráfica");
        //setando visibilidade
        window.setVisible(true);
        //setando tamanho da janela
        window.setSize(700,700);
        //garantindo que o programa vai fechar no momento certo
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        insideWindow = new JPanel();
        insideWindow.setBackground(Color.YELLOW);
        button = new JButton("nome do botao");
        label = new JLabel("novo rótulo (???)");
        insideWindow.add(button);
        insideWindow.add(label);
        window.add(insideWindow,BorderLayout.EAST);
    }      
    
    
    public static void main(String[] args){
        new Test();
    }

}

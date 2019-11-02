/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estudojavaswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

/**
 *
 * @author pc janete
 */
public class gridTest {
    
    private JFrame window;
    private JPanel insideWindow;
    private JButton button;
    private JLabel label;
    
    public gridTest(){
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
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;
        
        insideWindow = new JPanel(new GridBagLayout());
        insideWindow.setBackground(Color.YELLOW);
        button = new JButton("nome do botao");
        JButton button2 = new JButton("outro botao");
        insideWindow.add(button,c);
        c.gridy = 2;
        insideWindow.add(button2,c);
        window.add(insideWindow,BorderLayout.EAST);
    }      
    
    
    public static void main(String[] args){
        new gridTest();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pong;

import javax.swing.JFrame;

/**
 *
 * @author pc janete
 */
public class GameStart extends JFrame {
    
    
    public static void main(String[] args){
        MainWindow mw = new MainWindow();
        JFrame tela = new JFrame("pong game");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.add(mw);
        tela.setVisible(true);
        tela.pack();
      
    }
}

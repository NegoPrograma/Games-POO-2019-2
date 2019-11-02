/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonica;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author pc janete
 */
public class Agenda{
    
    protected  static JPanel container = new JPanel();
    
    
    public static JPanel retorna(){
        container.setLayout(new GridLayout(2,2,2,2));
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.add(ListPanel.retornaPainel());
        container.add(InfoPanel.retornaPainel());
        container.add(ButtonPanel.retornaPainel());
        return container;
    }
    
    
}

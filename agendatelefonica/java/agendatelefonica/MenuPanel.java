/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
/**
 *
 * @author pc janete
 */
public class MenuPanel {
    
    protected static JMenuBar menu = new JMenuBar();
    protected static JMenu op = new JMenu("Opções");
    protected static JMenuItem add = new JMenuItem("Adicionar");
    protected static JMenuItem rem = new JMenuItem("Remover");
    protected static JMenuItem att = new JMenuItem("Atualizar");
    
    public static void inicializaMenu(){
        add.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e) {
                    Mediador.addItem();
                }
        });
        rem.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e) {
                   Mediador.removeItem();
                }
        });
        att.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e) {
                   Mediador.updateItem();
                }
        });
    }
    
     
    public static JMenuBar retornaMenu(){
        inicializaMenu();
        op.add(add);
        op.add(rem);
        op.add(att);
        menu.add(op);
        return menu;
    }
    
   
}

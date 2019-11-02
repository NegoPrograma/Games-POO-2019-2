/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorgrafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author pc janete
 */
public class Editor extends JPanel {
    public static final int  LARGURA = 700;
    public static final int  ALTURA = 700;
    protected Double mouseX,mouseY;
    protected Desenho desenho = new Desenho();
    
    public Editor() {
        this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                   Point coordenada = e.getLocationOnScreen();
                   mouseX = coordenada.getX();
                   mouseY = coordenada.getY();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        this.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                 desenho.setModo(e.getKeyChar());
                 if(desenho.getModo() == 't'){
                     desenho.parametro = "triangulo";
                 }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
        
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);  
        g.setColor(Color.WHITE);
        g.fillRect(0,0,LARGURA,ALTURA);
        player.desenha(g);
        bola.desenha(g);
        //text.draw(g, player, player2);
         for(int i = 0; i < LINES; i++){
            for(int j = 0; j < COLUMNS; j++){
                if(!blocks[i][j].gotHit)
                    blocks[i][j].desenha(g);
            }
        }
        text.draw(g, player);
        
    }
    
    
}

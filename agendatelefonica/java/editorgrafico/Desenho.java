/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorgrafico;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author pc janete
 */
public class Desenho {
    protected char modo;
    protected String parametro;
    protected int[][] limite = new int[3][];

    public char getModo() {
        return modo;
    }

    public void setModo(char modo) {
        this.modo = modo;
    }
    
    public void draw(Graphics g,Double x, Double y){
        
        if(modo == 't'){
            g.setColor(Color.blue);
            g.fillOval(x.intValue(),y.intValue(), 5, 5);
            g.drawLine(modo, modo, modo, modo);
        }
    }
    
}

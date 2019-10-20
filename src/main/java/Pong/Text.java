/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Formatter;
/**
 *
 * @author pc janete
 */
public class Text {
  
    public void draw(Graphics g, Raquete p1,Raquete p2){
        
      // Display the ball's information
      g.setColor(Color.RED);
      g.setFont(new Font("Courier New", Font.PLAIN, 30));
      StringBuilder sb = new StringBuilder();
      Formatter formatter = new Formatter(sb);
      formatter.format(p1.score + " X " + p2.score);
      g.drawString(sb.toString(), MainWindow.LARGURA/2-30, 20);
    }
    

}

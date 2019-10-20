package Breakout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Formatter;
/**
 *
 * @author pc janete
 */
public class Text {
  
    public void draw(Graphics g,Player p){
        
      // Display the ball's information
      g.setColor(Color.CYAN);
      g.setFont(new Font("Courier New", Font.PLAIN, 30));
      StringBuilder sb = new StringBuilder();
      Formatter formatter = new Formatter(sb);
      formatter.format("Lives Remaining: " + p.life);
      g.drawString(sb.toString(),0, MainWindow.ALTURA/2);
    }

}

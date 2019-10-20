
package Breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bola  {
    protected Color cor=Color.WHITE;
    protected int raio,x,y;
    protected int larguraCenario, alturaCenario;
    protected int velocX=1, velocY=6;

    public int getRaio() {
        return raio;
    }

    public void setVelocX(int velocX) {
        this.velocX = velocX;
    }

    public void setVelocY(int velocY) {
        this.velocY = velocY;
    }

    public Bola(int raio, int x, int y, int larguraCenario, int alturaCenario) {
        this.raio = raio;
        this.x = x;
        this.y = y;
        this.larguraCenario = larguraCenario;
        this.alturaCenario = alturaCenario;
    }
    
    public void desenha(Graphics g){
      g.setColor(cor);
      g.fillOval((int) (x - raio), (int) (y - raio), (int)(2 * raio), (int)(2 * raio));
    }
    
    public void atualiza(){
               // um passo a cada na thread do cenario
               // calculo da nova posicao
               x += velocX;
               y += velocY;
               if(x > larguraCenario || x < 0)
                   velocX = -velocX;
               if(y > alturaCenario)
                   y = alturaCenario/2;
               else if(y-raio-3 < 0)
                   velocY = -velocY;
                           
               
                   
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    public void check(Rectangule rect){
        //lidando com impactos 
        if(rect.x <= x && x < rect.x+rect.largura){
             if(y < rect.y+rect.altura && y+2*raio+1 >= rect.y){
                 rect.gotHit = true;
                 velocY = -velocY;
             }
        }
        
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getVelocX(){
        return velocX;
    }
    public int getVelocY(){
        return velocY;
    }

    
}

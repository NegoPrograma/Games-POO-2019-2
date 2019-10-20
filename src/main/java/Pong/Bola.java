
package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bola  {

    protected int raio,x,y;
    protected int larguraCenario, alturaCenario;
    protected int velocX=3, velocY=6;
    protected Color cor=Color.GREEN;
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
    
    public void atualiza(Raquete p1, Raquete p2){
               // um passo a cada na thread do cenario
               // calculo da nova posicao
               x += velocX;
               y += velocY;

               // verificar limites atualizando x e y
               if (x - raio < p1.largura) {
                  velocX = -velocX; // reflexao da bola nas paredes verticais 
                  x = larguraCenario/2; // colocar encostado no limite, pois pode ter ultrapassado muito
                  p2.score++;
               } 
               if (x + raio >= p2.x) {
                  velocX = -velocX;
                  x = larguraCenario/2;
                  p1.score++;
               }
               // idem em y
               if (y - raio < 0) {
                  velocY = -velocY; // reflexao da bola
                  y = raio; // colocar encostado no limite, pois pode ter ultrapassado muito
               } else if (y + raio > alturaCenario) {
                  velocY = -velocY;
                  y = alturaCenario - raio;
               }
               
               //verificando interação com raquetes esquerda e direita
               if(p1.y+p1.altura >= y && y >= p1.y){
                   if(x-raio-3 <= p1.x + p1.largura)
                       velocX = -velocX;
               }
               
               if(p2.y+p2.altura >= y && y >= p2.y){
                   if(x+raio+3 >= p2.x )
                       velocX = -velocX;
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

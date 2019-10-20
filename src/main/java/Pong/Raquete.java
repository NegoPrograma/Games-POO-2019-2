package Pong;


import java.awt.Color;
import java.awt.Graphics;

public class Raquete {
    protected Color cor=Color.CYAN;
    protected int x,y,largura,altura;
    protected int pontos;
    protected int score = 0;
    public Raquete(int x, int y, int largura, int altura){
        this.altura = altura;
        this.x = x;
        this.y = y;
        this.largura = largura;
    }
    
    public void desenha(Graphics g){
      g.setColor(cor);
      g.fillRect((int) (x), (int) (y), (int)(largura), (int)(altura));
    }
    
    public void moveCima(){
        y -=10;
    }
    
    public void moveBaixo(){
        y +=10;
    }
    
}

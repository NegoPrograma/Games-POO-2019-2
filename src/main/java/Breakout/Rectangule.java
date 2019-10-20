package Breakout;


import java.awt.Color;
import java.awt.Graphics;

public class Rectangule {
    protected Color cor;
    protected int x,y,largura,altura;
    protected int pontos;
    protected int score = 0;
    protected Boolean gotHit = false;
    
    public Rectangule(int x, int y, int largura, int altura,Color cor){
        this.cor = cor;
        this.altura = altura;
        this.x = x;
        this.y = y;
        this.largura = largura;
    }
    
    public void desenha(Graphics g){
      g.setColor(cor);
      g.fillRect((int) (x), (int) (y), (int)(largura), (int)(altura));
    }
    
    public void moveRight(){
        x +=10;
    }
    
    public void moveLeft(){
        x -=10;
    }
    
 
    
}

package Pong;


import java.awt.Color;
import java.awt.Graphics;

public class Raquete {
    protected Color cor=Color.CYAN;
    protected int x,y,largura,altura;
    protected int pontos;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    protected int score = 0;
    protected Boolean cima,baixo;
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

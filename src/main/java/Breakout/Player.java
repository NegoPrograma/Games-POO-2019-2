package Breakout;


import java.awt.Color;
import java.awt.Graphics;

public class Player {
    protected Color cor;
    protected int x,y,width,height;
    protected int life = 3, velocidade=15;
    protected Boolean gotHit = false;
    
    public Player(int x, int y, int width, int height,Color cor){
        this.cor = cor;
        this.height = height;
        this.x = x;
        this.y = y;
        this.width = width;
    }
    
    public void desenha(Graphics g){
      g.setColor(cor);
      g.fillRect((int) (x), (int) (y), (int)(width), (int)(height));
    }
    
    public void moveRight(){
        x +=velocidade;
    }
    
    public void moveLeft(){
        x -=velocidade;
    }
    
    public void check(Bola b){
            if(b.getX() > x && b.getX() <= x+width){
                if(b.getY()+b.getRaio()+2 > y){
                    b.setVelocY(-b.getVelocY());
                    b.setVelocX(-(b.getVelocX()+3));
                    velocidade+=2;
                }
            }
            if(b.getY()+2 > y){
                life--;
                b.setY(MainWindow.ALTURA/2);
            }
            
    }
    
    
    
}

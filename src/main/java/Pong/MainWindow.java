package Pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;


public class MainWindow extends JPanel implements Runnable,KeyListener {
    
    private Raquete player1;
    private Raquete player2;
    private Bola bola;
    private Text text = new Text();
    Thread ball,p1,p2;
    public static final int LARGURA = 700;
    public static final int ALTURA  = 700;
   
    public MainWindow(){
        this.addKeyListener(this);
        this.setFocusable(true);
        player1 = new Raquete(10,ALTURA/2,20,80);
        player2 = new Raquete(LARGURA-20,ALTURA/2,20,80);
        this.setPreferredSize(new Dimension(LARGURA,ALTURA));
        //(int raio, int x, int y, int larguraCenario, int alturaCenario)
        bola = new Bola(10,LARGURA/2,ALTURA/2,LARGURA,ALTURA);
        ball = new Thread(this,"ball");
        ball.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);  
        g.setColor(Color.BLACK);
        g.fillRect(0,0,LARGURA,ALTURA);
        player1.desenha(g);
        player2.desenha(g);
        bola.desenha(g);
        text.draw(g, player1, player2);
    }

   
    


    @Override
    public void run() {
        while(true){
         /*   if(Thread.currentThread().getName().equals("p1")){
                   player1.moveCima();
               if(player1.baixo)
                   player1.moveBaixo();
           }*/
           if(Thread.currentThread().getName().equals("ball")){
               bola.atualiza(player1,player2);
           }
           /*if(Thread.currentThread().getName().equals("p2")){
               if(player2.cima)
                   player2.moveCima();
               if(player2.baixo)
                   player2.moveBaixo();
           }*/
           repaint();
           
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

   

    @Override
    public void keyPressed(KeyEvent e) {
          
       /* int keyCode = e.getKeyCode();
           if(keyCode == KeyEvent.VK_Q){
            player1.cima = true;
        } else if(keyCode == KeyEvent.VK_Q){
            player1.baixo = true;
        } else if(keyCode == KeyEvent.VK_Q){
            player2.cima = true;
        } else if(keyCode == KeyEvent.VK_Q){
            player2.baixo = true;
        }*/
         int keyCode = e.getKeyCode();
         if(keyCode == KeyEvent.VK_Q){
            player1.moveCima();
        } else if(keyCode == KeyEvent.VK_A){
            player1.moveBaixo();
        } 
        if(keyCode == KeyEvent.VK_O){
            player2.moveCima();
        } else if(keyCode == KeyEvent.VK_L){
            player2.moveBaixo();
        }
       
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
         if(p1 == null || p2 == null){
            p1 = new Thread(this,"p1");
            p2 = new Thread(this,"p2");
            p1.start();
            p2.start();
        } 
        System.out.println("pressionou.");
        int keyCode = e.getKeyCode();
         if(keyCode == KeyEvent.VK_Q){
            player1.moveCima();
        } else if(keyCode == KeyEvent.VK_A){
            player1.moveBaixo();
        } 
        if(keyCode == KeyEvent.VK_O){
            player2.moveCima();
        } else if(keyCode == KeyEvent.VK_L){
            player2.moveBaixo();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
  
}

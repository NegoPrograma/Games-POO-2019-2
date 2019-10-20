package Breakout;

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
    
    private Player player;
    private Rectangule[][] blocks = new Rectangule[LINES][COLUMNS];
    private Bola bola;
    private Text text = new Text();
    Thread ball,p1,p2;
    public static final int LARGURA = 940;
    public static final int ALTURA  = 700;
    public static final int LINES = 5;
    public static final int COLUMNS = 10;
    
    public MainWindow(){
        this.addKeyListener(this);
        this.setFocusable(true);
        player = new Player(LARGURA/2,ALTURA-30,80,20,Color.RED);
        this.setPreferredSize(new Dimension(LARGURA,ALTURA));
        //(int raio, int x, int y, int larguraCenario, int alturaCenario)
        bola = new Bola(15,LARGURA/2,ALTURA/2,LARGURA-5,ALTURA-5);
        for(int i = 0; i < LINES; i++){
            for(int j = 0; j < COLUMNS; j++){
                switch(i){
                    case 0:
                        blocks[i][j] = new Rectangule(7+j*80+(j*15),10,80,20,Color.RED);
                        break;
                    case 1:
                        blocks[i][j] = new Rectangule(7+j*80+(j*15),40,80,20,Color.ORANGE);
                        break;                        
                    case 2:
                        blocks[i][j] = new Rectangule(7+j*80+(j*15),70,80,20,Color.YELLOW);
                        break;
                    case 3:
                        blocks[i][j] = new Rectangule(7+j*80+(j*15),100,80,20,Color.GREEN);
                        break;
                    case 4:
                        blocks[i][j] = new Rectangule(7+j*80+(j*15),130,80,20,Color.BLUE);
                        break;                        
                }
            }
        }
        
        
        ball = new Thread(this,"ball");
        ball.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);  
        g.setColor(Color.BLACK);
        g.fillRect(0,0,LARGURA,ALTURA);
        player.desenha(g);
        bola.desenha(g);
        //text.draw(g, player, player2);
         for(int i = 0; i < LINES; i++){
            for(int j = 0; j < COLUMNS; j++){
                if(!blocks[i][j].gotHit)
                    blocks[i][j].desenha(g);
            }
        }
        text.draw(g, player);
        
    }

   public void gameOver(Player p,Bola b){
       if(p.life <= 0){
           for(int i = 0; i < LINES; i++){
            for(int j = 0; j < COLUMNS; j++){
                    blocks[i][j].gotHit = false;
            }
            p.life = 3;
            b.velocX = 1;
            p.velocidade = 10;
            
            
        }
           
       }
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
               bola.atualiza();
               
           }
           /*if(Thread.currentThread().getName().equals("p2")){
               if(player2.cima)
                   player2.moveCima();
               if(player2.baixo)
                   player2.moveBaixo();
           }*/
           player.check(bola);
           
           for(int i = 0; i < LINES; i++){
                for(int j = 0; j < COLUMNS; j++){
                    if(!blocks[i][j].gotHit)
                        bola.check(blocks[i][j]);
                }
            }
               
            gameOver(player,bola);
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
        if(player.x+player.width < LARGURA && player.x > 0){  
            int keyCode = e.getKeyCode();
            if(keyCode == KeyEvent.VK_LEFT){
               player.moveLeft();
           } else if(keyCode == KeyEvent.VK_RIGHT){
               player.moveRight();
           } 
        } else {
            player.x = LARGURA/2;
        }
       
    }
    
    
  

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
  
}

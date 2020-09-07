import Objects.Coin;
import Objects.Snake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;


public class Board extends JPanel{
    
    
    private Snake   playerSnake; 
    private Coin    coinInGame; 
     
    private boolean moveRight = false; 
    private boolean moveLeft  = false;
    private boolean moveDown  = false;
    private boolean moveUp    = false;
    private int     score = 0;
    
    private boolean defeated  = false;
  
    
    public Board()
    {
        playerSnake  = new Snake(250,250);
        coinInGame   = new Coin(); 
        
        addKeyListener(new boardListener());
        setBackground(Color.black);
        setFocusable(true); 
    } 
    
    public void handleDrawing(Graphics g) 
    {    
        g.setColor(Color.WHITE);
        if(playerSnake.inBoundaries())
        {
       
        g.drawString("Score - " +score, 7, 15);
        playerSnake.move(moveRight,moveLeft,moveDown,moveUp); 
           
        if(playerSnake != null) playerSnake.draw(g);
        if(coinInGame  != null) coinInGame.draw(g); 
        
        if(playerSnake.hasCollisionWithCoin(coinInGame)){
            coinInGame.destroy();
            coinInGame = new Coin();
            score+=5;
        }
        } else{
            g.drawString("You have been defeated! press enter to play again", 100, 250);
            g.drawString("Score -"+score, 100, 270);
            defeated = true;
        }
    }
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);  
        handleDrawing(g); 
        repaint();
    } 

    
    private class boardListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
 
            if (key == KeyEvent.VK_LEFT && !moveRight) {
               moveLeft  = true;
               moveRight = false;
               moveUp = false;
               moveDown = false;
            }
            if (key == KeyEvent.VK_RIGHT && !moveLeft) {
               moveRight = true;
               moveLeft  = false; 
               moveUp = false;
               moveDown = false;
            }
            if (key == KeyEvent.VK_UP && !moveDown) {
               moveUp = true;
               moveRight = false;
               moveLeft  = false;  
               moveDown = false;
            }
            if (key == KeyEvent.VK_DOWN && !moveUp) {
               moveRight = false;
               moveLeft  = false; 
               moveUp = false;
               moveDown = true;
            }
            if(key == KeyEvent.VK_ENTER && defeated){
                defeated = false;
                moveRight = false;
                moveLeft  = false;
                moveUp    = false;
                moveDown  = false;
                score     = 0;
                playerSnake.reset();
            }
        }
    }
}

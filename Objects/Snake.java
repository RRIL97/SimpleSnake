
package Objects;

import java.awt.Color;
import java.awt.Graphics; 

public class Snake {
    
    private int x ;
    private int y ;
        
    
    public Snake(int x, int y)
    {
    this.x = x;
    this.y = y;     
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y; 
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(x, y, 10,10);
    }
    
    public boolean inBoundaries(){
        if(x < 0  || x > 490) return false; 
        if(y < 0  || y > 490) return false;
        return true; 
    }
    public boolean hasCollisionWithCoin(Coin coin){
        int coinX = coin.getX();
        int coinY = coin.getY();
        
        if(Math.abs(x-coinX) <= 8 && Math.abs(y-coinY)<=8) return true;
        return false;
    }
    public void reset(){
        x = 250;
        y = 250;
    }
    public void move(boolean right, boolean left, boolean down, boolean up){
        try{
            if(right)
                moveRight();
            if(left)
                moveLeft();
            if(up)
                moveUp();
            if(down)
                moveDown();
        }catch(Exception moveException){ 
            moveException.printStackTrace();
        }
    }
    public void moveRight() throws InterruptedException{
        
        setX(x+2);
        Thread.sleep(10);
    }
    public void moveLeft() throws InterruptedException{
        setX(x-2);
        Thread.sleep(10);
    }
    public void moveUp() throws InterruptedException{
        setY(y-2); 
        Thread.sleep(10);
    }
    public void moveDown() throws InterruptedException{
        setY(y+2);  
        Thread.sleep(10);
    }
}

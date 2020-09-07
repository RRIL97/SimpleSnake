
package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;


public class Coin {
    
    int x ;
    int y ;
    
    public Coin(){
      x = ThreadLocalRandom.current().nextInt(10,400);    
      y = ThreadLocalRandom.current().nextInt(10,400);
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        g.drawRect(x, y, 6,6);
    }
    public void destroy(){
        x = -1;
        y = -1;
    }
    
}


import javax.swing.JFrame;


public class SnakeFrame extends JFrame {
    
    public SnakeFrame(){
        setResizable(false);
        setLocationRelativeTo(null); 
        add(new Board());   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(500,500);
        setTitle("Snake Game");
    }
    
    public static void main(String [] args)
    {
        JFrame mainGame = new SnakeFrame();
        mainGame.setVisible(true);
    }
}

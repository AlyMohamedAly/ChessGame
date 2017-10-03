package chessgame;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{
    private int X;
    BackgroundPanel(int x){
        X = x;
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if(X == 1){
            ImageIcon Background = new ImageIcon("north.png");
            g.drawImage(Background.getImage(), 0, 0, this);
        }
        if(X == 2){
            ImageIcon Background = new ImageIcon("south.png");
            g.drawImage(Background.getImage(), 0, 0, this);
        }
        if(X == 3){
            ImageIcon Background = new ImageIcon("east.png");
            g.drawImage(Background.getImage(), 0, 0, this);
        }
        if(X == 4){
            ImageIcon Background = new ImageIcon("west.png");
            g.drawImage(Background.getImage(), 0, 0, this);
        }
    }    
}
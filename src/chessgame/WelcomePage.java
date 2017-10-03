package chessgame;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WelcomePage extends JPanel{	
    private int timer = 1500;
    private int timer2 = 700;
    private int timer3 = 1500;
    
    private ImageIcon gameLoading = new ImageIcon("gameLoading.png");
    private ImageIcon logo = new ImageIcon("Logo.png");
    private ImageIcon Template = new ImageIcon("Template.png");
    private ImageIcon pressAnyKey = new ImageIcon("pressAnyKey.png");

    public WelcomePage() {
        while(timer2>0) {
            
            timer2--;
    	}
        while(timer>0) {
            
            timer--;
        }
        while(timer3>0) {
            
            timer3--;
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
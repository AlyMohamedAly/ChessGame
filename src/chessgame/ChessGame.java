package chessgame;

import javax.swing.JFrame;

public class ChessGame{

    public static void main (String[] args){
        GameFrame gg = new GameFrame();
        gg.setTitle("Chess Masters");
        gg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gg.setBounds(300, 10, 646, 669);
        gg.setResizable(false);
        gg.setVisible(true);
    }
}

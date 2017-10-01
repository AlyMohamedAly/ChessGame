package chessgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessGame {
    public static void main(String[] args) {
        GameFrame gg = new GameFrame();
        gg.setVisible(true);
    }
}
class GameFrame extends JFrame{
    private JLabel[] WhitePawns = new JLabel[8];
    private JLabel WhiteLeftKnight = new JLabel("here");
    private JLabel WhiteRightKnight = new JLabel("here");
    private JLabel WhiteLeftBishop = new JLabel("here");
    private JLabel WhiteRightBishop = new JLabel("here");
    private JLabel WhiteLeftRook = new JLabel("here");
    private JLabel WhiteRightRook = new JLabel("here");
    private JLabel WhiteQueen = new JLabel("here");
    private JLabel WhiteKing = new JLabel("here");
    
    private JLabel[] BlackPawns = new JLabel[8];
    private JLabel BlackLeftKnight = new JLabel();
    private JLabel BlackRightKnight = new JLabel();
    private JLabel BlackLeftBishop = new JLabel();
    private JLabel BlackRightBishop = new JLabel();
    private JLabel BlackLeftRook = new JLabel();
    private JLabel BlackRightRook = new JLabel();
    private JLabel BlackQueen = new JLabel();
    private JLabel BlackKing = new JLabel();
    
    private Tile[][] Tiles = new Tile[8][8];
    
    private ImageIcon WhitePawnImg = new ImageIcon("White_Pawn.png");
    private ImageIcon WhiteKnightImg = new ImageIcon("White_Knight.png");
    private ImageIcon WhiteBishopImg = new ImageIcon("White_Bishop.png");
    private ImageIcon WhiteRookImg = new ImageIcon("White_Rook.png");
    private ImageIcon WhiteQueenImg = new ImageIcon("White_Queen.png");
    private ImageIcon WhiteKingImg = new ImageIcon("White_King.png");
    
    private ImageIcon BlackPawnImg = new ImageIcon("Black_Pawn.png");
    private ImageIcon BlackKnightImg = new ImageIcon("Black_Knight.png");
    private ImageIcon BlackBishopImg = new ImageIcon("Black_Bishop.png");
    private ImageIcon BlackRookImg = new ImageIcon("Black_Rook.png");
    private ImageIcon BlackQueenImg = new ImageIcon("Black_Queen.png");
    private ImageIcon BlackKingImg = new ImageIcon("Black_King.png");
    
    private JPanel ppl = new JPanel();
    GameFrame(){
        
        this.setTitle("masr");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300,10,646,669);
        this.setResizable(false);
        Container C = this.getContentPane();
        ppl.setLayout(null);
        init();
        C.add(ppl);
    }
    private void init() {
        Color B = new Color(145, 83, 55);
        Color W = new Color(249, 217, 202);
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
            Tiles[i][j] = new Tile();
            Tiles[i][j].setBounds(j*80, i*80, 80, 80);
            Tiles[i][j].addMouseListener(new Hole(i,j));
            ppl.add(Tiles[i][j]);
            }
        }
        for(int i = 0, j = 0; j < 8; i += 2){
            Tiles[j][i].setBackground(W);
            if((i+2) % 8 == 0){
                j += 2;
                i = -2;
            }
        }
        for(int i = 0, j = 1; j < 8; i += 2){
            Tiles[j][i].setBackground(B);
            if((i+2) % 8 == 0){
                j += 2;
                i = -2;
            }
        }
        for(int i = 1, j = 1; j < 8; i += 2){
            Tiles[j][i].setBackground(W);
            if((i+1) % 8 == 0){
                j += 2;
                i = -1;
            }
        }
        for(int i = 1, j = 0; j < 8; i += 2){
            Tiles[j][i].setBackground(B);
            if((i+1) % 8 == 0){
                j += 2;
                i = -1;
            }
        }
        for(int i = 0; i < 8; i++){
            WhitePawns[i] = new JLabel();
            WhitePawns[i].setIcon(WhitePawnImg);
            WhitePawns[i].setBounds(Tiles[6][i].getBounds());
            ppl.add(WhitePawns[i]);
            
            BlackPawns[i] = new JLabel();
            BlackPawns[i].setIcon(BlackPawnImg);
            WhitePawns[i].setBounds(Tiles[1][i].getBounds());
            ppl.add(WhitePawns[i]);
        }
        WhiteLeftKnight.setIcon(WhiteKnightImg);
        WhiteLeftKnight.setBounds(Tiles[7][1].getBounds());
        WhiteRightKnight.setIcon(WhiteKnightImg);
        WhiteRightKnight.setBounds(Tiles[7][6].getBounds());
        System.out.println(Tiles[0][0].getBounds());
        ppl.add(WhiteLeftKnight);
        ppl.add(WhiteRightKnight);
        
        BlackLeftKnight.setIcon(BlackKnightImg);
        BlackLeftKnight.setBounds(Tiles[0][1].getBounds());
        BlackRightKnight.setIcon(BlackKnightImg);
        BlackRightKnight.setBounds(Tiles[0][6].getBounds());
        ppl.add(BlackLeftKnight);
        ppl.add(BlackRightKnight);
        
        WhiteLeftRook.setIcon(WhiteRookImg);
        WhiteLeftRook.setBounds(Tiles[7][0].getBounds());
        WhiteRightRook.setIcon(WhiteRookImg);
        WhiteRightRook.setBounds(Tiles[7][7].getBounds());
        ppl.add(WhiteLeftRook);
        ppl.add(WhiteRightRook);
        
        BlackLeftRook.setIcon(BlackRookImg);
        BlackLeftRook.setBounds(Tiles[0][0].getBounds());
        BlackRightRook.setIcon(BlackRookImg);
        BlackRightRook.setBounds(Tiles[0][7].getBounds());
        ppl.add(BlackLeftRook);
        ppl.add(BlackRightRook);
        
        WhiteLeftBishop.setIcon(WhiteBishopImg);
        WhiteLeftBishop.setBounds(Tiles[7][2].getBounds());
        WhiteRightBishop.setIcon(WhiteBishopImg);
        WhiteRightBishop.setBounds(Tiles[7][5].getBounds());
        ppl.add(WhiteLeftBishop);
        ppl.add(WhiteRightBishop);
        
        BlackLeftBishop.setIcon(BlackBishopImg);
        BlackLeftBishop.setBounds(Tiles[0][2].getBounds());
        BlackRightBishop.setIcon(BlackBishopImg);
        BlackRightBishop.setBounds(Tiles[0][5].getBounds());
        ppl.add(BlackLeftBishop);
        ppl.add(BlackRightBishop);
        
        WhiteKing.setIcon(WhiteKingImg);
        WhiteKing.setBounds(Tiles[7][4].getBounds());
        WhiteQueen.setIcon(WhiteQueenImg);
        WhiteQueen.setBounds(Tiles[7][3].getBounds());
        ppl.add(WhiteKing);
        ppl.add(WhiteQueen);
        
        BlackKing.setIcon(BlackKingImg);
        BlackKing.setBounds(Tiles[0][4].getBounds());
        BlackQueen.setIcon(BlackQueenImg);
        BlackQueen.setBounds(Tiles[0][3].getBounds());
        ppl.add(BlackKing);
        ppl.add(BlackQueen);
    }
    
    class Hole extends MouseAdapter{
        private int i,j;
        Hole(int ind1, int ind2){
            i = ind1;
            j = ind2;
        }
        public void mouseClicked(MouseEvent e)
        {
            Tiles[i][j].setBackground(Color.red);
        }
    }
    
    class Tile extends JPanel{
        private Piece pp = null;
        void setPiece(Piece p){
            pp = p;
        }
        Piece getPiece(){
            return pp;
        }
    }
    
    class Piece{
        
    }
}


package chessgame;

import java.awt.Color;
import java.awt.Container;
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
    private Piece[] WhitePawns = new Piece[8];
    private Piece WhiteLeftKnight = new Piece("WhiteLeftKnight");
    private Piece WhiteRightKnight = new Piece("WhiteRightKnight");
    private Piece WhiteLeftBishop = new Piece("WhiteLeftBishop");
    private Piece WhiteRightBishop = new Piece("WhiteRightBishop");
    private Piece WhiteLeftRook = new Piece("WhiteLeftRook");
    private Piece WhiteRightRook = new Piece("WhiteRightRook");
    private Piece WhiteQueen = new Piece("WhiteQueen");
    private Piece WhiteKing = new Piece("WhiteKing");
    
    private Piece[] BlackPawns = new Piece[8];
    private Piece BlackLeftKnight = new Piece("BlackLeftKnight");
    private Piece BlackRightKnight = new Piece("BlackRightKnight");
    private Piece BlackLeftBishop = new Piece("BlackLeftBishop");
    private Piece BlackRightBishop = new Piece("BlackRightBishop");
    private Piece BlackLeftRook = new Piece("BlackLeftRook");
    private Piece BlackRightRook = new Piece("BlackRightRook");
    private Piece BlackQueen = new Piece("BlackQueen");
    private Piece BlackKing = new Piece("BlackKing");
    
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
        
        this.setTitle("Chess2shba7");
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
            WhitePawns[i] = new Piece("WhitePawns");
            WhitePawns[i].setIcon(WhitePawnImg);
            WhitePawns[i].setBounds(Tiles[6][i].getBounds());
            Tiles[6][i].add(WhitePawns[i]);
            
            BlackPawns[i] = new Piece("BlackPawn");
            BlackPawns[i].setIcon(BlackPawnImg);
            WhitePawns[i].setBounds(Tiles[1][i].getBounds());
            Tiles[1][i].add(BlackPawns[i]);
        }
        WhiteLeftKnight.setIcon(WhiteKnightImg);
        WhiteLeftKnight.setBounds(Tiles[7][1].getBounds());
        WhiteRightKnight.setIcon(WhiteKnightImg);
        WhiteRightKnight.setBounds(Tiles[7][6].getBounds());
        Tiles[7][1].add(WhiteLeftKnight);
        Tiles[7][6].add(WhiteRightKnight);
        
        BlackLeftKnight.setIcon(BlackKnightImg);
        BlackLeftKnight.setBounds(Tiles[0][1].getBounds());
        BlackRightKnight.setIcon(BlackKnightImg);
        BlackRightKnight.setBounds(Tiles[0][6].getBounds());
        Tiles[0][1].add(BlackLeftKnight);
        Tiles[0][6].add(BlackRightKnight);
        
        WhiteLeftRook.setIcon(WhiteRookImg);
        WhiteLeftRook.setBounds(Tiles[7][0].getBounds());
        WhiteRightRook.setIcon(WhiteRookImg);
        WhiteRightRook.setBounds(Tiles[7][7].getBounds());
        Tiles[7][0].add(WhiteLeftRook);
        Tiles[7][7].add(WhiteRightRook);
        
        BlackLeftRook.setIcon(BlackRookImg);
        BlackLeftRook.setBounds(Tiles[0][0].getBounds());
        BlackRightRook.setIcon(BlackRookImg);
        BlackRightRook.setBounds(Tiles[0][7].getBounds());
        Tiles[0][0].add(BlackLeftRook);
        Tiles[0][7].add(BlackRightRook);
        
        WhiteLeftBishop.setIcon(WhiteBishopImg);
        WhiteLeftBishop.setBounds(Tiles[7][2].getBounds());
        WhiteRightBishop.setIcon(WhiteBishopImg);
        WhiteRightBishop.setBounds(Tiles[7][5].getBounds());
        Tiles[7][2].add(WhiteLeftBishop);
        Tiles[7][5].add(WhiteRightBishop);
        
        BlackLeftBishop.setIcon(BlackBishopImg);
        BlackLeftBishop.setBounds(Tiles[0][2].getBounds());
        BlackRightBishop.setIcon(BlackBishopImg);
        BlackRightBishop.setBounds(Tiles[0][5].getBounds());
        Tiles[0][2].add(BlackLeftBishop);
        Tiles[0][5].add(BlackRightBishop);
        
        WhiteKing.setIcon(WhiteKingImg);
        WhiteKing.setBounds(Tiles[7][4].getBounds());
        WhiteQueen.setIcon(WhiteQueenImg);
        WhiteQueen.setBounds(Tiles[7][3].getBounds());
        Tiles[7][4].add(WhiteKing);
        Tiles[7][3].add(WhiteQueen);
        
        BlackKing.setIcon(BlackKingImg);
        BlackKing.setBounds(Tiles[0][4].getBounds());
        BlackQueen.setIcon(BlackQueenImg);
        BlackQueen.setBounds(Tiles[0][3].getBounds());
        Tiles[0][4].add(BlackKing);
        Tiles[0][3].add(BlackQueen);
    }
    
    class Hole extends MouseAdapter{
        private int i,j;
        private Piece pp = null;
        Hole(int ind1, int ind2){
            i = ind1;
            j = ind2;
        }
        public void mouseClicked(MouseEvent e)
        {
            Piece ps =(Piece) Tiles[7][3].getComponent(0);
            Tiles[7][3].removePiece();
            Tiles[3][3].setPiece(ps);
            Tiles[7][3].repaint();
            Tiles[3][3].repaint();
        }
    }
    
    class Tile extends JPanel{
        
        void setPiece(Piece pp){
            this.add(pp);
        }
        Piece getPiece(){
            return (Piece)this.getComponent(0);
        }
        void removePiece(){
            this.removeAll();
        }
    }
    
    class Piece extends JLabel{
        private String Name;
        Piece(String name){
            Name = name;
        }
        String getColor(){
            return Name.substring(0, 5);
        }
    }
}


package chessgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
    private Pawn[] WhitePawns = new Pawn[8];
    private Knight WhiteLeftKnight = new Knight("WhiteLeftKnight");
    private Knight WhiteRightKnight = new Knight("WhiteRightKnight");
    private Bishop WhiteLeftBishop = new Bishop("WhiteLeftBishop");
    private Bishop WhiteRightBishop = new Bishop("WhiteRightBishop");
    private Rook WhiteLeftRook = new Rook("WhiteLeftRook");
    private Rook WhiteRightRook = new Rook("WhiteRightRook");
    private Queen WhiteQueen = new Queen("WhiteQueen");
    private King WhiteKing = new King("WhiteKing");
    
    private Pawn[] BlackPawns = new Pawn[8];
    private Knight BlackLeftKnight = new Knight("BlackLeftKnight");
    private Knight BlackRightKnight = new Knight("BlackRightKnight");
    private Bishop BlackLeftBishop = new Bishop("BlackLeftBishop");
    private Bishop BlackRightBishop = new Bishop("BlackRightBishop");
    private Rook BlackLeftRook = new Rook("BlackLeftRook");
    private Rook BlackRightRook = new Rook("BlackRightRook");
    private Queen BlackQueen = new Queen("BlackQueen");
    private King BlackKing = new King("BlackKing");
    
    public static Tile[][] Tiles = new Tile[8][8];
    
    private ImageIcon WhitePawnImg = new ImageIcon("wPawn.png");
    private ImageIcon WhiteKnightImg = new ImageIcon("wKnight.png");
    private ImageIcon WhiteBishopImg = new ImageIcon("wBishop.png");
    private ImageIcon WhiteRookImg = new ImageIcon("wRook.png");
    private ImageIcon WhiteQueenImg = new ImageIcon("wQueen.png");
    private ImageIcon WhiteKingImg = new ImageIcon("wKing.png");
    
    private ImageIcon BlackPawnImg = new ImageIcon("bPawn.png");
    private ImageIcon BlackKnightImg = new ImageIcon("bKnight.png");
    private ImageIcon BlackBishopImg = new ImageIcon("bBishop.png");
    private ImageIcon BlackRookImg = new ImageIcon("bRook.png");
    private ImageIcon BlackQueenImg = new ImageIcon("bQueen.png");
    private ImageIcon BlackKingImg = new ImageIcon("bKing.png");
    
    private ImageIcon nPnl = new ImageIcon(".png");
    private ImageIcon sPnl = new ImageIcon(".png");
    private ImageIcon ePnl = new ImageIcon(".png");
    private ImageIcon wPnl = new ImageIcon(".png");
    
    private JPanel cPPL = new JPanel();
    private BackgroundPanel nPPL = new BackgroundPanel(1);
    private BackgroundPanel sPPL = new BackgroundPanel(2);
    private BackgroundPanel ePPL = new BackgroundPanel(3);
    private BackgroundPanel wPPL = new BackgroundPanel(4);
    
    private Tile current = new Tile();
    private int player = 1;
    
    GameFrame(){
        this.setTitle("Chess Masters");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setBounds(300,10,646,669);
        this.setBounds(300,10,656,679);
        //this.setBounds(300,10,782,804);
        this.setResizable(true);
        Container C = this.getContentPane();
        cPPL.setLayout(null);
        init();
        
        //nPPL.setPreferredSize(new Dimension(640,63));
        //sPPL.setPreferredSize(new Dimension(640,63));
        //ePPL.setPreferredSize(new Dimension(63,640));
        //wPPL.setPreferredSize(new Dimension(63,640));
        
        C.add(cPPL, BorderLayout.CENTER);
        //C.add(nPPL, BorderLayout.NORTH);
        //C.add(sPPL, BorderLayout.SOUTH);
        //C.add(ePPL, BorderLayout.EAST);
        //C.add(wPPL, BorderLayout.WEST);
    }
    
    private void init() {
        Color B = new Color(145, 83, 55);
        Color W = new Color(249, 217, 202);
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
            Tiles[i][j] = new Tile();
            Tiles[i][j].setBounds(j*80, i*80, 80, 80);
            Tiles[i][j].addMouseListener(new Hole(i,j));
            cPPL.add(Tiles[i][j]);
            }
        }
        for(int i = 0, j = 0; j < 8; i += 2){
            Tiles[j][i].setBackground(W);
            Tiles[j][i].setColor(W);
            if((i+2) % 8 == 0){
                j += 2;
                i = -2;
            }
        }
        for(int i = 0, j = 1; j < 8; i += 2){
            Tiles[j][i].setBackground(B);
            Tiles[j][i].setColor(B);
            if((i+2) % 8 == 0){
                j += 2;
                i = -2;
            }
        }
        for(int i = 1, j = 1; j < 8; i += 2) {
            Tiles[j][i].setBackground(W);
            Tiles[j][i].setColor(W);
            if((i+1) % 8 == 0){
                j += 2;
                i = -1;
            }
        }
        for(int i = 1, j = 0; j < 8; i += 2) {
            Tiles[j][i].setBackground(B);
            Tiles[j][i].setColor(B);
            if((i+1) % 8 == 0){
                j += 2;
                i = -1;
            }
        }
        for(int i = 0; i < 8; i++) {
            WhitePawns[i] = new Pawn("WhitePawns");
            WhitePawns[i].setIcon(WhitePawnImg);
            WhitePawns[i].setBounds(Tiles[6][i].getBounds());
            Tiles[6][i].add(WhitePawns[i]);
            
            BlackPawns[i] = new Pawn("BlackPawn");
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
        
        Hole(int ind1, int ind2){
            i = ind1;
            j = ind2;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            Color W = new Color(249, 217, 202);
            Color Y = new Color(234, 230, 119);
            Color G = new Color(127, 229, 55);
            Color R = new Color(216, 60, 60);
            Piece ps;
            if(current.getPiece() != null){
                if(current.getColor().getRGB()== W.getRGB())
                    current.WhiteTile();
                else
                    current.BlackTile();
                
                for(int k = 0; k < 8; k++){
                    for(int u = 0; u < 8; u++){
                        if(current.getPiece().canMove(current, Tiles[u][k])){
                            Tiles[u][k].setBackground(Tiles[u][k].getColor());
                            Tiles[u][k].repaint();
                        }
                    }
                }
                
                if(Tiles[i][j].getPiece() != null){
                    if(current.getPiece().canMove(current, Tiles[i][j])){
                        if(Tiles[i][j].getPiece().getColor().equals(current.getPiece().getColor())){
                        }
                        else{
                        ps = current.getPiece();
                        Tiles[i][j].removePiece();
                        current.removePiece();
                        Tiles[i][j].setPiece(ps);
                        }
                    }
                }
                else{
                    if(current.getPiece().canMove(current, Tiles[i][j])){
                    ps = current.getPiece();
                    current.removePiece();
                    Tiles[i][j].setPiece(ps);
                    }
                    else{
                    }
                }
                    current.repaint();
                    current = EmptyTile();
            }
            else if(Tiles[i][j].getPiece() != null){
                for(int k = 0; k < 8; k++){
                    for(int u = 0; u < 8; u++){
                        if(Tiles[i][j].getPiece().canMove(Tiles[i][j], Tiles[u][k])){
                            Tiles[u][k].setBackground(G);
                            Tiles[u][k].repaint();
                            if(Tiles[u][k].getPiece() != null){
                                if(!Tiles[u][k].getPiece().getColor().equals( Tiles[i][j].getPiece().getColor())){
                                Tiles[u][k].setBackground(R);
                                Tiles[u][k].repaint();
                                }
                                else{
                                    Tiles[u][k].setBackground(Tiles[u][k].getColor());
                                    Tiles[u][k].repaint();
                                }
                            }
                        }
                    }
                }
                    Tiles[i][j].setBackground(Y);
                    current = Tiles[i][j];
            }
            Tiles[i][j].repaint();
        }
        public Tile EmptyTile(){
        Tile pp;
        for (int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(Tiles[i][j].getPiece() == null){
                    pp = Tiles[i][j];
                    return pp;
                }
            }
        }
        return null;
    }
}
    
}
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
    private Tile current = new Tile();
    private int player = 1;
    
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
    abstract class Piece extends JLabel{
        private String Name;
        Piece(String name){
            Name = name;
        }
        String getColor(){
            return Name.substring(0, 5);
        }
        String GetType(){
            return Name;
        }
         public abstract boolean canMove(Tile c, Tile t);
    }
    class Pawn extends Piece{
        private boolean Moved = false;
        Pawn(String s){
            super(s);
        }
        @Override
        public boolean canMove(Tile c, Tile t){
            int CI = c.getY()/80;
            int CJ = c.getX()/80;
            
            int TI = t.getY()/80;
            int TJ = t.getX()/80;
            if(Moved){
                if(TJ == CJ && TI == CI-1)
                    return true;
            }
            else{
                Moved = true;   // law 3amal call lel function w mamsheesh htb2a true
                if(TJ == CJ && TI == CI-1)
                    return true;
                if(TJ == CJ && TI == CI-2 && Tiles[CI-1][CJ].getPiece() == null)
                    return true;
            }
            return false;
        }
    }
    class Knight extends Piece{
        Knight(String s){
            super(s);
        }
        @Override
        public boolean canMove(Tile c, Tile t){
            int CI = c.getY()/80;
            int CJ = c.getX()/80;
            
            int TI = t.getY()/80;
            int TJ = t.getX()/80;
            
            if(TI == CI-2 && TJ == CJ-1)
                return true;
            if(TI == CI-2 && TJ == CJ+1)
                return true;
            
            if(TI == CI+2 && TJ == CJ-1)
                return true;
            if(TI == CI+2 && TJ == CJ+1)
                return true;
            
            if(TI == CI-1 && TJ == CJ-2)
                return true;
            if(TI == CI+1 && TJ == CJ-2)
                return true;
            
            if(TI == CI-1 && TJ == CJ+2)
                return true;
            return TI == CI-1 && TJ == CJ-2;
        }
    }
    class King extends Piece{
        King(String s){
            super(s);
        }
        @Override
        public boolean canMove(Tile c, Tile t){         // needs adjusyments
            int CI = c.getY()/80;
            int CJ = c.getX()/80;
            
            int TI = t.getY()/80;
            int TJ = t.getX()/80;
            
            if(TI == CI && TJ == CJ+1)
                return true;
            if(TI == CI && TJ == CJ-1)
                return true;
            
            if(TI == CI-1 && TJ == CJ)
                return true;
            if(TI == CI-1 && TJ == CJ-1)
                return true;
            if(TI == CI-1 && TJ == CJ+1)
                return true;
            
            if(TI == CI+1 && TJ == CJ)
                return true;
            if(TI == CI+1 && TJ == CJ+1)
                return true;
            return TI == CI+1 && TJ == CJ-1;
        }
    }
    class Rook extends Piece{
        Rook(String s){
            super(s);
        }
        @Override
        public boolean canMove(Tile c, Tile t){
            int CI = c.getY()/80;
            int CJ = c.getX()/80;
            
            int TI = t.getY()/80;
            int TJ = t.getX()/80;
            
            if(TI == CI && TJ == CJ+1)
                return true;
            if(TJ == CJ && TI == CI+1)
                    return true;
            try{
            if(Tiles[CI][CJ+1].getPiece() == null){
                if(TI == CI && TJ == CJ+2)
                    return true;
                if(Tiles[CI][CJ+2].getPiece() == null){
                    if(TI == CI && TJ == CJ+3)
                        return true;
                    if(Tiles[CI][CJ+3].getPiece() == null){
                        if(TI == CI && TJ == CJ+4)
                            return true;
                        if(Tiles[CI][CJ+4].getPiece() == null){
                            if(TI == CI && TJ == CJ+5)
                                return true;
                            if(Tiles[CI][CJ+5].getPiece() == null){
                                if(TI == CI && TJ == CJ+6)
                                    return true;
                                if(Tiles[CI][CJ+6].getPiece() == null){
                                    if(TI == CI && TJ == CJ+7)
                                        return true;
                                }
                            }
                        }
                    }
                }
            }
            }catch(ArrayIndexOutOfBoundsException ex){
                
            }
            
            try{
            if(Tiles[CI][CJ+1].getPiece() == null){
                if(TJ == CJ && TI == CI+2)
                    return true;
                if(Tiles[CI][CJ+2].getPiece() == null){
                    if(TJ == CJ && TI == CI+3)
                        return true;
                    if(Tiles[CI][CJ+3].getPiece() == null){
                        if(TJ == CJ && TI == CI+4)
                            return true;
                        if(Tiles[CI][CJ+4].getPiece() == null){
                            if(TJ == CJ && TI == CI+5)
                                return true;
                            if(Tiles[CI][CJ+5].getPiece() == null){
                                if(TJ == CJ && TI == CI+6)
                                    return true;
                                if(Tiles[CI][CJ+6].getPiece() == null){
                                    if(TJ == CJ && TI == CI+7)
                                        return true;
                                }
                            }
                        }
                    }
                }
            }
            }catch(ArrayIndexOutOfBoundsException ex){
                
            }
            return false;
        }
    }
    class Bishop extends Piece{
        Bishop(String s){
            super(s);
        }
        @Override
        public boolean canMove(Tile c, Tile t){
            int CI = c.getY()/80;
            int CJ = c.getX()/80;
            
            int TI = t.getY()/80;
            int TJ = t.getX()/80;
            
            if(TI == CI-2 && TJ == CJ-1)
                return true;
            if(TI == CI-2 && TJ == CJ+1)
                return true;
            if(TI == CI+2 && TJ == CJ-1)
                return true;
            return TI == CI+2 && TJ == CJ+1;
        }
    }
    class Queen extends Piece{
        Queen(String s){
            super(s);
        }
        @Override
        public boolean canMove(Tile c, Tile t){
            int CI = c.getY()/80;
            int CJ = c.getX()/80;
            
            int TI = t.getY()/80;
            int TJ = t.getX()/80;
            
            if(TI == CI-2 && TJ == CJ-1)
                return true;
            if(TI == CI-2 && TJ == CJ+1)
                return true;
            if(TI == CI+2 && TJ == CJ-1)
                return true;
            return TI == CI+2 && TJ == CJ+1;
        }
    }
    class Tile extends JPanel{
        private Color C;
        
        void setColor(Color c){
            C = c;
        }
        Color getColor(){
            return C;
        }
        
        void setPiece(Piece pp){
            this.add(pp);
        }
        Piece getPiece(){
            if(this.getComponentCount() == 0)
                return null;
            return (Piece)this.getComponent(0);
        }
        void removePiece(){
            this.removeAll();
        }
        
        void BlackTile(){
            this.setBackground(new Color(145, 83, 55));
        }
        void WhiteTile(){
            this.setBackground(new Color(249, 217, 202));
        }
    }
    class Hole extends MouseAdapter{
        private int i,j;
        Hole(int ind1, int ind2){
            i = ind1;
            j = ind2;
        }
        public void mouseClicked(MouseEvent e)
        {
            Color W = new Color(249, 217, 202);
            Color Y = new Color(234, 230, 119);
            Piece ps;
            if(current.getPiece() != null){
                if(current.getColor().getRGB()== W.getRGB())
                    current.WhiteTile();
                else
                    current.BlackTile();
                
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
                    Tiles[i][j].setBackground(Y);
                    current = Tiles[i][j];
                    
            }
            Tiles[i][j].repaint();
        }
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
        for(int i = 1, j = 1; j < 8; i += 2){
            Tiles[j][i].setBackground(W);
            Tiles[j][i].setColor(W);
            if((i+1) % 8 == 0){
                j += 2;
                i = -1;
            }
        }
        for(int i = 1, j = 0; j < 8; i += 2){
            Tiles[j][i].setBackground(B);
            Tiles[j][i].setColor(B);
            if((i+1) % 8 == 0){
                j += 2;
                i = -1;
            }
        }
        for(int i = 0; i < 8; i++){
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
}
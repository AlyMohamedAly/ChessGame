package chessgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame{

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

    private ImageIcon WhitePawnImg = new ImageIcon("TopViewPieces/wPawn.png");
    private ImageIcon WhiteKnightImg = new ImageIcon("TopViewPieces/wKnight.png");
    private ImageIcon WhiteBishopImg = new ImageIcon("TopViewPieces/wBishop.png");
    private ImageIcon WhiteRookImg = new ImageIcon("TopViewPieces/wRook.png");
    private ImageIcon WhiteQueenImg = new ImageIcon("TopViewPieces/wQueen.png");
    private ImageIcon WhiteKingImg = new ImageIcon("TopViewPieces/wKing.png");

    private ImageIcon BlackPawnImg = new ImageIcon("TopViewPieces/bPawn.png");
    private ImageIcon BlackKnightImg = new ImageIcon("TopViewPieces/bKnight.png");
    private ImageIcon BlackBishopImg = new ImageIcon("TopViewPieces/bBishop.png");
    private ImageIcon BlackRookImg = new ImageIcon("TopViewPieces/bRook.png");
    private ImageIcon BlackQueenImg = new ImageIcon("TopViewPieces/bQueen.png");
    private ImageIcon BlackKingImg = new ImageIcon("TopViewPieces/bKing.png");

    private JPanel cPPL = new JPanel();

    private Image gameLoading = new ImageIcon("gameLoading.png").getImage();
    private Image logo = new ImageIcon("Logo.png").getImage();
    private Image template = new ImageIcon("Template.png").getImage();
    private Image pressAnyKey = new ImageIcon("pressAnyKey.png").getImage();

    private Tile current = new Tile();
    private int player = 1;

    GameFrame (){
        this.setTitle("Chess Masters");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 10, 646, 669);
        this.setResizable(false);
        Container C = this.getContentPane();
        cPPL.setLayout(null);

        init();

        C.add(cPPL);
    }

    private void init (){
        Color B = new Color(145, 83, 55);
        Color W = new Color(249, 217, 202);

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Tiles[i][j] = new Tile();
                Tiles[i][j].setBounds(j * 80, i * 80, 80, 80);
                Tiles[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                Tiles[i][j].addMouseListener(new Hole(i, j));
                cPPL.add(Tiles[i][j]);
            }
        }
        for (int i = 0, j = 0; j < 8; i += 2){
            Tiles[j][i].setBackground(W);
            Tiles[j][i].setColor(W);
            if ((i + 2) % 8 == 0){
                j += 2;
                i = -2;
            }
        }
        for (int i = 0, j = 1; j < 8; i += 2){
            Tiles[j][i].setBackground(B);
            Tiles[j][i].setColor(B);
            if ((i + 2) % 8 == 0){
                j += 2;
                i = -2;
            }
        }
        for (int i = 1, j = 1; j < 8; i += 2){
            Tiles[j][i].setBackground(W);
            Tiles[j][i].setColor(W);
            if ((i + 1) % 8 == 0){
                j += 2;
                i = -1;
            }
        }
        for (int i = 1, j = 0; j < 8; i += 2){
            Tiles[j][i].setBackground(B);
            Tiles[j][i].setColor(B);
            if ((i + 1) % 8 == 0){
                j += 2;
                i = -1;
            }
        }
        for (int i = 0; i < 8; i++){
            WhitePawns[i] = new Pawn("WhitePawn" + i);
            WhitePawns[i].setIcon(WhitePawnImg);
            Tiles[6][i].add(WhitePawns[i]);

            BlackPawns[i] = new Pawn("BlackPawn" + i);
            BlackPawns[i].setIcon(BlackPawnImg);
            Tiles[1][i].add(BlackPawns[i]);
        }
        WhiteLeftKnight.setIcon(WhiteKnightImg);
        WhiteRightKnight.setIcon(WhiteKnightImg);
        Tiles[7][1].add(WhiteLeftKnight);
        Tiles[7][6].add(WhiteRightKnight);

        BlackLeftKnight.setIcon(BlackKnightImg);
        BlackRightKnight.setIcon(BlackKnightImg);
        Tiles[0][1].add(BlackLeftKnight);
        Tiles[0][6].add(BlackRightKnight);

        WhiteLeftRook.setIcon(WhiteRookImg);
        WhiteRightRook.setIcon(WhiteRookImg);
        Tiles[7][0].add(WhiteLeftRook);
        Tiles[7][7].add(WhiteRightRook);

        BlackLeftRook.setIcon(BlackRookImg);
        BlackRightRook.setIcon(BlackRookImg);
        Tiles[0][0].add(BlackLeftRook);
        Tiles[0][7].add(BlackRightRook);

        WhiteLeftBishop.setIcon(WhiteBishopImg);
        WhiteRightBishop.setIcon(WhiteBishopImg);
        Tiles[7][2].add(WhiteLeftBishop);
        Tiles[7][5].add(WhiteRightBishop);

        BlackLeftBishop.setIcon(BlackBishopImg);
        BlackRightBishop.setIcon(BlackBishopImg);
        Tiles[0][2].add(BlackLeftBishop);
        Tiles[0][5].add(BlackRightBishop);

        WhiteKing.setIcon(WhiteKingImg);
        WhiteQueen.setIcon(WhiteQueenImg);
        Tiles[7][4].add(WhiteKing);
        Tiles[7][3].add(WhiteQueen);

        BlackKing.setIcon(BlackKingImg);
        BlackQueen.setIcon(BlackQueenImg);
        Tiles[0][4].add(BlackKing);
        Tiles[0][3].add(BlackQueen);
    }

    class Hole extends MouseAdapter{

        private int i, j;

        Hole (int ind1, int ind2){
            i = ind1;
            j = ind2;
        }

        @Override
        public void mouseClicked (MouseEvent e){
            Color Y = new Color(234, 230, 119);
            Piece ps = current.getPiece();
            if (current.getPiece() != null){
                OriginalColor();
                boolean flag = true;
                if (getKing(current.getPiece()).checked){
                    if (getThreats().length > 1){
                        if (!(Tiles[i][j].getPiece() instanceof King)){
                            flag = false;
                        }
                    }else{
                        Tile Threat = (Tile) getThreats()[0].getParent();
                        if (!(Tiles[i][j] == Threat)){
                            flag = false;
                        }
                        if (current.getPiece() instanceof King){
                            flag = true;
                        }
                    }
                }
                if (flag){
                    if (Tiles[i][j].getPiece() != null){
                        if (current.getPiece().canMove(current, Tiles[i][j])){
                            if (Tiles[i][j].getPiece().getColor().equals(current.getPiece().getColor())){
                            }else{
                                if (Tiles[i][j].getPiece() == WhiteKing){
                                    MovePiece(ps, i, j);
                                    JOptionPane.showMessageDialog(null, "Black Wins!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                                    System.exit(0);
                                }else if (Tiles[i][j].getPiece() == BlackKing){
                                    MovePiece(ps, i, j);
                                    JOptionPane.showMessageDialog(null, "White Wins!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                                    System.exit(0);
                                }
                                if (current.getPiece() instanceof Pawn){
                                    Pawn temp = (Pawn) current.getPiece();
                                    temp.Moved = true;
                                    if (temp.getColor().equals("Black")){
                                        if (i == 7){
                                            Promote();
                                        }

                                    }else{
                                        if (i == 0){
                                            Promote();
                                        }
                                    }
                                }
                                if (current.getPiece() instanceof King){
                                    if (!CanKingDie(i, j)){
                                        MovePiece(ps, i, j);
                                        SwapPlayers();
                                    }
                                }else{
                                    MovePiece(ps, i, j);
                                    SwapPlayers();
                                }
                            }
                        }
                    }else{
                        if (current.getPiece().canMove(current, Tiles[i][j])){
                            if (current.getPiece() instanceof Pawn){
                                Pawn temp = (Pawn) current.getPiece();
                                temp.Moved = true;
                                if (temp.getColor().equals("Black")){
                                    if (i == 7){
                                        Promote();
                                    }

                                }else{
                                    if (i == 0){
                                        Promote();
                                    }
                                }
                            }
                            if (current.getPiece() instanceof King){
                                if (!CanKingDie(i, j)){
                                    MovePiece(ps, i, j);
                                    SwapPlayers();
                                }
                            }else{
                                MovePiece(ps, i, j);
                                SwapPlayers();
                            }
                        }else{
                        }
                    }
                }
                current.repaint();
                current = EmptyTile();
                if (player == 1){
                    BlackKing.checked = false;
                    CheckMate(2);
                }else{
                    WhiteKing.checked = false;
                    CheckMate(1);
                }
            }else if (Tiles[i][j].getPiece() != null){
                if (!(player == 1 && Tiles[i][j].getPiece().getColor().equals("Black"))){
                    if (!(player == 2 && Tiles[i][j].getPiece().getColor().equals("White"))){
                        ColorMoves(i, j);
                        Tiles[i][j].setBackground(Y);
                        current = Tiles[i][j];
                    }
                }
            }
            Tiles[i][j].repaint();
        }

        public void SwapPlayers (){
            if (player == 1){
                player = 2;
            }else{
                player = 1;
            }
        }

        public Tile EmptyTile (){
            Tile pp;
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    if (Tiles[i][j].getPiece() == null){
                        pp = Tiles[i][j];
                        return pp;
                    }
                }
            }
            return null;
        }
    }

    public void OriginalColor (){
        for (int k = 0; k < 8; k++){
            for (int u = 0; u < 8; u++){
                Tiles[u][k].setBackground(Tiles[u][k].getColor());
                Tiles[u][k].repaint();
            }
        }
    }

    public void MovePiece (Piece ps, int i, int j){
        ps = current.getPiece();
        Tiles[i][j].removePiece();
        current.removePiece();
        Tiles[i][j].setPiece(ps);
    }

    public King getKing (Piece p){
        if (p.getColor().equals("White")){
            return WhiteKing;
        }
        return BlackKing;
    }

    public void Promote (){
        Queen Promotion;
        if (player == 1){
            Promotion = new Queen("WhitePromotedPawn");
            Promotion.setIcon(WhiteQueenImg);
            current.removePiece();
            current.setPiece(Promotion);
        }else{
            Promotion = new Queen("BlackPromotedPawn");
            Promotion.setIcon(BlackQueenImg);
            current.removePiece();
            current.setPiece(Promotion);
        }
        current.repaint();
        current.validate();
    }

    public void ColorMoves (int i, int j){
        for (int k = 0; k < 8; k++){
            for (int u = 0; u < 8; u++){
                if (Tiles[i][j].getPiece().canMove(Tiles[i][j], Tiles[u][k])){
                    Tiles[u][k].setBackground(Color.GREEN);
                    Tiles[u][k].repaint();
                    if (Tiles[u][k].getPiece() != null){
                        if (!Tiles[u][k].getPiece().getColor().equals(Tiles[i][j].getPiece().getColor())){
                            Tiles[u][k].setBackground(Color.red);
                            Tiles[u][k].repaint();
                        }else{
                            Tiles[u][k].setBackground(Tiles[u][k].getColor());
                            Tiles[u][k].repaint();
                        }
                    }
                }
            }
        }
    }

    public Piece[] getThreats (){
        ArrayList<Piece> Threats = new ArrayList<Piece>();
        for (int k = 0; k < 8; k++){
            for (int l = 0; l < 8; l++){
                if (Tiles[k][l].getPiece() != null){
                    if (player == 2){
                        if (Tiles[k][l].getPiece().getColor().equals("White")){
                            Tile KingTile = (Tile) BlackKing.getParent();
                            if (Tiles[k][l].getPiece().canKill(Tiles[k][l], KingTile)){
                                Threats.add(Tiles[k][l].getPiece());
                            }
                        }
                    }else{
                        if (Tiles[k][l].getPiece().getColor().equals("Black")){
                            Tile KingTile = (Tile) WhiteKing.getParent();
                            if (Tiles[k][l].getPiece().canKill(Tiles[k][l], KingTile)){
                                Threats.add(Tiles[k][l].getPiece());
                            }
                        }
                    }
                }
            }
        }
        Piece[] ans = new Piece[Threats.size()];
        for (int k = 0; k < ans.length; k++){
            ans[k] = Threats.get(k);
        }
        return ans;
    }

    public boolean CanKingDie (int i, int j){
        boolean flag = false;
        for (int k = 0; k < 8; k++){
            for (int l = 0; l < 8; l++){
                if (Tiles[k][l].getPiece() != null){
                    if (player == 2){
                        if (Tiles[k][l].getPiece().getColor().equals("White")){
                            if (Tiles[k][l].getPiece().canKill(Tiles[k][l], Tiles[i][j])){
                                Tiles[i][j].setBackground(Color.CYAN);
                                Tiles[k][l].setBackground(Color.red);
                                flag = true;
                            }
                        }
                    }else{
                        if (Tiles[k][l].getPiece().getColor().equals("Black")){
                            if (Tiles[k][l].getPiece().canKill(Tiles[k][l], Tiles[i][j])){
                                Tiles[i][j].setBackground(Color.CYAN);
                                Tiles[k][l].setBackground(Color.red);
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        if (flag){
            return true;
        }
        return false;
    }

    public void CheckMate (int n){
        Tile KingTile;
        if (n == 1){
            KingTile = (Tile) BlackKing.getParent();
            for (int r = 0; r < 8; r++){
                for (int p = 0; p < 8; p++){
                    if (Tiles[r][p].getPiece() != null){
                        if (Tiles[r][p].getPiece().getColor().equals("White")){
                            if (Tiles[r][p].getPiece().canMove(Tiles[r][p], KingTile)){
                                KingTile.setBackground(Color.red);
                                BlackKing.checked = true;
                            }
                        }
                    }
                }
            }
        }else{
            KingTile = (Tile) WhiteKing.getParent();
            for (int r = 0; r < 8; r++){
                for (int p = 0; p < 8; p++){
                    if (Tiles[r][p].getPiece() != null){
                        if (Tiles[r][p].getPiece().getColor().equals("Black")){
                            if (Tiles[r][p].getPiece().canMove(Tiles[r][p], KingTile)){
                                KingTile.setBackground(Color.red);
                                WhiteKing.checked = true;
                            }
                        }
                    }
                }

            }
        }
    }
}

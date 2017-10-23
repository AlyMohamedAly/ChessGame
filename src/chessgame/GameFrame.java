package chessgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame{

    private final Pawn[] WhitePawns = new Pawn[8];
    private final Knight WhiteLeftKnight = new Knight("WhiteLeftKnight");
    private final Knight WhiteRightKnight = new Knight("WhiteRightKnight");
    private final Bishop WhiteLeftBishop = new Bishop("WhiteLeftBishop");
    private final Bishop WhiteRightBishop = new Bishop("WhiteRightBishop");
    private final Rook WhiteLeftRook = new Rook("WhiteLeftRook");
    private final Rook WhiteRightRook = new Rook("WhiteRightRook");
    private final Queen WhiteQueen = new Queen("WhiteQueen");
    private final King WhiteKing = new King("WhiteKing");

    private final Pawn[] BlackPawns = new Pawn[8];
    private final Knight BlackLeftKnight = new Knight("BlackLeftKnight");
    private final Knight BlackRightKnight = new Knight("BlackRightKnight");
    private final Bishop BlackLeftBishop = new Bishop("BlackLeftBishop");
    private final Bishop BlackRightBishop = new Bishop("BlackRightBishop");
    private final Rook BlackLeftRook = new Rook("BlackLeftRook");
    private final Rook BlackRightRook = new Rook("BlackRightRook");
    private final Queen BlackQueen = new Queen("BlackQueen");
    private final King BlackKing = new King("BlackKing");

    public static Tile[][] Tiles = new Tile[8][8];

    private final ImageIcon WhitePawnImg = new ImageIcon("TopViewPieces/wPawn.png");
    private final ImageIcon WhiteKnightImg = new ImageIcon("TopViewPieces/wKnight.png");
    private final ImageIcon WhiteBishopImg = new ImageIcon("TopViewPieces/wBishop.png");
    private final ImageIcon WhiteRookImg = new ImageIcon("TopViewPieces/wRook.png");
    private final ImageIcon WhiteQueenImg = new ImageIcon("TopViewPieces/wQueen.png");
    private final ImageIcon WhiteKingImg = new ImageIcon("TopViewPieces/wKing.png");

    private final ImageIcon BlackPawnImg = new ImageIcon("TopViewPieces/bPawn.png");
    private final ImageIcon BlackKnightImg = new ImageIcon("TopViewPieces/bKnight.png");
    private final ImageIcon BlackBishopImg = new ImageIcon("TopViewPieces/bBishop.png");
    private final ImageIcon BlackRookImg = new ImageIcon("TopViewPieces/bRook.png");
    private final ImageIcon BlackQueenImg = new ImageIcon("TopViewPieces/bQueen.png");
    private final ImageIcon BlackKingImg = new ImageIcon("TopViewPieces/bKing.png");

    private final JPanel cPPL = new JPanel();

    //private Image gameLoading = new ImageIcon("gameLoading.png").getImage();
    //private Image logo = new ImageIcon("Logo.png").getImage();
    //private Image template = new ImageIcon("Template.png").getImage();
    //private Image pressAnyKey = new ImageIcon("pressAnyKey.png").getImage();
    private Tile current = new Tile();
    private int player = 1;
    Container C = this.getContentPane();

    GameFrame (){
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

        private final int i;
        private final int j;

        Hole (int ind1, int ind2){
            i = ind1;
            j = ind2;
        }

        @Override
        public void mouseClicked (MouseEvent e){
            Color Y = new Color(234, 230, 119);
            Piece ps = current.getPiece();
            if (ps != null){
                OriginalColor();
                boolean flag = true;
                if (getKing(ps).checked){
                    if (getThreats().length > 1){
                        if (!(Tiles[i][j].getPiece() instanceof King)){
                            flag = false;
                        }
                    }else{
                        Tile Threat = (Tile) getThreats()[0].getParent();
                        if (!(Tiles[i][j] == Threat)){
                            flag = false;
                        }
                        if (canBlock(Threat.getPiece(), i, j)){
                            flag = true;
                        }
                        if (ps instanceof King){
                            flag = true;
                        }
                    }
                }
                if (flag){
                    if (Tiles[i][j].getPiece() != null){
                        if (ps.canMove(current, Tiles[i][j])){
                            if (Tiles[i][j].getPiece().getColor().equals(ps.getColor())){
                            }else{
                                if (Tiles[i][j].getPiece() instanceof King){
                                    if (Tiles[i][j].getPiece() == WhiteKing){
                                        MovePiece(i, j);
                                        JOptionPane.showMessageDialog(null, "Black Wins!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                                        System.exit(0);
                                    }else{
                                        MovePiece(i, j);
                                        JOptionPane.showMessageDialog(null, "White Wins!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                                        System.exit(0);
                                    }
                                }
                                if (ps instanceof Pawn){
                                    Pawn temp = (Pawn) ps;
                                    temp.Moved++;
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
                                if (ps instanceof King){
                                    if (!CanKingDie(i, j)){
                                        MovePiece(i, j);
                                        SwapPlayers();
                                    }
                                }else{
                                    MovePiece(i, j);
                                    SwapPlayers();
                                }
                            }
                        }
                    }else{
                        if (ps.canMove(current, Tiles[i][j])){
                            if (ps instanceof Pawn){
                                Pawn temp = (Pawn) ps;
                                temp.Moved++;
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
                            if (ps instanceof King){
                                if (!CanKingDie(i, j)){
                                    MovePiece(i, j);
                                    SwapPlayers();
                                }
                            }else{
                                MovePiece(i, j);
                                SwapPlayers();
                            }
                        }else{
                        }
                        if (ps instanceof Pawn){
                            Pawn temp = (Pawn) ps;
                            if (temp.getColor().equals("Black")){
                                if (temp.canPassat(current, Tiles[i][j], Tiles[i - 1][j])){
                                    if (Tiles[i - 1][j].getPiece() instanceof Pawn){
                                        Pawn Passat = (Pawn) Tiles[i - 1][j].getPiece();
                                        if (Passat.Moved == 1){
                                            Tiles[i - 1][j].removePiece();
                                            MovePiece(i, j);
                                            SwapPlayers();
                                        }
                                    }
                                }
                            }else{
                                if (temp.canPassat(current, Tiles[i][j], Tiles[i + 1][j])){
                                    if (Tiles[i + 1][j].getPiece() instanceof Pawn){
                                        Pawn Passat = (Pawn) Tiles[i + 1][j].getPiece();
                                        if (Passat.Moved == 1){
                                            Tiles[i + 1][j].removePiece();
                                            MovePiece(i, j);
                                            SwapPlayers();
                                        }
                                    }
                                }
                            }
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
            Tiles[i][j].validate();
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
            for (int T = 0; T < 8; T++){
                for (int Y = 0; Y < 8; Y++){
                    if (Tiles[T][Y].getPiece() == null){
                        pp = Tiles[T][Y];
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

    public void MovePiece (int i, int j){
        Piece pp = current.getPiece();
        Tiles[i][j].removePiece();
        current.removePiece();
        Tiles[i][j].setPiece(pp);
    }

    public King getKing (Piece p){
        if (p.getColor().equals("White")){
            return WhiteKing;
        }
        return BlackKing;
    }

    public boolean canBlock (Piece threat, int i, int j){              //Prototype
        if (threat instanceof Pawn || threat instanceof Knight || threat instanceof King){
            return false;
        }else{
            Tile ThreatTile = (Tile) threat.getParent();
            if (threat.canMove(ThreatTile, Tiles[i][j])){
                Tile KingTile = (Tile) getKing(current.getPiece()).getParent();
                if (threat.canMove(Tiles[i][j], KingTile)){
                    return true;
                }

            }
        }
        return false;
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

    public Piece[] getThreats (){
        ArrayList<Piece> Threats = new ArrayList<>();
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
        return flag;
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

    public void ColorMoves (int i, int j){
        Piece pss = Tiles[i][j].getPiece();
        if (Tiles[i][j].getPiece() instanceof Pawn){
            Pawn ppss = (Pawn) pss;
            if (ppss.getColor().equals("White")){
                if (i - 1 >= 0 && j + 1 < 8){
                    if (ppss.canPassat(Tiles[i][j], Tiles[i - 1][j + 1], Tiles[i][j + 1])){
                        if (Tiles[i][j + 1].getPiece() instanceof Pawn){
                            Pawn ppks = (Pawn) Tiles[i][j + 1].getPiece();
                            if (ppks.Moved == 1){
                                Tiles[i - 1][j + 1].setBackground(Color.MAGENTA);
                            }
                        }
                    }                                                                       //onPassat
                }
                if (i - 1 >= 0 && j - 1 >= 0){
                    if (ppss.canPassat(Tiles[i][j], Tiles[i - 1][j - 1], Tiles[i][j - 1])){
                        if (Tiles[i][j - 1].getPiece() instanceof Pawn){
                            Pawn ppks = (Pawn) Tiles[i][j - 1].getPiece();
                            if (ppks.Moved == 1){
                                Tiles[i - 1][j - 1].setBackground(Color.MAGENTA);
                            }
                        }
                    }
                }
            }else{
                if (j - 1 >= 0 && i + 1 < 8){
                    if (ppss.canPassat(Tiles[i][j], Tiles[i + 1][j - 1], Tiles[i][j - 1])){
                        if (Tiles[i][j - 1].getPiece() instanceof Pawn){
                            Pawn ppks = (Pawn) Tiles[i][j - 1].getPiece();
                            if (ppks.Moved == 1){
                                Tiles[i + 1][j - 1].setBackground(Color.MAGENTA);
                            }
                        }
                    }                                                                       //onPassat
                }
                if (i + 1 < 8 && j + 1 < 8){
                    if (ppss.canPassat(Tiles[i][j], Tiles[i + 1][j + 1], Tiles[i][j + 1])){
                        if (Tiles[i][j + 1].getPiece() instanceof Pawn){
                            Pawn ppks = (Pawn) Tiles[i][j + 1].getPiece();
                            if (ppks.Moved == 1){
                                Tiles[i + 1][j + 1].setBackground(Color.MAGENTA);
                            }
                        }
                    }
                }
            }
        }
        for (int k = 0; k < 8; k++){
            for (int u = 0; u < 8; u++){
                if (pss.canMove(Tiles[i][j], Tiles[u][k])){
                    Tiles[u][k].setBackground(Color.GREEN);
                    if (Tiles[u][k].getPiece() != null){
                        if (!Tiles[u][k].getPiece().getColor().equals(pss.getColor())){
                            Tiles[u][k].setBackground(Color.red);
                        }else{
                            Tiles[u][k].setBackground(Tiles[u][k].getColor());
                        }
                    }
                    Tiles[u][k].repaint();
                }
            }
        }
    }
}

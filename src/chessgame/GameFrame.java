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

    private Tile current = new Tile();
    private Knight TestKnight = new Knight("TestKnight");
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
                        if (canBlock(ps, Threat.getPiece(), i, j)){
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
                                if (!(isDefending(current.getPiece(), Tiles[i][j]))){
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
                                        King HisMajesty = (King) ps;
                                        if (!CanKingDie(i, j, HisMajesty)){
                                            MovePiece(i, j);
                                            SwapPlayers();
                                        }
                                    }else{
                                        MovePiece(i, j);
                                        SwapPlayers();
                                    }
                                }
                            }
                        }
                    }else{
                        if (ps.canMove(current, Tiles[i][j])){
                            if (!(isDefending(current.getPiece(), Tiles[i][j]))){
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
                                    King HisMajesty = (King) ps;
                                    if (!CanKingDie(i, j, HisMajesty)){
                                        MovePiece(i, j);
                                        SwapPlayers();
                                    }
                                }else{
                                    MovePiece(i, j);
                                    SwapPlayers();
                                }
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
                CheckGameOver(ps);  //prototype
            }else if (Tiles[i][j].getPiece() != null){
                if (!(player == 1 && Tiles[i][j].getPiece().getColor().equals("Black"))){
                    if (!(player == 2 && Tiles[i][j].getPiece().getColor().equals("White"))){
                        ColorMoves(i, j);
                        Tiles[i][j].setBackground(Color.YELLOW);
                        current = Tiles[i][j];
                    }
                }
            }
            Tiles[i][j].repaint();
            Tiles[i][j].validate();
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

    public King getOtherKing (Piece p){
        if (p.getColor().equals("White")){
            return BlackKing;
        }
        return WhiteKing;
    }

    public void SwapPlayers (){
        if (player == 1){
            player = 2;
        }else{
            player = 1;
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

    public boolean canBlock (Piece currentPiece, Piece threat, int i, int j){
        if (threat instanceof Pawn || threat instanceof Knight || threat instanceof King || current.getPiece() instanceof King){
            return false;
        }else{
            Tile ThreatTile = (Tile) threat.getParent();
            Tile KingTile = (Tile) (getKing(currentPiece)).getParent();
            Tiles[i][j].add(TestKnight);
            if (threat.canKill(ThreatTile, KingTile)){
                Tiles[i][j].remove(TestKnight);
                return false;
            }else{
                Tiles[i][j].remove(TestKnight);
                return true;
            }

        }
    }

    public void CheckDraw (){ // prototype
        int queens = 0, rooks = 0, knights = 0, bishops = 0, pawns = 0;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Piece ThisPiece = Tiles[i][j].getPiece();
                if (ThisPiece != null){
                    if (ThisPiece instanceof Pawn){
                        pawns++;
                    }
                    if (ThisPiece instanceof Knight){
                        knights++;
                    }
                    if (ThisPiece instanceof Bishop){
                        bishops++;
                    }
                    if (ThisPiece instanceof Rook){
                        rooks++;
                    }
                    if (ThisPiece instanceof Queen){
                        queens++;
                    }
                }
            }
        }
        if (queens == 0 && rooks == 0 && pawns == 0){
            if ((knights == 1 && bishops == 0) || (bishops == 1 && knights == 0)){
                JOptionPane.showMessageDialog(null, "Draw!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
        }
    }

    public void CheckGameOver (Piece currentPS){   //prototype
        //CheckDraw();
        King currentKing = getOtherKing(currentPS);
        if (currentKing.checked){
            if (CanKingMove(currentKing)){
                return;
            }

            String enemyColor = currentPS.getColor();
            String MyColor = currentKing.getColor();
            Piece[] Threats = getOtherThreats(currentPS);
            Tile ThreatTile = (Tile) Threats[0].getParent();
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    Piece ThisPiece = Tiles[i][j].getPiece();
                    if (ThisPiece != null){
                        if (ThisPiece.getColor().equals(MyColor)){
                            if (ThisPiece.canKill(Tiles[i][j], ThreatTile)){
                                return;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    Piece ThisPiece = Tiles[i][j].getPiece();
                    if (ThisPiece != null){
                        if (ThisPiece.getColor().equals(MyColor)){
                            for (int k = 0; k < 8; k++){
                                for (int l = 0; l < 8; l++){
                                    if (ThisPiece.canMove(Tiles[i][j], Tiles[k][l])){
                                        if (canBlock(currentKing, Threats[0], k, l)){
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (MyColor.equals("Black")){
                JOptionPane.showMessageDialog(null, "White Wins!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }else{
                JOptionPane.showMessageDialog(null, "Black Wins!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
        }
    }

    public boolean CanKingMove (Piece currentKing){  //prototype
        King HisMajesty = (King) currentKing;
        int WJ = currentKing.getX() / 80;
        int WI = currentKing.getY() / 80;
        String currentColor = currentKing.getColor();
        try{
            if (Tiles[WI + 1][WJ].getPiece() == null || !(Tiles[WI + 1][WJ].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI + 1, WJ, HisMajesty)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI + 1][WJ + 1].getPiece() == null || !(Tiles[WI + 1][WJ + 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI + 1, WJ + 1, HisMajesty)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI + 1][WJ - 1].getPiece() == null || !(Tiles[WI + 1][WJ - 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI + 1, WJ - 1, HisMajesty)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI - 1][WJ + 1].getPiece() == null || !(Tiles[WI - 1][WJ + 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI - 1, WJ + 1, HisMajesty)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI - 1][WJ - 1].getPiece() == null || !(Tiles[WI - 1][WJ - 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI - 1, WJ - 1, HisMajesty)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI - 1][WJ].getPiece() == null || !(Tiles[WI - 1][WJ].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI - 1, WJ, HisMajesty)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI][WJ + 1].getPiece() == null || !(Tiles[WI][WJ + 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI, WJ + 1, HisMajesty)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI][WJ - 1].getPiece() == null || !(Tiles[WI][WJ * 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI, WJ - 1, HisMajesty)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        return false;
    }

    public Piece[] getThreats (){
        ArrayList<Piece> Threats = new ArrayList<>();
        Piece currentPs = current.getPiece();
        String currentColor = currentPs.getColor();
        for (int k = 0; k < 8; k++){
            for (int l = 0; l < 8; l++){
                if (Tiles[k][l].getPiece() != null){
                    if (!(Tiles[k][l].getPiece().getColor().equals(currentColor))){
                        Tile KingTile = (Tile) (getKing(currentPs)).getParent();
                        if (Tiles[k][l].getPiece().canKill(Tiles[k][l], KingTile)){
                            Threats.add(Tiles[k][l].getPiece());
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

    public Piece[] getOtherThreats (Piece currentPS){  //prototype
        ArrayList<Piece> Threats = new ArrayList<>();
        String enemyColor = currentPS.getColor();
        for (int k = 0; k < 8; k++){
            for (int l = 0; l < 8; l++){
                if (Tiles[k][l].getPiece() != null){
                    if (Tiles[k][l].getPiece().getColor().equals(enemyColor)){
                        Tile KingTile = (Tile) (getOtherKing(currentPS)).getParent();
                        if (Tiles[k][l].getPiece().canKill(Tiles[k][l], KingTile)){
                            Threats.add(Tiles[k][l].getPiece());
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

    public boolean CanKingDie (int i, int j, King currentKing){
        boolean flag = false;
        Tile KingTile = (Tile) currentKing.getParent();
        String currentColor = currentKing.getColor();
        KingTile.removePiece();
        for (int k = 0; k < 8; k++){
            for (int l = 0; l < 8; l++){
                if (Tiles[k][l].getPiece() != null){
                    if (!(Tiles[k][l].getPiece().getColor().equals(currentColor))){
                        if (Tiles[k][l].getPiece().canKill(Tiles[k][l], Tiles[i][j])){
                            //Tiles[i][j].setBackground(Color.CYAN);
                            Tiles[k][l].setBackground(Color.red);
                            flag = true;
                        }
                    }
                }
            }
        }
        KingTile.add(currentKing);
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
                            if (Tiles[r][p].getPiece().canKill(Tiles[r][p], KingTile)){
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
                            if (Tiles[r][p].getPiece().canKill(Tiles[r][p], KingTile)){
                                KingTile.setBackground(Color.red);
                                WhiteKing.checked = true;
                            }
                        }
                    }
                }

            }
        }
    }

    public boolean isDefending (Piece dps, Tile Target){
        if (dps instanceof King){
            return false;
        }
        if (WhiteKing.checked){
            return false;
        }
        if (BlackKing.checked){
            return false;
        }
        Tile HostTile = (Tile) dps.getParent();
        HostTile.remove(dps);
        Target.add(dps);
        Tile WhiteTile = (Tile) WhiteKing.getParent();
        Tile BlackTile = (Tile) BlackKing.getParent();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Piece PotentialThreat = Tiles[i][j].getPiece();
                if (PotentialThreat != null){
                    if (player == 1){
                        if (PotentialThreat.getColor().equals("Black")){
                            if (PotentialThreat.canKill(Tiles[i][j], WhiteTile)){
                                HostTile.add(dps);
                                Target.remove(dps);
                                Tile ThreatTile = (Tile) PotentialThreat.getParent();
                                ThreatTile.setBackground(Color.red);
                                return true;
                            }
                        }
                    }else{
                        if (PotentialThreat.getColor().equals("White")){
                            if (PotentialThreat.canKill(Tiles[i][j], BlackTile)){
                                HostTile.add(dps);
                                Target.remove(dps);
                                Tile ThreatTile = (Tile) PotentialThreat.getParent();
                                ThreatTile.setBackground(Color.red);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        HostTile.add(dps);
        Target.remove(dps);
        return false;
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
                    }                                                                       //EnPassat
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
                    }                                                                       //EnPassat
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

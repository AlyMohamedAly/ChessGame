package chessgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameFrame extends JFrame implements ActionListener{
    private JTextArea area = new JTextArea();
    private final JMenuBar mnuBar = new JMenuBar();
    private final JMenu mnuFile = new JMenu("File");
    private final JMenuItem itmOpen = new JMenuItem("Load");
    private final JMenuItem itmSave = new JMenuItem("Save");

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
    private final Knight TestKnight = new Knight("TestKnight");
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
        this.setJMenuBar(mnuBar);
        mnuBar.add(mnuFile);
        mnuBar.add(area);
        area.setEditable(false);
        area.setText("\t\t\tPlayer "+player+" (White)");
        mnuFile.add(itmOpen);
        mnuFile.add(itmSave);
        itmOpen.addActionListener(this);
        itmSave.addActionListener(this);

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

    @Override
    public void actionPerformed (ActionEvent e){
        Object o = e.getSource();
        if (o == itmSave){
            save();
        }else if (o == itmOpen){
            load();
        }
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
                                        King HisMajesty = getKing(ps);
                                        if (!CanKingDie(i, j, HisMajesty, true)){
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
                                    King HisMajesty = getKing(ps);
                                    if (!CanKingDie(i, j, HisMajesty, true)){
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
                                    if (Tiles[i - 1][j].getPiece() instanceof Pawn && !(Tiles[i - 1][j].getPiece().getColor().equals(ps.getColor()))){
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
                                    if (Tiles[i + 1][j].getPiece() instanceof Pawn && !(Tiles[i + 1][j].getPiece().getColor().equals(ps.getColor()))){
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

    public void MovePiece (int i, int j){
        Piece pp = current.getPiece();
        Tiles[i][j].removePiece();
        current.removePiece();
        Tiles[i][j].setPiece(pp);
    }

    public void SwapPlayers (){
        if (player == 1){
            player = 2;
            area.setText("\t\t\tPlayer "+player+" (Black)");
        }else{
            player = 1;
            area.setText("\t\t\tPlayer "+player+" (White)");
        }
    }

    public void OriginalColor (){
        for (int k = 0; k < 8; k++){
            for (int u = 0; u < 8; u++){
                Tiles[u][k].setBackground(Tiles[u][k].getColor());
                Tiles[u][k].repaint();
                Tiles[u][k].validate();
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

    public boolean CheckStaleMate (King currentKing, String MyColor){  //prototype
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Piece ThisPiece = Tiles[i][j].getPiece();
                if (ThisPiece != null){
                    if (!(ThisPiece instanceof King)){
                        if (ThisPiece.getColor().equals(MyColor)){
                            for (int k = 0; k < 8; k++){
                                for (int l = 0; l < 8; l++){
                                    if (ThisPiece.canMove(Tiles[i][j], Tiles[k][l])){
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
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

    public boolean CanKingDie (int i, int j, King currentKing, boolean color){
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
                            if (color){
                                Tiles[k][l].setBackground(Color.red);
                            }
                            flag = true;
                        }
                    }
                }
            }
        }
        KingTile.add(currentKing);
        return flag;
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
                int choice = JOptionPane.showConfirmDialog(null, "Restart?", "Draw!", JOptionPane.OK_OPTION);
                if (choice == 0){
                    this.setVisible(false);
                    GameFrame restratgame = new GameFrame();
                    restratgame.setTitle("Chess Masters");
                    restratgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    restratgame.setBounds(300, 10, 646, 669);
                    restratgame.setResizable(false);
                    restratgame.setVisible(true);
                }else{
                    System.exit(0);
                }
            }
        }
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

    public void Promote (){
        String[] options = new String[]{"Queen", "Rook", "Bishop", "Knight"};

        int response = JOptionPane.showOptionDialog(null, "Choose a promotion", "Promote", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        Piece Promotion = new Queen("WhitePromotedQueenPawn");

        if (player == 1){
            switch (response){
                case 0:
                    Promotion.setIcon(WhiteQueenImg);
                    break;
                case 1:
                    Promotion = new Rook("WhitePromotedRookPawn");
                    Promotion.setIcon(WhiteRookImg);
                    break;
                case 2:
                    Promotion = new Bishop("WhitePromotedBishopPawn");
                    Promotion.setIcon(WhiteBishopImg);
                    break;
                case 3:
                    Promotion = new Knight("WhitePromotedKnightPawn");
                    Promotion.setIcon(WhiteKnightImg);
                    break;
            }
        }else{
            switch (response){
                case 0:
                    Promotion = new Queen("BlackPromotedQueenPawn");
                    Promotion.setIcon(BlackQueenImg);
                    break;
                case 1:
                    Promotion = new Rook("BlackPromotedRookPawn");
                    Promotion.setIcon(BlackRookImg);
                    break;
                case 2:
                    Promotion = new Bishop("BlackPromotedBishopPawn");
                    Promotion.setIcon(BlackBishopImg);
                    break;
                case 3:
                    Promotion = new Knight("BlackPromotedKnightPawn");
                    Promotion.setIcon(BlackKnightImg);
                    break;
            }
        }
        current.removePiece();
        current.setPiece(Promotion);
        current.repaint();
        current.validate();
    }

    public void CheckGameOver (Piece currentPS){   //prototype
        CheckDraw();
        King currentKing = getOtherKing(currentPS);
        //String enemyColor = currentPS.getColor();
        String MyColor = currentKing.getColor();

        if (currentKing.checked){
            if (CanKingMove(currentKing)){
                return;
            }
        }
        if (CheckStaleMate(currentKing, MyColor)){
            if (!(CanKingMove(currentKing))){
                int choice = JOptionPane.showConfirmDialog(null, "Restart?", "Draw!", JOptionPane.OK_OPTION);
                if (choice == 0){
                    this.setVisible(false);
                    GameFrame restratgame = new GameFrame();
                    restratgame.setTitle("Chess Masters");
                    restratgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    restratgame.setBounds(300, 10, 646, 669);
                    restratgame.setResizable(false);
                    restratgame.setVisible(true);
                }else{
                    System.exit(0);
                }
            }
        }
        if (currentKing.checked){
            Piece[] Threats = getOtherThreats(currentPS);
            Tile ThreatTile = (Tile) Threats[0].getParent();

            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    Piece ThisPiece = Tiles[i][j].getPiece();
                    if (ThisPiece != null){
                        if (ThisPiece.getColor().equals(MyColor)){
                            if (!(ThisPiece instanceof King)){
                                if (ThisPiece.canKill(Tiles[i][j], ThreatTile)){        // killing the threat
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    Piece ThisPiece = Tiles[i][j].getPiece();
                    if (ThisPiece != null){
                        if (!(ThisPiece instanceof King)){
                            if (ThisPiece.getColor().equals(MyColor)){
                                for (int k = 0; k < 8; k++){
                                    for (int l = 0; l < 8; l++){
                                        if (ThisPiece.canMove(Tiles[i][j], Tiles[k][l])){
                                            if (canBlock(currentKing, Threats[0], k, l)){   //defend the king
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (MyColor.equals("Black")){
                int choice = JOptionPane.showConfirmDialog(null, "Restart?", "White Wins!", JOptionPane.OK_OPTION);
                if (choice == 0){
                    this.setVisible(false);
                    GameFrame restratgame = new GameFrame();
                    restratgame.setTitle("Chess Masters");
                    restratgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    restratgame.setBounds(300, 10, 646, 669);
                    restratgame.setResizable(false);
                    restratgame.setVisible(true);
                }else{
                    System.exit(0);
                }

            }else{
                int choice = JOptionPane.showConfirmDialog(null, "Restart?", "Black Wins!", JOptionPane.OK_OPTION);
                //System.exit(0);
                if (choice == 0){
                    this.setVisible(false);
                    GameFrame restratgame = new GameFrame();
                    restratgame.setTitle("Chess Masters");
                    restratgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    restratgame.setBounds(300, 10, 646, 669);
                    restratgame.setResizable(false);
                    restratgame.setVisible(true);
                }else{
                    System.exit(0);
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
                        if (Tiles[i][j + 1].getPiece() instanceof Pawn && Tiles[i][j + 1].getPiece().getColor().equals("Black")){
                            Pawn ppks = (Pawn) Tiles[i][j + 1].getPiece();
                            if (ppks.Moved == 1){
                                Tiles[i - 1][j + 1].setBackground(Color.MAGENTA);
                            }
                        }
                    }                                                                       //EnPassat
                }
                if (i - 1 >= 0 && j - 1 >= 0){
                    if (ppss.canPassat(Tiles[i][j], Tiles[i - 1][j - 1], Tiles[i][j - 1])){
                        if (Tiles[i][j - 1].getPiece() instanceof Pawn && Tiles[i][j - 1].getPiece().getColor().equals("Black")){
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
                        if (Tiles[i][j - 1].getPiece() instanceof Pawn && Tiles[i][j - 1].getPiece().getColor().equals("White")){
                            Pawn ppks = (Pawn) Tiles[i][j - 1].getPiece();
                            if (ppks.Moved == 1){
                                Tiles[i + 1][j - 1].setBackground(Color.MAGENTA);
                            }
                        }
                    }                                                                       //EnPassat
                }
                if (i + 1 < 8 && j + 1 < 8){
                    if (ppss.canPassat(Tiles[i][j], Tiles[i + 1][j + 1], Tiles[i][j + 1])){
                        if (Tiles[i][j + 1].getPiece() instanceof Pawn && Tiles[i][j + 1].getPiece().getColor().equals("White")){
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

    public boolean CanKingMove (Piece currentKing){  //prototype
        King HisMajesty = (King) currentKing;
        int WJ = currentKing.getParent().getX() / 80;
        int WI = currentKing.getParent().getY() / 80;
        String currentColor = currentKing.getColor();
        try{
            if (Tiles[WI + 1][WJ].getPiece() == null || !(Tiles[WI + 1][WJ].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI + 1, WJ, HisMajesty, false)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI + 1][WJ + 1].getPiece() == null || !(Tiles[WI + 1][WJ + 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI + 1, WJ + 1, HisMajesty, false)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI + 1][WJ - 1].getPiece() == null || !(Tiles[WI + 1][WJ - 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI + 1, WJ - 1, HisMajesty, false)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI - 1][WJ + 1].getPiece() == null || !(Tiles[WI - 1][WJ + 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI - 1, WJ + 1, HisMajesty, false)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI - 1][WJ - 1].getPiece() == null || !(Tiles[WI - 1][WJ - 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI - 1, WJ - 1, HisMajesty, false)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI - 1][WJ].getPiece() == null || !(Tiles[WI - 1][WJ].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI - 1, WJ, HisMajesty, false)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI][WJ + 1].getPiece() == null || !(Tiles[WI][WJ + 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI, WJ + 1, HisMajesty, false)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        try{
            if (Tiles[WI][WJ - 1].getPiece() == null || !(Tiles[WI][WJ * 1].getPiece().getColor().equals(currentColor))){
                if (!CanKingDie(WI, WJ - 1, HisMajesty, false)){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        return false;
    }

    public void save (){

        try{
            FileOutputStream fos = new FileOutputStream("game.data");
            ObjectOutputStream o = new ObjectOutputStream(fos);

            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    if (Tiles[i][j].getPiece() == null){
                        o.writeUTF("null");
//                        System.out.println("null");
                        continue;
                    }
                    o.writeUTF(Tiles[i][j].getPiece().GetType());
//                      System.out.println(Tiles[i][j].getPiece().GetType());
                }
            }
            o.writeInt(player);
            o.flush();
            o.close();
        }catch (Exception ex){

        }

    }

    public void load (){
//        String[] loaded = new String[64];
        try{
            FileInputStream fis = new FileInputStream("game.data");
            ObjectInputStream o = new ObjectInputStream(fis);
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    String loaded = o.readUTF();
                    if (loaded.equals("null")){
                        Tiles[i][j].removePiece();
                    }else if (loaded.equals("WhiteLeftKnight")){
                        Tiles[i][j].setPiece(WhiteLeftKnight);
                    }else if (loaded.equals("WhiteRightKnight")){
                        Tiles[i][j].setPiece(WhiteRightKnight);
                    }else if (loaded.equals("WhiteLeftBishop")){
                        Tiles[i][j].setPiece(WhiteLeftBishop);
                    }else if (loaded.equals("WhiteRightBishop")){
                        Tiles[i][j].setPiece(WhiteRightBishop);
                    }else if (loaded.equals("WhiteLeftRook")){
                        Tiles[i][j].setPiece(WhiteLeftRook);
                    }else if (loaded.equals("WhiteRightRook")){
                        Tiles[i][j].setPiece(WhiteRightRook);
                    }else if (loaded.equals("WhiteQueen")){
                        Tiles[i][j].setPiece(WhiteQueen);
                    }else if (loaded.equals("WhiteKing")){
                        Tiles[i][j].setPiece(WhiteKing);
                    }else if (loaded.equals("WhitePromotedRookPawn")){
                        Rook WhitePromotedRookPawn = new Rook("WhitePromotedRookPawn");
                        WhitePromotedRookPawn.setIcon(WhiteRookImg);
                        Tiles[i][j].setPiece(WhitePromotedRookPawn);
                    }else if (loaded.equals("WhitePromotedBishopPawn")){
                        Bishop WhitePromotedBishopPawn = new Bishop("WhitePromotedBishopPawn");
                        WhitePromotedBishopPawn.setIcon(WhiteBishopImg);
                        Tiles[i][j].setPiece(WhitePromotedBishopPawn);
                    }else if (loaded.equals("WhitePromotedKnightPawn")){
                        Knight WhitePromotedKnightPawn = new Knight("WhitePromotedKnightPawn");
                        WhitePromotedKnightPawn.setIcon(WhiteKnightImg);
                        Tiles[i][j].setPiece(WhitePromotedKnightPawn);
                    }else if (loaded.equals("WhitePromotedQueenPawn")){
                        Queen WhitePromotedQueenPawn = new Queen("WhitePromotedQueenPawn");
                        WhitePromotedQueenPawn.setIcon(WhiteQueenImg);
                        Tiles[i][j].setPiece(WhitePromotedQueenPawn);
                    }else if (loaded.equals("BlackLeftKnight")){
                        Tiles[i][j].setPiece(BlackLeftKnight);
                    }else if (loaded.equals("BlackRightKnight")){
                        Tiles[i][j].setPiece(BlackRightKnight);
                    }else if (loaded.equals("BlackLeftBishop")){
                        Tiles[i][j].setPiece(BlackLeftBishop);
                    }else if (loaded.equals("BlackRightBishop")){
                        Tiles[i][j].setPiece(BlackRightBishop);
                    }else if (loaded.equals("BlackLeftRook")){
                        Tiles[i][j].setPiece(BlackLeftRook);
                    }else if (loaded.equals("BlackRightRook")){
                        Tiles[i][j].setPiece(BlackRightRook);
                    }else if (loaded.equals("BlackQueen")){
                        Tiles[i][j].setPiece(BlackQueen);
                    }else if (loaded.equals("BlackKing")){
                        Tiles[i][j].setPiece(BlackKing);
                    }else if (loaded.equals("BlackPromotedQueenPawn")){
                        Queen BlackPromotedQueenPawn = new Queen("BlackPromotedQueenPawn");
                        BlackPromotedQueenPawn.setIcon(BlackQueenImg);
                        Tiles[i][j].setPiece(BlackPromotedQueenPawn);
                    }else if (loaded.equals("BlackPromotedRookPawn")){
                        Rook BlackPromotedRookPawn = new Rook("BlackPromotedRookPawn");
                        BlackPromotedRookPawn.setIcon(BlackRookImg);
                        Tiles[i][j].setPiece(BlackPromotedRookPawn);
                    }else if (loaded.equals("BlackPromotedBishopPawn")){
                        Bishop BlackPromotedBishopPawn = new Bishop("BlackPromotedBishopPawn");
                        BlackPromotedBishopPawn.setIcon(BlackBishopImg);
                        Tiles[i][j].setPiece(BlackPromotedBishopPawn);
                    }else if (loaded.equals("BlackPromotedKnightPawn")){
                        Knight BlackPromotedKnightPawn = new Knight("BlackPromotedKnightPawn");
                        BlackPromotedKnightPawn.setIcon(BlackKnightImg);
                        Tiles[i][j].setPiece(BlackPromotedKnightPawn);
                    }else if (loaded.equals("WhitePawn0")){
                        Tiles[i][j].setPiece(WhitePawns[0]);
                    }else if (loaded.equals("WhitePawn1")){
                        Tiles[i][j].setPiece(WhitePawns[1]);
                    }else if (loaded.equals("WhitePawn2")){
                        Tiles[i][j].setPiece(WhitePawns[2]);
                    }else if (loaded.equals("WhitePawn3")){
                        Tiles[i][j].setPiece(WhitePawns[3]);
                    }else if (loaded.equals("WhitePawn4")){
                        Tiles[i][j].setPiece(WhitePawns[4]);
                    }else if (loaded.equals("WhitePawn5")){
                        Tiles[i][j].setPiece(WhitePawns[5]);
                    }else if (loaded.equals("WhitePawn6")){
                        Tiles[i][j].setPiece(WhitePawns[6]);
                    }else if (loaded.equals("WhitePawn7")){
                        Tiles[i][j].setPiece(WhitePawns[7]);
                    }else if (loaded.equals("BlackPawn0")){
                        Tiles[i][j].setPiece(BlackPawns[0]);
                    }else if (loaded.equals("BlackPawn1")){
                        Tiles[i][j].setPiece(BlackPawns[1]);
                    }else if (loaded.equals("BlackPawn2")){
                        Tiles[i][j].setPiece(BlackPawns[2]);
                    }else if (loaded.equals("BlackPawn3")){
                        Tiles[i][j].setPiece(BlackPawns[3]);
                    }else if (loaded.equals("BlackPawn4")){
                        Tiles[i][j].setPiece(BlackPawns[4]);
                    }else if (loaded.equals("BlackPawn5")){
                        Tiles[i][j].setPiece(BlackPawns[5]);
                    }else if (loaded.equals("BlackPawn6")){
                        Tiles[i][j].setPiece(BlackPawns[6]);
                    }else if (loaded.equals("BlackPawn7")){
                        Tiles[i][j].setPiece(BlackPawns[7]);
                    }
                }
            }
            player = o.readInt();
            o.close();
            OriginalColor();
        }catch (Exception ex){

        }
    }
}

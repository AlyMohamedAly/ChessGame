package chessgame;

import java.awt.Color;
import javax.swing.JPanel;

public class Tile extends JPanel{

    private Color C;

    void setColor (Color c){
        C = c;
    }

    @Override
    public boolean equals (Object o){
        Tile target = (Tile) o;
        if (target.getX() == this.getX() && target.getY() == this.getY()){
            return true;
        }
        return false;
    }

    Color getColor (){
        return C;
    }

    void setPiece (Piece pp){
        this.add(pp);
    }

    Piece getPiece (){
        if (this.getComponentCount() == 0){
            return null;
        }
        return (Piece) this.getComponent(0);
    }

    void removePiece (){
        this.removeAll();
    }

    void BlackTile (){
        this.setBackground(new Color(145, 83, 55));
    }

    void WhiteTile (){
        this.setBackground(new Color(249, 217, 202));
    }
}

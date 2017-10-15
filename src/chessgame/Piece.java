package chessgame;

import javax.swing.JLabel;

public abstract class Piece extends JLabel{

    private String Name;

    Piece (String name){
        Name = name;
    }

    String getColor (){
        return Name.substring(0, 5);
    }

    String GetType (){
        return Name;
    }

    public abstract boolean canMove (Tile c, Tile t);

    public abstract boolean canKill (Tile c, Tile t);
}

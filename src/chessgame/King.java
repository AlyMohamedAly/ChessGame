package chessgame;

public class King extends Piece{

    public boolean checked = false;

    King (String s){
        super(s);
    }

    @Override
    public boolean canKill (Tile c, Tile t){
        return canMove(c, t);
    }

    @Override
    public boolean canMove (Tile c, Tile t){         // needs adjusyments
        int CI = c.getY() / 80;
        int CJ = c.getX() / 80;

        int TI = t.getY() / 80;
        int TJ = t.getX() / 80;

        if (TI == CI && TJ == CJ + 1){
            return true;
        }
        if (TI == CI && TJ == CJ - 1){
            return true;
        }

        if (TI == CI - 1 && TJ == CJ){
            return true;
        }
        if (TI == CI - 1 && TJ == CJ - 1){
            return true;
        }
        if (TI == CI - 1 && TJ == CJ + 1){
            return true;
        }

        if (TI == CI + 1 && TJ == CJ){
            return true;
        }
        if (TI == CI + 1 && TJ == CJ + 1){
            return true;
        }
        return TI == CI + 1 && TJ == CJ - 1;
    }
}

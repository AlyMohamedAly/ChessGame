package chessgame;

class Pawn extends Piece{

    public int Moved = 0;

    Pawn (String s){
        super(s);
    }

    @Override
    public boolean canKill (Tile c, Tile t){
        int CI = c.getY() / 80;
        int CJ = c.getX() / 80;

        int TI = t.getY() / 80;
        int TJ = t.getX() / 80;
        if (this.getColor().equals("White")){
            if (TJ == CJ - 1 && TI == CI - 1){
                return true;
            }
            if (TJ == CJ + 1 && TI == CI - 1){
                return true;
            }
        }else{
            if (TJ == CJ - 1 && TI == CI + 1){
                return true;
            }
            if (TJ == CJ + 1 && TI == CI + 1){
                return true;
            }
        }
        return false;
    }

    public boolean canPassat (Tile c, Tile t, Tile t2){
        int CI = c.getY() / 80;
        int CJ = c.getX() / 80;

        int TI = t.getY() / 80;
        int TJ = t.getX() / 80;

        if (this.getColor().equals("White")){
            if (TI == 2 && TJ == CJ - 1 && TI == CI - 1 && t2.getPiece() != null){
                return true;
            }
            if (TI == 2 && TJ == CJ + 1 && TI == CI - 1 && t2.getPiece() != null){
                return true;
            }
        }else{
            if (TI == 6 && TJ == CJ - 1 && TI == CI + 1 && t2.getPiece() != null){
                return true;
            }
            if (TI == 6 && TJ == CJ + 1 && TI == CI + 1 && t2.getPiece() != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canMove (Tile c, Tile t){
        int CI = c.getY() / 80;
        int CJ = c.getX() / 80;

        int TI = t.getY() / 80;
        int TJ = t.getX() / 80;
        if (this.getColor().equals("White")){
            if (TJ == CJ - 1 && TI == CI - 1 && GameFrame.Tiles[TI][TJ].getPiece() != null){
                return true;
            }
            if (TJ == CJ + 1 && TI == CI - 1 && GameFrame.Tiles[TI][TJ].getPiece() != null){
                return true;
            }
            if (TJ == CJ && TI == CI - 1 && GameFrame.Tiles[TI][TJ].getPiece() == null){
                return true;
            }
            if (Moved == 0 && CI == 6){
                if (TJ == CJ && TI == CI - 2 && GameFrame.Tiles[TI][TJ].getPiece() == null && GameFrame.Tiles[CI - 1][CJ].getPiece() == null){
                    return true;
                }
            }
        }else{
            if (TJ == CJ - 1 && TI == CI + 1 && GameFrame.Tiles[TI][TJ].getPiece() != null){
                return true;
            }
            if (TJ == CJ + 1 && TI == CI + 1 && GameFrame.Tiles[TI][TJ].getPiece() != null){
                return true;
            }

            if (TJ == CJ && TI == CI + 1 && GameFrame.Tiles[TI][TJ].getPiece() == null){
                return true;
            }
            if (Moved == 0 && CI == 1){
                if (TJ == CJ && TI == CI + 2 && GameFrame.Tiles[TI][TJ].getPiece() == null && GameFrame.Tiles[CI + 1][CJ].getPiece() == null){
                    return true;
                }
            }
        }

        return false;
    }
}

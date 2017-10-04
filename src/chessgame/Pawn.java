package chessgame;

class Pawn extends Piece{
        private boolean Moved = true;
        Pawn(String s){
            super(s);
        }
        @Override
        public boolean canMove(Tile c, Tile t){
            int CI = c.getY()/80;
            int CJ = c.getX()/80;
            
            int TI = t.getY()/80;
            int TJ = t.getX()/80;
            if(this.getColor().equals("White")){
                if(TJ == CJ-1 && TI == CI-1 && GameFrame.Tiles[TI][TJ].getPiece() != null)
                    return true;
                if(TJ == CJ+1 && TI == CI-1 && GameFrame.Tiles[TI][TJ].getPiece() != null)
                    return true;
                
                if(TJ == CJ && TI == CI-1 && GameFrame.Tiles[TI][TJ].getPiece() == null)
                    return true;
            }
            else{
                if(TJ == CJ-1 && TI == CI+1 && GameFrame.Tiles[TI][TJ].getPiece() != null)
                    return true;
                if(TJ == CJ+1 && TI == CI+1 && GameFrame.Tiles[TI][TJ].getPiece() != null)
                    return true;
                
                if(TJ == CJ && TI == CI+1 && GameFrame.Tiles[TI][TJ].getPiece() == null)
                    return true;
            }
            return false;
        }
    }
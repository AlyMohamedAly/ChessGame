package chessgame;

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
            if(this.getColor().equals("White")){
                if(Moved){
                    if(TJ == CJ && TI == CI-1)
                        return true;
                }
                else{
                    Moved = true;   // law 3amal call lel function w mamsheesh htb2a true
                    if(TJ == CJ && TI == CI-1)
                        return true;
                    if(TJ == CJ && TI == CI-2 && GameFrame.Tiles[CI-1][CJ].getPiece() == null)
                        return true;
                }
            }
            else{
                if(Moved){
                    if(TJ == CJ && TI == CI+1)
                        return true;
                }
                else{
                    Moved = true;   // law 3amal call lel function w mamsheesh htb2a true
                    if(TJ == CJ && TI == CI+1)
                        return true;
                    if(TJ == CJ && TI == CI+2 && GameFrame.Tiles[CI+1][CJ].getPiece() == null)
                        return true;
                }
            }
            return false;
        }
    }
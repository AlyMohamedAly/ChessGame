package chessgame;

public class Rook extends Piece{

    Rook (String s){
        super(s);
    }

    @Override
    public boolean canKill (Tile c, Tile t){
        return canMove(c, t);
    }

    @Override
    public boolean canMove (Tile c, Tile t){
        int CI = c.getY() / 80;
        int CJ = c.getX() / 80;

        int TI = t.getY() / 80;
        int TJ = t.getX() / 80;

        if (TI == CI && TJ == CJ + 1){
            return true;
        }
        if (TJ == CJ && TI == CI + 1){
            return true;
        }
        if (TI == CI && TJ == CJ - 1){
            return true;
        }
        if (TJ == CJ && TI == CI - 1){
            return true;
        }
        try{
            if (GameFrame.Tiles[CI][CJ + 1].getPiece() == null){
                if (TI == CI && TJ == CJ + 2){
                    return true;
                }
                if (GameFrame.Tiles[CI][CJ + 2].getPiece() == null){
                    if (TI == CI && TJ == CJ + 3){
                        return true;
                    }
                    if (GameFrame.Tiles[CI][CJ + 3].getPiece() == null){
                        if (TI == CI && TJ == CJ + 4){
                            return true;
                        }
                        if (GameFrame.Tiles[CI][CJ + 4].getPiece() == null){
                            if (TI == CI && TJ == CJ + 5){
                                return true;
                            }
                            if (GameFrame.Tiles[CI][CJ + 5].getPiece() == null){
                                if (TI == CI && TJ == CJ + 6){
                                    return true;
                                }
                                if (GameFrame.Tiles[CI][CJ + 6].getPiece() == null){
                                    if (TI == CI && TJ == CJ + 7){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){
        }
        try{
            if (GameFrame.Tiles[CI][CJ - 1].getPiece() == null){
                if (TI == CI && TJ == CJ - 2){
                    return true;
                }
                if (GameFrame.Tiles[CI][CJ - 2].getPiece() == null){
                    if (TI == CI && TJ == CJ - 3){
                        return true;
                    }
                    if (GameFrame.Tiles[CI][CJ - 3].getPiece() == null){
                        if (TI == CI && TJ == CJ - 4){
                            return true;
                        }
                        if (GameFrame.Tiles[CI][CJ - 4].getPiece() == null){
                            if (TI == CI && TJ == CJ - 5){
                                return true;
                            }
                            if (GameFrame.Tiles[CI][CJ - 5].getPiece() == null){
                                if (TI == CI && TJ == CJ - 6){
                                    return true;
                                }
                                if (GameFrame.Tiles[CI][CJ - 6].getPiece() == null){
                                    if (TI == CI && TJ == CJ - 7){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){
        }
        try{
            if (GameFrame.Tiles[CI + 1][CJ].getPiece() == null){
                if (TJ == CJ && TI == CI + 2){
                    return true;
                }
                if (GameFrame.Tiles[CI + 2][CJ].getPiece() == null){
                    if (TJ == CJ && TI == CI + 3){
                        return true;
                    }
                    if (GameFrame.Tiles[CI + 3][CJ].getPiece() == null){
                        if (TJ == CJ && TI == CI + 4){
                            return true;
                        }
                        if (GameFrame.Tiles[CI + 4][CJ].getPiece() == null){
                            if (TJ == CJ && TI == CI + 5){
                                return true;
                            }
                            if (GameFrame.Tiles[CI + 5][CJ].getPiece() == null){
                                if (TJ == CJ && TI == CI + 6){
                                    return true;
                                }
                                if (GameFrame.Tiles[CI + 6][CJ].getPiece() == null){
                                    if (TJ == CJ && TI == CI + 7){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){
        }
        try{
            if (GameFrame.Tiles[CI - 1][CJ].getPiece() == null){
                if (TJ == CJ && TI == CI - 2){
                    return true;
                }
                if (GameFrame.Tiles[CI - 2][CJ].getPiece() == null){
                    if (TJ == CJ && TI == CI - 3){
                        return true;
                    }
                    if (GameFrame.Tiles[CI - 3][CJ].getPiece() == null){
                        if (TJ == CJ && TI == CI - 4){
                            return true;
                        }
                        if (GameFrame.Tiles[CI - 4][CJ].getPiece() == null){
                            if (TJ == CJ && TI == CI - 5){
                                return true;
                            }
                            if (GameFrame.Tiles[CI - 5][CJ].getPiece() == null){
                                if (TJ == CJ && TI == CI - 6){
                                    return true;
                                }
                                if (GameFrame.Tiles[CI - 6][CJ].getPiece() == null){
                                    if (TJ == CJ && TI == CI - 7){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
        return false;
    }
}

package chesspoint.cstech;

/**
 *
 * @author Bora
 */
import java.util.*; 
public abstract class Piece {
    // All pieces (pawn, rook, knight, bishop, queen, king) are child of this class

    protected float point;                // point of the piece that is not threatened
    protected int row;                  // row and column shows the
    protected int column;              // coordinate of the piece
    protected String color;             //white or black
    protected boolean is_threatened;    //true if the piece is under a thread of pawn knight or queen
    
    public Piece (int _row, int _column){
        row = _row;
        column = _column;
    }
    
    public abstract void checkThreating(List<Piece> all_pieces); // abstract function for determine the pieces threatened by this piece

    Piece checkCell(List<Piece> all_pieces, int row, int column){
        //check the cell
    	// if cell is occupied by a piece return the piece
    	// else return null
    	for (Piece piece : all_pieces){
            if(piece.row == row && piece.column == column){
               return piece;
            }
           
        }
        return null;
    }
}

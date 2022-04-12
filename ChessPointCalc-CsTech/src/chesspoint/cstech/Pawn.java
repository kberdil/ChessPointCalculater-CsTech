package chesspoint.cstech;

/**
 *
 * @author Bora
 */
import java.util.*; 
public class Pawn extends Piece {
    
    public Pawn(String _color, int _row, int _column){
        super(_row, _column);
        color = _color;
        point = 1;
        is_threatened = false;       
    }

    @Override
    public void checkThreating(List<Piece> all_pieces){
        // pawn can threat two cells.
    	// whites can threat up-left and up-right cells
    	// blacks can threat bottom-left and bottom-right cells
        if(color == "white"){
            if(column > 1){
            	// left target is in the chess board
                Piece p = checkCell(all_pieces, row+1, column-1);
                if(p != null && p.color == "black"){
                    //cell is occupied by an opposite side piece 
                	p.is_threatened = true;
                }
            }
            if(column < 8){
            	// right target is in the chess board
                Piece p = checkCell(all_pieces, row+1, column+1);
                if(p != null && p.color == "black"){
                	//cell is occupied by an opposite side piece 
                    p.is_threatened = true;
                }
            }
        }
        else{
            if(column > 1){
            	// left target is in the chess board
                Piece p = checkCell(all_pieces, row-1, column-1);
                if(p != null && p.color == "white"){
                	//cell is occupied by an opposite side piece 
                    p.is_threatened = true;
                }
            }
            if(column < 8){
            	// right target is in the chess board
                Piece p = checkCell(all_pieces, row-1, column+1);
                if(p != null && p.color == "white"){
                	//cell is occupied by an opposite side piece 
                    p.is_threatened = true;
                }
            }
        }    
    }
}

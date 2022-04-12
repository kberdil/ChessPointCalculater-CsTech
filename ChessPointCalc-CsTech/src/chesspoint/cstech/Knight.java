package chesspoint.cstech;

/**
 *
 * @author Bora
 */
import java.util.*;

public class Knight extends Piece {
    
    // 8 possible move transitions for a knight as two integers is a pair as (row, column) 
    private static int[] possible_moves = {2,-1, 2,1, 1,-2, 1,2, -1,2, -1,-2, -2,1, -2,-1};
    public Knight(String _color, int _row, int _column){
        super(_row, _column);
        color = _color;
        point = 3;
        is_threatened = false;
    }

    @Override
    public void checkThreating(List<Piece> all_pieces){
        int target_row, target_column; //coordinates of the cell that knight can move.
        for (int i = 0; i<16 ;i+=2){
            target_row = row + possible_moves[i];
            target_column = column + possible_moves[i+1];
            if(target_row >= 1 && target_row <= 8 &&
               target_column >= 1 && target_column <= 8){
            	//target cell is in the chess board
            	
            	//for checking the target cell if it is empty or occupied by a same side piece
                Piece p = checkCell(all_pieces, target_row, target_column);
                if(p != null && p.color != color){
                	//cell is occupied by an opposite piece
                    p.is_threatened = true;
                }
            }
        }
        
    }
}

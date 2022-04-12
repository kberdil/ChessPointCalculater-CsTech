package chesspoint.cstech;

/**
 *
 * @author Bora
 */
import java.util.*; 
public class Queen extends Piece {

	// 8 possible directions for a queen as two integers is a pair as (row, column) 
    private static int[] directions = {1,0, -1,0, 0,1, 0,-1, 1,-1, 1,1, -1,-1, -1,1};
    // 1,0    up
    // -1,0   down
    // 0,1	  right
    // 0,-1   left
    // 1,-1   up-left diagonal
    // 1,1	  up-right diagonal
    // -1,-1   down-left diagonal
    // -1,1  down-right diagonal
    
    public Queen(String _color, int _row, int _column){
        super(_row, _column);
        color = _color;
        point = 9;
        is_threatened = false;
    }

    @Override
    public void checkThreating(List<Piece> all_pieces){
    	int target_row, target_column; //coordinates of the cell that queen can move.
    	// queen has 8 possible moving directions
    	// check all directions cell by cell
    	for (int i = 0; i<16; i+=2) {   //directions[i], directions[i+1] is for the direction as (row, column)
    		//initialize target row and column
    		target_row = row;
    		target_column = column;
    		while(true) {
    			target_row += directions[i];
    			target_column += directions[i+1];
    			if(!(target_row >= 1 && target_row <= 8 &&
    		               target_column >= 1 && target_column <= 8)){
    				//target cell is not in the chess board go to next direction
    				break;
    			}
				//target cell is in the chess board
				
				//for checking the target cell if it is empty or occupied by a same side piece
				Piece p = checkCell(all_pieces, target_row, target_column);
				
				if(p == null) {   //cell is empty
					continue;     //go to next cell in the same direction
					
				}
				if(p.color == color){	//cell is  occupied by a same side piece
					break; // do not check rest of the this direction
				}
				//cell is  occupied by a opposite side piece
				p.is_threatened = true;
                break;	
    		}
    	}
    }
}

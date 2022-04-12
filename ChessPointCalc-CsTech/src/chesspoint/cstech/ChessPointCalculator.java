package chesspoint.cstech;

/**
 *
 * @author Bora
 */
import java.util.*; 

public class ChessPointCalculator {
    
    public void calculatePoints(List<Piece> all_pieces){
    	//determine all threatened pieces 
    	checkAllThreats(all_pieces);
    	
    	// initialize points for both sides
    	float white_points = 0;
        float black_points = 0;
        
        //add all piece points
        for (Piece piece : all_pieces){
        	if(piece.color == "white") {
        		if(piece.is_threatened) {
        			//piece is under a threat
        			white_points += piece.point/2;
        			continue;
        		}
        		//piece is not under a threat
        		white_points += piece.point;
        	}
        	else {
        		//a black piece
				if(piece.is_threatened) {
					//piece is under a threat
					black_points += piece.point/2;
					continue;
				}
				//piece is not under a threat
				black_points += piece.point;
        	}
        }
        System.out.print("Siyah: " +  black_points + "\t");
        System.out.println("Beyaz: " +  white_points);
        
    }
    
    public void checkAllThreats(List<Piece> all_pieces){
        //determine all threats piece by piece  
    	for (Piece piece : all_pieces){
            piece.checkThreating(all_pieces);
        }
    }    
}

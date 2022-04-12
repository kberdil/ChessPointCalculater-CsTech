package chesspoint.cstech;

/**
 *
 * @author Bora
 */
import java.util.*; 
public class King extends Piece {
    
    public King(String _color, int _row, int _column){
        super(_row, _column);
        color = _color;
        point = 100;
        is_threatened = false;
    }

    @Override
    public void checkThreating(List<Piece> all_pieces){}

}

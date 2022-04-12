package chesspoint.cstech;

/**
 *
 * @author Bora
 */
import java.util.*; 
public class Bishop extends Piece {

    public Bishop(String _color, int _row, int _column){
        super(_row, _column);
        color = _color;
        point = 3;
        is_threatened = false;
    }

    @Override
    public void checkThreating(List<Piece> all_pieces){}
}

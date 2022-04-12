package chesspoint.cstech;

/**
 *
 * @author Bora
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;  

public class InputReader {
    
    public List<Piece> readInput(String filename){
        File file = new File(filename);
        List<Piece> all_pieces = new ArrayList<Piece>(); // list for storing all pieces
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            
            // create row and column variable for getting coordinates of chess board. 
            int row = 8; // row will be decreased by 1 after each line
            int column; // column will start at "1" and increased to 8 at each line
            while (line != null) {
                column = 1;
                // split line by space to get cell information
                String[] cells = line.split(" ");
                for(String cell : cells){
                    char first_char = cell.charAt(0);

                    // Create pieces
                    switch(first_char) {
                        case 'p':   //pawn
                            if(cell.charAt(1) == 'b'){
                                all_pieces.add(new Pawn("white", row, column));
                            }
                            else{
                                all_pieces.add(new Pawn("black", row, column));
                            }                                
                            break;
                        case 'a':   //knight
                            if(cell.charAt(1) == 'b'){
                                all_pieces.add(new Knight("white", row, column));
                            }
                            else{
                                all_pieces.add(new Knight("black", row, column));
                            }                                
                            break;
                        case 'f':   //bishop
                            if(cell.charAt(1) == 'b'){
                                all_pieces.add(new Bishop("white", row, column));
                            }
                            else{
                                all_pieces.add(new Bishop("black", row, column));
                            }                                
                            break;
                        case 'k':   //rook
                            if(cell.charAt(1) == 'b'){
                                all_pieces.add(new Rook("white", row, column));
                            }
                            else{
                                all_pieces.add(new Rook("black", row, column));
                            }                                
                            break;
                        case 'v':   //queen
                            if(cell.charAt(1) == 'b'){
                                all_pieces.add(new Queen("white", row, column));
                            }
                            else{
                                all_pieces.add(new Queen("black", row, column));
                            }                                
                            break;
                        case 's':   //king
                            if(cell.charAt(1) == 'b'){
                                all_pieces.add(new King("white", row, column));
                            }
                            else{
                                all_pieces.add(new King("black", row, column));
                            }                                
                            break;
                        default:    //empty cell
                            break;
                                
                                                
                    }
                    column++; // increase column
                }
                // read next line
                line = br.readLine();
                row--; // decrease row
                
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
     
        return all_pieces;
    }

}

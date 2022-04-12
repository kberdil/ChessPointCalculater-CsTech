package chesspoint.cstech;

/**
 *
 * @author Bora
 */
import java.util.*; 
import java.io.File;

public class Main {

    /**
     * @param args the command line arguments
     */
	
	
    public static void main(String[] args) {
        
        InputReader input_reader = new InputReader();
        
        //get all inputs
        List<String> filenames = getAlltxtFiles();
        
        for(String file : filenames) {
        	List<Piece> all_pieces = input_reader.readInput(file);
        	System.out.print(file + " \t");
            
            //calculate points
            ChessPointCalculator cpc = new ChessPointCalculator();
            cpc.calculatePoints(all_pieces);       
        }  
    }
    
    public static List<String> getAlltxtFiles() {
    	// get current directory
        File current_dir = new File(System.getProperty("user.dir"));
        
        // list for storing all txt files
        List<String> filenames = new ArrayList<String>(); 

        // get all files current directory
        // or you can enter a new directory that has input files
        // directory must not have any .txt files other than inputs
        File filesList[] = current_dir.listFiles();
       
        for(File file : filesList) {
        	if (file.isFile() && file.getName().endsWith(".txt")) {
        		// get all .txt files and names
        		filenames.add(file.getName());
        	}
        }
        return filenames;

    }
}

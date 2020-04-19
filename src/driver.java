/**
 * @author mike802
 * @version 1.0 - 2/26/2013
 */
import core.Board;
import core.Mover;
import core.Properties;

public class driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length != 2){
			System.out.println("java driver <rootDir> <user dir>");
		}
		
		Properties properties = new Properties(args[0]);
		Board board = new Board(properties, args[1]);
		board.init();
		
		Thread thread = new Thread(new Mover(board));
		thread.start();
	}
}

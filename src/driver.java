/**
 * @author wontzer
 * @version 1.0 - 2/26/2013
 * 
 * brand-aware
 */
import core.Board;
import core.Mover;
import core.Properties;

public class driver {

	public static void main(String[] args) {
		//current working dir used to locate image folder
		String currentDir = System.getProperty("user.dir");
		Properties properties = new Properties(currentDir);
		Board board = new Board(properties);
		board.init();
		
		//starts game animation
		Thread thread = new Thread(new Mover(board));
		thread.start();
	}
}

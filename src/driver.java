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
		String currentDir = System.getProperty("user.dir");
		Properties properties = new Properties(currentDir);
		Board board = new Board(properties);
		board.init();
		
		Thread thread = new Thread(new Mover(board));
		thread.start();
	}
}

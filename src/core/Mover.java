/**
 * @author mike802
 * @version 1.0 - 2/26/2013
 */
package core;

public class Mover implements Runnable{
	
	private Board board;
	
	public Mover(Board b){
		board = b;
	}

	@Override
	public void run() {
		board.init();
		while(true){
			try {
				Thread.sleep(1);
				board.move();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

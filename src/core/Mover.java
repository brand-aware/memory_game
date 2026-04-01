/**
 * @author wontzer
 * @version 1.0 - 2/26/2013
 * 
 * brand-aware
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
		//infinite animation loop
		while(true){
			try {
				//animation set to as fast as possible
				Thread.sleep(1);
				//looks for any needed animations to perform
				board.move();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

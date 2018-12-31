import java.awt.Canvas;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private  boolean running = false;
	private Thread thread; 
	public Game() {}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
		
	}
	public synchronized void stop() throws InterruptedException {
		running = false;
		thread.join();
	}

	@Override
	public void run() {
		
		while(running) {
			
			update();
			render();
		}
		
	}
	
	public void update() {}
	
	public void render() {
		
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
	}
	
}

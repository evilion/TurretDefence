/**
 * 
 */
package gui;

import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import business.GameLoop;
import business.KeyInput;

/**
 * @author Evilion
 *
 */
public class TD extends Applet implements KeyListener, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = -20871060598428842L;
	private Thread gameLoopThread;
	private GameLoop gameLoop;
	private RenderPanel renderPanel;
	
	public void init(){
		// Set render size
		setSize(854,480);
		
		
		
		// Initialise rendering panel, position and add to window
		this.renderPanel = new RenderPanel();
		this.renderPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(this.renderPanel);
		
		// Bind (localised) listener for controls
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		// Initialise and start gameloop
		this.gameLoop = new GameLoop(this.renderPanel);
		this.renderPanel.Render(this.gameLoop);
		this.gameLoopThread = new Thread(this.gameLoop);
		this.gameLoopThread.start();
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// This is the problem when implementing events.
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		setCursor(null);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (e.getButton())
		{
		case MouseEvent.BUTTON1:
			gameLoop.KeyInput.mousePressed(KeyInput.BTN_LEFT);
			break;
		case MouseEvent.BUTTON2:
			gameLoop.KeyInput.mousePressed(KeyInput.BTN_RIGHT);
			break;
		case MouseEvent.BUTTON3:
			gameLoop.KeyInput.mousePressed(KeyInput.BTN_MIDDLE);
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton())
		{
		case MouseEvent.BUTTON1:
			gameLoop.KeyInput.mouseReleased(KeyInput.BTN_LEFT);
			break;
		case MouseEvent.BUTTON2:
			gameLoop.KeyInput.mouseReleased(KeyInput.BTN_RIGHT);
			break;
		case MouseEvent.BUTTON3:
			gameLoop.KeyInput.mouseReleased(KeyInput.BTN_MIDDLE);
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		// Any key configuration can be mapped (from game settings for example) to the engine mapping
		// For example if you want to enable wasd and udlr, uncomment the cases.
		switch (keyEvent.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
		//case KeyEvent.VK_A:
			gameLoop.KeyInput.keyPressed(KeyInput.KEY_LEFT);
			break;
		case KeyEvent.VK_UP:
		//case KeyEvent.VK_W:
			gameLoop.KeyInput.keyPressed(KeyInput.KEY_UP);
			break;
		case KeyEvent.VK_RIGHT:
		//case KeyEvent.VK_D:
			gameLoop.KeyInput.keyPressed(KeyInput.KEY_RIGHT);
			break;
		case KeyEvent.VK_DOWN:
		//case KeyEvent.VK_S:
			gameLoop.KeyInput.keyPressed(KeyInput.KEY_DOWN);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		// Any key configuration can be mapped (from game settings for example) to the engine mapping
		// For example if you want to enable wasd and udlr, uncomment the cases.
		switch (keyEvent.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
		//case KeyEvent.VK_A:
			gameLoop.KeyInput.keyReleased(KeyInput.KEY_LEFT);
			break;
		case KeyEvent.VK_UP:
		//case KeyEvent.VK_W:
			gameLoop.KeyInput.keyReleased(KeyInput.KEY_UP);
			break;
		case KeyEvent.VK_RIGHT:
		//case KeyEvent.VK_D:
			gameLoop.KeyInput.keyReleased(KeyInput.KEY_RIGHT);
			break;
		case KeyEvent.VK_DOWN:
		//case KeyEvent.VK_S:
			gameLoop.KeyInput.keyReleased(KeyInput.KEY_DOWN);
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		/*x = e.getX()-10;
		y = e.getY()-10;*/
	}
}

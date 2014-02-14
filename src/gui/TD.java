/**
 * 
 */
package gui;

import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import business.GameLoop;

/**
 * @author Evilion
 *
 */
public class TD extends Applet implements KeyListener, MouseListener {
	private static final long serialVersionUID = -20871060598428842L;
	private Thread gameLoopThread;
	private GameLoop gameLoop;
	private RenderPanel renderPanel;
	
	public void init(){
		// Set render size
		setSize(854,480);
		setLayout(null);
		
		
		// Initialise rendering panel, position and add to window
		this.renderPanel = new RenderPanel();
		this.renderPanel.setSize(getWidth(), getHeight());
		this.add(this.renderPanel, 0, 0);
		
		// Bind (localised) listener for controls
		addKeyListener(this);
		addMouseListener(this);
		this.renderPanel.addKeyListener(this);
		this.renderPanel.addMouseListener(this);

		/*KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
				new KeyEventDispatcher() {
					
					@Override
					public boolean dispatchKeyEvent(KeyEvent e) {
						if (e.getID() == KeyEvent.KEY_PRESSED)
							keyPressed(e);
						if (e.getID() == KeyEvent.KEY_RELEASED)
							keyReleased(e);
						
						return false;
					}
				});*/
		
		// Initialise and start gameloop
		this.gameLoop = GameLoop.Instance();
		this.gameLoop.Initialise(this.renderPanel);
		this.renderPanel.Render(this.gameLoop);
		this.gameLoopThread = new Thread(this.gameLoop);
		this.gameLoopThread.start();
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// This is the problem when implementing events.
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
		gameLoop.KeyInput.mousePressed(e.getButton());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		gameLoop.KeyInput.mouseReleased(e.getButton());
	}

	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		gameLoop.KeyInput.keyPressed(keyEvent.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		gameLoop.KeyInput.keyReleased(keyEvent.getKeyCode());
	}
}

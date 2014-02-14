package business;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyInput {
	private Map<Integer, Boolean> pressedKeys = new HashMap<Integer, Boolean>();
	//private Map<Integer, Boolean> pressedButtons = new HashMap<Integer, Boolean>();
	
	/**
	 * Movement vector pointing in the direction of movement.
	 * x,y:
	 * -1,-1|0,-1|1,-1
	 *        ^
	 * -1,0|<0,0>|1,0
	 *        v 
	 * -1,1| 0,1 |1,1      
	 */
	private Dimension mouseMovement = new Dimension(0, 0);
	private boolean mouseMoved = false;
	private boolean shooting = false;
	
	public void mousePressed(int buttonCode)
	{
	}
	
	public void mouseReleased(int buttonCode)
	{
	}
	
	public void keyPressed(int keyCode)
	{
		if (pressedKeys.containsKey(keyCode))
			pressedKeys.remove(keyCode);
		
		pressedKeys.put(keyCode, true);
	}
	
	public void keyReleased(int keyCode)
	{
		if (pressedKeys.containsKey(keyCode))
			pressedKeys.remove(keyCode);
		
		pressedKeys.put(keyCode, false);
	}
	
	public void mouseMoved(int relativeX, int relativeY)
	{
		mouseMoved = true;
		this.mouseMovement = new Dimension(relativeX, relativeY);
	}
	
	public Dimension GetMovement()
	{
		Dimension movement = new Dimension();
		
		if (pressedKeys.containsKey(KeyEvent.VK_UP) && pressedKeys.get(KeyEvent.VK_UP))
			movement.height -= 1;
		if (pressedKeys.containsKey(KeyEvent.VK_DOWN) && pressedKeys.get(KeyEvent.VK_DOWN))
			movement.height += 1;
		if (pressedKeys.containsKey(KeyEvent.VK_LEFT) && pressedKeys.get(KeyEvent.VK_LEFT))
			movement.width -= 1;
		if (pressedKeys.containsKey(KeyEvent.VK_RIGHT) && pressedKeys.get(KeyEvent.VK_RIGHT))
			movement.width += 1;
		
		if (mouseMoved)
		{
			movement.height += this.mouseMovement.height;
			movement.width += this.mouseMovement.width;
			mouseMoved = false;
		}
		
		return movement;
	}
	
	public boolean IsShooting()
	{
		return this.shooting;
	}
}

package business;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
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
	private Dimension movement = null;
	private Point mouseMovement = null;
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
		/*this.mouseMovement = new Dimension(relativeX, relativeY);
		System.out.println("Detected movement: " + relativeX + "," + relativeY);*/
	}
	
	/**
	 * On tick, clear mouse vector to prevent stuck movement
	 */
	public void Tick()
	{
		this.movement = null;
	}
	
	public Dimension GetMovement()
	{
		if (movement == null)
		{
			movement = new Dimension();
			
			if (pressedKeys.containsKey(KeyEvent.VK_UP) && pressedKeys.get(KeyEvent.VK_UP))
				movement.height -= 1;
			if (pressedKeys.containsKey(KeyEvent.VK_DOWN) && pressedKeys.get(KeyEvent.VK_DOWN))
				movement.height += 1;
			if (pressedKeys.containsKey(KeyEvent.VK_LEFT) && pressedKeys.get(KeyEvent.VK_LEFT))
				movement.width -= 1;
			if (pressedKeys.containsKey(KeyEvent.VK_RIGHT) && pressedKeys.get(KeyEvent.VK_RIGHT))
				movement.width += 1;
			
			Point newPoint = null;
			if (mouseMovement != null)
			{
				newPoint = MouseInfo.getPointerInfo().getLocation();
				movement.width += newPoint.getX() - mouseMovement.getX();
				movement.height += newPoint.getY() - mouseMovement.getY();
			}
			mouseMovement = newPoint == null ? MouseInfo.getPointerInfo().getLocation() : newPoint;
		}
		
		return movement;
	}
	
	public boolean IsShooting()
	{
		return this.shooting;
	}
}

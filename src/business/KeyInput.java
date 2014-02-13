package business;

import java.awt.Dimension;

public class KeyInput {
	// Note: These key codes do not need to represent actual Java key codes. This is the internal engine mapping!
	public static final int KEY_UP = 38;
	public static final int KEY_DOWN = 40;
	public static final int KEY_LEFT = 37;
	public static final int KEY_RIGHT = 39;
	
	public static final int BTN_LEFT = 1;
	public static final int BTN_RIGHT = 2;
	public static final int BTN_MIDDLE = 3;
	
	/**
	 * Movement vector pointing in the direction of movement.
	 * x,y:
	 * -1,-1|0,-1|1,-1
	 *        ^
	 * -1,0|<0,0>|1,0
	 *        v 
	 * -1,1| 0,1 |1,1      
	 */
	private Dimension movement = new Dimension(0, 0);
	private boolean shooting = false;
	
	public void mousePressed(int buttonCode)
	{
		if (buttonCode == BTN_LEFT)
			this.shooting = true;
	}
	
	public void mouseReleased(int buttonCode)
	{
		if (buttonCode == BTN_LEFT)
			this.shooting = false;
	}
	
	public void keyPressed(int keyCode)
	{
		if (keyCode == KEY_UP)
			movement.height += 1;
		if (keyCode == KEY_DOWN)
			movement.height -= 1;
		if (keyCode == KEY_LEFT)
			movement.width -= 1;
		if (keyCode == KEY_RIGHT)
			movement.width += 1;
	}
	
	public void keyReleased(int keyCode)
	{
		if (keyCode == KEY_UP)
			movement.height -= 1;
		if (keyCode == KEY_DOWN)
			movement.height += 1;
		if (keyCode == KEY_LEFT)
			movement.width += 1;
		if (keyCode == KEY_RIGHT)
			movement.width -= 1;
	}
	
	public Dimension GetMovement()
	{
		return movement;
	}
	
	public boolean IsShooting()
	{
		return this.shooting;
	}
}

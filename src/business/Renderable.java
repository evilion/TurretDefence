package business;

import java.awt.Dimension;

public class Renderable {
	private static int maximumObjectId = 0;
	
	protected Dimension position;
	protected float scaleX, scaleY;
	protected int zIndex;
	protected int objectId;
	
	public Renderable(int x, int y, float sizeX, float sizeY, int zIndex)
	{
		this.position = new Dimension(x, y);
		this.scaleX = sizeX;
		this.scaleY = sizeY;
		this.zIndex = zIndex;
		this.objectId = ++Renderable.maximumObjectId;
	}
	
	public Dimension GetPosition()
	{
		return this.position;
	}
	
	public int GetX()
	{
		return this.position.width;
	}
	
	public int GetY()
	{
		return this.position.height;
	}
	
	public float GetSizeX()
	{
		return this.scaleX;
	}
	
	public float GetSizeY()
	{
		return this.scaleY;
	}
	
	public int GetZIndex()
	{
		return this.zIndex;
	}
	
	public void SetX(int x)
	{
		this.position.width = x;
	}
	
	public void SetY(int y)
	{
		this.position.height = y;
	}
	
	public void SetSizeX(float sizeX)
	{
		this.scaleX = sizeX;
	}
	
	public void SetSizeY(float sizeY)
	{
		this.scaleY= sizeY;
	}
	
	public void SetZIndex(int z)
	{
		this.zIndex = z;
	}
	
	public void SetPosition(Dimension position)
	{
		this.position = position;
	}
}

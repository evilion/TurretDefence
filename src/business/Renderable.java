package business;

import java.awt.Dimension;

public class Renderable {
	private static int maximumObjectId = 0;
	
	protected Dimension position;
	protected Dimension scale;
	protected int zIndex;
	protected int objectId;
	
	public Renderable(int x, int y, int sizeX, int sizeY, int zIndex)
	{
		this.position = new Dimension(x, y);
		this.scale = new Dimension(sizeX, sizeY);
		this.zIndex = zIndex;
		this.objectId = ++Renderable.maximumObjectId;
	}
	
	public Dimension GetPosition()
	{
		return this.position;
	}
	
	public Dimension GetScale()
	{
		return this.scale;
	}
	
	public int GetX()
	{
		return this.position.width;
	}
	
	public int GetY()
	{
		return this.position.height;
	}
	
	public int GetSizeX()
	{
		return this.scale.width;
	}
	
	public int GetSizeY()
	{
		return this.scale.height;
	}
	
	public int GetZIndex()
	{
		return this.zIndex;
	}
}

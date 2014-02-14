package business;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Cursor extends GeometricRenderable {
	public Cursor(int x, int y, float sizeX, float sizeY) {
		super(x, y, sizeX, sizeY, ZINDEX_LAYER);
	}
	
	public void RenderGeometry(Graphics graphics)
	{
		// Draw a red circular crosshair
		graphics.setColor(Color.RED);
		graphics.drawOval(this.GetX(), this.GetY(), (int)this.GetSizeX(), (int)this.GetSizeY());
	}
	
	public void SetX(int x)
	{
		int maxWidth = (int)(GameLoop.Instance().GetSize().width - this.GetSizeX());
		this.position.width = (x < 0 || x > maxWidth) ? (x < 0 ? 0 : maxWidth) : x;
	}
	
	public void SetY(int y)
	{
		int maxHeight = (int)(GameLoop.Instance().GetSize().height - this.GetSizeY());
		this.position.height = (y < 0 || y > maxHeight) ? (y < 0 ? 0 : maxHeight) : y;
	}

	public void SetPosition(Dimension position)
	{
		this.SetX(position.width);
		this.SetY(position.height);
	}
}

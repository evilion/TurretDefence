package business;

import java.awt.Color;
import java.awt.Graphics;

public class Cursor extends GeometricRenderable {
	public Cursor(int x, int y, int sizeX, int sizeY) {
		super(x, y, sizeX, sizeY, ZINDEX_LAYER);
	}
	
	public void RenderGeometry(Graphics graphics)
	{
		// Draw a red circular crosshair
		graphics.setColor(Color.RED);
		graphics.drawOval(this.GetX(), this.GetY(), this.GetSizeX(), this.GetSizeY());
	}

}

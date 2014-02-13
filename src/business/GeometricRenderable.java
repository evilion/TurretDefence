package business;

import java.awt.Graphics;

public class GeometricRenderable extends Renderable {
	protected static final int ZINDEX_LAYER = 0; // GUI Layer
	
	public GeometricRenderable(int x, int y, int sizeX, int sizeY, int zIndex) {
		super(x, y, sizeX, sizeY, zIndex);
	}

	public void RenderGeometry(Graphics graphics)
	{
		graphics.fillRect(this.GetX(), this.GetY(), this.GetSizeX(), this.GetSizeY());
	}
}

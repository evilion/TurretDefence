package business;

import java.awt.Graphics;

public class GeometricRenderable extends Renderable {
	protected static final int ZINDEX_LAYER = 0; // GUI Layer
	
	public GeometricRenderable(int x, int y, float sizeX, float sizeY, int zIndex) {
		super(x, y, sizeX, sizeY, zIndex);
	}

	public void RenderGeometry(Graphics graphics)
	{
		graphics.fillRect(this.GetX(), this.GetY(), (int)this.GetSizeX(), (int)this.GetSizeY());
	}
}

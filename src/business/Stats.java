package business;

import java.awt.Dimension;
import java.awt.Graphics;

public class Stats extends GeometricRenderable {

	public Stats() {
		super(5, 10, 0, 0, 0);
	}

	public void RenderGeometry(Graphics graphics)
	{
		Dimension movement = GameLoop.Instance().KeyInput.GetMovement();
		graphics.drawString("x:" + movement.width + ",y:" + movement.height, this.position.width, this.position.height);
	}
}

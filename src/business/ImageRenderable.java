package business;

import java.awt.image.BufferedImage;

public class ImageRenderable extends Renderable {
	protected BufferedImage image;
	
	public ImageRenderable(int x, int y, int sizeX, int sizeY, int zIndex) {
		super(x, y, sizeX, sizeY, zIndex);
	}

	public BufferedImage GetImage()
	{
		return this.image;
	}
}

package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import business.GameLoop;

/**
 * Panel that is capable of rendering a gameloop.
 * @author gachl
 *
 */
public class RenderPanel extends Panel {
	private static final long serialVersionUID = 9140488114029556637L;
	GameLoop drawCallback;
	
	public void Render(GameLoop drawCallback)
	{
		this.drawCallback = drawCallback;
	}
	
	public void paint(Graphics graphics)
	{
		Image offscreenImage = this.createImage(this.getWidth(), this.getHeight());
		Graphics offscreenRenderer = offscreenImage.getGraphics(); // Double buffer
		drawCallback.Draw(offscreenRenderer);
		//this.paint(offscreenRenderer);
		graphics.drawImage(offscreenImage, 0, 0, this);
	}
}

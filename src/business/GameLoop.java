package business;

import gui.RenderPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Evilion
 *
 */
public class GameLoop implements Runnable
{
	/**
	 * The following variable definitions *should* all be private.
	 */
	//public Graphics d; // unneeded
	public boolean up,down,left,right; // Should be classified
	public BufferedImage background, foreground, enemy; // Should be classified
	public int x,y, eX, eY; // Should be dimensions or maybe unneeded?
	//public Image offscreen; // Unneeded
	public int counter, health=100, points=100, sizeX=10, sizeY=10, state=1; // Game variables
	//public SpawnEnemy spawnEnemy; // Unneeded
	public List<Renderable> allObjects = new LinkedList<Renderable>(); // Should be classified
	private boolean running = false; // Keeps the engine running
	private int fps = 60; // Frames per second to be ticked and rendered
	private RenderPanel panel; // Panel to invalidate after each tick to invoke rendering
	private Dimension viewPort; // View port defines which area of the whole screne is rendered (x,y to canvas width,height)
	
	public KeyInput KeyInput = new KeyInput();
	
	public GameLoop(RenderPanel panel)
	{
		this.panel = panel;
		this.viewPort = new Dimension(0, 0);
	}
	
	/**
	 * GameLoop for continuous run mode.
	 */
	@Override
	public void run() {
		x = 100;
		y = 100;
		
		Resources.GetResources().Load(); // Load resources
		
		//spawnEnemy = new SpawnEnemy();
		//ArrayList<Object> allObjectsList = new ArrayList<Object>();
		
		running = true;
		while (running)
		{
			long timeBegin = System.currentTimeMillis();
			
			/* Engine work */
			tick();
			
			/* Graphics work */
			panel.repaint(); // Invalidate and repaint
			
			long timeDifference = System.currentTimeMillis() - timeBegin;
			try
			{
				Thread.sleep((1000/fps) - timeDifference); // Calculate time to wait for fps and substract previous frame time.
			}
			catch (Exception e)
			{
				System.err.println("Dropped frame, performance issues!");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * A single engine frame
	 * <p>
	 * An engine frame that calculates all events and is rendered into
	 * one image. This function is performance critical, that means
	 * it should not exceed 1000/fps milliseconds of runtime to prevent
	 * lags and dropped frames.
	 * </p>
	 */
	private void tick()
	{
		counter++;
		if (counter >= 4){
			counter = 0;
		}
		
		if (counter == 3)
			allObjects.addAll(Arrays.asList(Enemy.SpawnEnemies(eX, eY, health, points, sizeX, sizeY, 2)));
		
		switch(counter)
		{
		case 0: eX=100; eY=100; break;
		case 1: eX=300; eY=100; break;
		case 2: eX=500; eY=100; break;
		case 3: eX=700; eY=100; break;
		}
		
		Dimension movement = KeyInput.GetMovement();
		x += movement.width * 2; // Two pixel per movement unit
		y += movement.height * 2; // "
	}
	
	/**
	 * A single graphics frame
	 * <p>
	 * A graphics frame that contains all work to render a scene image.
	 * This is called once per tick from within the drawing pane.
	 * @param graphics
	 */
	public void Draw(Graphics graphics)
	{
		graphics.clearRect(0, 0, 854, 480); // This should be dynamic
		graphics.drawImage((BufferedImage)Resources.GetResources().GetResource("Background"), 0, 0, null);
		
		// Bring Z-Index in correct order
		Collections.sort(allObjects, new Comparator<Renderable>() {
			@Override
			public int compare(Renderable o1, Renderable o2) {
				if (o1.GetZIndex() == o2.GetZIndex())
					return 0;
				
				return o1.GetZIndex() < o2.GetZIndex() ? -1 : 1;
			}
		});
		
		for (Object item : allObjects)
		{
			/*
			System.out.println("Item: " + item); // This will cause problems
			
			// What is that supposed to do?
			for (int i = 0; i < item.getClass().getFields().length; i++)
				System.out.println(i);
			System.out.println();
			*/
			
			if (item.getClass().isInstance(ImageRenderable.class))
			{
				// "Ingame" graphics (relative)
				ImageRenderable renderable = (ImageRenderable)item;
				graphics.drawImage(renderable.GetImage(), renderable.GetX() - viewPort.width, renderable.GetY() - viewPort.height, null);
			}
			else if (item.getClass().isInstance(GeometricRenderable.class))
			{
				// "GUI" graphics (absolute)
				GeometricRenderable renderable = (GeometricRenderable)item;
				renderable.RenderGeometry(graphics);
			}
			
			//d.drawImage(enemy, (int) item, (int) allObjectsList.get(eY),this);
			
		}
		//d.drawImage(foreground,offscreen.getWidth(this)/2-foreground.getWidth()/2,offscreen.getHeight(this)-foreground.getHeight(),this);
		//System.out.println("offscreen get width/2-foreground.getwidth/2 = " + (offscreen.getWidth(this)/2-foreground.getWidth()/2));
		//System.out.println("offscreen get height-foreground.getHeight = " + (offscreen.getHeight(this)-foreground.getHeight()));
		graphics.drawImage((BufferedImage)Resources.GetResources().GetResource("Foreground"), 271, 383, null);
	}
	
	/**
	 * Grind halt the engine.
	 */
	public void Stop()
	{
		this.running = false;
	}

}

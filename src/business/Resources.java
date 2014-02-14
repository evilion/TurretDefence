package business;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Resources {
	private static Resources instance = null;
	public static Resources GetResources()
	{
		if (instance == null)
			instance = new Resources();
		return instance;
	}
	
	private Map<String, String> namedResources;
	private Map<String, Object> storedResources;
	
	private Resources()
	{
		this.namedResources = new HashMap<String, String>();
		this.namedResources.put("EnemySprite", "images/enemy.gif");
		this.namedResources.put("Background", "images/background.png");
		this.namedResources.put("Foreground", "images/foreground.png");
	}
	
	public void Load()
	{
		this.storedResources = new HashMap<String, Object>();
		for (String key : this.namedResources.keySet())
		{
			try
			{
				this.storedResources.put(key, ImageIO.read(new File(this.namedResources.get(key))));
			}
			catch (Exception e)
			{
				System.err.println("Error while loading resource " + key);
				e.printStackTrace();
			}
		}
	}
	
	public Object GetResource(String name)
	{
		if (!this.storedResources.containsKey(name))
			return null;
		
		return this.storedResources.get(name);
	}
}

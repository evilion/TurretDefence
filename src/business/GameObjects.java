package business;

import java.util.ArrayList;

public class GameObjects extends ArrayList<Renderable>
{
	private static GameObjects instance = null;
	public static GameObjects GetObjects()
	{
		if (instance == null)
			instance = new GameObjects();
		
		return instance;
	}
	
	private static final long serialVersionUID = -7771210448902688384L;

	private GameObjects()
	{
		
	}
	
	@SuppressWarnings("rawtypes")
	public Renderable GetObjectByClass(Class type)
	{
		for (Renderable renderable : this)
			if (renderable.getClass().isInstance(type))
				return renderable;
		
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Renderable> GetObjectsByClass(Class type)
	{
		ArrayList<Renderable> matches = new ArrayList<Renderable>();
		
		for (Renderable renderable : this)
			if (renderable.getClass().isInstance(type))
				matches.add(renderable);
		
		return matches;
	}
}

package business;

import java.awt.image.BufferedImage;

public class Enemy extends LivingEntity
{
	private static final int ZINDEX_LAYER = 4;
	
	public Enemy(int x, int y, int sizeX, int sizeY, int zIndex, int health, int points)
	{
		super(x, y, sizeX, sizeY, zIndex);
		
		// Initialise Enemy
		this.image = (BufferedImage)Resources.GetResources().GetResource("EnemySprite");
		this.health = health;
		this.points = points;
	}

	public static Enemy[] SpawnEnemies(int x, int y, int health, int points, int sizeX, int sizeY)
	{
		return SpawnEnemies(x, y, health, points, sizeX, sizeY, 1);
	}
	
	public static Enemy[] SpawnEnemies(int x, int y, int health, int points, int sizeX, int sizeY, int amount)
	{
		Enemy[] enemies = new Enemy[amount];
		for (int i = 0; i < amount; i++)
			enemies[i] = SpawnOneEnemy(x, y, health, points, sizeX, sizeY);
		
		System.out.println("Spawned wave of " + amount + " enemies.");
		
		return enemies;
	}

	private static Enemy SpawnOneEnemy(int x, int y, int health, int points, int sizeX, int sizeY)
	{
		Enemy enemy = new Enemy(x, y, sizeX, sizeY, ZINDEX_LAYER, health, points);
		System.out.println("Spawned single enemy " + enemy.toString());
		return enemy;
	}
	
	public String toString()
	{
		return "Enemy {" + this.GetX() + "|" + this.GetY() + "|" + this.GetSizeX() + "|" + this.GetSizeY() + "} (" + objectId + ")"; // Make enemies more identifiable (Enemy {x|y|sx|sy} (id))
	}

}

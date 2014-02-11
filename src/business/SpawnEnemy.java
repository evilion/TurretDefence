package business;

import java.awt.image.BufferedImage;

public class SpawnEnemy {
	
	public SpawnEnemy(){}
	public Object SpawnEnemies(final int x, final int y, final BufferedImage enemy, final int health, final int points,  final int sizeX, final int sizeY, final int state){
		System.out.println("I've spawned one enemy!");
		return SpawnOneEnemy(x,y, enemy, health, points, sizeX, sizeY, state);
		
	}
	
	@SuppressWarnings("unused")
	public Object SpawnEnemies(int x, int y, BufferedImage enemy, int health, int points,  int sizeX, int sizeY, int state, int howMuch){
		for (int i = 0; i <= howMuch; i++){
			System.out.println("I've spawned a wave! The enemy is "+ SpawnOneEnemy(x,y, enemy, health, points, sizeX, sizeY, state).toString() );
			return SpawnOneEnemy(x,y, enemy, health, points, sizeX, sizeY, state);
			
			
		}
		return null;
	}

	private Object SpawnOneEnemy(int x, int y, BufferedImage enemy, int health,
			int points, int sizeX, int sizeY, int state) {
		
		Enemy enemyObj = new Enemy(x, y, enemy, health, points, sizeX, sizeY, state);
		
		return enemyObj;
	}
	

}

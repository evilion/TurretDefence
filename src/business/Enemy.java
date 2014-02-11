package business;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Enemy {
	private int x, y, health, points, sizeX, sizeY, state;
	private BufferedImage enemy;
	
	public Enemy(int x, int y, BufferedImage enemy, int health, int points,
			int sizeX, int sizeY, int state) {
		super();
		this.x = x;
		this.y = y;
		this.enemy = enemy;
		this.health = health;
		this.points = points;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.state = state;
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(enemy,x,y,null);
	}
	
}

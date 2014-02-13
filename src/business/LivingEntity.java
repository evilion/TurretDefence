package business;

public class LivingEntity extends ImageRenderable {
	protected int health;
	protected int points;
	protected int state;
	
	public LivingEntity(int x, int y, int sizeX, int sizeY, int zIndex) {
		super(x, y, sizeX, sizeY, zIndex);
	}

}

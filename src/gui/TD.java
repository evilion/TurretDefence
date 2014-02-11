/**
 * 
 */
package gui;

import java.awt.Graphics;

import business.GameLoop;

/**
 * @author Evilion
 *
 */
public class TD extends GameLoop {

	/**
	 * 
	 */
	public void init(){
		setSize(854,480);
		Thread th = new Thread(this);
		th.start();
		offscreen = createImage(854,480);
		d = offscreen.getGraphics();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	

	public void paint(Graphics g){
		d.clearRect(0,0,854,480);
		d.drawImage(background,0,0,this);
		//spawnEnemy(eX,eY);
		d.drawOval(x,y,20,20);
		for (Object item: allObjectsList){
			System.out.println("Item: "+item);
			for (int i=0; i<item.getClass().getFields().length; i++){
				System.out.println(i);
			}
			System.out.println();
			/*try {
				System.out.println("Item " +item+" hat folgende felder belegt. eX: "+ item.getClass().getField("eX")+" eY: "+ item.getClass().getField("eY"));
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//d.drawImage(enemy, (int) item, (int) allObjectsList.get(eY),this);
			
		}
		//d.drawImage(foreground,offscreen.getWidth(this)/2-foreground.getWidth()/2,offscreen.getHeight(this)-foreground.getHeight(),this);
		//System.out.println("offscreen get width/2-foreground.getwidth/2 = " + (offscreen.getWidth(this)/2-foreground.getWidth()/2));
		//System.out.println("offscreen get height-foreground.getHeight = " + (offscreen.getHeight(this)-foreground.getHeight()));
		d.drawImage(foreground,271,383,this);
		g.drawImage(offscreen,0,0,this);
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	/*private void spawnEnemy(int x, int y){
		d.drawImage(enemy, x, y, this);
	}*/

}

/**
 * 
 */
package business;

import java.applet.Applet;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import business.SpawnEnemy;

/**
 * @author Evilion
 *
 */
public class GameLoop extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Graphics d;
	public boolean up,down,left,right;
	public BufferedImage background, foreground, enemy;
	public int x,y, eX, eY;
	public Image offscreen;
	public int counter, health=100, points=100, sizeX=10, sizeY=10, state=1;
	public Object spawnEnemy;
	public ArrayList<Object> allObjectsList = new ArrayList<Object>();
	
	
	@Override
	public void run() {
		x = 100;
		y = 100;
		
		try {
			background = ImageIO.read(new File("images/background.png"));
			foreground = ImageIO.read(new File("images/foreground.png"));
			enemy = ImageIO.read(new File("images/enemy.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SpawnEnemy spawnEnemy = new SpawnEnemy();
		//ArrayList<Object> allObjectsList = new ArrayList<Object>();
		
		while(true){
			counter++;
			if (counter >= 4){
				counter = 0;
			}
			
			if (counter == 3){
				for ( int i=0; i<2; i++){
				allObjectsList.add(i, spawnEnemy.SpawnEnemies(eX, eY, enemy, health, points, sizeX, sizeY, state, 2));}
			}
			switch(counter){
			case 0: eX=100; eY=100;break;
			case 1: eX=300; eY=100;break;
			case 2: eX=500; eY=100;break;
			case 3: eX=700; eY=100;break;
			}
			if (left == true){
				x-=2;
			}
			if (right == true){
				x+=2;
			}
			if (up == true){
				y-=2;
			}
			if (down == true){
				y+=2;
			}
			
			
			repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setCursor(null);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if (arg0.getKeyCode() == 37){
			left = true;
		}
		if (arg0.getKeyCode() == 38){
			up = true;
		}
		if (arg0.getKeyCode() == 39){
			right = true;
		}
		if (arg0.getKeyCode() == 40){
			down = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		if (arg0.getKeyCode() == 37){
			left = false;
		}
		if (arg0.getKeyCode() == 38){
			up = false;
		}
		if (arg0.getKeyCode() == 39){
			right = false;
		}
		if (arg0.getKeyCode() == 40){
			down = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("ich wurde gedragt auf "+ arg0.getPoint());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("ich wurde bewegt auf "+ e.getPoint());
		x = e.getX()-10;
		y = e.getY()-10;
		
	}

}

package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class City extends Elements {

	boolean hitTheCity;
	public City(int x, int y) {
		super(x, y);
	}

	public void update() {
		checkForCollisions();		
	}
	
	 public void draw(Graphics2D g2d) {
			g2d.drawImage(getPoint(), 550, 600, null);		
		}

	public Image getPoint() {	
		ImageIcon hitCity;
		if (hitTheCity) {
			hitCity = new ImageIcon("explosion222.png");			
		}
		else {
			hitCity = new ImageIcon("city.png");
		}		
		return hitCity.getImage();
	}
	
	public void checkForCollisions() {
		ArrayList<Target> targets = GameFrame.getTargetsList();		
		for (int i = 0; i < targets.size(); i++) {
			Target currentTarget = targets.get(i);
			if (getBounds().intersects(currentTarget.getBounds())) {
				hitTheCity = true;
			}	
			
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(550, 600, getPoint().getWidth(null),
				getPoint().getHeight(null));
	}		
}
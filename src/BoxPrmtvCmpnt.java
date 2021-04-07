/**
 * 
 * @author Sudipta Sharif
 * Composite Pattern
 */
import java.awt.Color;
import java.awt.Graphics;

public class BoxPrmtvCmpnt extends ShapeCmpnt {
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	
	public BoxPrmtvCmpnt(int x, int y) {
		// Shifting origin of Box to Center it
		super(x - (WIDTH/2), y - (HEIGHT/2));
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(super.getXCoord(), super.getYCoord(), WIDTH, HEIGHT);
	}

}

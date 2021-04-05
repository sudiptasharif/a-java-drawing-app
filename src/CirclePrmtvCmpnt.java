/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 2
 * 
 * Composite Pattern
 * Primitive Component 2: CirclePrimitiveComponent
 */
import java.awt.Color;
import java.awt.Graphics;

public class CirclePrmtvCmpnt extends ShapeCmpnt {
	private static final int RADIUS = 20;
	
	public CirclePrmtvCmpnt(int x, int y) {
		// Shifting origin of Circle to Center it
		super(x - (RADIUS/2), y - (RADIUS/2));
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(super.getXCoord(), super.getYCoord(), RADIUS, RADIUS);
	}
	
}

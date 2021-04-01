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
	private final int RADIUS = 20;
	
	public CirclePrmtvCmpnt(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(super.getXCoord(), super.getYCoord(), RADIUS, RADIUS);
	}
	
}

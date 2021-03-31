/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 1
 * 
 * Composite Pattern
 * Primitive Component 2: CirclePrimitiveComponent
 */
import java.awt.Color;
import java.awt.Graphics;

public class CirclePrimitiveComponent extends ShapeComponent{
	private int radius;
	
	public CirclePrimitiveComponent(int x, int y, int r) {
		super(x, y);
		radius = r;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(super.getXCoord(), super.getYCoord(), radius, radius);
	}
	
}

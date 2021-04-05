/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 2
 * 
 * Composite Pattern
 * Primitive Component 1: BoxPrimitiveComponent
 */
import java.awt.Color;
import java.awt.Graphics;

public class BoxPrmtvCmpnt extends ShapeCmpnt {
	private static final int WIDTH = 20;
	private static final int HEIGHT = 20;
	
	public BoxPrmtvCmpnt(int x, int y) {
		super(x - (WIDTH/2), y - (HEIGHT/2));
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(super.getXCoord(), super.getYCoord(), WIDTH, HEIGHT);
	}

}

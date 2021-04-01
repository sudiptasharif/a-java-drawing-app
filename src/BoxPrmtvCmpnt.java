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
	private final int WIDTH = 20;
	private final int HEIGHT = 20;
	
	public BoxPrmtvCmpnt(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(super.getXCoord(), super.getYCoord(), WIDTH, HEIGHT);
	}

}

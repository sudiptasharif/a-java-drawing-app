/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 1
 * 
 * Composite Pattern
 * Primitive Component 1: BoxPrimitiveComponent
 */
import java.awt.Color;
import java.awt.Graphics;

public class BoxPrimitiveComponent extends ShapeComponent{
	private int width;
	private int height;
	
	public BoxPrimitiveComponent(int x, int y, int w, int h) {
		super(x, y);
		width = w;
		height = h;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(super.getXCoord(), super.getYCoord(), this.width, this.height);
	}

}

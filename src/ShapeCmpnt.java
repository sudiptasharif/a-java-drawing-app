import java.awt.Graphics;

/* 
 * Composite Pattern
 * Component: ShapeComponent 
*/
public abstract class ShapeCmpnt {
	private int xCoord;
	private int yCoord;
	
	public ShapeCmpnt() {
		xCoord = 0;
		yCoord = 0;
	}
	
	public ShapeCmpnt(int x, int y) {
		xCoord = x;
		yCoord = y;
	}
	
	public int getXCoord() {
		return xCoord;
	}

	public int getYCoord() {
		return yCoord;
	}

	public void add(ShapeCmpnt shape) {}
	public ShapeCmpnt remove() {return null;}
	public abstract void draw(Graphics g);
}

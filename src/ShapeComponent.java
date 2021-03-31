import java.awt.Graphics;

/* 
 * Composite Pattern
 * Component: ShapeComponent 
*/
public abstract class ShapeComponent {
	private int xCoord;
	private int yCoord;
	
	public ShapeComponent() {
		xCoord = 0;
		yCoord = 0;
	}
	
	public ShapeComponent(int x, int y) {
		xCoord = x;
		yCoord = y;
	}
	
	public int getXCoord() {
		return xCoord;
	}

	public int getYCoord() {
		return yCoord;
	}

	public void push(ShapeComponent shape) {}
	public ShapeComponent pop() {return null;}
	public boolean empty() {return true;}
	public abstract void draw(Graphics g);
}

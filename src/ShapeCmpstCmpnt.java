import java.awt.Graphics;
import java.util.Stack;

/* 
 * @author Sudipta Sharif
 * Composite Pattern
*/
public class ShapeCmpstCmpnt extends ShapeCmpnt {
	private Stack<ShapeCmpnt> shapeCollection;

	ShapeCmpstCmpnt(){
		super();
		shapeCollection = new Stack<>();
	}
	
	@Override
	public void add(ShapeCmpnt shape) {
		if(shape != null) {
			shapeCollection.push(shape);			
		}
	}
	
	@Override
	public ShapeCmpnt remove() {
		ShapeCmpnt shape = null;
		if(!shapeCollection.empty()) {
			shape = shapeCollection.pop();
		}
		return shape;
	}

	@Override
	public void draw(Graphics g) {
		for(ShapeCmpnt shape: shapeCollection) {
			shape.draw(g);
		}
	}
}

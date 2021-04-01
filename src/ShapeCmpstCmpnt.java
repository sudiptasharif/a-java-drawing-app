import java.awt.Graphics;
import java.util.Stack;

/* 
 * Composite Pattern
 * Composite Component: ShapeCompositeComponent 
*/
public class ShapeCmpstCmpnt extends ShapeCmpnt {
	private Stack<ShapeCmpnt> shapeCollection;

	ShapeCmpstCmpnt(){
		super();
		shapeCollection = new Stack<>();
	}
	
	@Override
	public void add(ShapeCmpnt shape) {
		if(shape != null)
			shapeCollection.push(shape);
	}
	
	@Override
	public ShapeCmpnt remove() {
		return shapeCollection.pop();
	}

	@Override
	public void draw(Graphics g) {
		for(ShapeCmpnt shape: shapeCollection) {
			shape.draw(g);
		}
	}
}

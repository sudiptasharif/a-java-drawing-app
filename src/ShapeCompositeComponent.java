import java.awt.Graphics;
import java.util.Stack;

/* 
 * Composite Pattern
 * Composite Component: ShapeCompositeComponent 
*/
public class ShapeCompositeComponent extends ShapeComponent{
	private Stack<ShapeComponent> shapeCollection;

	ShapeCompositeComponent(){
		super();
		shapeCollection = new Stack<ShapeComponent>();
	}
	
	@Override
	public void push(ShapeComponent shape) {
		shapeCollection.push(shape);
	}
	
	@Override
	public ShapeComponent pop() {
		return shapeCollection.pop();
	}
	
	@Override
	public boolean empty() {
		return shapeCollection.empty();
	}
	
	@Override
	public void draw(Graphics g) {
		for(ShapeComponent shape: shapeCollection) {
			shape.draw(g);
		}
	}
}

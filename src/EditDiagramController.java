/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 1
 * 
 * Controller Pattern
 */
import java.awt.event.MouseEvent;
import java.util.Stack;

public class EditDiagramController {
	private final int BOX_WIDTH = 20;
	private final int BOX_HEIGHT = 20;
	private final int RADIUS = 20;
	private Stack<ShapeComponent> undoCmdStack;
	private ShapeComponent shapeCmpstComponent;
	private Command addShapeCmd;
	private int shapeToDraw;
	
	public EditDiagramController() {
		addShapeCmd = null;
		shapeToDraw = GUI.CODE_NONE;
		undoCmdStack = new Stack<ShapeComponent>();
		shapeCmpstComponent = new ShapeCompositeComponent();
	}
		
	public void setShapeToDraw(int shapeCode) {
		shapeToDraw = shapeCode;
	}
	
	public void addShape(MouseEvent e) {
		ShapeComponent shape;
		
		if(shapeToDraw == GUI.CODE_BOX) 
			shape = new BoxPrimitiveComponent(e.getX(), e.getY(), BOX_WIDTH, BOX_HEIGHT);
		else if(shapeToDraw == GUI.CODE_CIRC) 
			shape = new CirclePrimitiveComponent(e.getX(), e.getY(), RADIUS);
		else 
			shape = null;
		
		addShapeCmd = new AddShapeCommand(shape, shapeCmpstComponent, undoCmdStack);
		addShapeCmd.execute();
	}
	
	public void undoShapeDrawn() {
		if(addShapeCmd != null)
			addShapeCmd.undo();
	}
	
	public void redoShapeDrawn() {
		if(addShapeCmd != null)
			addShapeCmd.redo();
	}
	
	public ShapeComponent getCmpstComponent() {
		return shapeCmpstComponent;
	}
}

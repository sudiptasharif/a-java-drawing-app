/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 1
 * 
 * Command Pattern
 * Concrete Command Class: AddShapeCommand
 */
import java.util.Stack;

public class AddShapeCommand implements Command{
	private ShapeComponent shapeCmpstComponent;
	private Stack<ShapeComponent> undoCmdStack;
	private ShapeComponent shape; 
	
	public AddShapeCommand(ShapeComponent shape, ShapeComponent shapeCmpstComponent, Stack<ShapeComponent> undoCmdStack) {
		this.shapeCmpstComponent = shapeCmpstComponent;
		this.undoCmdStack = undoCmdStack;
		this.shape = shape;
	}
	
	@Override
	public void execute() {
		if(shape != null)
			shapeCmpstComponent.push(shape);
	}

	@Override
	public void undo() {
		if(!shapeCmpstComponent.empty() && reversible())
			undoCmdStack.push(shapeCmpstComponent.pop());	
	}
	
	@Override
	public void redo() {
		if(!undoCmdStack.empty() && reversible())
			shapeCmpstComponent.push(undoCmdStack.pop());			
	}

	@Override
	public boolean reversible() {
		return true;
	}
}

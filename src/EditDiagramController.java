/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 2
 * 
 * Controller Pattern
 */
import java.awt.event.MouseEvent;
import java.util.Stack;

public class EditDiagramController {
	private Stack<Command> cmdHistoryStack;
	private Stack<Command> cmdUndoStack;
	private ShapeCmpnt shapeCmpstComponent;
	private int shapeToDraw;
	
	public EditDiagramController() {
		shapeToDraw = GUI.CODE_NONE;
		shapeCmpstComponent = new ShapeCmpstCmpnt();
		cmdHistoryStack = new Stack<>();
		cmdUndoStack = new Stack<>();
	}
		
	public void setShapeToDraw(int shapeCode) {
		shapeToDraw = shapeCode;
	}
	
	public void addShape(MouseEvent mouseEvent) {
		Command cmd;
		if (shapeToDraw == GUI.CODE_BOX) {
			cmd = new AddBoxCmd(mouseEvent, shapeCmpstComponent);
			cmdHistoryStack.push(cmd);
		} else if (shapeToDraw == GUI.CODE_CIRC) {
			cmd = new AddCircleCmd(mouseEvent, shapeCmpstComponent);
			cmdHistoryStack.push(cmd);
		} else {
			cmd = null;
		}
		if (cmd != null) {
			cmd.execute();
		}

	}
	
	public void undoShapeDrawn() {
		Command cmd;
		if(!cmdHistoryStack.empty()) {
			cmd = cmdHistoryStack.pop();
			cmd.undo();
			cmdUndoStack.push(cmd);
		}
	}
	
	public void redoShapeDrawn() {
		Command cmd;
		if(!cmdUndoStack.empty()) {
			cmd = cmdUndoStack.pop();
			cmd.redo();
			cmdHistoryStack.push(cmd);
		}
	}
	
	public ShapeCmpnt getCmpstComponent() {
		return shapeCmpstComponent;
	}
}

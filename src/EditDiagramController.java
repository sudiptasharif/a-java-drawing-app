/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 2
 * 
 * Controller Pattern
 */
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class EditDiagramController {
	private Stack<Command> cmdHistoryStack;
	private Stack<Command> cmdUndoStack;
	private ShapeCmpnt shapeCmpstComponent;
	private MouseEvent mouseEvent;

	private State addBoxState;
	private State addCircleState;
	private State initState;

	private State state;
	
	public EditDiagramController() {
		shapeCmpstComponent = new ShapeCmpstCmpnt();
		cmdHistoryStack = new Stack<Command>();
		cmdUndoStack = new Stack<Command>();
		addBoxState = AddBoxState.getInstance();
		addCircleState = AddCircleState.getInstance();
		initState = InitState.getInstance();
		state = initState;
		mouseEvent = null;
	}

	public void boxBtnClkd() {
		state = state.boxBtnClkd(this);
	}

	public void circleBtnClkd() {
		state = state.circleBtnClkd(this);
	}

	public void mousePressed (MouseEvent e) {
		this.mouseEvent = e;
		state = state.mousePressed(this);
	}

	public void undoBtnClkd() {
		state = state.undoBtnClkd(this);
	}

	public void redoBtnClkd() {
		state = state.redoBtnClkd(this);
	}

	public Command popCmdHistoryStack() {
		Command poppedCmd = null;
		if(!cmdHistoryStack.empty())
			poppedCmd = cmdHistoryStack.pop();
		return poppedCmd;
	}

	public void pushCmdHistoryStack(Command command) {
		cmdHistoryStack.push(command);
	}

	public Command popCmdUndoStack() {
		Command poppedCmd = null;
		if(!cmdUndoStack.empty())
			poppedCmd = cmdUndoStack.pop();
		return poppedCmd;
	}

	public void pushCmdUndoStack(Command command) {
		cmdUndoStack.push(command);
	}

	public ShapeCmpnt getCmpstComponent() {
		return shapeCmpstComponent;
	}

	public MouseEvent getMouseEvent() {
		return this.mouseEvent;
	}
}

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
	private State state;
	
	public EditDiagramController() {
		state = InitState.getInstance();
	}

	public void boxBtnClkd() {
		state = state.boxBtnClkd();
	}

	public void circleBtnClkd() {
		state = state.circleBtnClkd();
	}

	public void mousePressed (MouseEvent e) {
		state = state.mousePressed(e.getX(), e.getY());
	}

	public void undoBtnClkd() {
		state = state.undoBtnClkd();
	}

	public void redoBtnClkd() {
		state = state.redoBtnClkd();
	}

	public ShapeCmpnt getCmpstComponent() {
		return state.getShapesToDraw();
	}

}

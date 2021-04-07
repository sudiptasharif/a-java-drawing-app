/**
 * 
 * @author Sudipta Sharif
 * Controller Pattern
 */
import java.awt.event.MouseEvent;

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

	public ShapeCmpnt getCmpstCmpnt() {
		return state.getShapesToDraw();
	}

}

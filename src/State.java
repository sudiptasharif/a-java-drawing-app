import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 * State Pattern
 */

public class State {

    public State boxBtnClkd (EditDiagramController subject) { return this; }

    public State circleBtnClkd (EditDiagramController subject) {
        return this;
    }

    public State mousePressed (EditDiagramController subject) { return this; }

    public State undoBtnClkd (EditDiagramController subject) {
        return this;
    }

    public State redoBtnClkd (EditDiagramController subject) {
        return this;
    }
}

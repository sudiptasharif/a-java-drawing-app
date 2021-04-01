import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class InitState extends State {
    private static InitState uniqueInstance;

    private InitState() { }

    public static InitState getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new InitState();
        return uniqueInstance;
    }

    public State boxBtnClkd(EditDiagramController subject) {
        //setCursor(Cursor.CROSSHAIR_CURSOR);
        return AddBoxState.getInstance();
    }

    public State circleBtnClkd(EditDiagramController subject) {
        //setCursor(Cursor.CROSSHAIR_CURSOR);
        return AddCircleState.getInstance();
    }

    public State undoBtnClkd (EditDiagramController subject) {
        Command command = subject.popCmdHistoryStack();
        if(command != null) {
            command.undo();
            subject.pushCmdUndoStack(command);
        }
        return this;
    }

    public State redoBtnClkd (EditDiagramController subject) {
        Command command = subject.popCmdUndoStack();
        if(command != null) {
            command.redo();
            subject.pushCmdHistoryStack(command);
        }
        return this;
    }

}

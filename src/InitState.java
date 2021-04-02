import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class InitState extends State {
    private static InitState uniqueInstance;
    private ShapeCmdMgr cmdMgr;

    private InitState() {
        cmdMgr = ShapeCmdMgr.getInstance();
    }

    public static InitState getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new InitState();
        return uniqueInstance;
    }

    public State boxBtnClkd() {
        //setCursor(Cursor.CROSSHAIR_CURSOR);
        return AddBoxState.getInstance();
    }

    public State circleBtnClkd() {
        //setCursor(Cursor.CROSSHAIR_CURSOR);
        return AddCircleState.getInstance();
    }

    public State undoBtnClkd () {
        cmdMgr.undoOperation();
        return InitState.getInstance();
    }

    public State redoBtnClkd () {
        cmdMgr.redoOperation();
        return InitState.getInstance();
    }

    public ShapeCmpnt getShapesToDraw() {
        return cmdMgr.getShapeCmpstCmpnt();
    }

}

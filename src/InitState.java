/**
 * 
 * @author Sudipta Sharif
 * Singleton Pattern
 * Also part of State Pattern
 */
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
        return AddBoxState.getInstance();
    }

    public State circleBtnClkd() {
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

import java.util.Stack;

/**
 * Singleton
 * Using a Singleton, so that there is only one ShapeCmdMgr to
 * add shapes or undo or redo them
 */
public class ShapeCmdMgr {
    private static ShapeCmdMgr uniqueInstance = null;
    private Stack<Command> cmdHistoryStack;
    private Stack<Command> cmdUndoStack;
    private ShapeCmpnt shapeCmpstCmpnt;

    private ShapeCmdMgr() {
        this.cmdHistoryStack = new Stack<>();
        this.cmdUndoStack = new Stack<>();
        this.shapeCmpstCmpnt = new ShapeCmpstCmpnt();
    }

    public static ShapeCmdMgr getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new ShapeCmdMgr();
        return uniqueInstance;
    }

    public void addBox(int xCoord, int yCoord) {
        Command cmd = new AddBoxCmd(xCoord, yCoord, shapeCmpstCmpnt);
        cmdHistoryStack.push((AddBoxCmd)cmd.execute());
    }

    public void addCircle(int xCoord, int yCoord) {
        Command cmd = new AddCircleCmd(xCoord, yCoord, shapeCmpstCmpnt);
        cmdHistoryStack.push((AddCircleCmd)cmd.execute());
    }

    public void undoOperation() {
        Command cmd;
        if (!cmdHistoryStack.empty()) {
            cmd = cmdHistoryStack.pop();
            cmd.undo();
            cmdUndoStack.push(cmd);
        }
    }

    public void redoOperation() {
        Command cmd;
        if (!cmdUndoStack.empty()) {
            cmd = cmdUndoStack.pop();
            cmd.redo();
            cmdHistoryStack.push(cmd);
        }
    }

    public ShapeCmpnt getShapeCmpstCmpnt() {
        return shapeCmpstCmpnt;
    }

}

public class AddCircleState extends State {
    private static AddCircleState uniqueInstance;

    private AddCircleState() { }

    public static AddCircleState getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new AddCircleState();
        return uniqueInstance;
    }

    public State mousePressed(EditDiagramController subject) {
        Command cmd = new AddCircleCmd(subject.getMouseEvent(), subject.getCmpstComponent());
        cmd.execute();
        subject.pushCmdHistoryStack(cmd);
        //resetCursor();
        return InitState.getInstance();
    }
}

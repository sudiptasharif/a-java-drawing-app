public class AddCircleState extends State {
    private static AddCircleState uniqueInstance;
    private ShapeCmdMgr cmdMgr;

    private AddCircleState() {
           cmdMgr = ShapeCmdMgr.getInstance();
    }

    public static AddCircleState getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new AddCircleState();
        return uniqueInstance;
    }

    public State mousePressed(int xCoord, int yCoord) {
        cmdMgr.addCircle(xCoord, yCoord);
        //resetCursor();
        return InitState.getInstance();
    }
}

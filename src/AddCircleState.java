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
        return InitState.getInstance();
    }
    
	/**
	 * If the Box Button is clicked when in AddCircleState will delegate the
	 * work to InitState which will also change the state
	 * to InitState.
	 */
    public State boxBtnClkd() {
    	return InitState.getInstance().boxBtnClkd();
    }
    
	/**
	 * If Undo/Redo Button is Clicked when in 
	 * Add Circle State, will call the InitState's 
	 * undo/redo button methods to handle those operations
	 * and return to InitState
	 */
    public State undoBtnClkd() {
    	return InitState.getInstance().undoBtnClkd();
    }
    
    public State redoBtnClkd() {
    	return InitState.getInstance().redoBtnClkd();
    }
}

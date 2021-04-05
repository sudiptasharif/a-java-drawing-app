/**
 * State Pattern
 * Singleton Pattern
 */
public class AddBoxState extends State {
    private static AddBoxState uniqueInstance;
    private ShapeCmdMgr cmdMgr;

    private AddBoxState() {
        cmdMgr = ShapeCmdMgr.getInstance();
    }

    public static AddBoxState getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new AddBoxState();
        return uniqueInstance;
    }

    public State mousePressed(int xCoord, int yCoord) {
        cmdMgr.addBox(xCoord, yCoord);
        return InitState.getInstance();
    }
    
	/**
	 * If the Circle Button is clicked when in AddBoxState will delegate the
	 * work to InitState which will also change the state
	 * to InitState.
	 */
    public State circleBtnClkd() {
    	return InitState.getInstance().circleBtnClkd();
    }
    
	/**
	 * If Undo/Redo Button is Clicked when in 
	 * Add Box State, will call the InitState's 
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
	
/**
 * @author Sudipta Sharif
 * State Pattern
 */

public class State {

    public State boxBtnClkd () {
        return this;
    }

    public State circleBtnClkd () {
        return this;
    }

    public State mousePressed (int xCoord, int yCoord) {
        return this;
    }

    public State undoBtnClkd () {
        return this;
    }

    public State redoBtnClkd () {
        return this;
    }

    public ShapeCmpnt getShapesToDraw() {
        return null;
    }
}

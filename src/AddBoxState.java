import com.sun.org.apache.xml.internal.security.Init;

import java.awt.*;
import java.awt.event.MouseEvent;

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

}

import com.sun.org.apache.xml.internal.security.Init;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * State Pattern
 * Singleton Pattern
 */
public class AddBoxState extends State {
    private static AddBoxState uniqueInstance;

    private AddBoxState() { }

    public static AddBoxState getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new AddBoxState();
        return uniqueInstance;
    }

    public State mousePressed(EditDiagramController subject) {
        Command cmd = new AddBoxCmd(subject.getMouseEvent(), subject.getCmpstComponent());
        cmd.execute();
        subject.pushCmdHistoryStack(cmd);
        //resetCursor();
        return InitState.getInstance();
    }

}

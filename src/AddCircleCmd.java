import java.awt.event.MouseEvent;

public class AddCircleCmd implements Command {
    private MouseEvent mouseEvent;
    private ShapeCmpnt shapeCmpstCmpnt;
    private ShapeCmpnt removedCircle;

    public AddCircleCmd(MouseEvent e, ShapeCmpnt shapeCmpstCmpnt) {
        this.mouseEvent = e;
        this.shapeCmpstCmpnt = shapeCmpstCmpnt;
        this.removedCircle = null;
    }

    @Override
    public void execute() {
        shapeCmpstCmpnt.add(new CirclePrmtvCmpnt(mouseEvent.getX(), mouseEvent.getY()));
    }

    @Override
    public void undo() {
        if(reversible()) {
            removedCircle = shapeCmpstCmpnt.remove();
        }
    }

    @Override
    public void redo() {
        if(reversible()) {
            shapeCmpstCmpnt.add(removedCircle);
            removedCircle = null;
        }
    }

    @Override
    public boolean reversible() {
        return true;
    }
}

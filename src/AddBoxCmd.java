import java.awt.event.MouseEvent;

public class AddBoxCmd implements Command {
    private MouseEvent mouseEvent;
    private ShapeCmpnt shapeCmpstCmpnt;
    private ShapeCmpnt removedBox;

    public AddBoxCmd(MouseEvent e, ShapeCmpnt shapeCmpstCmpnt) {
        this.mouseEvent = e;
        this.shapeCmpstCmpnt = shapeCmpstCmpnt;
        this.removedBox = null;
    }
    @Override
    public void execute() {
        shapeCmpstCmpnt.add(new BoxPrmtvCmpnt(mouseEvent.getX(), mouseEvent.getY()));
    }

    @Override
    public void undo() {
        if(reversible()) {
            removedBox = shapeCmpstCmpnt.remove();
        }
    }

    @Override
    public void redo() {
        if (reversible() && removedBox != null) {
            shapeCmpstCmpnt.add(removedBox);
            removedBox = null;
        }
    }

    @Override
    public boolean reversible() {
        return true;
    }
}

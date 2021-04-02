import java.awt.event.MouseEvent;

public class AddBoxCmd implements Command {
    private int xCoord;
    private int yCoord;
    private ShapeCmpnt shapeCmpstCmpnt;
    private ShapeCmpnt removedBox;

    public AddBoxCmd(int xCoord, int yCoord, ShapeCmpnt shapeCmpstCmpnt) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.shapeCmpstCmpnt = shapeCmpstCmpnt;
        this.removedBox = null;
    }
    @Override
    public void execute() {
        shapeCmpstCmpnt.add(new BoxPrmtvCmpnt(xCoord, yCoord));
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

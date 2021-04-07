/**
 * 
 * @author Sudipta Sharif
 * Command Pattern
 */
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
    public Object execute() {
        shapeCmpstCmpnt.add(new BoxPrmtvCmpnt(xCoord, yCoord));
        return this;
    }

    @Override
    public void undo() {
    	removedBox = shapeCmpstCmpnt.remove();
    }

    @Override
    public void redo() {
        shapeCmpstCmpnt.add(removedBox);
        removedBox = null;
    }
}

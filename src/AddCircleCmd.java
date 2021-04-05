public class AddCircleCmd implements Command {
    private int xCoord;
    private int yCoord;
    private ShapeCmpnt shapeCmpstCmpnt;
    private ShapeCmpnt removedCircle;

    public AddCircleCmd(int xCoord, int yCoord,  ShapeCmpnt shapeCmpstCmpnt) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.shapeCmpstCmpnt = shapeCmpstCmpnt;
        this.removedCircle = null;
    }

    @Override
    public Object execute() {
        shapeCmpstCmpnt.add(new CirclePrmtvCmpnt(xCoord, yCoord));
        return this;
    }

    @Override
    public void undo() {
        if(reversible()) {
            removedCircle = shapeCmpstCmpnt.remove();
        }
    }

    @Override
    public void redo() {
        if(reversible() && removedCircle != null) {
            shapeCmpstCmpnt.add(removedCircle);
            removedCircle = null;
        }
    }

    @Override
    public boolean reversible() {
        return true;
    }
}

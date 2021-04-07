/**
 * 
 * @author Sudipta Sharif
 * Command Pattern
 */
public interface Command {
	public Object execute();
	public void undo();
	public void redo();
}

/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 1
 * 
 * Command Pattern
 * Command Interface: Command
 */
public interface Command {
	public void execute();
	public void undo();
	public void redo();
	public boolean reversible();
}

/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 2
 * 
 */
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelCanvas extends JPanel{
	private ShapeCmpnt shapeCmpstComponent;
	
	public PanelCanvas() {
		// Initially empty, nothing to draw yet
		shapeCmpstComponent = new ShapeCmpstCmpnt();
	}
		
	public void setCmpstComponent(ShapeCmpnt cmpstComponent) {
		shapeCmpstComponent = cmpstComponent;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		shapeCmpstComponent.draw(g);
	}
}

/**
 * 
 * @author Sudipta Sharif
 * Expert Pattern
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
		
	public void setCmpstCmpnt(ShapeCmpnt cmpstCmpnt) {
		shapeCmpstComponent = cmpstCmpnt;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		shapeCmpstComponent.draw(g);
	}
}

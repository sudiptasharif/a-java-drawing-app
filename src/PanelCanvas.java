/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 1
 * 
 */
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelCanvas extends JPanel{
	private ShapeComponent shapeCmpstComponent;
	
	public PanelCanvas() {
		// Initially empty, nothing to draw yet
		shapeCmpstComponent = new ShapeCompositeComponent();
	}
		
	public void setCmpstComponent(ShapeComponent cmpstComponent) {
		shapeCmpstComponent = cmpstComponent;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		shapeCmpstComponent.draw(g);
	}
}

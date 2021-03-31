/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 1
 * 
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener, MouseListener{
	public static final String FRAME_TITLE = "CSE 5322 Homework 1";
	public static final String LABEL_BOX = "Box";
	public static final String LABEL_CIRC = "Circle";
	public static final String LABEL_UNDO = "Undo";
	public static final String LABEL_REDO = "Redo";
	public static final int WINDOW_WIDTH = 500;
	public static final int WINDOW_HEIGHT = 250;
	public static final int CODE_NONE = -1;
	public static final int CODE_BOX = 0;
	public static final int CODE_CIRC = 1;
	public static final int CODE_UNDO = 2;
	public static final int CODE_REDO = 3;
	private JPanel panelBtns;
	private PanelCanvas panelCanvas;
	private JButton btnBox;
	private JButton btnCirc;
	private JButton btnUndo;
	private JButton btnRedo;
	private int btnSelected;
	private EditDiagramController editDiagramController;
	
	public GUI(){}
	
	public void start() {
		btnSelected = CODE_NONE;
		editDiagramController = new EditDiagramController();
		setTitle(FRAME_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanelCanvas();
		buildPanelBtns();
		add(panelCanvas, BorderLayout.CENTER);
		add(panelBtns, BorderLayout.EAST);	
		setVisible(true);
	}
	
	private void buildPanelCanvas(){
		panelCanvas = new PanelCanvas();
		panelCanvas.addMouseListener(this);	
	}
	
	private void buildPanelBtns(){
		panelBtns = new JPanel();
		panelBtns.setLayout(new GridLayout(4, 1));
		btnBox = new JButton(LABEL_BOX);
		btnCirc = new JButton(LABEL_CIRC);
		btnUndo = new JButton(LABEL_UNDO);
		btnRedo = new JButton(LABEL_REDO);
		clearAllBtnFocus();
		btnBox.addActionListener(this);
		btnCirc.addActionListener(this);
		btnUndo.addActionListener(this);
		btnRedo.addActionListener(this);		
		panelBtns.add(btnBox);
		panelBtns.add(btnCirc);
		panelBtns.add(btnUndo);
		panelBtns.add(btnRedo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnBox) {
			btnSelected = CODE_BOX;
			editDiagramController.setShapeToDraw(btnSelected);
		}else if(e.getSource() == btnCirc) {
			btnSelected = CODE_CIRC;
			editDiagramController.setShapeToDraw(btnSelected);
		}else if(e.getSource() == btnUndo){
			btnSelected = CODE_UNDO;
			editDiagramController.setShapeToDraw(CODE_NONE);
			editDiagramController.undoShapeDrawn();
			repaint();
		}else {
			btnSelected = CODE_REDO;
			editDiagramController.setShapeToDraw(CODE_NONE);
			editDiagramController.redoShapeDrawn();
			repaint();
		}
		setTargetBtnFocus(btnSelected);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		editDiagramController.addShape(e);
		panelCanvas.setCmpstComponent(editDiagramController.getCmpstComponent());
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void clearAllBtnFocus() {
		btnBox.setFocusPainted(false);
		btnCirc.setFocusPainted(false);
		btnUndo.setFocusPainted(false);
		btnRedo.setFocusPainted(false);
	}
	
	private void setTargetBtnFocus(int btnCode) {
		clearAllBtnFocus();
		
		if(btnCode == CODE_BOX)
			btnBox.setFocusPainted(true);
		else if(btnCode == CODE_CIRC)
			btnCirc.setFocusPainted(true);
		else if(btnCode == CODE_UNDO)
			btnUndo.setFocusPainted(true);
		else if(btnCode == CODE_REDO)
			btnRedo.setFocusPainted(true);
	}
}
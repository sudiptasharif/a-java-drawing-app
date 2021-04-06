/**
 * 
 * @author Sudipta Sharif
 * CSE 5322 Homework 2
 * 
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener, MouseListener{
	public static final String FRAME_TITLE = "CSE 5322 Homework 2";
	public static final String LABEL_BOX = "Box";
	public static final String LABEL_CIRC = "Circle";
	public static final String LABEL_UNDO = "Undo";
	public static final String LABEL_REDO = "Redo";
	public static final int WINDOW_WIDTH = 500;
	public static final int WINDOW_HEIGHT = 250;
	private JPanel panelBtns;
	private PanelCanvas panelCanvas;
	private JButton btnBox;
	private JButton btnCirc;
	private JButton btnUndo;
	private JButton btnRedo;
	private EditDiagramController edCntrlr;

	public GUI(){
		edCntrlr = new EditDiagramController();
		setTitle(FRAME_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanelCanvas();
		buildPanelBtns();
		add(panelCanvas, BorderLayout.CENTER);
		add(panelBtns, BorderLayout.EAST);
		setVisible(true);
	}

	public void buildPanelCanvas(){
		panelCanvas = new PanelCanvas();
		panelCanvas.addMouseListener(this);	
	}
	
	public void buildPanelBtns(){
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
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			edCntrlr.boxBtnClkd();
		}else if(e.getSource() == btnCirc) {
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			edCntrlr.circleBtnClkd();
		}else if(e.getSource() == btnUndo){
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			edCntrlr.undoBtnClkd();
			repaintCanvas();
		}else {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			edCntrlr.redoBtnClkd();
			repaintCanvas();
		}
		setTargetBtnFocus((JButton) e.getSource());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		edCntrlr.mousePressed(e);
		repaintCanvas();
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
	
	public void clearAllBtnFocus() {
		btnBox.setFocusPainted(false);
		btnCirc.setFocusPainted(false);
		btnUndo.setFocusPainted(false);
		btnRedo.setFocusPainted(false);
	}
	
	public void setTargetBtnFocus(JButton selectedBtn) {
		clearAllBtnFocus();
		selectedBtn.setFocusPainted(true);
	}
	
	public void repaintCanvas() {
		panelCanvas.setCmpstComponent(edCntrlr.getCmpstCmpnt());
		clearAllBtnFocus();
		repaint();		
	}
}

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {  // view class
	private String mouseStatus;
	private ArrayList<Dot> dots; 
	private int dotSize;
	public int getDotSize() {
		return dotSize;
	}
	public void setDotSize(int ds) {
		if (ds <= 0) {
			dotSize = 1;
		} else {
			dotSize = ds;
		}
	}
	public void clearDots() {
		dots.clear();
	}
	public ArrayList<Dot> getDots() {
		return dots;
	}
	public void setDots(ArrayList<Dot> dots) {
		this.dots = dots;
	}
	public DrawingPanel() {
		mouseStatus = "Welcome";
		addMouseListener(this);
		addMouseMotionListener(this);
		dots = new ArrayList<Dot>();
		dotSize = 20;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(mouseStatus, 20, 20);
		for (Dot dot : dots) {
			g.fillOval(dot.getX(),dot.getY(),dot.getRadius(),dot.getRadius());
		}

	}
	public String getMouseStatus() {
		return mouseStatus;
	}
	public void setMouseStatus(String ms) {
		mouseStatus = ms;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		mouseStatus = "Mouse entered the panel.";
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		mouseStatus = "Mouse exited the panel.";
		repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		mouseStatus = String.format("mouse clicked at (%d, %d)", e.getX(),e.getY());
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		mouseStatus = String.format("mouse pressed at (%d, %d)", e.getX(),e.getY());
		repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		mouseStatus = String.format("mouse released at (%d, %d)", e.getX(),e.getY());
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseStatus = String.format("mouse moving at (%d, %d)", e.getX(),e.getY());
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseStatus = String.format("mouse dragging at (%d, %d)", e.getX(),e.getY());
		Dot dotty = new Dot(e.getX(),e.getY(),dotSize); 
		dots.add(dotty);
		repaint();
	}
	
}

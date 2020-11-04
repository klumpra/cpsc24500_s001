import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Dot {  // model  -  data
	private int x;
	private int y;
	private int radius;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getRadius() {
		return radius;
	}
	public void setX(int x) {
		this.x = x;  // this.x means the x that is the private data member of *this* class.
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setRadius(int rad) {
		if (rad < 0) {
			radius = 1;
		} else {
			radius = rad;
		}
	}
	public Dot() {
		x = -1;
		y = -1;
		radius = 1;
	}
	public Dot(int x, int y, int rad) {
		setX(x);
		setY(y);
		setRadius(rad);
	}
	// every class ultimately is part of the java.lang.Object family.
	// java.lang.Object introduces 11 functions that every class has and can override.
	// One of the functions that is most useful to override is toString.
	// It allows us to System.out.println(that object) to print a text representation of the object
	@Override
	public String toString() {  // comes from java.lang.Object
		return String.format("%d %d %d",x,y,radius);
	}
}
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
class MenuAndMouseFrame extends JFrame {
	private DrawingPanel pan;
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miClear = new JMenuItem("Clear");
		miClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pan.setMouseStatus("");
				pan.clearDots();
				repaint();
			}
		});
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile.add(miClear);
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Application created by me!");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	public void setupLook() {
		setBounds(100,100,500,500);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		pan = new DrawingPanel();
		c.add(pan,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		panSouth.add(new JLabel("Size"));
		JTextField txtSize = new JTextField(2);
		panSouth.add(txtSize);
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ds = Integer.parseInt(txtSize.getText());
					pan.setDotSize(ds);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"The size must be an integer.");
				}
			}
		});
		panSouth.add(btnChange);
		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu();
	}
	public MenuAndMouseFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
public class DrawingTool {
	public static void main(String[] args) {
		MenuAndMouseFrame frm = new MenuAndMouseFrame();
		frm.setVisible(true);
		Dot dotty = new Dot(17,16,4);
	}
}

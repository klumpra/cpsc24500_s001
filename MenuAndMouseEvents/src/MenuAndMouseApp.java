import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {
	private String mouseStatus;
	public DrawingPanel() {
		mouseStatus = "Welcome";
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(mouseStatus, 20, 20);
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
public class MenuAndMouseApp {
	public static void main(String[] args) {
		MenuAndMouseFrame frm = new MenuAndMouseFrame();
		frm.setVisible(true);
	}
}

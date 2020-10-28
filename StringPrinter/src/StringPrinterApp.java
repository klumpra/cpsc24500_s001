import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class StringPanel extends JPanel {
	private String text; // the text to show
	private Font font;
	public void setText(String s) {
		text = s;
	}
	public String getText() {
		return text;
	}
	public void setFont(String name, int size) {
		if (size < 6) {
			size = 6;
		} 
		font = new Font(name,Font.BOLD,size);
	}
	
	public StringPanel() {
		text = "Welcome!";
		font = new Font("Arial",Font.PLAIN,12);
	}
	public StringPanel(String s) {
		text = s;
		font = new Font("Arial",Font.PLAIN,12);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(font);
		g.drawString(text, 20, 50);
	}
}
class StringPrinterFrame extends JFrame {
	private StringPanel panCenter;
	public void centerFrame() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();  // width and height
		int screenWidth = (int)dim.getWidth();
		int screenHeight = (int)dim.getHeight();
		int frameWidth = 750;
		int frameHeight = 500;
		int left = (screenWidth-frameWidth)/2;
		int top = (screenHeight - frameHeight)/2;
		setBounds(left,top,frameWidth,frameHeight);
	}
	public void setupLook() {
		setTitle("String Printer");
		centerFrame();
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		panCenter = new StringPanel();
		panCenter.setText("Welcome to my program.");
		c.add(panCenter,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JLabel lblText = new JLabel("Text to display: ");
		panSouth.add(lblText);
		JTextField txtStringToShow = new JTextField(20);
		panSouth.add(txtStringToShow);
		JLabel lblFontSize = new JLabel("Font size:");
		panSouth.add(lblFontSize);
		JTextField txtFontSize = new JTextField(2);
		panSouth.add(txtFontSize);
		JTextField txtFontName = new JTextField(10);
		panSouth.add(txtFontName);
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panCenter.setText(txtStringToShow.getText());
				panCenter.setFont(txtFontName.getText(), 
						Integer.parseInt(txtFontSize.getText()));
				repaint();  // forces the whole window to repaint.
			}
		}		
		);
		panSouth.add(btnChange);
		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu();
	}
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miClear = new JMenuItem("Clear");
		miClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panCenter.setText("Welcome to my program.");
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
				JOptionPane.showMessageDialog(null, "Copyright 2020 by Ray Klump");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	public StringPrinterFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
public class StringPrinterApp {
	public static void main(String[] args) {
		StringPrinterFrame frm = new StringPrinterFrame();
		frm.setVisible(true);
	}
}

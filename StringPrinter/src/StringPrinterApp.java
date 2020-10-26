import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	public void setupLook() {
		setTitle("String Printer");
		setBounds(100,100,500,500);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		StringPanel panCenter = new StringPanel();
		panCenter.setText("It is only Monday and that sucks.");
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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class StringPanel extends JPanel {
	private String text; // the text to show
	public void setText(String s) {
		text = s;
	}
	public String getText() {
		return text;
	}
	public StringPanel() {
		text = "Welcome!";
	}
	public StringPanel(String s) {
		text = s;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
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
		JButton btnChange = new JButton("Change");
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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Container;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;

public class FunWithGUIs {
	public static void main(String[] args) {
		JFrame frm = new JFrame();
		frm.setTitle("My First User Interface");
		frm.setBounds(100,100,500,400); //l,t,w,h
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frm.getContentPane();
//		c.setBackground(Color.BLACK);
		JButton btnClick = new JButton("Click Me");
		JLabel lblSouth = new JLabel("I'm from the south y'all.");
		lblSouth.setHorizontalAlignment(SwingConstants.CENTER);
		lblSouth.setFont(new Font("Arial",Font.BOLD,24));
		c.setLayout(new BorderLayout());
		c.add(lblSouth, BorderLayout.SOUTH);
		c.add(btnClick, BorderLayout.CENTER);
		frm.setVisible(true);
	}
}

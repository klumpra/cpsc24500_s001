import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class DrawingPanel extends JPanel {
    /* A JPanel is a lightweight component.
       It renders itself using its built-in paintComponent function.
       Override the paintComponent funcion to draw on it.
       Let's see how.
    */
	private int shapeType;    // 0 will mean oval, 1 will mean rectangle
							  // information hiding 
	public int getShapeType() {              // getter - retrieves private variable value
		return shapeType;
	}
	/*
	public void setShapeType(int val) {      // setters - sets private variable value
		if (val < 0) {
			shapeType = 0;
		} else if (val > 1) {
			shapeType = 1;
		} else {
			shapeType = val;
		}
	}
	*/
	public DrawingPanel() {
		shapeType = 0;
	}
	public void toggleShape() {
		if (shapeType == 0) {
			shapeType = 1;
		} else {
			shapeType = 0;
		}
		repaint();  // this automatically calls paintComponent();
	}
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // to draw the background and borders properly - call the ancestor
                                     // super is synonym for parent
        if (shapeType == 0) {
        	g.drawOval(50,100,100,50);   // left top width and height within the panel
        } else {
        	g.drawRect(50, 100, 100, 50);
        }
    }
}

class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"An external named class generated this.");
	}
}

class FancyCustomFrame extends JFrame {
/*	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"The frame itself generated this.");
	}
*/
    public void setLook(String title, int left, int top, int width, int height) {
        setTitle(title);
        setBounds(left, top, width, height);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        DrawingPanel panCenter = new DrawingPanel();
        c.add(panCenter,BorderLayout.CENTER);
        JButton btnClick = new JButton("Toggle!");
        btnClick.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
      //  		JOptionPane.showMessageDialog(null, "This was created by an anonymous inner class.");
        		panCenter.toggleShape();
        		System.out.println(panCenter.getShapeType());
        		repaint();  // tell the whole frame to repaint
        	}
        });

/*        ButtonHandler handler = new ButtonHandler();
        btnClick.addActionListener(handler);
*/

//        btnClick.addActionListener(this); // this refers to the frame itself
        c.add(btnClick,BorderLayout.SOUTH);
    }
    public FancyCustomFrame() {  // default constructor
        setLook("Fancy Custom Frame",100,100,500,500);  // delegation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public FancyCustomFrame(String title, int left, int top, int width, int height, int closeOp) {
        setLook(title,left,top,width,height);
        setDefaultCloseOperation(closeOp);
    }
}

public class CustomFrame {
    public static void main(String[] args) {
        FancyCustomFrame frm = new FancyCustomFrame();
        frm.setVisible(true);
    }
}
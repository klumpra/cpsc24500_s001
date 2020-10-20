import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;

class DrawingPanel extends JPanel {
    /* A JPanel is a lightweight component.
       It renders itself using its built-in paintComponent function.
       Override the paintComponent funcion to draw on it.
       Let's see how.
    */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // to draw the background and borders properly - call the ancestor
                                     // super is synonym for parent
        g.drawOval(50,100,100,50);   // left top width and height within the panel
    }
}

class FancyCustomFrame extends JFrame {
    public void setLook(String title, int left, int top, int width, int height) {
        setTitle(title);
        setBounds(left, top, width, height);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JButton btnClick = new JButton("Click Me!");
        c.add(btnClick,BorderLayout.SOUTH);
        DrawingPanel panCenter = new DrawingPanel();
        c.add(panCenter,BorderLayout.CENTER);
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
        FancyCustomFrame frm2 = new FancyCustomFrame("My frame", 300, 300, 500,200, JFrame.HIDE_ON_CLOSE);
        frm2.setVisible(true);
    }
}
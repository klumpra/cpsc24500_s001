import javax.swing.JFrame;

public class FunWithCustomFrame  {
	public static void main(String[] args) {
		MyCustomFrame frm = new MyCustomFrame();
		frm.setVisible(true);
		MyCustomFrame frm2 = new MyCustomFrame("A more customize one",200,400,300,700, JFrame.HIDE_ON_CLOSE);
		frm2.setVisible(true);
	}
}

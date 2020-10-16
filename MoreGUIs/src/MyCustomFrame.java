import javax.swing.JFrame;

/**
 * This is a specialized descendant of JFrame.
 * Like JFrame, it is a heavyweight component.
 * It has a content pane - etc. 
 * By making this custom descendant of JFrame,
 * I get a chance to reuse it across multiple apps.
 * OOP is all about that - code reuse.
 * "extends" literally means "is a"
 * @author klumpra
 */
public class MyCustomFrame extends JFrame {
	/*
	 * every class has one or more constructors in it.
	 * A constructor is a function that builds objects. A constructor
	 * a. has the same name as the class
	 * b. sets aside the memory for the object you're creating
	 * c. initializes any pieces of data that your class indicates its objects should have
	 * class = data type; prototype   for building objects
	 * 
	 * A constructor that takes in no parameters is called the "default constructor".
	 * Default - initializes the data of the class according to default values.
	 * 
	 * One or more non-default constructors may also be present.
	 * These take in parameters. Those values are used to initialize the data members of the class.
	 * 
	 */
	// here is the default constructor:
	public MyCustomFrame() {
		this("CustomFrame",100,100,500,500,EXIT_ON_CLOSE);   /* "this(...)" is a 
		keyword in Java that allows you to call some other constructor that is
		defined as part of the class. If this is followed by the name of a function or by
		a variable name, it emphasizes that that other function or variable belongs to
		this class.
		*/
	}
	// non-default constructor
	// This is an example of function overloading - two functions with the same short name
	// differing in the type, order, and / or number of their parameters.
	public MyCustomFrame(String title, int left, int top, int width, int height, int closeAction) {
		setLook(title,left,top,width,height);  // delegation - pass data to another function to handle part of your job
		setDefaultCloseOperation(closeAction);
	}
	public void setLook(String title, int left, int top, int width, int height) {
		setTitle(title);
		setBounds(left,top,width,height);		
	}
}

import java.io.Serializable;

public class Dot implements Serializable {  // model  -  data
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
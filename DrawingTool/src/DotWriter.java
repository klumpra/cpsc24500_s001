import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Writes Dot objects in a variety of file formats.
 * Specifically, it writes text, binary, xml, and json formats for Dot objects.
 * @author klumpra
 *
 */
public class DotWriter {
	/**
	 * This function writes Dot objects to the file named fname.
	 * @param fname the name of the file
	 * @param dots the list of dots to write
	 * @return true if successful, false if an exception happens
	 */
	public boolean writeToText(String fname, ArrayList<Dot> dots) {
		File f = new File(fname);
		return writeToText(f,dots);   // delegation - I am passing the responsibility
			// to the other writeToText function that takes in a File and an ArrayList
			// rather than a String and an array list.
	}
	public boolean writeToText(File f, ArrayList<Dot> dots) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (Dot dot : dots) {
				pw.println(dot);  // dot's toString() will return a string
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean writeToBinary(String fname, ArrayList<Dot> dots) {
		File f = new File(fname);
		return writeToBinary(f,dots);
	}
	
	public boolean writeToBinary(File f, ArrayList<Dot> dots) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(dots);
			oos.close();
			return true; // success
		} catch (Exception ex) {
			return false;
		}
	}
}

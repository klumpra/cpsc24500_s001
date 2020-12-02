import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Writes Dot objects in a variety of file formats.
 * Specifically, it writes text, binary, xml, and json formats for Dot objects.
 * @author klumpra
 *
 */
public class ObjectWriter<T> {
	/**
	 * This function writes Dot objects to the file named fname.
	 * @param fname the name of the file
	 * @param dots the list of dots to write
	 * @return true if successful, false if an exception happens
	 */
	public boolean writeToText(String fname, ArrayList<T> objects) {
		File f = new File(fname);
		return writeToText(f,objects);   // delegation - I am passing the responsibility
			// to the other writeToText function that takes in a File and an ArrayList
			// rather than a String and an array list.
	}
	public boolean writeToText(File f, ArrayList<T> objects) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (T obj : objects) {
				pw.println(obj);  // dot's toString() will return a string
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public boolean writeToBinary(String fname, ArrayList<T> objects) {
		File f = new File(fname);
		return writeToBinary(f,objects);
	}
	public boolean writeToBinary(File f, ArrayList<T> objects) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(objects);
			oos.close();
			return true; // success
		} catch (Exception ex) {
			return false;
		}
	}
	public boolean writeToXML(String fname, ArrayList<T> objects) {
		File f = new File(fname);
		return writeToXML(f,objects);
	}
	public boolean writeToXML(File f, ArrayList<T> objects) {
		try {
			XMLEncoder enc = new XMLEncoder(new 
					BufferedOutputStream(new FileOutputStream(f)));
			enc.writeObject(objects);
			enc.close();			
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean write(String fname, ArrayList<T> objects) {
		File f = new File(fname);
		return write(f,objects);
	}
	/**
	 * This writes dot data to whatever file format the user wants
	 * based on the extension of the file's name
	 * .txt - text
	 * .bin = binary
	 * .xml - xml
	 * .jsn or .json - json
	 * @param f the file object
	 * @param dots the list of dots to write
	 * @return true if successful, false otherwise
	 */
	public boolean write(File f, ArrayList<T> objects) {
		String fname = f.getName().toUpperCase();
		if (fname.endsWith(".TXT")) {
			return writeToText(f,objects);
		}
		if (fname.endsWith(".BIN")) {
			return writeToBinary(f,objects);
		}
		if (fname.endsWith(".XML")) {
			return writeToXML(f,objects);
		}
		return false;  // invalid or unrecognized file type
	}
}

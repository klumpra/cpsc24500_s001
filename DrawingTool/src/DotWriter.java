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
	public boolean writeToXML(String fname, ArrayList<Dot> dots) {
		File f = new File(fname);
		return writeToXML(f,dots);
	}
	public boolean writeToXML(File f, ArrayList<Dot> dots) {
		try {
			XMLEncoder enc = new XMLEncoder(new 
					BufferedOutputStream(new FileOutputStream(f)));
			enc.writeObject(dots);
			enc.close();			
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	public boolean writeToJSON(String fname, ArrayList<Dot> dots) {
		File f = new File(fname);
		return writeToJSON(f,dots);
	}
	public boolean writeToJSON(File f, ArrayList<Dot> dots) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			// define the JSONArray that will hold all the JSon dot objects
			JSONArray array = new JSONArray();
			// define the variable that will the JSON object wrapper for each dot
			JSONObject dotObj;
			for (Dot dot : dots) {
				// create the JSON wrapper object
				dotObj = new JSONObject();
				dotObj.put("x",dot.getX());
				dotObj.put("y",dot.getY());
				dotObj.put("rad",dot.getRadius());
				array.add(dotObj);
			}
			// create the outer JSON object, whose value is the array we just filled
			JSONObject allDots = new JSONObject();
			allDots.put("dots",array);
			pw.println(allDots.toJSONString());
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	public boolean write(String fname, ArrayList<Dot> dots) {
		File f = new File(fname);
		return write(f,dots);
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
	public boolean write(File f, ArrayList<Dot> dots) {
		String fname = f.getName().toUpperCase();
		if (fname.endsWith(".TXT")) {
			return writeToText(f,dots);
		}
		if (fname.endsWith(".BIN")) {
			return writeToBinary(f,dots);
		}
		if (fname.endsWith(".XML")) {
			return writeToXML(f,dots);
		}
		if (fname.endsWith(".JSN") || (fname.endsWith(".JSON"))) {
			return writeToJSON(f,dots);
		}
		return false;  // invalid or unrecognized file type
	}
}

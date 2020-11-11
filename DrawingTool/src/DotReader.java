import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads an arraylist of dots from a file.
 * @author klumpra
 *
 */
public class DotReader {
	public ArrayList<Dot> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
	public ArrayList<Dot> readFromText(File f) {
		try {
			ArrayList<Dot> result = new ArrayList<Dot>();
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			int xpos, ypos, rad;
			Dot dot;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();  // get rid of whitespace at the end
				if (line.length() > 0) {  // prevent processing a blank line
					parts = line.split(" ");
					xpos = Integer.parseInt(parts[0]);
					ypos = Integer.parseInt(parts[1]);
					rad = Integer.parseInt(parts[2]);
					dot = new Dot(xpos, ypos, rad);
					result.add(dot);
				}
			}
			fsc.close();
			return result; 
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;  // object equivalent to false 
		}
	}
	public ArrayList<Dot> readFromBinary(String fname) {
		File f = new File(fname);
		return readFromBinary(f);
	}
	public ArrayList<Dot> readFromBinary(File f) {
		try {
			ArrayList<Dot> dotsRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			dotsRead = (ArrayList<Dot>)ois.readObject();
			ois.close();
			return dotsRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<Dot> read(String fname) {
		File f = new File(fname);
		return read(f);
	}
	public ArrayList<Dot> read(File f) {
		String fname = f.getName().toUpperCase();
		if (fname.endsWith(".TXT")) {
			return readFromText(f);
		}
		if (fname.endsWith(".BIN")) {
			return readFromBinary(f);
		}
		return null;  // unrecognize file type.
	}
}

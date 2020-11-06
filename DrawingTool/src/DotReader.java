import java.io.File;
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
				line = fsc.nextLine();
				parts = line.split(" ");
				xpos = Integer.parseInt(parts[0]);
				ypos = Integer.parseInt(parts[1]);
				rad = Integer.parseInt(parts[2]);
				dot = new Dot(xpos, ypos, rad);
				result.add(dot);
			}
			fsc.close();
			return result; 
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;  // object equivalent to false 
		}
	}

}

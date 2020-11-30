import java.net.URL;
import java.util.Scanner;

/**
 * This will go to a website - the department home page
 * and read the contents of the page and print them to the screen.
 * This illustrates the use of the java.net.URL class.
 * @author klumpra
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			URL link = new URL("http://www.cs.lewisu.edu/mathcs/");
			Scanner sc = new Scanner(link.openStream());
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (Exception ex) {
			System.out.println("Could not reach that site.");
		}
	}
}

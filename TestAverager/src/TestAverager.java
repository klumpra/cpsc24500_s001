import java.util.Scanner;

/**
 * This program reads a tab-separated line of text that looks like this:
 * Ray	78	82	64
 * It's then going to print the user's name and their average score.
 * @author klumpra
 *
 */
public class TestAverager {
	public static void main(String[] args) {
		System.out.print("Enter tab-separated name followed three scores: ");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();  // the line of text
		String[] parts = line.split("\t");   // tab is the delimiter
		String name = parts[0];
		int grade1 = Integer.parseInt(parts[1]);  
		int grade2 = Integer.parseInt(parts[2]);
		int grade3 = Integer.parseInt(parts[3]);
		double average = (grade1+grade2+grade3)/3.0; // int / double -> double
		System.out.printf("%s %.2f\n", name,average);
	}
}

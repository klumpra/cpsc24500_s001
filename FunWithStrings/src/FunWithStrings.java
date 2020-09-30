import java.util.Scanner;
public class FunWithStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a phrase: ");
		String phrase = sc.nextLine();
		System.out.println("The string uppercase is " + phrase.toUpperCase());
		System.out.print("Enter a word to search for: ");
		String searchFor = sc.nextLine();
		int pos = phrase.indexOf(searchFor);
		if (pos < 0) {
			System.out.println("That string is not in the phrase.");
		} else {
			System.out.println("That string was found at location " + pos + ".");
		}
		String partial = phrase.substring(3,10);
		System.out.println("The substring is " + partial);
	}
}

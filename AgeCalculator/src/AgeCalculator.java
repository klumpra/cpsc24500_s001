import java.util.Scanner;
/**
 * This program asks the user for their name and shows them their age in months.
 * It then insults them.
 * @author klumpra
 *
 */
public class AgeCalculator {
	public static void welcome() {
		System.out.println("** Welcome to Age Calculator **");
		System.out.println("Don't be offended by this program.");
	}
	/**
	 * Converts years to months
	 * @param yrs Age in years
	 * @return Age in months
	 */
	public static int getAgeInMonths(int yrs) {
		return yrs * 12;
	}
	public static void main(String[] args) {
		welcome();
		Scanner sc = new Scanner(System.in);
		System.out.print("What is your first name? ");
		String name;
		name = sc.next();
		System.out.print("Enter your age in years, " + name + ": ");
		int age = sc.nextInt();
		int ageInMonths = getAgeInMonths(age);
		System.out.printf("I see, %s, that you are %d months old.\n", name, ageInMonths);
		if (ageInMonths < 120) {
			System.out.println("You live a relatively carefree life.");
		} else if (ageInMonths < 180) {
			System.out.println("Life is getting complicated.");
		} else if (ageInMonths < 240) {
			System.out.println("Life is really getting complicated.");
		} else {
			System.out.println("You have loans to pay.");
		}
		System.out.print("Are you happy? (y or n) ");
		String happyStr = sc.next();
		happyStr = happyStr.toLowerCase().trim();  // trim away whitespace and lower-case it
		if (happyStr.equals("y")) {
			System.out.println("That is nice to hear.");
		} else {
			System.out.println("Cheer up, buttercup.");
		}
	}
}

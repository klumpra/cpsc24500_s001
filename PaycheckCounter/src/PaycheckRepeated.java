import java.util.Scanner;
public class PaycheckRepeated {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double hours,rate,gross;
		String doAgain = "y";
		while (doAgain.equalsIgnoreCase("y")) {
			System.out.print("Enter hourly rate and hours worked: ");
			rate = sc.nextDouble();
			hours = sc.nextDouble();
			gross = hours*rate;
			System.out.printf("Gross pay: $%.2f.\n",gross);
			System.out.print("Again? ");
			doAgain = sc.next().trim();  // gets the user input and trims whitespace
		}
		System.out.println("Thank you.");
	}
}

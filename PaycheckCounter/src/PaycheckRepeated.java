import java.util.Scanner;
public class PaycheckRepeated {
	public static void main(String[] args) {
		System.out.print("How many employees: ");
		Scanner sc = new Scanner(System.in);
		int empCount;
		double hours,rate,gross;
		empCount = sc.nextInt();
		for (int i = 0; i < empCount; i++) {
			System.out.print("Enter hourly rate and hours worked: ");
			rate = sc.nextDouble();
			hours = sc.nextDouble();
			gross = hours*rate;
			System.out.printf("Gross pay: $%.2f.\n",gross);
		}
		System.out.println("Thank you.");
	}
}

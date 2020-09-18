import java.util.Scanner;
/**
 * This application calculates pay for an hourly employee
 * @author klumpra
 *
 */
public class PaycheckCalculator {
	public static double calculateGrossPay(double hours, double pay) {
		double result = hours * pay;
		return result;
	}
	public static void main(String[] args) {
		double hoursWorked;
		double payRate;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter hours worked: ");
		hoursWorked = sc.nextDouble();
		System.out.print("Enter pay rate: ");
		payRate = sc.nextDouble();
		double gross = calculateGrossPay(hoursWorked,payRate);
		System.out.printf("You worked %.2f hours at $%.2f per hour.\n", hoursWorked, payRate);
		System.out.printf("So, you earned a gross pay of $%.2f.\n", gross);
	}
}

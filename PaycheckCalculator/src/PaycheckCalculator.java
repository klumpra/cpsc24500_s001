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
	public static double getTaxRate(double gross) {
		double taxRate;
		if (gross >= 2000) {
			taxRate = 0.25;
		} else if (gross >= 1000) {
			taxRate = 0.2;
		} else {
			taxRate = 0.1;
		}
		return taxRate;
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
		double taxRate = getTaxRate(gross);
		double taxes = taxRate * gross;
		double netPay = gross - taxes;
		System.out.printf("Take home pay is $%.2f.\n", netPay);
	}
}

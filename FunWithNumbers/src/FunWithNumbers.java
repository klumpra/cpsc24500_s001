import java.util.Scanner;
public class FunWithNumbers {
	public static int printMenuAndGetChoice(Scanner sc) {
		int choice;
		do {
			try {
				System.out.println("Here are your options: ");
				System.out.println("1. Add");
				System.out.println("2. Sub");
				System.out.println("3. Mult");
				System.out.println("4. Div");
				System.out.println("5. Quit");
				System.out.print("What is your choice? ");
				choice = sc.nextInt();
			} catch (Exception ex) {
				System.out.println("Enter a number!");
				sc.nextLine();
				choice = 0;
			}
		} while (choice <= 0);
		return choice;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;      // the number of their choice from menu
		int num1, num2;  // 2 numbers they'll enter
		int sum, diff, prod;
		double quot;
		num1 = 5;
		num2 = 3;
		do {
			choice = printMenuAndGetChoice(sc);
			if (choice == 1) {
				sum = num1 + num2;
				System.out.printf("%d + %d = %d\n",num1,num2,sum);
			} else if (choice == 2) {
				diff = num1 - num2;
				System.out.printf("%d - %d = %d\n",num1,num2,diff);				
			} else if (choice == 3) {
				prod = num1 * num2;
				System.out.printf("%d * %d = %d\n",num1,num2,prod);				
			} else if (choice == 4) {
				quot = (double)num1 / num2;
				System.out.printf("%d / %d = %d\n",num1,num2,quot);				
			}
		} while (choice != 5);
	}
}

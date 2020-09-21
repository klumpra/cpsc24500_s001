import java.util.Scanner;
public class FunWithNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;      // the number of their choice from menu
		int num1, num2;  // 2 numbers they'll enter
		int sum, diff, prod, quot;
		num1 = 5;
		num2 = 3;
		do {
			System.out.println("Here are your options: ");
			System.out.println("1. Add");
			System.out.println("2. Sub");
			System.out.println("3. Mult");
			System.out.println("4. Div");
			System.out.println("5. Quit");
			System.out.print("What is your choice? ");
			choice = sc.nextInt();
			if (choice == 1) {
				sum = num1 + num2;
				System.out.printf("%d + %d = %d\n",num1,num2,sum);
			}
		} while (choice != 5);
	}
}

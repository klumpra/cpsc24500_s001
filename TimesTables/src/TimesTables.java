
import java.util.InputMismatchException;
import java.util.Scanner;

public class TimesTables {
	public static void printTimesTables(int cap) {
		int ans;
		for (int i = 1; i <= cap; i++) {
			for (int j = 1; j <= cap; j++) {
				ans = i * j;
				System.out.printf("%d * %d = %d\n", i, j, ans);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cap;
		do {
			try {
				System.out.print("Enter the largest value you want multiplied: ");
				cap = sc.nextInt();
				if (cap <= 0) {
					System.out.println("You need to enter a positive int.");
				}
			} catch (Exception ex) {
				System.out.println("You needed to enter an int.");
				sc.nextLine(); // cleans out the input
				cap = 0;
			}
		} while (cap <= 0);
		printTimesTables(cap);
	}
}

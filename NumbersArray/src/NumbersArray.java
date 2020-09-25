import java.util.Random;
import java.util.Arrays;

/**
 * This program generates an array of 10 random integers
 * @author klumpra
 *
 */
public class NumbersArray {
	public static void printNumbers(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
	public static void main(String[] args) {
		Random rnd = new Random();
		// declare and create the array of 10 ints
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rnd.nextInt(100);
		}
		System.out.println("Here are the numbers: ");
		printNumbers(numbers);
		Arrays.sort(numbers); // sort the list of numbers
		System.out.println("Here are the numbers sorted: ");
		printNumbers(numbers);
		int min = numbers[0];
		int max = numbers[numbers.length-1];
		System.out.printf("The min is %d, and the max is %d.\n",min,max);
	}
}

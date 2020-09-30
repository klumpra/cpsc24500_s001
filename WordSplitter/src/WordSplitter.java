import java.util.Scanner;
import java.util.Arrays;
public class WordSplitter {
	public static void printWords(String[] words) {
		for (String word : words) {
			System.out.println(word);
		}
	}
	public static void makeLowerCase(String[] words) {
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].toLowerCase();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a phrase and I'll chop it up: ");
		String phrase = sc.nextLine();
		String[] words = phrase.split(" ");
		makeLowerCase(words);
		printWords(words);
		Arrays.sort(words);
		System.out.println("In alpha order: ");
		printWords(words);
	}
}

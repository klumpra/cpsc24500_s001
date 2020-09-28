import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FunWithArrayLists {
	public static void printNames(ArrayList<String> names) {
		for (String name : names) {
			System.out.println(name);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ray");
		names.add("Karen");
		names.add("Brody");
		printNames(names);
		System.out.print("Enter another name: ");
		String name = sc.next();
		names.add(1,name);
		System.out.println("Here is the new list of names: ");
		printNames(names);
		Collections.sort(names);
		System.out.println("Here are the names sorted: ");
		printNames(names);
		System.out.print("Enter a name to remove: ");
		name = sc.next();
		names.remove(name);
		printNames(names);
	}
}

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Groceries {
	public static void main(String[] args) {
		// each grocery item will be stored here. The key will be the name of the item.
		// The value will be its cost.
		LinkedHashMap<String, Double> groceries = new LinkedHashMap<String, Double>();
		groceries.put("bread", 1.99);
		groceries.put("milk", 2.19);
		groceries.put("jelly", 0.89);
		System.out.print("What item do you want to purchase? ");
		Scanner sc = new Scanner(System.in);
		String item = sc.next();
		if (groceries.containsKey(item)) {
			System.out.println(groceries.get(item));
		} else {
			System.out.println("Not in list.");
			System.out.println("These are the only items we have: ");
			for (String key : groceries.keySet()) {
				System.out.println("Item: " + key + ", Cost: " + groceries.get(key));
			}
		}
	}
}

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class SemesterGrades {
	public static int showMenuAndGetChoice(Scanner sc) {
		System.out.println("Choose a semester: ");
		System.out.println("1. Fall 2019");
		System.out.println("2. Spring 2020");
		System.out.println("3. Fall 2020");
		System.out.println("4. All sorted by average");
		System.out.println("5. Exit");
		System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		return choice;
	}
	public static double getAverage(String line) {
		String[] parts = line.split("\t");
		double avg = (Integer.parseInt(parts[1]) + 
				Integer.parseInt(parts[2]) + Integer.parseInt(parts[3]))/3.0;
		return avg;
	}
	public static void printStats(ArrayList<String> grades) {
		String [] parts;
		double avg;
		for (String grade : grades) {
			parts = grade.split("\t");
			avg = getAverage(grade);
			System.out.printf("%-10s%6.2f\n",parts[0],avg);
		}
	}
	public static void insertByAverage(ArrayList<String> all, String line) {
		double thisAvg = getAverage(line);
		double otherAvg;
		int pos = -1;
		for (int i = 0; i < all.size(); i++) {
			otherAvg = getAverage(all.get(i));
			if (thisAvg > otherAvg) {
				pos = i;
				break;
			}
		}
		if (pos < 0) {
			all.add(line);
		} else {
			all.add(pos,line);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name of file: ");
		String fname = sc.nextLine();
		ArrayList<String> fa19 = new ArrayList<String>();
		ArrayList<String> sp20 = new ArrayList<String>();
		ArrayList<String> fa20 = new ArrayList<String>();
		ArrayList<String> target = null;
		ArrayList<String> allTogether = new ArrayList<String>();  // option 4
		String line;
		String[] parts;
		String sem;
		boolean canGoAhead;
		int choice;
		try {
			Scanner fsc = new Scanner(new File(fname));
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split("\t");
				if (parts[0].equalsIgnoreCase("SEMESTER")) {
					sem = parts[1].toUpperCase();
					if (sem.equalsIgnoreCase("FA19")) {
						target = fa19;
					} else if (sem.equalsIgnoreCase("SP20")) {
						target = sp20;
					} else if (sem.equalsIgnoreCase("FA20")) {
						target = fa20;
					}
				} else {
					target.add(line);
					insertByAverage(allTogether,line);
				}
			}
			fsc.close();
			canGoAhead = true;
		} catch (Exception ex) {
			System.out.println("Couldn't read the file.");
			canGoAhead = false;
		}
		if (canGoAhead) {
			do {
				choice = showMenuAndGetChoice(sc);
				if (choice == 1) {
					printStats(fa19);
				} else if (choice == 2) {
					printStats(sp20);
				} else if (choice == 3) {
					printStats(fa20);
				} else if (choice == 4) {
					for (String student : allTogether) {
						System.out.println(student);
					}
				}
			} while (choice != 5);
		}	
	}
}


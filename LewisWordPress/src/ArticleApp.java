import java.util.ArrayList;
import java.util.Scanner;
public class ArticleApp {
	public static int showMenuAndGetChoice(Scanner sc) {
		System.out.println("Here are your  choices: ");
		System.out.println("1. Add an article");
		System.out.println("2. Print articles");
		System.out.println("3. Save articles to JSON");
		System.out.println("4. Delete articles");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");
		int result = sc.nextInt();
		sc.nextLine(); // the end-of-line the accompanied what the user typed
		return result;
	}
	public static void printArticles(ArrayList<Article> articles) {
		for (Article article : articles) {
			System.out.println(article);
		}
	}
	public static void main(String[] args) {
		// this will hold all the articles we create
		ArrayList<Article> articles = new ArrayList<Article>();
		Scanner sc = new Scanner(System.in);
		String title, author, text;
		int choice;
		int toRemove;
		String path;
		Article article;
		ArticleWriter aw = new ArticleWriter();
		// this do loop will keep on offering the user choices
		// they will be able to create articles, print them to the
		// screen, remove an article, and write to json
		do {
			choice = showMenuAndGetChoice(sc);
			if (choice == 1) {  // create new article
				System.out.print("Enter title: ");
				title = sc.nextLine();
				System.out.print("Enter author: ");
				author = sc.nextLine();
				System.out.print("Enter text: ");
				text = sc.nextLine();
				article = new Article(title,author,text);
				articles.add(article);
			} else if (choice == 2)  {  // print to screen
				printArticles(articles);
			} else if (choice == 3) {  // print JSON
				System.out.print("Enter file path: ");
				path = sc.nextLine();
				if (aw.writeToJSON(path,articles)) {
					System.out.println("Wrote successfully.");
				} else {
					System.out.println("An error occurred.");
				}
			} else if (choice == 4) {   // delete
				System.out.print("Enter number of article to delete: ");
				toRemove = sc.nextInt();
				articles.remove(toRemove);
			}
		} while (choice != 5);
		System.out.println("Thank you.");
	}
}

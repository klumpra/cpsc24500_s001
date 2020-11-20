/**
 * This is the model class.
 * As the model class, it holds the data we care about.
 * @author klumpra
 *
 */
public class Article {
	private String title;
	private String author;
	private String text;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Article() {
		title = "none";
		author = "none";
		text = "none";
	}
	public Article(String title, String author, String text) {
		setTitle(title);
		setAuthor(author);
		setText(text);
	}
	@Override
	public String toString() {
		return String.format("%s\n%s\n%s",title,author,text);
	}
}

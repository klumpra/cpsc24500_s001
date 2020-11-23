import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ArticleReader {
	public ArrayList<Article> readFromJSON(String fname) {
		ArrayList<Article> articles = new ArrayList<Article>();
		try {
			FileReader reader = new FileReader(new File(fname));
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)parser.parse(reader);
			JSONArray arr = (JSONArray)all.get("articles");
			Iterator itr = arr.iterator();
			/* itr will help us navigate through all the JSONObjects
			 * in the JSONArray arr. So, we will now use a while loop
			 * to do that. As we do, we will recover JSONObjects which
			 * we can convert to Article objects.
			 */
			JSONObject articleObject;
			String title, author, text;
			while (itr.hasNext()) {
				articleObject = (JSONObject)itr.next();
				title = articleObject.get("title").toString();
				author = articleObject.get("author").toString();
				text = articleObject.get("text").toString();
				articles.add(new Article(title,author,text));
			}
			reader.close();
			return articles;
		} catch (Exception ex) {
			return null;
		}
	}
}

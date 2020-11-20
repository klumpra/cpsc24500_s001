
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/** 
 * this is a controller class.
 * It takes our Model (Article) and dumps to a view (a file of JSON data)
 * @author klumpra
 *
 */
public class ArticleWriter {
	public boolean writeToJSON(String fname, ArrayList<Article> articles) {
		try {
			File f = new File(fname);
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			/* strategy for writing json:
			 * 1. create a json array
			 * 2. march through the articles, creating a json object from each and adding to the array
			 * 3. create an outer json object whose value is that array
			 * 4. write the toJSONString version of that.
			 */
			JSONObject obj;  // will point to each article
			JSONArray arr = new JSONArray();
			for (Article article : articles) {
				obj = new JSONObject();
				obj.put("title", article.getTitle());
				obj.put("author", article.getAuthor());
				obj.put("text", article.getText());
				arr.add(obj);
			}
			JSONObject all = new JSONObject();
			all.put("articles",arr);
			pw.println(all.toJSONString());
			pw.close();
			return true;
		} catch(Exception ex) {
			return false;
		}
	}
}

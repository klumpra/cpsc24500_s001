import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {
	public static void main(String[] args) {
		try {
			URL link = new 
			URL("http://cs.lewisu.edu/~klumpra/cpsc24500fall2020/restful/products/read.php");
			Scanner sc = new Scanner(link.openStream());
			String str = "";
			while (sc.hasNextLine()) {
				str = str + " " + sc.nextLine();
			}
			sc.close();
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)(parser.parse(str));
			JSONArray arr = (JSONArray)(all.get("body"));
			Iterator itr = (Iterator)arr.iterator();
			JSONObject obj;
			String sku,name;
			while (itr.hasNext()) {
				obj = (JSONObject)itr.next();
				sku = obj.get("sku").toString();
				name = obj.get("name").toString();
				System.out.printf("%-15s%s\n",sku,name);
			}
		} catch (Exception ex) {
			System.out.println("Couldn't access the website.");
		}
	}
}

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class FindingStock {

	final static String API_KEY = "8IV3PLI59IG081UC";
	public static String share;
	
	public static String gettingPrice (String share ) throws IOException {
		
		String rootURL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + share + "&apikey=" + API_KEY; 
		URL request = new URL (rootURL);
		InputStream openStream = request.openStream();
		String response = IOUtils.toString(openStream);
		JSONObject root = new JSONObject(response);

		JSONObject quote = (JSONObject) root.get("Global Quote");
		String price = (String) quote.get("05. price");
		return price;
	}
	
	public static void main(String[] args) throws IOException {
		String priceFromAPI = gettingPrice("GOOG");

		System.out.println("The price of Google stock is " + priceFromAPI);
	}
}


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class MakeMeRich {
	public static final List<String> symbols = Arrays.asList("AMD", "HPQ",
			"IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE", "AMZN", "CRAY", "CSCO",
			"SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN",
			"YHOO");

	public static void main(String[] args) {

		// 1. Print these symbols using a Java 8 for-each and lambdas
		
		Stream<String> nameOfStocks = symbols.stream();
		nameOfStocks.forEach(System.out::println);

		// 2. Use the StockUtil class to print the price of Bitcoin
		System.out.println(StockUtil.getPrice("BTC-USD"));
		
		// 3. Create a new List of StockInfo that includes the stock price
		List<StockInfo>stockInfo = new ArrayList<StockInfo>();
		
		for (String s : symbols) {
			stockInfo.add(StockUtil.getPrice(s));
			
		}
		System.out.println(stockInfo);
	
		// 4. Find the highest-priced stock under $500
		
		StockInfo highestPricedStockUnder500 = stockInfo.stream().filter(StockUtil.isPriceLessThan(500)).max(Comparator.comparing(s->s.price)).get();
		
		System.out.println("The highest-priced stock under 500 usd is " + highestPricedStockUnder500);
		
		File files = new File ("src");
		File [] listOfFiles = files.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			try {
				String curentFile =  FileUtils.readFileToString(listOfFiles[i]);
				if(!curentFile.contains("Copyrights")) {
					FileUtils.write(listOfFiles[i], "//Copyrights Marko Kozic, 2019 ");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	
	}
	
	
}

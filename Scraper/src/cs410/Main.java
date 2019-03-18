package cs410;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		Scraper scrape = new Scraper();

		String filepath = "src/cs410/index2.html";
		filepath = "https://www.google.com";
		String[] lines = scrape.readInputHTML(Paths.get(filepath));

		// Prints contents of file
		for (int i = 0; i < lines.length; i++) {
			// System.out.println(lines[i]);
		}

		List<String[]> identifiers = scrape.getIdentifiers(lines, "all");
		for (int i = 0; i < identifiers.size(); i++) {
			System.out.println(
					identifiers.get(i)[0] + ", Line:" + identifiers.get(i)[1] + ", Pos:" + identifiers.get(i)[2]);
		}

		// new WebBrowser();
	}

}

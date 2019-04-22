package tools;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Scraper {

	public Scraper() {
		// constructor
	}

	public String[] readInputHTML(Path path) throws IOException {
		List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));
		String[] arr = lines.toArray(new String[lines.size()]);
		System.out.println("Scraper: readInputHTML finished");
		return arr;
	}

	public List<String[]> getIdentifiers(String[] html, String category) {
		List<String[]> identifiers = new ArrayList<String[]>();

		for (int i = 0; i < html.length; i++) {

			if (category == "all") {
				if (html[i].contains("<input") || html[i].contains("<button") || html[i].contains("<INPUT") || html[i].contains("<BUTTON")) {
					int pos = 0;
					if(html[i].contains("id=\"")) {
					  pos = html[i].indexOf("id=\"");
					} else if(html[i].contains("ID=\"")) {
					  pos = html[i].indexOf("ID=\"");
					} else if(html[i].contains("class=\"")) {
					  pos = html[i].indexOf("class=\"");
					} else {
					  pos = html[i].indexOf("CLASS=\"");
					}
					int startingPos = pos;
					if (pos != -1) {
						List<Character> chars = new ArrayList<Character>();
						while (html[i].charAt(pos + 4) != '\"') {
							chars.add(html[i].charAt(pos + 4));
							pos++;
						}
						StringBuilder sb = new StringBuilder();
						for (Character ch : chars) {
							sb.append(ch);
						}
						String string = sb.toString();
						String[] tempArr = new String[] { string, Integer.toString(i), Integer.toString(startingPos) };
						identifiers.add(tempArr);
					}
				}
			}

			if (category == "input") {
				if (html[i].contains("<input")
						&& (html[i].contains("type=\"text\"") || html[i].contains("type=\"password\""))) {
					int pos = html[i].indexOf("id=\"");
					int startingPos = pos;
					if (pos != -1) {
						List<Character> chars = new ArrayList<Character>();
						while (html[i].charAt(pos + 4) != '\"') {
							chars.add(html[i].charAt(pos + 4));
							pos++;
						}
						StringBuilder sb = new StringBuilder();
						for (Character ch : chars) {
							sb.append(ch);
						}
						String string = sb.toString();
						String[] tempArr = new String[] { string, Integer.toString(i), Integer.toString(startingPos) };
						identifiers.add(tempArr);
					}
				}
			}

			if (category == "button") {
				if ((html[i].contains("<input") && html[i].contains("type=\"button\""))
						|| (html[i].contains("<button"))) {
					int pos = html[i].indexOf("id=\"");
					int startingPos = pos;
					if (pos != -1) {
						List<Character> chars = new ArrayList<Character>();
						while (html[i].charAt(pos + 4) != '\"') {
							chars.add(html[i].charAt(pos + 4));
							pos++;
						}
						StringBuilder sb = new StringBuilder();
						for (Character ch : chars) {
							sb.append(ch);
						}
						String string = sb.toString();
						String[] tempArr = new String[] { string, Integer.toString(i), Integer.toString(startingPos) };
						identifiers.add(tempArr);
					}
				}
			}

		}
		return identifiers;
	}

}

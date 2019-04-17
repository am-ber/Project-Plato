package core.elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import core.JavaBrowserLauncher;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import tools.CP;
import tools.Scraper;

public class Browser extends Region {

	public final WebView browser = new WebView();
	public BrowserUI browserUI;
	public String outerHTML;
	public Scraper scrape = new Scraper();
	
	private final WebEngine webEngine = browser.getEngine();
	private JavaBrowserLauncher launcher;

	public Browser(JavaBrowserLauncher launcher) {
		this.launcher = launcher;
		// apply the styles
		getStyleClass().add("browser");
		// load the web page
		webEngine.load(launcher.currentURL);
		// add the web view to the scene
		getChildren().add(browser);
		
		browserUI = new BrowserUI(launcher);
	}
	
	public void setWebPage(String url) {
		webEngine.load(url);
	}
	
	public void updateOuterHtml() {
		printHTML(launcher.cacheLocation);
	}
	
	public void printHTML(String location) {   
		try {
			FileOutputStream fout = new FileOutputStream(location);
			printDocument(webEngine.getDocument(), fout);
		} catch (Exception e) {
			CP.println("OuterHTML error: " + e.getMessage());
		}
	}
	
	public void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
	    TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer transformer = tf.newTransformer();
	    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
	    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	    transformer.transform(new DOMSource(doc), 
	         new StreamResult(new OutputStreamWriter(out, "UTF-8")));
	}

	public Node createSpacer() {
		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		return spacer;
	}

	protected void layoutChildren() {
		double w = getWidth();
		double h = getHeight();
		layoutInArea(browser, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
	}

	protected double computePrefWidth(double height) {
		return 1040;
	}

	protected double computePrefHeight(double width) {
		return 720;
	}
}

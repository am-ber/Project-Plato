package core.elements;

import javafx.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import core.JavaBrowserLauncher;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
//import jdk.nashorn.api.scripting.JSObject;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import tools.CP;
import tools.Scraper;
import javax.script.*;

public class Browser extends Region {

	public final WebView browser = new WebView();
	public BrowserUI browserUI;
	public String outerHTML;
	
	public final WebEngine webEngine = browser.getEngine();
	
	private JavaBrowserLauncher launcher;
	
	private Scraper scrape = new Scraper();
	StringBuilder jQueryContents = new StringBuilder();
	BufferedReader reader;
	String line;

	public Browser(JavaBrowserLauncher launcher) throws IOException {
		this.launcher = launcher;
		// apply the styles
		getStyleClass().add("browser");
		// load the web page
		webEngine.load(launcher.currentURL);
		// add the web view to the scene
		getChildren().add(browser);
		
		browserUI = new BrowserUI(launcher);
		
	  
		browserUI.hackerMenueButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent arg0) {
        launcher.getBrowser().printHTML(launcher.cacheLocation);
        
        String filepath = "res/cache.html";
        String[] lines = null;
        try {
          lines = scrape.readInputHTML(Paths.get(filepath));
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        List<String[]> identifiers = new ArrayList<String[]>();
        identifiers = scrape.getIdentifiers(lines, "all");
        for (int i = 0; i < identifiers.size(); i++) {
          System.out.println(identifiers.get(i)[0] + ", Line:" + identifiers.get(i)[1] + ", Pos:" + identifiers.get(i)[2]);
        }
        
        
        
        executeJquery("inventoryText", "Test text", 0);
        
        
        
        /*
        reader = new BufferedReader(new InputStreamReader(Browser.class.getResourceAsStream("jquery/jquery-3.3.1.min.js")));
        try {
          line = reader.readLine();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        while(line != null) {
          jQueryContents.append(line);
          try {
            line = reader.readLine();
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        browser.getEngine().executeScript(jQueryContents.toString());
        JSObject jQuery = null;
        try {
          //jQuery = (JSObject) browser.getEngine().executeScript("$('body').css('background-color', 'blue');");
          //jQuery = (JSObject) browser.getEngine().executeScript("$('#inventoryBtn').html('testing');");
          jQuery = (JSObject) browser.getEngine().executeScript("$('#inventoryText').val('Injected text');");
        } catch(JSException jse) {
          //
        }
        if(jQuery == null) {
          browser.getEngine().executeScript(jQueryContents.toString());
        }
        */
        
        
        //printHTML(launcher.cacheLocation);
        //webEngine.load("res/cache.html");
        
        
      }
    });
    
		
		
		
		
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

	  transformer.transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(out, "UTF-8")));
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
	
	public void executeJquery(String tag, String val, int flag) {
	  reader = new BufferedReader(new InputStreamReader(Browser.class.getResourceAsStream("jquery/jquery-3.3.1.min.js")));
    try {
      line = reader.readLine();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    while(line != null) {
      jQueryContents.append(line);
      try {
        line = reader.readLine();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    browser.getEngine().executeScript(jQueryContents.toString());
    JSObject jQuery = null;
    try {
      if(flag == 0) {
        // Inserting text
        jQuery = (JSObject) browser.getEngine().executeScript("$('#" + tag + "').val('" + val + "');");
      } else {
        // Click button
        jQuery = (JSObject) browser.getEngine().executeScript("$('#" + tag + "').click();");
      }
    } catch(JSException jse) {
      //
    }
    if(jQuery == null) {
      browser.getEngine().executeScript(jQueryContents.toString());
    }
	}
	
}

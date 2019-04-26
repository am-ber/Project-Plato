package core;

import java.io.FileInputStream;

import core.elements.Browser;
import core.elements.HackingToolsUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import tools.CP;

public class JavaBrowserLauncher extends Application {
	public String currentURL = "https://www.cs.siu.edu/~rstockstill/exstore"; // default https://www.google.com
	public String cacheLocation = "res/cache.html";
	public Scene mainScene;
	public final int initWidth = 1450;
	
	private GridPane mainPane;
	private JavaBrowserUpdateThread updateThread;
	public Browser browser;

	public HackingToolsUI htUI;

	public static void main(String[] args) {
		CP.println("Starting Browser.");
		launch(args);
	}

	@Override
	public void start(Stage primary) throws Exception {
		mainPane = new GridPane();
		browser = new Browser(this);	// Literally pass the launcher just to get the currentURL
		htUI = new HackingToolsUI(this);
		
		// Load in created classes and send the launcher through
		updateThread = new JavaBrowserUpdateThread(this);
		
		// Add elements to GridPane
		mainPane.add(browser.browserUI, 0, 0);
		mainPane.add(browser, 0, 1);
		mainPane.add(htUI, 1, 1);
		
		mainScene = new Scene(mainPane,1450,720);
		
		// try to add the CSS file
		try {
			mainScene.getStylesheets().add(getClass().getResource("default.css").toExternalForm());
		} catch (Exception e) {
			CP.println("¯\\_(ツ)_/¯");
		}
		
		// Set window configurations and add main scene
		primary.setTitle("Plato Browser");
		primary.getIcons().add(new Image(new FileInputStream("res/img/logohatwht.png")));
		primary.setScene(mainScene);
		primary.show();
		updateThread.start();
		
	}
	
	// Is used to communicate to the browser what web page to go to
	public void goToURL(String url) {
		currentURL = url;
		browser.browserUI.searchField.setText(url);
		browser.setWebPage(url);
	}
	
	// Without setting the webpage updates the url from traveling links
	public void setURI(String uri) {
		// Checks to see if the address has actually changed
		if (currentURL.equals(uri)) {
			return;
		}
		currentURL = uri;
		browser.browserUI.searchField.setText(uri);
	}
	
	public Browser getBrowser() {
		return browser;
	}
	
	// Returns the address of the current site
	public String getURI() {
		return browser.browser.getEngine().getDocument().getBaseURI();
	}
	
	// Will tell the browser to refresh the previous saved current URL
	public void refreshURL() {
		browser.setWebPage(currentURL);
	}
	
	// Interrupts the thread safely
	public void stop() {
		updateThread.interrupt();
	}
	
}

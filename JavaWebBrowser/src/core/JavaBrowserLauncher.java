package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tools.CP;
import core.elements.Browser;
import core.elements.BrowserUI;

public class JavaBrowserLauncher extends Application {
	
	public String currentURL = "https://www.google.com";
	
	private Scene mainScene;
	private GridPane mainPane;
	
	private JavaBrowserUpdateThread updateThread;
	private Browser browser;
	private BrowserUI browserUI;

	public static void main(String[] args) {
		CP.println("Starting Browser.");
		launch(args);
	}

	@Override
	public void start(Stage primary) throws Exception {
		mainPane = new GridPane();
		
		// Load in created classes and send the launcher through
		browser = new Browser(this);
		browserUI = new BrowserUI(this);
		updateThread = new JavaBrowserUpdateThread(this);
		
		// Add elements to GridPane
		mainPane.add(browserUI, 0, 0);
		mainPane.add(browser, 0, 1);
		
		mainScene = new Scene(mainPane,1440,720, Color.web("#666970"));
		
		// Set window configurations and add main scene
		primary.setTitle("Plato Browser");
		primary.setScene(mainScene);
		primary.show();
		updateThread.start();
	}
	
	// Is used to communicate to the browser what web page to go to
	public void setURL(String url) {
		currentURL = url;
		browserUI.searchField.setText(url);
		browser.setWebPage(url);
	}
	
	// Without setting the webpage updates the url from traveling links
	public void setURI(String uri) {
		currentURL = uri;
		browserUI.searchField.setText(uri);
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

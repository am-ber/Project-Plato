package core;
//asdfasfa
// testing slkfgjaelkfahfkjfnaskjfn
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tools.CP;

import java.io.FileInputStream;
import java.net.URL;

import core.elements.Browser;
import core.elements.BrowserUI;

public class JavaBrowserLauncher extends Application {
	
	public String currentURL = "https://www.google.com";
	
	private Scene mainScene;
	private GridPane mainPane;
	
	private JavaBrowserUpdateThread updateThread;
	private Browser browser;

	public static void main(String[] args) {
		CP.println("Starting Browser.");
		launch(args);
	}

	@Override
	public void start(Stage primary) throws Exception {
		mainPane = new GridPane();
		browser = new Browser(this);	// Literally pass the launcher just to get the currentURL
		
		// Load in created classes and send the launcher through
		updateThread = new JavaBrowserUpdateThread(this);
		
		// Add elements to GridPane
		mainPane.add(browser.browserUI, 0, 0);
		mainPane.add(browser, 0, 1);
		
		mainScene = new Scene(mainPane,1040,720);
		
		// Add the CSS file
		try {
			URL url = getClass().getResource("/res/default.css");
			if (url != null)
				mainScene.getStylesheets().add(url.toExternalForm());
			else
				CP.println("css file wasn't found, oh well.");
		} catch (Exception e) {
			// do nothing cause we don't care you can't find the css file THAT'S RIGHT THERE
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

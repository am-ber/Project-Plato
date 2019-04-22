package core.elements;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import core.JavaBrowserLauncher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import tools.CP;
import tools.Scraper;

public class BrowserUI extends GridPane {

	public TextField searchField;

	private JavaBrowserLauncher launcher;
	private boolean toggleHackerMenu = true;
	// Buttons
	private Button backButton;
	private Button forwardButton;
	private Button refreshButton;
	private Button goButton;
	public Button hackerMenueButton;

	// Images
	private Image backButtonImage;
	private Image forwardButtonImage;
	private Image refreshButtonImage;
	private Image goButtonImage;
	private Image hackerMenueImage;
	
	public Scraper scrape = new Scraper();

	public BrowserUI(JavaBrowserLauncher launcher) {
		this.launcher = launcher;

		setPadding(new Insets(10, 10, 10, 10));
		getStyleClass().add("dark-background");
		setVgap(5);
		setHgap(5);

		try {
			initImages();
		} catch (FileNotFoundException f) {
			CP.println("Whoops! looks like that file isn't there!");
		} catch (Exception e) {
			CP.println("Something else happened and we can't explain it.");
		}
		initButtons();
		searchField = new TextField(launcher.currentURL);
		searchField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
				if (t.getCode() == KeyCode.ENTER) {
					launcher.goToURL(checkSearchField(searchField.getText()));
				}
			}
		});
		searchField.setPrefColumnCount(68);
		add(searchField, 3, 0);
	}
	
	// Checks the input for basic https and www stuff on an address
	public String checkSearchField(String input) {
		String sender = "";
		if (!input.contains("http://")) {
			if (!input.contains("https://")) {
				sender += "http://";
			}
			if (!input.contains("www.")) {
				sender += "www.";
			}
			return sender += input;
		}
		return input;
	}
	
	// Toggles visibility of hacker menu
	public void toggleHackerMenu() {
		CP.println("Toggled Hacker Menu");
		toggleHackerMenu = !toggleHackerMenu;
		launcher.mainScene.getWindow().setWidth(toggleHackerMenu ? launcher.initWidth : 1200);
		launcher.htUI.setVisible(toggleHackerMenu);
		
		CP.println(launcher.getBrowser().outerHTML);
	}

	// inits the images
	public void initImages() throws FileNotFoundException {
		backButtonImage = new Image(new FileInputStream("res/img/backv2.png"));
		forwardButtonImage = new Image(new FileInputStream("res/img/forwv2.png"));
		refreshButtonImage = new Image(new FileInputStream("res/img/refresh.png"));
		goButtonImage = new Image(new FileInputStream("res/img/search.png"));
		hackerMenueImage = new Image(new FileInputStream("res/img/hackhat.png"));
	}

	// inits the buttons
	public void initButtons() {
		backButton = new Button();
		backButton.setGraphic(new ImageView(backButtonImage));
		add(backButton, 0, 0);

		forwardButton = new Button();
		forwardButton.setGraphic(new ImageView(forwardButtonImage));
		add(forwardButton, 1, 0);

		// Refresh Button
		refreshButton = new Button();
		refreshButton.setGraphic(new ImageView(refreshButtonImage));
		refreshButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				launcher.refreshURL();
			}
		});
		add(refreshButton, 2, 0);

		// Go button
		goButton = new Button();
		goButton.setGraphic(new ImageView(goButtonImage));
		goButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				launcher.goToURL(checkSearchField(searchField.getText()));
			}
		});
		add(goButton, 4, 0);
		
		hackerMenueButton = new Button();
		hackerMenueButton.setGraphic(new ImageView(hackerMenueImage));
		hackerMenueButton.setOnAction(new EventHandler<ActionEvent>() {
		  @Override
			public void handle(ActionEvent arg0) {
				launcher.getBrowser().printHTML(launcher.cacheLocation);
				
				/* Start weird scraper test thing 
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
				  //System.out.println("Hello");
				}
				End weird scraper test thing */
				
			}
		});
		add(hackerMenueButton, 5, 0);
	}
}

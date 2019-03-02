package core.elements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

public class BrowserUI extends GridPane {

	public TextField searchField;

	private JavaBrowserLauncher launcher;

	// Buttons
	private Button backButton;
	private Button forwardButton;
	private Button refreshButton;
	private Button goButton;
	private Button test;

	// Images
	private Image backButtonImage;
	private Image forwardButtonImage;
	private Image refreshButtonImage;
	private Image goButtonImage;

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
		searchField.setPrefColumnCount(50);
		add(searchField, 3, 0);
	}
	
	// Checks the input for basic https and www stuff on an address
	public String checkSearchField(String input) {
		String sender = "";
		if (!input.contains("http://") | !input.contains("https://")) {
			sender += "http://";
			if (!input.contains("www.")) {
				sender += "www.";
			}
			return sender += input;
		}
		return input;
	}

	// inits the images
	public void initImages() throws FileNotFoundException {
		backButtonImage = new Image(new FileInputStream("res/img/back.png"));
		forwardButtonImage = new Image(new FileInputStream("res/img/forw.png"));
		refreshButtonImage = new Image(new FileInputStream("res/img/refresh.png"));
		goButtonImage = new Image(new FileInputStream("res/img/search.png"));
	}

	// inits the buttons
	public void initButtons() {
		backButton = new Button();
		backButton.setStyle("-fx-background-color: #DADADA;" + "-fx-border-color: #797979;");
		backButton.setGraphic(new ImageView(backButtonImage));
		add(backButton, 0, 0);

		forwardButton = new Button();
		forwardButton.setStyle("-fx-background-color: #DADADA;" + "-fx-border-color: #797979;");
		forwardButton.setGraphic(new ImageView(forwardButtonImage));
		add(forwardButton, 1, 0);

		// Refresh Button
		refreshButton = new Button();
		refreshButton.setStyle("-fx-background-color: #DADADA;" + "-fx-border-color: #797979;");
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
		goButton.setStyle("-fx-background-color: #DADADA;" + "-fx-border-color: #797979;");
		goButton.setGraphic(new ImageView(goButtonImage));
		goButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				launcher.goToURL(checkSearchField(searchField.getText()));
			}
		});
		add(goButton, 4, 0);
		
		test = new Button(":o");
		test.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println("Does nothing yet.");
			}
		});
		add(test, 5, 0);
	}
}

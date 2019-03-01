package core.elements;

import core.JavaBrowserLauncher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class BrowserUI extends GridPane {
	
	public TextField searchField;
	
	private JavaBrowserLauncher launcher;
	
	// Buttons
	private Button backButton;
	private Button forwardButton;
	private Button refreshButton;
	private Button goButton;
	
	public BrowserUI(JavaBrowserLauncher launcher) {
		this.launcher = launcher;
		
		setPadding(new Insets(10, 10, 10, 10));
		setVgap(5); 
	    setHgap(5);
	    
		initButtons();
		searchField = new TextField(launcher.currentURL);
		searchField.setPrefColumnCount(50);
		add(searchField, 3, 0);
	}
	
	public void initButtons() {
		backButton = new Button("<-");
		add(backButton, 0, 0);
		
		forwardButton = new Button("->");
		add(forwardButton, 1, 0);
		
		// Refresh Button
		refreshButton = new Button("F5");
		refreshButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				launcher.refreshURL();
			}
		});
		add(refreshButton, 2, 0);
		
		// Go button
		goButton = new Button("O");
		goButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				launcher.setURL(searchField.getText());
			}
		});
		add(goButton, 4, 0);
	}
}

package core.elements;

import core.JavaBrowserLauncher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tools.CP;

public class HackingToolsUI extends GridPane {
	
	@SuppressWarnings("unused")
	private JavaBrowserLauncher launcher;
	
	private Button tautologyAttackButton;
	private Button secondOrderAttackButton;
	private Button attack3Button;
	private Button attack4Button;
	private Button attack5Button;
	
	private Label menuLabel;
	
	public HackingToolsUI(JavaBrowserLauncher launcher) {
		this.launcher = launcher;
		
		setPadding(new Insets(10, 10, 10, 10));
		setVgap(5);
		setHgap(5);
		
		menuLabel = new Label("Hacker Man");
		add(menuLabel, 0, 0);
		initButtons();
	}
	
	public void initButtons() {
		tautologyAttackButton = new Button("Tautology Attack");
		tautologyAttackButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println("");
			}
		});
		add(tautologyAttackButton, 0, 1);
		
		secondOrderAttackButton = new Button("Second Order");
		secondOrderAttackButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println("");
			}
		});
		add(secondOrderAttackButton, 0, 2);
		
		attack3Button = new Button("the 3rd?");
		attack3Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println("");
			}
		});
		add(attack3Button, 0, 3);
		
		attack4Button = new Button("4th ??");
		attack4Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println("");
			}
		});
		add(attack4Button, 0, 4);
		
		attack5Button = new Button("5 ?");
		attack5Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println("");
			}
		});
		add(attack5Button, 0, 5);
	}
}

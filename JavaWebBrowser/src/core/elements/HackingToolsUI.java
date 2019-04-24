package core.elements;

import core.JavaBrowserLauncher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tools.CP;
import tools.BobRoss;

public class HackingToolsUI extends GridPane {
	
	@SuppressWarnings("unused")
	private JavaBrowserLauncher launcher;
	
	private Button tautologyAttackButton;
	private Button secondOrderAttackButton;
	private Button piggyBackQueryButton;
	private Button unionAttackButton;
	private Button storedProcedureButton;
	
	private Label menuLabel;
	
	private BobRoss residentBob;
	
	public HackingToolsUI(JavaBrowserLauncher launcher) {
		this.launcher = launcher;
		
		setPadding(new Insets(10, 10, 10, 10));
		setVgap(5);
		setHgap(5);
		
		menuLabel = new Label("Hacker Man");
		add(menuLabel, 0, 0);
		initButtons();
		
		residentBob = new BobRoss();
	}
	
	public void initButtons() {
		tautologyAttackButton = new Button("Tautology Attack");
		tautologyAttackButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println(residentBob.attack_hot_tautic("Test Base"));
			}
		});
		add(tautologyAttackButton, 0, 1);
		
		secondOrderAttackButton = new Button("Second Order Attack");
		secondOrderAttackButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String args[] = {"admin", "false"};
				CP.println(residentBob.attack_second_order("Test Base", args, "inference"));
			}
		});
		add(secondOrderAttackButton, 0, 2);
		
		piggyBackQueryButton = new Button("Piggy-back Query Attack");
		piggyBackQueryButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println(residentBob.attack_piggy_bois("Test Base", "*", "Table","1=1"));
			}
		});
		add(piggyBackQueryButton, 0, 3);
		
		unionAttackButton = new Button("Union Attack");
		unionAttackButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println(residentBob.attack_union_jack("Test Base", "Attribute", "Table", "1 = 1"));
			}
		});
		add(unionAttackButton, 0, 4);
		
		storedProcedureButton = new Button("Stored Procedure Attack");
		storedProcedureButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println(residentBob.attack_fatty_fatty_boombalady("Test Base", "SHUTDOWN"));
			}
		});
		add(storedProcedureButton, 0, 5);
	}
}

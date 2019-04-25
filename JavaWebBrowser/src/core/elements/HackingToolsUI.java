package core.elements;

import core.JavaBrowserLauncher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import tools.CP;
import tools.BobRoss;

public class HackingToolsUI extends GridPane {
	
	@SuppressWarnings("unused")
	private JavaBrowserLauncher launcher;
	
	private Button tautologyAttackButton;
	private Button secondOrderAttackButton;
	private Button piggyQueryButton;
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
	  Label tautologyAttackTitle = new Label("Tautology Attack");
	  add(tautologyAttackTitle, 0,1);
	  
	  Label tautologyAttackBaseLbl = new Label("Base Text:");
    add(tautologyAttackBaseLbl, 0,2);
	  
    TextField tautologyAttackBaseText = new TextField();
    add(tautologyAttackBaseText, 1, 2);
    
		tautologyAttackButton = new Button("Attack");
		tautologyAttackButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println(residentBob.attack_hot_tautic(tautologyAttackBaseText.getText()));
			}
		});
		add(tautologyAttackButton, 0, 3);
		
		/*
		secondOrderAttackButton = new Button("Second Order Attack");
		secondOrderAttackButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String args[] = {"admin", "false"};
				CP.println(residentBob.attack_second_order("Test Base", args, "inference"));
			}
		});
		add(secondOrderAttackButton, 0, 2);
		*/
		Label piggyAttackTitle = new Label("Piggy Back Attack");
    add(piggyAttackTitle, 0,4);
    
    Label piggyAttackBaseLbl = new Label("Base Text:");
    add(piggyAttackBaseLbl, 0,5);
    
    TextField piggyAttackBaseText = new TextField();
    add(piggyAttackBaseText, 1, 5);
    
    Label piggyAttackAttrLbl = new Label("Attribute:");
    add(piggyAttackAttrLbl, 0,6);
    
    TextField piggyAttackAttrText = new TextField();
    add(piggyAttackAttrText, 1, 6);
    
    Label piggyAttackTableLbl = new Label("Table:");
    add(piggyAttackTableLbl, 0,7);
    
    TextField piggyAttackTableText = new TextField();
    add(piggyAttackTableText, 1, 7);
    
    Label piggyAttackEqualityLbl = new Label("Equality:");
    add(piggyAttackEqualityLbl, 0,8);
    
    TextField piggyAttackEqualityText = new TextField();
    add(piggyAttackEqualityText, 1, 8);
    
    piggyQueryButton = new Button("Attack");
    piggyQueryButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println(residentBob.attack_piggy_bois(piggyAttackBaseText.getText(), piggyAttackAttrText.getText(), piggyAttackTableText.getText(),piggyAttackEqualityText.getText()));
			}
		});
		add(piggyQueryButton, 0, 9);
		
		
		Label unionAttackTitle = new Label("Union Back Attack");
    add(unionAttackTitle, 0,10);
    
    Label unionAttackBaseLbl = new Label("Base Text:");
    add(unionAttackBaseLbl, 0,11);
    
    TextField unionAttackBaseText = new TextField();
    add(unionAttackBaseText, 1, 11);
    
    Label unionAttackAttrLbl = new Label("Attribute:");
    add(unionAttackAttrLbl, 0,12);
    
    TextField unionAttackAttrText = new TextField();
    add(unionAttackAttrText, 1, 12);
    
    Label unionAttackTableLbl = new Label("Table:");
    add(unionAttackTableLbl, 0,13);
    
    TextField unionAttackTableText = new TextField();
    add(unionAttackTableText, 1, 13);
    
    Label unionAttackEqualityLbl = new Label("Equality:");
    add(unionAttackEqualityLbl, 0,14);
    
    TextField unionAttackEqualityText = new TextField();
    add(unionAttackEqualityText, 1, 14);
		
		unionAttackButton = new Button("Attack");
		unionAttackButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println(residentBob.attack_union_jack(unionAttackBaseText.getText(), unionAttackAttrText.getText(), unionAttackTableText.getText(), unionAttackEqualityText.getText()));
			}
		});
		add(unionAttackButton, 0, 15);
		
		Label procAttackTitle = new Label("Stored Procedure Attack");
    add(procAttackTitle, 0,16);
    
    Label procAttackBaseLbl = new Label("Base Text:");
    add(procAttackBaseLbl, 0,17);
    
    TextField procAttackBaseText = new TextField();
    add(procAttackBaseText, 1, 17);
    
    Label procAttackProcLbl = new Label("Procedure:");
    add(procAttackProcLbl, 0,18);
    
    TextField procAttackProcText = new TextField();
    add(procAttackProcText, 1, 18);
		
		storedProcedureButton = new Button("Attack");
		storedProcedureButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CP.println(residentBob.attack_fatty_fatty_boombalady(procAttackBaseText.getText(), procAttackProcText.getText()));
			}
		});
		add(storedProcedureButton, 0, 19);
	}
}

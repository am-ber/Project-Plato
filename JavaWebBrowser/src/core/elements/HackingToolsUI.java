package core.elements;

import core.JavaBrowserLauncher;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class HackingToolsUI extends GridPane {
	
	private JavaBrowserLauncher launcher;
	
	public HackingToolsUI(JavaBrowserLauncher launcher) {
		this.launcher = launcher;
		
		setPadding(new Insets(10, 10, 10, 10));
		setVgap(5);
		setHgap(5);
		
		
	}

}

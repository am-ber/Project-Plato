package core.elements;

import core.JavaBrowserLauncher;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import tools.CP;

public class Browser extends Region {

	private final WebView browser = new WebView();
	private final WebEngine webEngine = browser.getEngine();
	
	private JavaBrowserLauncher launcher;

	public Browser(JavaBrowserLauncher launcher) {
		this.launcher = launcher;
		
		// apply the styles
		getStyleClass().add("browser");
		// load the web page
		webEngine.load("https://www.google.com");
		// add the web view to the scene
		getChildren().add(browser);

	}
	
	public void getHTML() {
		//CP.print(browser.getEngine().getDocument().getBaseURI().toLowerCase());
	}
	
	public void setWebPage(String url) {
		webEngine.load(url);
	}

	private Node createSpacer() {
		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		return spacer;
	}

	protected void layoutChildren() {
		double w = getWidth();
		double h = getHeight();
		layoutInArea(browser, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
	}

	protected double computePrefWidth(double height) {
		return 750;
	}

	protected double computePrefHeight(double width) {
		return 500;
	}
}

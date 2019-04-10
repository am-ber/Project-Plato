package core;

import tools.CP;

public class JavaBrowserUpdateThread extends Thread {

	private JavaBrowserLauncher launcher;

	public JavaBrowserUpdateThread(JavaBrowserLauncher launcher) {
		this.launcher = launcher;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				// Updates the address bar if the user travles
				launcher.setURI(launcher.getURI());
				
				// Waits 0.75 seconds to update
				Thread.sleep(750);
				
			} catch (InterruptedException ex) {
				// Will safely exit the thread
				CP.println("--- Thread interrupted.");
				Thread.currentThread().interrupt();
				return;
			} catch (Exception e) {
				// If the webpage isn't loaded yet it will
				CP.println("--- No webpage yet.");
				try {
					Thread.sleep(2000);
				} catch (Exception e1) {
					CP.println("--- Something else happened.");
					break;
				}
			}
		}
	}
}
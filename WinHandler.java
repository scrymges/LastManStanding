import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

	public class WinHandler extends WindowAdapter {
		JFrame window;

	    public WinHandler(JFrame window) {
	    	this.window = window;
	    }

		public void windowClosing(WindowEvent we) {
			window.dispose();       // Frees native resources.
			System.exit(0);  // Stops the program normally.
	    }
	}
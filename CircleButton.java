import java.awt.*;

import javax.swing.*;
	
public class CircleButton extends JButton{

	private static final long serialVersionUID = 1L;

	public CircleButton(String label) {
		super(label);
	    Dimension size = getPreferredSize();
	    size.width = size.height = Math.max(size.width, size.height);
	    setPreferredSize(size);
	    setContentAreaFilled(false);
	}

	  // Paint the round background and label.
	  protected void paintComponent(Graphics g) {
		  if (getModel().isArmed()) {
			  g.setColor(Color.white);
		  } 
		  else {
			  g.setColor(getBackground());
		  }
		  g.fillOval(15, 15, 175, 175);
		  super.paintComponent(g);
	  }

	  protected void paintBorder(Graphics g) {
	    g.setColor(getForeground());
	    g.drawOval(15, 15, 175, 175);
	  }
}

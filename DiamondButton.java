import java.awt.*;

import javax.swing.*;
	
public class DiamondButton extends JButton{

	private static final long serialVersionUID = 1L;
	  int xPoints[] = {50,100,50,0};
	  int yPoints[] = {0,50,100,500};
	public DiamondButton(String label) {
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
		  g.fillPolygon(xPoints, yPoints, xPoints.length); 
		  super.paintComponent(g);
	  }

	  protected void paintBorder(Graphics g) {
	    g.setColor(getForeground());
	    g.drawPolygon(xPoints,yPoints,xPoints.length);
	  }
}


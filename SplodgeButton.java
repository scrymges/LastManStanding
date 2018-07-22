import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
	
public class SplodgeButton extends JButton{

	private static final long serialVersionUID = 1L;

	public SplodgeButton(String label) {
		super(label);
	    Dimension size = getPreferredSize();
	    size.width = size.height = Math.max(size.width, size.height);
	    setPreferredSize(size);
	    setContentAreaFilled(false);
	}

	  // Paint the round background and label.
	  protected void paintComponent(Graphics g) {
		  Graphics2D g2 = (Graphics2D) g;
		  if (getModel().isArmed()) {
			  g2.setColor(Color.white);
		  } 
		  else {
			  g2.setColor(getBackground());
		  }
		  
		  g2.fill(new QuadCurve2D.Float(25,0,150,6,80,50));
		  g2.fill(new QuadCurve2D.Float(80,50,150,80,60,110));
		  g2.fill(new QuadCurve2D.Float(60,110,0,95,24,40));
		  g2.fill(new QuadCurve2D.Float(20,20,0,14,25,0));
		  g2.fill(new RoundRectangle2D.Float(30,7,50,97,40,40));
		  g2.fill(new Rectangle2D.Float(21,2,35,20));
		  g2.fill(new Rectangle2D.Float(24,40,40,50));
		  g2.fill(new QuadCurve2D.Float(20,8,30,40,40,35));
		  g2.fill(new QuadCurve2D.Float(21,45,50,30,32,25));
		  g2.fill(new QuadCurve2D.Float(50,90,60,130,70,90));
		  super.paintComponent(g);
	  }

	  protected void paintBorder(Graphics g) {
		  Graphics2D g2 = (Graphics2D) g;
		  g2.setColor(getForeground());
		  g2.draw(new QuadCurve2D.Float(25,0,150,6,80,50));
		  g2.draw(new QuadCurve2D.Float(80,50,150,80,60,110));
		  g2.draw(new QuadCurve2D.Float(60,110,0,95,24,40));
		  g2.draw(new QuadCurve2D.Float(24,40,36,30,20,20));
		  g2.draw(new QuadCurve2D.Float(20,20,0,14,25,0));
	  }
}

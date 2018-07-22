/**
 * 
 * @author Steven Scrymgeour
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dummyTest extends JFrame {

	/**
	 * Default serialVerionUID added
	 */
	private static final long serialVersionUID = 1L;
	private JLabel loginlabel1 = new JLabel("Please Enter Your ID Number:");
	private JTextField textField = new JTextField(20);
    private JPanel headpanel = new JPanel();
    private JPanel headpanel1 = new JPanel();

    public class fieldHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			try {
				int time = 30000;
				String name = textField.getText();
				textField.selectAll();
				int layout = 1;
				int setgen = 100;
				int expnum = 0;
				int itnum = 4;
				int fontType = 0;
				int	numcond = 0; // There are 4 different colour conditions
				int	numb = 1; // makes default button squares
				int	filenum = 0;
				new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
				dummyTest.this.dispose();
			}
			catch (Exception e) {
			}
		}  
    }
    
    public dummyTest () {
	    Container pane= getContentPane();     // Fetches the frame's content pane.
	    headpanel.setBackground(Color.white);
	    headpanel1.setBackground(Color.white);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Stops the program
	    setTitle("Word Generation");      // This text appears in the title bar.
	    setSize(1024,740);              
	    setResizable(false);              // Prevents the size from being changed.
	    setLocation(0,0);
	    pane.setBackground(Color.white);        // Sets the frame drawing-area background.
	    
	    loginlabel1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,32));
		headpanel.add(loginlabel1, BorderLayout.CENTER);
		headpanel1.add(textField,BorderLayout.SOUTH);
		textField.addActionListener(new fieldHandler());
		pane.add(headpanel,BorderLayout.NORTH);
		pane.add(headpanel1,BorderLayout.CENTER);

		this.addWindowListener(new WinHandler(this));
		this.setVisible(true);
		
	  }

	  public static void main (String[] args)
	  {
	    new dummyTest(); // Creates the program frame.
	  }
}


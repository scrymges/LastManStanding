/**
 * 
 * @author Steven_Scrymgeour
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class ScrabbleUI extends JFrame {
			
	/**
	 * Default serialVerionUID added
	 */
	private static final long serialVersionUID = 1L;
	private JLabel loginlabel1 = new JLabel("Please Enter Your ID Number:");
	private JTextField textField = new JTextField(20);
    private JPanel headpanel = new JPanel();
    private JPanel headpanel1 = new JPanel();
    private Random generator = new Random();
    
    public class fieldHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			try {
				Scanner s = new Scanner(new File("ExperimentNumbers.txt"));
				int expnum = s.nextInt();
				int itnum = s.nextInt();
				int time = s.nextInt();
				String name = textField.getText();
				textField.selectAll();
				int layout = 1;
				int setgen = generator.nextInt(16);
				setgen++;
				int fontType = 0;
				int filenum = 0;
				int numcond;
				int numb = 1; // makes default button squares
				if (expnum == 1) { // 1 means carry out the colour experiment
					numcond = 4; // There are 4 different colour conditions					
					filenum = 1; //makes 1st filenum the first file
					new ScrabbleTaskUI("colourcondition"+filenum+".txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
				}
				else if(expnum == 2) {
					numcond = 6;
					new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);			
				}
				else if (expnum == 3){
					numcond = 3;
					new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
				}
				else if (expnum == 4){
					numcond = 4;
					fontType = 1;
					new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
				}
				s.close();
				ScrabbleUI.this.dispose();
			}
			catch (Exception e) {
			}
		}  
    }
    
    public ScrabbleUI () {
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
	    new ScrabbleUI(); // Creates the program frame.
	  }
}

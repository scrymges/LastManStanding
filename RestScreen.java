/**
 * 
 * @author Steven Scrymgeour
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RestScreen extends JFrame {
			
	/**
	 * Default serialVerionUID added
	 */
	private static final long serialVersionUID = 1L;
    private JPanel headpanel = new JPanel();
    private JLabel continuelabel = new JLabel("Press Any Key to Quit Rest Period...");
    private int resttime = 30000;
    private Timer timer;   
    private static String filename,name;
    private static int expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType;
    
    public class KListener extends KeyAdapter{
        public void keyPressed(KeyEvent ke){
        	timer.stop();
        	Toolkit.getDefaultToolkit().beep();
        	new ScrabbleTaskUI(filename,name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
        	RestScreen.this.dispose();
        }
      }  
    
    public class timerHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			timer.stop();
			Toolkit.getDefaultToolkit().beep();
			new ScrabbleTaskUI(filename,name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
			RestScreen.this.dispose();
		}  
    }
    
    public RestScreen (String filename, String name,int expnum,int itnum, int numcond, int time,int filenum,int numb, int setgen, int layout,int fontType) {
    	RestScreen.filename = filename;
    	RestScreen.name = name;
    	RestScreen.expnum = expnum;
    	RestScreen.itnum = itnum;
    	RestScreen.numcond = numcond;
    	RestScreen.time = time;
    	RestScreen.filenum = filenum;
    	RestScreen.numb = numb;
    	RestScreen.setgen = setgen;
    	RestScreen.layout = layout;
    	RestScreen.fontType = fontType;
	    addKeyListener(new KListener());
	    headpanel.setBackground(Color.white);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Stops the program
	    setTitle("Word Generation");      // This text appears in the title bar.
	    setSize(Toolkit.getDefaultToolkit().getScreenSize());              
	    setResizable(false);              // Prevents the size from being changed.
	    setLocation(0,0);
	    setBackground(Color.white);        // Sets the frame drawing-area background.
	    timer = new Timer(resttime,new timerHandler()); // Performs action every 30 seconds
	    continuelabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,32));
	    headpanel.add(continuelabel,BorderLayout.CENTER);
		add(headpanel,BorderLayout.CENTER);
		this.addWindowListener(new WinHandler(this));
		this.setVisible(true);		
		Toolkit.getDefaultToolkit().beep();
		timer.start();
	  }

	  public static void main (String[] args)
	  {
		  new RestScreen(filename,name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
	  }
}

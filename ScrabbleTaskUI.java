/**
 * 
 * @author Steven Scrymgeour
 *
 */
import javax.swing.*;	
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class ScrabbleTaskUI extends JFrame {
	/**
	 * Default serialVerionUID added
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea = new JTextArea();
	private static int expnum,itnum,time,gameCount,numcond,filenum,numb,setgen,layout,fontType;	private int vowelCount = 0;
	private static Timer timer;
	private static String name,filename;
	private static String outputs="";
	private static Formatter f;	private static int practiceNum = 8;
	private Random generator = new Random();
	private JPanel headpanel = new JPanel();
	private JPanel headpanel1 = new JPanel();
	private int numTiles = 9;
	private JButton[] tiles = new JButton[numTiles];	private static int[] capacityCheck = new int[7];
	private static String[] tempLetters = new String[9];
	private static int[] letsetCheck = new int[17];
	public class timerHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {  
			Toolkit.getDefaultToolkit().beep();
			ScrabbleTaskUI.gameCount++;
			timer.stop();
			if (expnum == 0) { // dummyTest Experiment
				if (gameCount != 4) {
					setgen++;
					new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
				}
				else {
					System.exit(0);
				}
			}
			else {							letsetCheck[setgen]+=1;				int prevSet = setgen;				int rando = 0;				boolean contin = false;				boolean same = true;				while (!contin) {					rando = generator.nextInt(16);					rando++;					same = true;					if ((setgen != rando) && (letsetCheck[rando] <= 2)) {						int lowest = letsetCheck[rando];						for (int i = 1; i <= 16; i++) {							if (lowest > letsetCheck[i]) {								same = false;							}						}						if (same) {							contin = true;						}					}				}				setgen = rando; // Ensures different letter set is used for the next condition							contin = false;												if (gameCount < practiceNum) {					
					if (expnum == 1) {// colour experiment						if (filenum < 4) {							filenum++;							if (gameCount == 6) {								new RestScreen("colourcondition"+filenum+".txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
							}							else {								new ScrabbleTaskUI("colourcondition"+filenum+".txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
							}						}
						else {							filenum = 1;							new ScrabbleTaskUI("colourcondition"+filenum+".txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);						
						}					}
					else if (expnum == 2) { //shape experiment						if (gameCount == 6) {							numb = 1;							new RestScreen("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
						}						else {							numb++;							new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);					
						}					}
					else if (expnum == 3){ // layout experiment						if (layout < 3) {							layout++;							new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);					
						}						else {							layout = 1;							if (gameCount == 6) {								new RestScreen("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
							}							else {								new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
							}						}										}								else if (expnum == 4){ // font experiment						if (fontType < 4) {							fontType++;							new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);											}						else {							fontType = 1;							if (gameCount == 6) {								new RestScreen("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);							}							else {								new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);							}						}										}				}
				else if (gameCount == practiceNum){					contin = false;								while (!contin) { 						rando = generator.nextInt(numcond);						rando++;						if (expnum == 1){							if (rando != filenum) {								contin = true;							}						}						else if (expnum == 2){							if (rando != numb) {								contin = true;							}						}						else if (expnum == 3){							if (rando != layout) {								contin = true;							}						}						else if (expnum == 4){							if (rando != fontType) {								contin = true;							}						}					}					
					if (expnum == 1) { //colour experiment												filenum = rando; // Ensures file from last task are not used consecutively						new ScrabbleTaskUI("colourcondition"+filenum+".txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
					}
					else if (expnum == 2) { // shape experiment
						numb = rando;						new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
					}						else if (expnum == 3){// layout experiment
						layout = rando;						new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);				
					}					else if (expnum == 4){// font experiment						fontType = rando;						new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);									}							}
				else { // gameCount > practiceNumber					try {					if (expnum == 1) {						outputs += ("ID "+name + " ExperimentNumber "+ expnum +" ColourCondition "+ filenum+" LetterSet "+ prevSet +" Letters=" + tiles[0].getText()+"," +tiles[1].getText()+","+tiles[2].getText()+","+tiles[3].getText()+","+tiles[4].getText()+","+tiles[5].getText()+","+tiles[6].getText()+","+tiles[7].getText()+","+tiles[8].getText()+ "  WordsEntered= "+textArea.getText()+ System.getProperty("line.separator"));					}					else if (expnum == 2) {						outputs += ("ID "+name + " ExperimentNumber "+ expnum +" ShapeConditionNumber "+ numb+" LetterSet "+ prevSet +" Letters=" + tiles[0].getText()+"," +tiles[1].getText()+","+tiles[2].getText()+","+tiles[3].getText()+","+tiles[4].getText()+","+tiles[5].getText()+","+tiles[6].getText()+","+tiles[7].getText()+","+tiles[8].getText()+ " Words Entered= "+textArea.getText()+ System.getProperty("line.separator"));					}					else if (expnum == 3) {						outputs += ("ID "+name + " ExperimentNumber "+ expnum +" LayoutConditionNumber "+ layout+" LetterSet "+ prevSet +" Letters=" + tiles[0].getText()+"," +tiles[1].getText()+","+tiles[2].getText()+","+tiles[3].getText()+","+tiles[4].getText()+","+tiles[5].getText()+","+tiles[6].getText()+","+tiles[7].getText()+","+tiles[8].getText()+ " WordsEntered= "+textArea.getText()+ System.getProperty("line.separator"));					}					else if (expnum == 4) {						outputs += ("ID "+name + " ExperimentNumber "+ expnum +" FontConditionNumber "+ fontType+" LetterSet "+ prevSet +" Letters=" + tiles[0].getText()+"," +tiles[1].getText()+","+tiles[2].getText()+","+tiles[3].getText()+","+tiles[4].getText()+","+tiles[5].getText()+","+tiles[6].getText()+","+tiles[7].getText()+","+tiles[8].getText()+ " WordsEntered= "+textArea.getText()+ System.getProperty("line.separator"));					}
					String[] finalOutputs = {outputs};					ScrabbleTaskUI.f.format("%s",finalOutputs);					if (ScrabbleTaskUI.gameCount == (itnum*numcond+practiceNum)) { // number of iterations * number of conditions + practiceNum						ScrabbleTaskUI.f.close();						System.exit(0);					}										contin = false;											int num=0;										if (expnum==1) {						num = filenum;					}					else if (expnum==2) {						num = numb;					}					else if (expnum==3) {						num = layout;					}					else if (expnum==4) {						num = fontType;					}					capacityCheck[num] +=1;										while (!contin) { 						rando = generator.nextInt(numcond);						rando++;						boolean theSame = true;						if ((rando != num) && (capacityCheck[rando] < itnum)) {							int lowest = capacityCheck[rando];							for(int i = 1; i <= numcond; i++) {								if (lowest > capacityCheck[i]) {									theSame = false;								}							}							if (theSame) {								contin = true;							}						}					}			
					if (expnum == 1) {	// Colour Experiment									filenum = rando;
						if (ScrabbleTaskUI.gameCount%6 == 0) {
							new RestScreen("colourcondition"+filenum+".txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
						}
						else {
							new ScrabbleTaskUI("colourcondition"+filenum+".txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);							
						}
					}				
					else if (expnum == 2) { // Shape Experiment
						numb = rando;
						if (ScrabbleTaskUI.gameCount%6 == 0) {
							new RestScreen("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);						
						}
						else {							new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
						}
					}
					else if (expnum == 3) { // Layout Experiment
						layout = rando;
						if (ScrabbleTaskUI.gameCount%6 == 0) {
							new RestScreen("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);
						}
						else {
							new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);								
						}
					}					else if (expnum == 4) { // Font Experiment						fontType = rando;						if (ScrabbleTaskUI.gameCount%6 == 0) {							new RestScreen("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);						}						else {							new ScrabbleTaskUI("basecolour.txt",name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType);														}					}
				}			
				catch (Exception e) {e.printStackTrace();}
				}
			}			ScrabbleTaskUI.this.dispose();		}
	}
	public ScrabbleTaskUI(String filename, String name,int expnum,int itnum, int numcond, int time,int filenum,int numb, int setgen,int layout,int fontType) {
		ScrabbleTaskUI.filename = filename;
		ScrabbleTaskUI.name = name;
		ScrabbleTaskUI.expnum = expnum;
		ScrabbleTaskUI.itnum = itnum;
		ScrabbleTaskUI.numcond = numcond;
		ScrabbleTaskUI.filenum = filenum;
		ScrabbleTaskUI.numb = numb;
		ScrabbleTaskUI.time = time;
		ScrabbleTaskUI.setgen = setgen;
		ScrabbleTaskUI.layout = layout;		ScrabbleTaskUI.fontType = fontType;
		Container pane= getContentPane();     // Fetches the frame's content pane.
		pane.setLayout(new GridBagLayout());
		headpanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		try {
			Scanner s = new Scanner(new File(filename));
			int headRed = s.nextInt();
			int headGreen = s.nextInt();
			int headBlue = s.nextInt();
			headpanel.setBackground(new Color(headRed,headGreen,headBlue));
			headpanel1.setBackground(new Color(headRed,headGreen,headBlue));
			ScrabbleTaskUI.f = new Formatter(name+".txt");
			timer = new Timer(time,new timerHandler()); // Performs action every 30 seconds
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Stops the program
			setTitle("Word Generation");      // This text appears in the title bar.
			setSize(1024,740);
			setResizable(false);              // Prevents the size from being changed.
			setLocation(0,0);
			pane.setBackground(new Color(headRed,headGreen,headBlue));  // Sets the frame drawing-area background.
			textArea.setRows(10);
			textArea.setVisible(true);
			textArea.setColumns(100);
			textArea.setBorder(BorderFactory.createLineBorder(Color.black));
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setBackground(Color.white);
			int[] tileArray = new int[tiles.length];
			for(int  i = 0; i < tiles.length; i++) {
				tileArray[i] = 0;
			}	
			int randplace = 0;
			Scanner sc = new Scanner(new File("Letters"+setgen+".txt"));
			JScrollPane scrollpane = new JScrollPane(textArea);
			Font baseFont = new Font("Arial",Font.PLAIN,28);			Font georgiaFont = new Font("Georgia",Font.PLAIN,28);			Font timesFont = new Font("Times New Roman",Font.PLAIN,28);			Font verdanaFont = new Font("Verdana",Font.PLAIN,28);			Font verdanaItalicFont = new Font("Verdana",Font.ITALIC,28);			
			if (ScrabbleTaskUI.layout == 1 || ScrabbleTaskUI.layout ==2) {	    	
				int count = 0;
				while (count < tiles.length) {
					String letter = sc.next();
					boolean fini = false;
					while(!fini) {
						randplace = generator.nextInt(9);
						if (tileArray[randplace] == 0) {
							fini = true;
						}
					}
					tileArray[randplace] += 1;
					if (ScrabbleTaskUI.numb == 1) {	
						tiles[randplace] = new SquareButton(letter);					}
					else if (ScrabbleTaskUI.numb == 2) {
						tiles[randplace] = new RoundedSquareButton(letter);
					}
					else if (ScrabbleTaskUI.numb == 3) {
						tiles[randplace] = new CircleButton(letter);
					}
					else if (ScrabbleTaskUI.numb == 4) {
						tiles[randplace] = new TriangleButton(letter);
					}					else if (ScrabbleTaskUI.numb == 5) {
						tiles[randplace] = new SplatButton(letter);
					}
					else {
						tiles[randplace] = new SplodgeButton(letter);
					}					if (fontType == 0) {
					tiles[randplace].setFont(baseFont);					}					else if (fontType == 1){						tiles[randplace].setFont(georgiaFont);						}					else if (fontType == 2){						tiles[randplace].setFont(timesFont);						}					else if (fontType == 3){						tiles[randplace].setFont(verdanaFont);					}					else if (fontType == 4){						tiles[randplace].setFont(verdanaItalicFont);					}					
					tiles[randplace].setBackground(Color.white);
					count++;
				}	    
				if (ScrabbleTaskUI.layout == 1) {
					int x = 0; int y = 1;
					c.ipady = 95;
					c.ipadx = 105;
					c.insets = new Insets(10,30,40,30); 
					for(int i =0; i < 3; i++) {
						c.gridx = x;
						c.gridy = y;
						pane.add(tiles[i], c);
						x++;
					}
					x-=3;
					y++;
					for(int i =3; i < 6; i++) {
						c.gridx = x;
						c.gridy = y;
						pane.add(tiles[i], c);
						x++;
					}
					x-=3;
					y++;
					for(int i = 6; i < tiles.length; i++) {
						c.gridx = x;
						c.gridy = y;
						pane.add(tiles[i], c);
						x++;
					}
					c.ipadx = 0;
					x-=3;  	
					y++;
					c.gridwidth = 4; 
					c.fill = GridBagConstraints.BOTH;
					c.gridx = x;
					c.gridy = y;
					pane.add(scrollpane,c);
				}
				else {
					int x = generator.nextInt(5);
					int y = 0;
					c.gridx = x;
					c.gridy = y;
					c.ipady = 95;
					c.ipadx = 105;
					c.insets = new Insets(10,30,30,30); 
					pane.add(tiles[0],c);					c.insets = new Insets(50,30,30,0); 
					int x1 = generator.nextInt(5);					while (x == x1) {
						x1 = generator.nextInt(5);
					}
					c.gridx =  x1;
					c.gridy = y;
					pane.add(tiles[1],c);
					c.insets = new Insets(10,30,20,10); 
					int x2 = generator.nextInt(5);
					while ((x2 == x1) || (x2 == x)) {
						x2 = generator.nextInt(5);
					}
					c.gridx = x2;
					c.gridy = y;
					pane.add(tiles[2],c);
					x = generator.nextInt(5);
					y++;
					c.gridx =  x;
					c.gridy = y;					c.insets = new Insets(50,30,10,10); 
					pane.add(tiles[3],c);
					x1 = generator.nextInt(5);
					while (x == x1) {
						x1 = generator.nextInt(5);
					}
					c.gridx =  x1;
					c.gridy = y;
					pane.add(tiles[4],c);
					x2 = generator.nextInt(5);
					while ((x2 == x1)||(x2 == x)) {						x2 = generator.nextInt(5);
					}
					c.gridx = x2;
					c.gridy = y;					c.insets = new Insets(10,30,20,10); 
					pane.add(tiles[5],c);
					x = generator.nextInt(5);
					y++;
					c.gridx =  x;
					c.gridy = y;
					pane.add(tiles[6],c);
					x1 = generator.nextInt(5);
					while (x == x1) {
						x1 = generator.nextInt(5);
					}
					c.gridx =  x1;
					c.gridy = y;					c.insets = new Insets(50,30,10,0);
					pane.add(tiles[7],c);	
					x2 = generator.nextInt(5);
					while ((x2 == x1) || (x2 == x)) {
						x2 = generator.nextInt(5);
					}
					c.gridx =  x2;
					c.gridy = y;					c.insets = new Insets(10,30,20,10);
					pane.add(tiles[8],c);		    
					x = 1;	    	
					y++;
					c.ipadx = 0;
					c.gridwidth = 3;					c.fill = GridBagConstraints.BOTH;
					c.gridx = x;					c.gridy = y;
					pane.add(scrollpane,c);
				}
			}
			else if(ScrabbleTaskUI.layout == 3) {
				int counter = 0;
				while(counter < tiles.length) {				
					String letter = sc.next();
					if (letter.equals("A") || letter.equals("E") ||letter.equals("I") ||letter.equals("O") || letter.equals("U"))  {
						tempLetters[vowelCount] = letter;
						vowelCount++;
					}
					else {
						tempLetters[counter] = letter;
					}
					counter++;
				}
				for(int i = 0; i < tiles.length; i++) {				
					String letter = tempLetters[i];
					boolean fini = false;
					int rand = 0;
					if (letter.equals("A") || letter.equals("E") ||letter.equals("I") ||letter.equals("O") || letter.equals("U"))  {												while(!fini) {
							rand = generator.nextInt(vowelCount);
							if (tileArray[rand] == 0) {
								fini = true;
							}
						}
						tileArray[rand] += 1;											}					else {
						while(!fini) {
							rand  = generator.nextInt(tiles.length);
							if (rand >= vowelCount) {
								if (tileArray[rand] == 0) {
									fini = true;
								}
							}
						}
					}
					tileArray[rand] += 1;
					tiles[rand] = new SquareButton(letter);					tiles[rand].setFont(baseFont);
					tiles[rand].setBackground(Color.white);
				}				
				int x = 0; int y = 0;
				c.ipady = 95;
				c.ipadx = 105;
				c.insets = new Insets(10,20,40,20); 
				for(int i =0; i < vowelCount; i++) {
					if (i == 3){
						x++;
						y = 0;
					}					c.gridx = x;					c.gridy = y;
					pane.add(tiles[i], c);					y++;
				}
				x = 5;
				y = 0;
				for(int i = tiles.length-1; i >= vowelCount; i--) {
					if(i == 5 || i == 2) {
						c.insets = new Insets(10,20,40,20); 
						x--;						y =0;
						if (vowelCount > 2) {
							if (i == 5) {
								c.insets = new Insets(10,150,40,20);
							}						}
						else if (i == 2) {
							c.insets = new Insets(10,150,40,20);						}
					}
					c.gridx = x;
					c.gridy = y;
					pane.add(tiles[i], c);
					y++;
				}
				x=0;
				y+=2;				c.ipadx = 0;				c.gridwidth = 0;
				c.fill = GridBagConstraints.BOTH;
				c.gridx = x;
				c.gridy = y;
				pane.add(scrollpane,c);
			}
			this.addWindowListener(new WinHandler(this));			this.setVisible(true);
			textArea.requestFocusInWindow();
			timer.start();			s.close();			sc.close();
		}
		catch (Exception e) {}
	}
	public static void main (String[] args){		new ScrabbleTaskUI(filename,name,expnum,itnum,numcond,time,filenum,numb,setgen,layout,fontType); // Creates the program frame.
	}	
}

import java.util.*;

public class GenerateLetterSets {
	
	static Formatter f;
	
	public GenerateLetterSets() {
		String[] Letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		Random generator = new Random();
	    int linecount = 0;
	    int tileNumber = 9;	   
		int maxVowels = 5;    
	    
	    try {
	    for(int i = 0; i < 16; i++) {	    	
	    	int vowelNum = 0;
	    	while (vowelNum < 2){
	    		vowelNum = generator.nextInt(maxVowels+1);
	    	}
	    linecount++;
	    int vowelCount = 0;	
	    f = new Formatter("Letters"+linecount+".txt");
	    boolean finished = false;
	    String output = "";
	    while(!finished) {    		    		    		    	
	    	int rand = generator.nextInt(26);	    	
	    	if (Letters[rand].equals("A") || Letters[rand].equals("E") ||Letters[rand].equals("I") ||Letters[rand].equals("O") || Letters[rand].equals("U")) {	    		
	    		if (vowelCount < vowelNum) {
	    			output = (Letters[rand]);
	    			String[] finalOutputs = {output};
	    		    f.format("%s",finalOutputs);
	    			vowelCount++;
	    		}
	    		else {
	    			finished = true;
	    		}
	    	}
	    }
	    int count = 0;
	    while (count < tileNumber-vowelCount) {
	    	int rand = generator.nextInt(26);
	    	if (!(Letters[rand].equals("A") || Letters[rand].equals("E") ||Letters[rand].equals("I") ||Letters[rand].equals("O") || Letters[rand].equals("U"))) {	
	    		output = (Letters[rand]);
	    		String[] finalOutputs = {output};
    		    f.format(" %s",finalOutputs);
	    		count++;
	    	}
	    }
	    f.close();
	    }	   
	    }
	    catch (Exception e) {}
	}

	    public static void main (String[] args) {
	    	new GenerateLetterSets();
	    }
}

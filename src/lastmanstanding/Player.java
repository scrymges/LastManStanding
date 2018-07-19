/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastmanstanding;

import java.util.ArrayList;

/**
 *
 * @author Steven Scrymgeour
 */ 
public class Player {

    private final String name;
    private String prediction;
    private final ArrayList<String> prevPredictions;

    public String getName() {
        return this.name;
    }
    
    public String getPrediction() {
        return this.prediction;
    }
    
    public void setPrediction(String prediction) {
        this.prediction = prediction;
        prevPredictions.add(prediction);
    }
    
    public boolean isPrevPred(String prediction) {
        return prevPredictions.contains(prediction);
    } 
    
public Player (String name, String prediction){
    this.prevPredictions = new ArrayList<>();
    this.name = name;
    this.prediction = prediction;
}
    
}

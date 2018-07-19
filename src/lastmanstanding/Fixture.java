/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastmanstanding;

/**
 *
 * @author Steven
 */
public class Fixture {
    private final String homeTeam, awayTeam;
    private int homeScore,awayScore;
    
    public void setResult(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
    
    public String getFixture() {
        return (homeTeam + " V " + awayTeam);
    }
    
    public String getResult() {
        return ("Result: "+ homeTeam + " V " + awayTeam + " - "+ homeScore + "-" + awayScore);
    }
            
    public boolean isWinner(String predictedTeam) {
        if (predictedTeam.equals(homeTeam)) {
            return homeScore > awayScore; // Home Team(Predicted team) won
        }
        else { // predicted team is the away team
            return awayScore > homeScore;
        } // Away team (Predicted team) won
    }
    
    public boolean involvedIn(String predictedTeam) {
        return predictedTeam.equals(homeTeam) || predictedTeam.equals(awayTeam);
    }
  
    public Fixture (String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
    }
}

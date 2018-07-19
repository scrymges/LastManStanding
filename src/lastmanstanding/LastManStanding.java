/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastmanstanding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class LastManStanding implements Serializable {
  private static final long serialVersionUID = 7526472295622776147L;
  private final ArrayList<Player> stillStanding;
  private final ArrayList<Fixture> fixtures;
  private final ArrayList<String> teams;
  private final ArrayList<Player> playerList;
  private int weekNumber = 1;
  private final String league;
  private final int totalLeagueWeeks;
    
           
  public int getWeekNumber() {
      return weekNumber;
  }
  
  public ArrayList<Player> getStillStanding() {    
      return stillStanding;
  }
  
  public ArrayList<Fixture> getFixtures() {    
      return fixtures;
  }
  
  public ArrayList<String> getTeams() {    
      return teams;
  }
  
  public ArrayList<Player> getPlayerList() {    
      return playerList;
  }
  
  public void addPlayer(String name, String prediction) {
      Player p = new Player(name,prediction);
      if (!playerList.contains(p)) {
          playerList.add(p);
      }
      else {
          System.out.println(p.getName()+" is already entered into the game.");
      }
  }
  
  public boolean isPlayerAlready(String name) {
      return playerList.stream().anyMatch((player) -> (player.getName().equalsIgnoreCase(name)));
  }
  
  public void removePlayer (Player p) {
      if (playerList.contains(p)) {
        playerList.remove(p);
      }
      else {
        System.out.println(p.getName()+" hasn't been found to remove.");  
      } 
  }
  
  public Player getPlayerByName(String name) {
     for(Player player : playerList) {
         if (player.getName().equalsIgnoreCase(name)) {
             return player;
         }
     } 
     return null;
  }
  
  public String showPlayers() {
      String playerString;
      playerString = "<html><p> ";
      playerString = playerList.stream().map((player) -> (player.getName()+".  ")).reduce(playerString, String::concat);
    
    playerString += "<p></html>";
    return playerString;
  }
  
  public void saveList(ArrayList<Object> savedList) {
        // Write current list Serial output
     try {
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("stillStanding.ser"))) {
             out.writeObject(savedList);
             out.flush();
             out.close();
         }
        System.out.println("Saved List so far - " + savedList);
     }
    catch (IOException e) {
        System.out.println(e);
    }
  }
  
  public ArrayList<Object> getList(){
       ArrayList<Object> retrievedArray = null;
       try {
           try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("stillStanding.ser"))) {
               retrievedArray = (ArrayList<Object>) in.readObject();
           }
       }
       catch (IOException |ClassNotFoundException e){
           System.out.println(e);
       }
       return retrievedArray;
   }
  
  public int getWeek() {
      int weekNum=0;
       try {
      try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("week.ser"))) {
            weekNum = in.readInt();
      }
       }
       catch (IOException e){
           
       }
      return weekNum;
  }
  
  public void saveWeek(int week) {
      try {
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("week.ser"))) {
             out.writeInt(week);
             out.flush();
             out.close();
         }
        System.out.println("Saved at week - " + week);
     }
    catch (IOException e) {
        System.out.println(e);
    }
  }
  
  public void getFixtures(String league) {
      String homeTeam, awayTeam;
             try {
          try (Scanner s = new Scanner(new File(league+".txt"))) {
              while (s.hasNext()) {
                  homeTeam = s.nextLine();
                  awayTeam = s.nextLine();
                  Fixture fx = new Fixture(homeTeam,awayTeam);
                  fixtures.add(fx);
              } 
          s.close();
          }
      }
      catch (Exception e) {
          
      }
  }
  
   public void showFixtures() {
       fixtures.forEach((fx) -> {
           System.out.print("Fixture = ");
           fx.getFixture();
      });
   }
  
  public void removeAllFixtures(ArrayList<Fixture> fixtures) {
      fixtures.removeAll(fixtures);
  }
  
  public void getLeagueTeams(String league) {
      try {
          try (Scanner s = new Scanner(new File(league+".txt"))) {
              String tm;
              while (s.hasNext()) {
                  tm = s.nextLine();
                  teams.add(tm);
              } 
          s.close();
          }
      }
      catch (Exception e) {
          
      }
  }
                
  
  public void processResult() {
      ArrayList<Player> outList = new ArrayList<>();
      for (Player p : playerList) {
        for (Fixture f : fixtures) {
            if (f.involvedIn(p.getPrediction())) {
                if (f.isWinner(p.getPrediction())) {
                System.out.println(p.getName()+" through to next round");
                }
                else {
               System.out.println(p.getName()+" is out");
               outList.add(p);
               }
            }
        }
      }
      outList.forEach((p) -> {
          this.removePlayer(p);
      });
      fixtures.clear();
      weekNumber++;
      if (weekNumber <= totalLeagueWeeks) {
      getFixtures(league+"Fixtures"+weekNumber);
      }
      
  }
  
  public LastManStanding (String league, int totalLeagueWeeks) {
      this.league = league;
      this.totalLeagueWeeks = totalLeagueWeeks;
      this.stillStanding = new ArrayList<>();
      this.fixtures = new ArrayList<>();
      this.teams = new ArrayList<>();
      this.playerList = new ArrayList<>();
  }
}

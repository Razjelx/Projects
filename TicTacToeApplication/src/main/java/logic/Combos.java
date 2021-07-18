/**
 *
 * @author Razjel
 */
package logic;

import java.util.ArrayList;
import java.util.HashMap;


public class Combos {
    
    private HashMap <String, ArrayList<Position>> playersCombos; 
            
    public Combos() {
        this.playersCombos = new HashMap<>();
    }

    public void addCombo(String player, ArrayList<Position> positionList, Position position) {      
        if (positionList != null) {          
            positionList.add(position);
            this.playersCombos.put(player, positionList);
        }    
    }    
    
    public ArrayList<Position> getPlayerCombos(String player) {       
        if (this.playersCombos.get(player) != null) {       
            return this.playersCombos.get(player);
        }
    return new ArrayList<>();
    }
    
    public boolean isComboCompleted(String player) {        
        if (this.getPlayerCombos(player).size() >= 3) { 
            
            ArrayList<Position> diagonal = new ArrayList<>();
            ArrayList<Position> antidiagonal = new ArrayList<>();
            ArrayList<Position> row1 = new ArrayList<>();
            ArrayList<Position> row2 = new ArrayList<>();
            ArrayList<Position> row3 = new ArrayList<>();
            ArrayList<Position> col1 = new ArrayList<>();
            ArrayList<Position> col2 = new ArrayList<>();
            ArrayList<Position> col3 = new ArrayList<>();
            
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (i == 1) {
                        col1.add(new Position(j, i));
                    }
                    if (i == 2) {
                        col2.add(new Position(j, i));
                    }
                    if (i == 3) {
                        col3.add(new Position(j, i));
                    }
                    if (j == 1) {
                        row1.add(new Position(j, i));
                    } 
                    if (j == 2) {
                        row2.add(new Position(j, i));
                    }    
                    if (j == 3) {
                        row3.add(new Position(j, i));              
                    }                   
                    if (i == j) {
                        diagonal.add(new Position(j, i));
                    } 
                    if (i + j - 1 == 3) {
                        antidiagonal.add(new Position(j, i));
                    }                
                }
            }
            
            if (this.getPlayerCombos(player).containsAll(diagonal)) {
                return true;
            } else if (this.getPlayerCombos(player).containsAll(antidiagonal)) {
                return true; 
            } else if (this.getPlayerCombos(player).containsAll(row1)) {
                return true;
            } else if (this.getPlayerCombos(player).containsAll(row2)) {
                return true;
            } else if (this.getPlayerCombos(player).containsAll(row3)) {
                return true;
            } else if (this.getPlayerCombos(player).containsAll(col1)) {   
                return true;
            } else if (this.getPlayerCombos(player).containsAll(col2)) {
                return true;
            } else if (this.getPlayerCombos(player).containsAll(col3)) {
                return true; 
            } else {
                return false;
            }  
        }
        
        return false;
    }
}
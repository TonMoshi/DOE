/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Users;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dani
 */
public class User implements Comparable<Model.Users.User>{
    private String name;
    private String pass;
    private String email;
    private List<User> enemies;
    private List<User> allies;
    private int win;
    private int plays;
    private float winRatio;
    
    public User(String name, String pass, String email, int win, int plays){
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.win = win;
        this.plays = plays;
        updateWinRatio();
        enemies = new ArrayList<>();
        allies = new ArrayList<>();
    }
    
    public User(String[] user){
        this.name = user[0];
        this.email = user[1];
        this.pass = user[2];
        this.win = Integer.parseInt(user[3]);
        this.plays = Integer.parseInt(user[4]);
        updateWinRatio();
        enemies = new ArrayList<>();
        allies = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }    
    
    public String getName() {
        return name;
    }   

    public void setName(String name) {
        this.name = name;
    }

    public void newWin() {
        this.win = win++;
    }

    public void newPlays() {
        this.plays = plays++;
    }
    
    
    private void updateWinRatio(){
        winRatio = plays/win;
    }
    
    public boolean addAlly(User ally){
        if(!allies.contains(ally)){
            allies.add(ally);
            return true;
        }
        return false;
    }
    
    public boolean addEnemy(User enemy){
        if(!enemies.contains(enemy)){
            enemies.add(enemy);
            return true;
        }
        return false;
    }
    
    public boolean removeAlly(User ally){
        int i=0;
        boolean found = false;
        while(!found && i<allies.size()){
            found = allies.get(i).getName().equals(ally.getName());
            i++;
        }
        if(found){
            allies.remove(i-1);
            return true;
        }
        return false;
    }
    
    public boolean removeEnemy(User enemy){
        int i=0;
        boolean found = false;
        while(!found && i<enemies.size()){
            found = enemies.get(i).getName().equals(enemy.getName());
            i++;
        }
        if(found){
            enemies.remove(i-1);
            return true;
        }
        return false;
    }

    public int getWin() {
        return win;
    }

    public int getPlays() {
        return plays;
    }

    public float getWinRatio() {
        return winRatio;
    }

    @Override
    public int compareTo(User o) {
        if (this.getWinRatio()> o.getWinRatio()) {
            return -1;
        }else if(this.getWinRatio()== o.getWinRatio()){
            return 0;
        }else return 1;
    }
    
    
    
}

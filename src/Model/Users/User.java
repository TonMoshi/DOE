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
public class User {
    private String name;
    private String pass;
    private String email;
    private List<User> enemies;
    private List<User> allies;
    
    public User(String name, String pass, String email){
        this.name = name;
        this.email = email;
        this.pass = pass;
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
}

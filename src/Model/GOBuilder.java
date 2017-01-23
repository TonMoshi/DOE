/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Users.User;
import View.Representation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dani
 */
public class GOBuilder extends GameObj{
    
    protected int bRate;
    protected List<GameObj> options;
    
    public GOBuilder(int x, int y, int life, User owner, int bRate, Representation rep) {
        super(x, y, life, owner, rep);
        this.bRate = bRate;
        this.options = new ArrayList<GameObj>();
    }

    public int getbRate() {
        return bRate;
    }

    public List<GameObj> getOptions() {
        return options;
    }

    public void setOptions(List<GameObj> options) {
        this.options = options;
    }

    public void setbRate(int bRate) {
        this.bRate = bRate;
    }   
    
    public boolean build(int iGO){
        return true;
    }
}

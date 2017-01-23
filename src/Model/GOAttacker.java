/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Users.User;
import View.Representation;
import no.geosoft.cc.graphics.GObject;

/**
 *
 * @author Dani
 */
public class GOAttacker extends GameObj{
    
    protected int range;
    protected int force;
    
    public GOAttacker(int x, int y, int life, User owner, int range, int force, Representation rep) {
        super(x, y, life, owner, rep);
        this.range = range;
        this.force = force;
    }

    public int getForce() {
        return force;
    }

    public int getRange() {
        return range;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setRange(int range) {
        this.range = range;
    }      
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Users.User;
import View.Representation;
import View.Terrain.Cell;
import no.geosoft.cc.graphics.GObject;

/**
 *
 * @author Dani
 */
public class GameObj {
    protected int x;
    protected int y;
    protected int life;
    protected User owner;
    protected Representation rep;

    public GameObj(int x, int y, int life, User owner, Representation rep) {
        this.x = x;
        this.y = y;
        this.life = life;
        this.owner = owner;
        this.rep = rep;
    }

    public int getLife() {
        return life;
    }

    public User getOwner() {
        return owner;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLife(int life) {
        this.life = life;
        if(rep instanceof View.Units.Unit){
            ((View.Units.Unit) rep).setLife(life);
        }else if(rep instanceof View.Buildings.Building){
            ((View.Buildings.Building) rep).setLife(life);
        }
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setX(int x) {
        this.x = x;
        this.rep.setX(x*Cell.SIDE);
    }

    public void setY(int y) {
        this.y = y;
        this.rep.setY(y*Cell.SIDE);
    }   

    public GObject getRep() {
        return rep;
    }

    public void setRep(Representation rep) {
        this.rep = rep;
    }   

    public void die() {
        this.rep.removeSegments();
        this.rep.removeAll();
    }
}

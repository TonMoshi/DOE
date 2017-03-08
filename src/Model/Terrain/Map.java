/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Terrain;

import Model.GOAttacker;
import Model.GOBuilder;
import Model.GameObj;
import Model.Movable;
import Model.Users.User;
import java.util.ArrayList;
import java.util.List;
import no.geosoft.cc.graphics.GObject;



/**
 *
 * @author Dani
 */
public class Map{
    private int numCasX;
    private int numCasY;
    private List<GameObj> gamesObjects;
    private GObject rep;
    
    public Map(int w, int h){
        gamesObjects = new ArrayList<GameObj>();
        rep = new View.Terrain.Map(w, h);
        numCasX = ((View.Terrain.Map) rep).getNumCasX();
        numCasY = ((View.Terrain.Map) rep).getNumCasY();
    }

    public void addGameObj(GameObj gObj){
        gamesObjects.add(gObj);
        rep.add(gObj.getRep());
    }

    public GObject getRep() {
        return rep;
    }   

    public List<GameObj> getObjsRange(GOAttacker obj) {
        List<GameObj> result = new ArrayList<>();
        for(int i=0;i<gamesObjects.size();i++){
            if(Math.abs(obj.getX()-gamesObjects.get(i).getX())<=obj.getRange() &&
                    Math.abs(obj.getY()-gamesObjects.get(i).getY())<=obj.getRange() &&
                    !gamesObjects.get(i).equals(obj) &&
                    !obj.getOwner().getName().equals(gamesObjects.get(i).getOwner().getName())){
                result.add(gamesObjects.get(i));
            }
        }
        return result;
    }

    public List<GOAttacker> getGOAttackers() {
        List<GOAttacker> result = new ArrayList<GOAttacker>();
        for(int i=0;i<gamesObjects.size();i++){
            if(gamesObjects.get(i) instanceof GOAttacker){
                result.add((GOAttacker) gamesObjects.get(i));
            }
        }
        return result;
    }

    public List<GameObj> getGObjs() {
        return gamesObjects;
    }

    public List<Movable> getMovable(User player) {
        List<Movable> result = new ArrayList<Movable>();
        for(int i=0;i<gamesObjects.size();i++){
            if(gamesObjects.get(i) instanceof Movable && !(gamesObjects.get(i) instanceof GOBuilder) && gamesObjects.get(i).getOwner().getName().equals(player.getName())){
                result.add((Movable) gamesObjects.get(i));
            }
        }
        return result;
    }

    public List<GOBuilder> getGOBuilder(User player) {
        List<GOBuilder> result = new ArrayList<GOBuilder>();
        for(int i=0;i<gamesObjects.size();i++){
            if(gamesObjects.get(i) instanceof GOBuilder && gamesObjects.get(i).getOwner().getName().equals(player.getName())){
                result.add((GOBuilder) gamesObjects.get(i));
            }
        }
        return result;
    }

    public Integer getNumCasillasX() {
        return numCasX;
    }

    public Integer getNumCasillasY() {
        return numCasY;
    }
}

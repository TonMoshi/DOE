/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Units;

import Model.GOBuilder;
import Model.Movable;
import Model.Users.User;
import View.Terrain.Cell;

/**
 *
 * @author Dani
 */
public class Builder extends GOBuilder implements Movable{
    
    public Builder(int x, int y, User user) {
        super(x, y, 100, user, 10, new View.Units.Builder(x, y, 100));        
    }   

    @Override
    public int move(int nX, int nY) {
        if(nX != x){
            this.rep.setX(this.rep.getX()+ Integer.signum(nX-x));
            if(this.rep.getX()%Cell.SIDE==0){
                x = x+ Integer.signum(nX-x);
            }
        }
        if(nY != y){
            this.rep.setY(this.rep.getY()+ Integer.signum(nY-y));
            if(this.rep.getY()%Cell.SIDE==0){
                y = y+ Integer.signum(nY-y);
            }
        }
        return 0;
    }

    @Override
    public boolean reach(int nX, int nY) {
        return (nX==x && nY == y);
    }
}

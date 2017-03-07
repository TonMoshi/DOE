/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Units;

import Model.GOAttacker;
import Model.Movable;
import Model.Users.User;

/**
 *
 * @author Dani
 */
public class Warrior extends GOAttacker implements Movable{
    
    public Warrior(int x, int y, User user) {
        super(x, y, 100, user, 3, 5, new View.Units.Warrior(x, y, 100));
    }

    @Override
    public int move(int nX, int nY) {
        int auxX = this.rep.getX();
        if(nX != auxX){
            this.rep.setX(auxX+ Integer.signum(nX-auxX));
//            if(this.rep.getX()%Cell.SIDE==0){
//                x = x+ Integer.signum(nX-x);
//            }
        }
        int auxY = this.rep.getY();
        if(nY != auxY){
            this.rep.setY(auxY+ Integer.signum(nY-auxY));
//            if(this.rep.getY()%Cell.SIDE==0){
//                y = y+ Integer.signum(nY-y);
//            }
        }
        return 0;
    }

    @Override
    public boolean reach(int nX, int nY) {
        int auxX = this.rep.getX();
        int auxY = this.rep.getY();
        return (nX==auxX && nY == auxY);
    }
}

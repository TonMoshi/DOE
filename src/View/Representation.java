/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import no.geosoft.cc.graphics.GObject;

/**
 *
 * @author dam2
 */
public class Representation  extends GObject{
    private int X;
    private int Y;
    
    
    public void setX(int x){
        this.X = x;
    }
    
    public void setY(int y){
        this.Y = y;
    }
    
    public int getX(){
        return X;
    }
    
    public int getY(){
        return Y;
    }
    
}

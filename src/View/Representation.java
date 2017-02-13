/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import no.geosoft.cc.graphics.GImage;
import no.geosoft.cc.graphics.GObject;
import no.geosoft.cc.graphics.GSegment;

/**
 *
 * @author dam2
 */
public class Representation  extends GObject{
    
    private GImage img;
    private int X;
    private int Y;
    private GSegment Rep;
    
    public Representation(){
        Rep = new GSegment();
        addSegment(Rep);
    
    }

    @Override
    public void draw() {
        Rep.setGeometry (X, Y);
    }
    
    
    
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

    public void setImg(GImage img) {
        this.img = img;
        Rep.setImage(this.img);
    }
    
    
}

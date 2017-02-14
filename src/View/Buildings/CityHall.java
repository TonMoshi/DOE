/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Buildings;

import java.io.File;
import no.geosoft.cc.graphics.GImage;


/**
 *
 * @author dam2
 */
public class CityHall extends Building{
    
    int x, y, z;
    private final GImage IMG = new GImage(new File ("resources\\Tiles\\testHall.png"));
    
    public CityHall(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
 //       setters(x,y,z);
    }
    
    public void setters(int x, int y, int z){
        setX(x);
        setY(y);
        setLife(z);
        setImg(IMG);
    }
    
    @Override
    public void setImg(GImage img) {
        super.setImg(img); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setY(int y) {
        super.setY(y); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setX(int x) {
        super.setX(x); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getY() {
        return super.getY(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getX() {
        return super.getX(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {
        super.draw(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLife(int life) {
        super.setLife(life); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

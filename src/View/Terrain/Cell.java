/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Terrain;

import View.Representation;
import java.io.File;
import no.geosoft.cc.graphics.GImage;


/**
 *
 * @author dam2
 */
public class Cell  extends Representation{
    public static int SIDE = 100;
    private final GImage IMG = new GImage(new File ("resources\\Tiles\\testCell.png"));
    
    public Cell(int x, int y){
        super();
        settersIni(x,y);   
    }
    
    @Override
    public void draw() {
        super.draw(); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void settersIni(int x, int y){
        setX(x);
        setY(y);
        setImg(IMG);
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
    public void setY(int y) {
        super.setY(y); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setX(int x) {
        super.setX(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setImg(GImage img) {
        super.setImg(img); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

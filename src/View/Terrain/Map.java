/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Terrain;

import View.Representation;
import no.geosoft.cc.graphics.GObject;

/**
 *
 * @author dam2
 */
public class Map extends Representation{
    
    private int[][] mapGrid;
    
    int w, h, numCasX, numCasY;
    
    public Map(int w, int h){
    
        this.w = Cell.SIDE * w;
        this.h = Cell.SIDE * h;
        this.numCasX = w;
        this.numCasY = h;
        mapGrid = new int[w][h];
    }
    
    public int getNumCasX(){
        return numCasX;
    }
    
    public int getNumCasY(){
        return numCasY;
    }
    
}

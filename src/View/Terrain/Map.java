/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Terrain;

import View.Representation;
import java.awt.Color;
import no.geosoft.cc.geometry.Geometry;
import no.geosoft.cc.graphics.GSegment;
import no.geosoft.cc.graphics.GStyle;

/**
 *
 * @author dam2
 */
public class Map extends Representation {

    private static Point[][] mapGrid;
    private Cell[][] cellGrid;
    private double w, h;
    private GSegment map;
    int numCasX, numCasY;

    public Map(int w, int h) {
        super();
        super.setX(w);
        super.setY(h);
        this.numCasX = w / Cell.SIDE;
        if(this.numCasX > 33)this.numCasX = 33;
        this.numCasY = h / Cell.SIDE;
        if(this.numCasY > 17)this.numCasY = 17;
        mapGrid = new Point[numCasX][numCasY];
        cellGrid = new Cell[numCasX][numCasY];
        makeGrids();
        
    }
    
    public void makeGrids() {

        float auX = 30;
        float auY = 30;
        for (int i = 1; i < numCasY; i++) {
            for (int j = 1; j < numCasX; j++) {
                mapGrid[j][i] = new Point(auX, auY);
                cellGrid[j][i] = new Cell((int)auX, (int)auY);
                add(cellGrid[j][i]);
                auX += 51;
            }
            auX = 30;
            auY += 51;
        }
    }
    
    public static Point getPoint(int x, int y){
        
        return mapGrid[x][y];
    }

    public int getNumCasX() {
        return numCasX;
    }

    public int getNumCasY() {
        return numCasY;
    }

    @Override
    public void draw() {
        super.draw();
//        map.setGeometry(Geometry.createRectangle(0, 0, super.getX(), super.getY()));
        
//        for (int i = 0; i < mapGrid.length; i++) {
//            for (int j = 0; j < mapGrid[0].length; j++) {
//                
//            }
//        }
    }
    
    //Inner Class Point
    public class Point{
        private final float X;
        private final float Y;
        
        public Point(float x, float y){
            this.X = x;
            this.Y = y;
        }

        public float getX() {
            return X;
        }

        public float getY() {
            return Y;
        }
        
        
    
    }

}

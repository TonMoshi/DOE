/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Terrain;

import View.Representation;
import no.geosoft.cc.graphics.GSegment;

/**
 *
 * @author dam2
 */
public class Map extends Representation {

    private static Point[][] mapGrid;
    private Cell[][] cellGrid;
    private GSegment map;
    int numCasX, numCasY;

    public Map(int w, int h) {
        super();
//        super.setX(w);
//        super.setY(h);
        this.numCasX = w / Cell.SIDE;
        if(this.numCasX > 32)this.numCasX = 32;
        this.numCasY = h / Cell.SIDE;
        if(this.numCasY > 16)this.numCasY = 16;
        mapGrid = new Point[numCasX][numCasY];
        cellGrid = new Cell[numCasX][numCasY];
        makeGrids();
        
    }
    
    public void makeGrids() {

        float auX = 30;
        float auY = 30;
        for (int i = 0; i < numCasY; i++) {
            for (int j = 0; j < numCasX; j++) {
                mapGrid[j][i] = new Point((int)auX, (int)auY);
                cellGrid[j][i] = new Cell(j, i);
                //cellGrid[j][i] = new Cell((int)auX, (int)auY);
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
    }
    
    //Inner Class Point
    public class Point{
        private final int X;
        private final int Y;
        
        public Point(int x, int y){
            this.X = x;
            this.Y = y;
        }

        public int getX() {
            return X;
        }

        public int getY() {
            return Y;
        }
        
        
    
    }

}

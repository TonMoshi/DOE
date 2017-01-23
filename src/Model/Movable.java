/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dani
 */
public interface Movable {
    public int move(int nX, int nY);
    
    public boolean reach(int nX, int nY);
}
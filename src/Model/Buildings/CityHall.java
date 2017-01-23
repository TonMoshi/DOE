/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Buildings;

import Model.GOBuilder;
import Model.Users.User;

/**
 *
 * @author Dani
 */
public class CityHall extends GOBuilder{

    public static int MAXLIFE = 1000;
    
    public CityHall(int x, int y, User user) {
        super(x, y, 1000, user, 5, new View.Buildings.CityHall(x, y, 1000));        
    }   
}

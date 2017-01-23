/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Buildings;

import Model.GOAttacker;
import Model.Users.User;

/**
 *
 * @author Dani
 */
public class Defense extends GOAttacker{
    
    public Defense(int x, int y, User user) {
        super(x, y, 250, user, 5, 5, new View.Buildings.Defense(x, y,250));        
    }        
}

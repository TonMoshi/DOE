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
public class ShowAct{

    private Controller controller;
    
    public ShowAct(Controller controller){
        this.controller = controller;
    }
    
    public void run() {
        controller.refreshScene();
    }
    
}

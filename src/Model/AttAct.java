/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Dani
 */
public class AttAct {

    private Controller controller;
    
    public AttAct(Controller controller){
        
        this.controller=controller;
    }
    
    public void run() {
        Random r = new Random();
        List<GOAttacker> list = controller.getMap().getGOAttackers();
        for(int i=0;i<list.size();i++){
            GOAttacker obj = list.get(i);
            List<GameObj> objs = controller.getMap().getObjsRange(obj);
            if(objs.size()>0){
                int index = r.nextInt(objs.size());
                GameObj objetive = objs.get(index);
                objetive.setLife(objetive.getLife()-obj.getForce());
                if(objetive.getOwner().getName().equals(controller.getPlayer().getName())){
                       if(objetive instanceof Model.Buildings.CityHall){
                           controller.getInfo().setLifeCityHall(-obj.getForce());
                       }
                    }
            }            
        }
    }    
}

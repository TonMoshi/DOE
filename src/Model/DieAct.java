/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Dani
 */
public class DieAct{

    private Controller controller;
    
    public DieAct(Controller controller){
        this.controller = controller;
    }
    
    public void run() {
        List<GameObj> list = controller.getMap().getGObjs();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getLife()==0){
                list.get(i).die();
                controller.removeGO4Death(list.get(i));
                if(list.get(i).getOwner().getName().equals(controller.getPlayer().getName())){
                       if(list.get(i) instanceof Model.Units.Builder){
                           controller.getInfo().incrBuilders(-1);
                       }
                       if(list.get(i) instanceof Model.Units.Warrior){
                           controller.getInfo().incrWarriors(-1);
                       }
                       if(list.get(i) instanceof Model.Buildings.Defense){
                           controller.getInfo().incrDefense(-1);
                       }
                    }
                list.remove(i);
                i--;
                
            }
        }
    }
    
}

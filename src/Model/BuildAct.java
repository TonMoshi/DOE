/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Terrain.Cell;
import java.util.List;

/**
 *
 * @author Dani
 */
public class BuildAct implements Runnable{
    private Controller controller;

    public BuildAct(Controller controller) {
        this.controller=controller;
    }
   
    @Override
    public void run() {
        int j=0;
        for(int i=0;i<controller.getBuilders().size();i++){
            GOBuilder b = controller.getBuilders().get(i);
            int posX = controller.getPosObjBul().get(j);
            int posY = controller.getPosObjBul().get(j+1);
            int progressObj = controller.getBuildProgress().get(i);
            GameObj toB = controller.getToBuild().get(i);
            if(Math.abs(b.getX()-posX)<=1 && Math.abs(b.getY()-posY)<=1){
                if(progressObj == toB.getLife()){
                    toB.setX(posX);
                    toB.setY(posY);
                    controller.getMap().addGameObj(toB);
                    if(toB.getOwner().getName().equals(controller.getPlayer().getName())){
                       if(toB instanceof Model.Units.Builder){
                           controller.getInfo().incrBuilders(1);
                       }
                       if(toB instanceof Model.Units.Warrior){
                           controller.getInfo().incrWarriors(1);
                       }
                       if(toB instanceof Model.Buildings.Defense){
                           controller.getInfo().incrDefense(1);
                       }
                    }
                    controller.getBuilders().remove(i);
                    controller.getBuildProgress().remove(i);
                    controller.getPosObjBul().remove(j);
                    controller.getPosObjBul().remove(j);
                    controller.getToBuild().remove(i);
                    j = j-2;
                    i--;
                }else{
                    controller.getBuildProgress().remove(i);
                    controller.getBuildProgress().add(i, progressObj+b.getbRate());
                }
            }
            j=j+2;
        }
    }
}

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

    public AttAct(Controller controller) {

        this.controller = controller;
    }

    public void run() {
        List<GOAttacker> list = controller.getMap().getGOAttackers();
        for (int i = 0; i < list.size(); i++) {
            GOAttacker obj = list.get(i);
            List<GameObj> objs = controller.getMap().getObjsRange(obj);
            if (objs.size() > 0) {
                for (int j = 0; j < objs.size(); j++) {
                    if (!objs.get(j).getOwner().getName().equals(obj.getOwner().getName())) {
                        GameObj objetive = objs.get(j);
                        objetive.setLife(objetive.getLife() - obj.getForce());
                        System.out.println("Ahora la vida de " + objetive.getClass() + " del jugador "+objetive.getOwner().getName()+" es: " + objetive.getLife());
                        if (objetive.getOwner().getName().equals(controller.getPlayer().getName())) {
                            if (objetive instanceof Model.Buildings.CityHall) {
                                controller.getInfo().setLifeCityHall(-obj.getForce());
                            }
                        }
                    }
                }
            }
        }
    }
}

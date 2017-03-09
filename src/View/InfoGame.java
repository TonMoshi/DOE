/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author dam2
 */
public class InfoGame {

    private int LifeCityHall;
    private int warriors, builders, defense;

    /**
     * Creates new form InfoGame
     */
    public InfoGame(int LifeCityHall) {

        this.LifeCityHall = LifeCityHall;
    }

    public void setLifeCityHall(int LifeCityHall) {
        this.LifeCityHall = LifeCityHall;
    }

    public int getLifeCityHall() {
        return LifeCityHall;
    }

    public void incrBuilders(int x) {
        this.builders += x;

    }

    public void incrWarriors(int x) {
        this.warriors += x;

    }

    public void incrDefense(int x) {
        this.defense += x;

    }

    public int getWarriors() {
        return warriors;
    }

    public int getBuilders() {
        return builders;
    }

    public int getDefense() {
        return defense;
    }
    

    public void updateInfo(List<JLabel> l) throws InterruptedException {

        synchronized (l) {

            l.get(0).setText(String.valueOf(LifeCityHall));
            l.get(1).setText(String.valueOf(warriors));
            l.get(2).setText(String.valueOf(builders));
            l.get(3).setText(String.valueOf(defense));
            l.notify();

        }

    }
}

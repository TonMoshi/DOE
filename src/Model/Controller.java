/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Buildings.CityHall;
import Model.Buildings.Defense;
import Model.Terrain.Map;
import Model.Units.Builder;
import Model.Users.User;
import View.InfoGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import no.geosoft.cc.graphics.GScene;

/**
 *
 * @author Dani
 */
public class Controller {

    private User player;
    private List<Integer> nextPosBP;
    private List<User> rivals;
    private List<List<Integer>> nextPosBR;
    private Model.Terrain.Map map;
    private GScene scene;
    private List<Movable> listObjMov;
    private List<Integer> posObjMov;
    private List<GOAttacker> listObjAtt;
    private List<GameObj> toBuild;
    private List<GOBuilder> builders;
    private List<Integer> posObjBul;
    private List<Integer> buildProgress;
    private InfoGame info;
    private int FinalToken;

    public static int[] initX;
    public static int[] initY;

    public Controller(User player, List<User> rivals, Map map, GScene scene, InfoGame info) {
        this.info = info;
        this.player = player;
        this.rivals = rivals;
        this.map = map;
        this.scene = scene;
        this.listObjMov = new ArrayList<>();
        this.posObjMov = new ArrayList<>();
        this.listObjAtt = new ArrayList<>();
        this.toBuild = new ArrayList<>();
        this.builders = new ArrayList<>();
        this.posObjBul = new ArrayList<>();
        this.buildProgress = new ArrayList<>();
        this.nextPosBP = new ArrayList<>();
        initX = new int[]{map.getNumCasillasX() - 1, map.getNumCasillasX() - 1, 1};
        initY = new int[]{map.getNumCasillasY() - 1, 1, map.getNumCasillasY() - 1};
    }

    public void setInitialScenario() {
        GameObj gO = new CityHall(1, 1, player);
        info.setLifeCityHall(gO.getLife());
        nextPosB();
        map.addGameObj(gO);
        for (int i = 0; i < rivals.size(); i++) {
            gO = new CityHall(initX[i], initY[i], rivals.get(i));
            map.addGameObj(gO);
        }
        FinalToken = rivals.size() + 1;
    }

    public void nextPosB() {
        for (int n = 1; n < map.getNumCasillasX() / 4; n++) {//Niveles

            int x = 1;
            int y = n * 4 + 1;
            if (y > map.getNumCasillasY()) {
                y = map.getNumCasillasY() - 2;
            }
            while (x < n * 4) {
                nextPosBP.add(x);
                nextPosBP.add(y);
                x = x + 4;
            }
            while (y >= 1) {
                nextPosBP.add(x);
                nextPosBP.add(y);
                y = y - 4;
            }

        }
    }

    public void addGO2Move(Movable gObj, int posX, int posY) {
        if (listObjMov.contains(gObj)) {
            int index = listObjMov.indexOf(gObj);
            posObjMov.remove(index);
            posObjMov.remove(index);
            listObjMov.remove(gObj);
        }
        listObjMov.add(gObj);
        posObjMov.add(posX);
        posObjMov.add(posY);
    }

    public void addGO2Build(GOBuilder gObj, int posX, int posY, GameObj toBuild) {
        if ((Math.abs(posX - gObj.getX()) > 1 || Math.abs(posY - gObj.getY()) > 1) && gObj instanceof Movable) {
            System.out.println("Primero me muevo cerca de " + posX + ":" + posY);
            System.out.println(posX - Integer.signum(posX - gObj.getX()) + ":" + (posY - Integer.signum(posY - gObj.getY())));
            addGO2Move((Movable) gObj, (int) posX - Integer.signum(posX - gObj.getX()), (int) posY - Integer.signum(posY - gObj.getY()));
        }
        this.toBuild.add(toBuild);
        this.builders.add(gObj);
        this.buildProgress.add(0);
        this.posObjBul.add(posX);
        this.posObjBul.add(posY);
    }

    public void removeGO4Death(GameObj gObj) {
        if (gObj instanceof CityHall || gObj instanceof Defense) {
            if (gObj instanceof CityHall) {
                if (gObj.getOwner().getName().equals(player.getName())) {
                    FinalToken = 0;
                }else{
                    FinalToken--;
                }
            }
            if (gObj.getOwner().getName().equals(player.getName())) {
                nextPosBP.add(0, gObj.getY());
                nextPosBP.add(0, gObj.getX());
            }
        }

        if (gObj instanceof Movable && listObjMov.contains(gObj)) {
            int index = listObjMov.indexOf(gObj);
            posObjMov.remove(index);
            posObjMov.remove(index);
            listObjMov.remove(gObj);
            System.out.println("Eliminado el objeto en posición " + gObj.getX() + ":" + gObj.getY());
        }

        if (gObj instanceof GOBuilder) {
            if (builders.contains(gObj)) {
                int index = builders.indexOf(gObj);
                posObjBul.remove(index);
                posObjBul.remove(index);
                buildProgress.remove(index);
                toBuild.remove(index);
                builders.remove(index);
            }
        }
    }

    public Model.Terrain.Map getMap() {
        return map;
    }

    public List<GOBuilder> getBuilders() {
        return builders;
    }

    public List<Integer> getBuildProgress() {
        return buildProgress;
    }

    public List<Integer> getPosObjBul() {
        return posObjBul;
    }

    public List<GameObj> getToBuild() {
        return toBuild;
    }

    public List<Movable> getListObjMov() {
        return listObjMov;
    }

    public List<Integer> getPosObjMov() {
        return posObjMov;
    }

    public List<Movable> getMovUnits(User player) {
        return map.getMovable(player);
    }
    
    public int getFinalToken() {
        return FinalToken;
    }

    public GOBuilder getAppBuilder(User player, GameObj toBuild) {
        List<GOBuilder> l = map.getGOBuilder(player);
        Random r = new Random();
        GOBuilder builder = null;
        if (toBuild instanceof Movable) {
            //Necesitamos el CityHall
            int i = 0;
            boolean found = false;
            while (!found && i < l.size()) {
                found = l.get(i) instanceof CityHall;
                i++;
            }
            if (found) {
                i--;
                builder = l.get(i);
            } else {
                return null;
            }
        } else {
            // Necesitamos un Constructor
            List<GOBuilder> aux = new ArrayList<GOBuilder>();
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i) instanceof Builder && !this.builders.contains(l.get(i))) {
                    aux.add(l.get(i));
                }
            }
            if (aux.size() == 0) {
                return null;
            }
            builder = aux.get(r.nextInt(aux.size()));
        }
        return builder;
    }

    public List<Integer> getPosLibre(GOBuilder builder) {
        List<Integer> l = new ArrayList<Integer>();
        if (!(builder instanceof Movable)) {
            l.add(builder.getX() - 1);
            l.add(builder.getY() - 1);
            l.add(builder.getX() - 1);
            l.add(builder.getY());
            l.add(builder.getX() - 1);
            l.add(builder.getY() + 1);
            l.add(builder.getX());
            l.add(builder.getY() - 1);
            l.add(builder.getX() - 1);
            l.add(builder.getY() + 1);
            l.add(builder.getX() + 1);
            l.add(builder.getY() - 1);
            l.add(builder.getX() + 1);
            l.add(builder.getY());
            l.add(builder.getX() + 1);
            l.add(builder.getY() + 1);
            int i = 0;
            while (i < l.size() / 2) {
                if (l.get(i) < 0 || l.get(i) > map.getNumCasillasX() || l.get(i + 1) < 0 || l.get(i + 1) > map.getNumCasillasY()) {
                    l.remove(i);
                    l.remove(i);
                } else {
                    i = i + 2;
                }
            }
            for (i = 0; i < this.posObjBul.size(); i = i + 2) {
                int j = 0;
                boolean found = false;
                while (!found && j < l.size()) {
                    if (l.get(j) == posObjBul.get(i) && l.get(j + 1) == posObjBul.get(i + 1)) {
                        l.remove(j);
                        l.remove(j);
                        found = true;
                    } else {
                        j = j + 2;
                    }
                }
                if (found) {
                    i = i - 2;
                }
            }
        } else if (builder.getOwner().getName().equals(this.player.getName())) {
            if (!nextPosBP.isEmpty()) {
                l.add(nextPosBP.remove(0));
                l.add(nextPosBP.remove(0));
            }
        }
        return l;
    }

    public void refreshScene() {
        scene.redraw();
        scene.refresh();
    }

    public User getPlayer() {
        return player;
    }

    public InfoGame getInfo() {
        return this.info;
    }
}

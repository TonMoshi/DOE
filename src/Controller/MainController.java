/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utilities.Cipher;
import Model.BBDD.Connection;
import Model.BBDD.Query;
import Model.Controller;
import Model.Terrain.Map;
import Model.Users.User;
import View.InfoGame;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import no.geosoft.cc.graphics.GScene;
import no.geosoft.cc.graphics.GWindow;

/**
 *
 * @author dam2
 */
public class MainController {

    private Model.Controller odin;
    private View.GUI.MainFrame mF;
    private boolean connStatus;

    public MainController() {

        isConnStatus();
        mF = new View.GUI.MainFrame(this);
        mF.setExtendedState(mF.MAXIMIZED_BOTH);
        mF.setEnabled(true);
        mF.setVisible(true);

    }

    public boolean logIn(String name, String pass) {

        String auxPass = new Cipher(pass).toString();
        Connection conn = new Connection();
        Query query = new Query(conn);

        User user = query.getUser(name);

        conn.closeConn();
        if (user == null) {
            return false;

        } else {
            return user.getPass().equals(auxPass);
        }

    }

    public boolean register(String name, String email, String pass) {

        String auxPass = new Cipher(pass).toString();
        Connection conn = new Connection();
        Query query = new Query(conn);

        if (!query.userExist(name)) {
            if (query.setUser(name, email, auxPass)) {
                conn.closeConn();
                return true;
            } else {
                conn.closeConn();
                return false;
            }
        } else {
            conn.closeConn();
            return false;
        }
    }

    public List<User> getUsers() {

        Connection conn = new Connection();
        Query query = new Query(conn);
        List<User> users = query.getUsers();
        conn.closeConn();
        return users;
    }
    
    public List<User> getAllies(User user){
        Connection conn = new Connection();
        Query query = new Query(conn);
        List<User> allies = query.getAllies(user.getName());
        conn.closeConn();
        return allies;
    
    }
    
    public List<User> getEnemies(User user){
        Connection conn = new Connection();
        Query query = new Query(conn);
        List<User> enemies = query.getEnemies(user.getName());
        conn.closeConn();
        return enemies;
    
    }

    public User getUser(String userName) {
        Connection conn = new Connection();
        Query query = new Query(conn);
        User user = query.getUser(userName);
        conn.closeConn();
        return user;
    }

    public int getDuration(String userName) {
        Connection conn = new Connection();
        Query query = new Query(conn);
        int duration = query.getTimePlayed(userName);
        conn.closeConn();
        return duration;
    }

    public boolean setUserName(String name, String actualName) {
        Connection conn = new Connection();
        Query query = new Query(conn);
        boolean token = false;
        if (!query.userExist(name)) {
            token = query.setUserName(name, actualName);
            conn.closeConn();
            if (token) {
                mF.getUser().setName(name);
            }
            return token;
        } else {
            return token;
        }

    }

    public boolean setPassword(String pass, String actualName) {

        String auxPass = new Cipher(pass).toString();
        Connection conn = new Connection();
        Query query = new Query(conn);
        
        boolean token = false;
        token = query.setPassword(auxPass, actualName);
        conn.closeConn();
        if (token) {
            mF.getUser().setPass(auxPass);
        }
        return token;

    }

    public boolean setEmail(String email, String name) {
        Connection conn = new Connection();
        Query query = new Query(conn);
        boolean token = false;
        token = query.setEmail(email, name);
        conn.closeConn();
        if (token) {
            mF.getUser().setEmail(email);
        }
        return token;

    }

//    public void startControllerModel(User player, JPanel panel) {
//        Map map = new Map(1, 1);
//
//        GWindow window = new GWindow();
//        window.getCanvas().setPreferredSize(new Dimension(1000, 1000));
//        panel.add(window.getCanvas());
//        GScene scene = new GScene(window);
//
//        InfoGame info = new InfoGame(1000);
//
//        Connection conn = new Connection();
//        Query query = new Query(conn);
//        List<User> rivals = query.getEnemies(player.getName());
//        conn.closeConn();
//        odin = new Model.Controller(player, rivals, map, scene, info);
//    }

    public Controller getOdin() {
        return odin;
    }

    public boolean isConnStatus() {

        Connection conn = new Connection();
        this.connStatus = conn.isCheckConn();
        conn.closeConn();

        return this.connStatus;
    }

}

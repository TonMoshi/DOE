/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utilities.Cipher;
import Model.BBDD.Connection;
import Model.BBDD.Query;

/**
 *
 * @author dam2
 */
public class MainController {

    private Model.Controller odin;
    private View.GUI.MainFrame mF;

    public MainController() {

        mF = new View.GUI.MainFrame(this);
        mF.setExtendedState(mF.MAXIMIZED_BOTH);
        mF.setEnabled(true);
        mF.setVisible(true);
        //odin = new Model.Controller(User player, List<User> rivals, Map map, GScene scene, InfoGame info);

    }

    public boolean logIn(String name, String pass) {

        String auxPass = new Cipher(pass).toString();
        Connection conn = new Connection();
        Query query = new Query(conn);

        String[] list = query.getUser(name);

        conn.closeConn();
        if (list[0] == null) {
            return false;

        } else if (list[2].equals(auxPass)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean register(String name, String email, String pass) {

        String auxPass = new Cipher(pass).toString();
        Connection conn = new Connection();
        Query query = new Query(conn);

        if (query.setUser(name, email, auxPass)) {
            conn.closeConn();
            return true;
        } else {
            conn.closeConn();
            return false;
        }       
    }

}

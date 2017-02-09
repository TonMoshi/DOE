/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BBDD;

import Model.Users.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Query {

    private Connection conn;
    private Statement stmt;

    public Query() {
    }

    ;
    
    public Query(Connection conn) {
        this.conn = conn;
        try {

            conn.getConn().setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //
    //Acceso a Datos
    //

    public ArrayList getUsers() {

        ArrayList list = new ArrayList();
        ResultSet rs;
        try {
            stmt = conn.getConn().createStatement();
            rs = stmt.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                String[] matrix = new String[2];
                matrix[0] = rs.getString("name");
                matrix[1] = rs.getString("email");
                list.add(matrix);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public User getUser(String player) {
        ResultSet rs;
        int win, plays;
        User user;
        String[] matrix = new String[3];
        String query = "SELECT * FROM user WHERE name='" + player + "'";
        try {
            stmt = conn.getConn().createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {

                matrix[0] = rs.getString("name");
                matrix[1] = rs.getString("email");
                matrix[2] = rs.getString("password");
                win = rs.getInt("win");
                plays = rs.getInt("plays");
                
                user = new User(matrix[0], matrix[1], matrix[2], win, plays);
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList getAllies(String player) {
        ArrayList list = new ArrayList();
        ResultSet rs;
        try {
            stmt = conn.getConn().createStatement();
            rs = stmt.executeQuery("SELECT Player2 FROM Alliances WHERE Player1='" + player + "'");
            while (rs.next()) {
                list.add(rs.getString("Player2"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ArrayList getEnemies(String player) {
        ArrayList list = new ArrayList();
        ResultSet rs;
        try {
            stmt = conn.getConn().createStatement();
            rs = stmt.executeQuery("SELECT Player2 FROM Enemies WHERE Player1='" + player + "'");
            while (rs.next()) {
                list.add(rs.getString("Player2"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ArrayList getMatchInfo(String player) {
        ArrayList list = new ArrayList();
        ResultSet rs;
        try {
            stmt = conn.getConn().createStatement();
            rs = stmt.executeQuery("SELECT * FROM MatchInfo WHERE PlayerName='" + player + "'");
            while (rs.next()) {
                String[] matrix = new String[7];
                matrix[0] = rs.getString("PlayerName");
                matrix[1] = rs.getString("DateHour");
                matrix[2] = rs.getString("Duration");
                matrix[3] = rs.getString("TownHallLife");
                matrix[4] = rs.getString("Defenses");
                matrix[5] = rs.getString("Builders");
                matrix[6] = rs.getString("Warriors");

                list.add(matrix);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    public boolean userExist(String player) {
        ResultSet rs;
        String query = "SELECT * FROM user WHERE name='" + player + "'";
        try {
            stmt = conn.getConn().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                return true;
            }else return false;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //
    //Introducción de Datos
    //
    public boolean setUser(String name, String email, String password) {
        try {
            stmt = conn.getConn().createStatement();
            String insert  ="INSERT INTO user VALUES('" + name + "','" + email + "','" + password + "','0,0)";
            stmt.executeUpdate(insert);
            conn.getConn().commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    //
    //Modificación/Borrado de Datos
    //
    
    
    //
    //Setter de la Conexión
    //
    public void setConn(Connection conn) {
        this.conn = conn;
        try {
            conn.getConn().setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

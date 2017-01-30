/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BBDD;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    ;
    
    //
    //Acceso a Datos
    //

    public ArrayList getUsers() {

        ArrayList list = new ArrayList();
        ResultSet rs;
        try {
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

    public ArrayList getUser(String player) {
        ArrayList list = new ArrayList();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM user WHERE name='"+player+"'");
            while (rs.next()) {
                String[] matrix = new String[3];
                matrix[0] = rs.getString("name");
                matrix[1] = rs.getString("email");
                String original = rs.getString("password");
                byte[] bytesOfMessage = original.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(original.getBytes());
                byte[] digest = md.digest();
                String pass = new String(digest);
                matrix[2] = pass;
                list.add(matrix);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList getAllies(String player) {
        ArrayList list = new ArrayList();
        ResultSet rs;        
        try {
            rs = stmt.executeQuery("SELECT Player2 FROM Alliances WHERE Player1='"+player+"'");
            while(rs.next()){
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
            rs = stmt.executeQuery("SELECT Player2 FROM Enemies WHERE Player1='"+player+"'");
            while(rs.next()){
                list.add(rs.getString("Player2"));            
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    public ArrayList getMatchInfo(String player){
        ArrayList list = new ArrayList();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM MatchInfo WHERE PlayerName='"+player+"'");
            while(rs.next()){
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

    //
    //Introducción de Datos
    //
    public void setUser(String name, String email, String password) {
        String auxPass = "";
        try {
            byte[] bytesOfMessage = password.getBytes("UTF-8");
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            auxPass = new String(digest);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs;
            rs = stmt.executeQuery("INSERT INTO user VALUES('" + name + "','" + email + "','" + auxPass + "')");
            conn.getConn().commit();
        } catch (SQLException ex) {
            try {
                conn.getConn().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
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

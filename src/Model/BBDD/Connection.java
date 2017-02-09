/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BBDD;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Connection {
    
    
    private final String USER = "DamOfEmpires";
    private final String PASS = "root";
    private final String URL = "jdbc:mysql://137.74.46.102:3306/DamOfEmpires";
    private final java.sql.Connection conn;
    private boolean checkConn;
    
    
    public Connection(){
        this.conn = initConn();
        if (conn != null) {
            System.out.println("Conexión exitosa a la base de datos.");
            checkConn = true;
        }else{
            checkConn = false;
        }
        
    }
    
    private java.sql.Connection initConn() {

        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
            java.sql.Connection connAux = DriverManager.getConnection(URL, USER, PASS);
            return connAux;
        } catch (SQLException ex) {
            System.out.println("Error: unable to load driver class!");
            return null;

        }
    }

    public java.sql.Connection getConn() {
        return conn;
    }
    
    public void  closeConn(){
    
        try {
            this.conn.close();
            System.out.println("Desconectado de la base de datos.");
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isCheckConn() {
        return checkConn;
    }
    
    
    
}

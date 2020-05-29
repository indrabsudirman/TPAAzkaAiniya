/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpaazkaainiya.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jabrikos
 */
public class ConnectionDatabase {
    
    public Connection connection;
    public Statement statement;
    public Connection connect() throws SQLException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Gagal koneksi database " + e);
        }
        
        String url = "jdbc:mysql://localhost/azkaainiya";
        try {
            connection = DriverManager.getConnection(url, "IndraSudirman", "Lubn4d4nNury");
            System.out.println("Berhasil koneksi database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal koneksi database " + e, "Error", JOptionPane.ERROR_MESSAGE);
//            System.out.println("Gagal koneksi database " + e);
        }
        
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        System.out.println(  "create connection called from " + st[2] );
        
//        connection.close();
        
        
        
        return connection;
    }
    
}

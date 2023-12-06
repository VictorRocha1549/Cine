/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cine.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author vagui
 */
public class MySQLConnection {

    public static Connection get() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://uqids5srot9zjq9x:EgQPwHhCuwnJmNGI6wWW@btevp3s5rcrxbgeky0xb-mysql.services.clever-cloud.com:3306/btevp3s5rcrxbgeky0xb", "uqids5srot9zjq9x", "EgQPwHhCuwnJmNGI6wWW");
        } catch (Exception ex) {
            System.err.print("Error: " + ex.getMessage());
        }
        return connection;
    }
}

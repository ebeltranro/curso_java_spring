/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.modelo;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin - Elena
 */
public class MySQLCliente {

    public MySQLCliente() {

        //primero cargamos el driver. Siempre necesario para establecer una conexión con la BBDD
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.registerDriver(
                    new com.mysql.cj.jdbc.Driver());
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCliente.class.getName()).log(Level.SEVERE, "Error"
                    + "SQL", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLCliente.class.getName()).log(Level.SEVERE, "Error"
                    + "en la clase", ex);
        } catch (Exception ex) {
            Logger.getLogger(MySQLCliente.class.getName()).log(Level.SEVERE, "Otro error", ex);
        }
    }

    //añadamos un método para crear un nuevo usuario en la base de datos 
    public boolean crear(String nombre, String email, String passwd, int edad, boolean activo) {

        try (Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_ventas?user"
                + "=admin&password=Admin1234&useSSL=false&serverTimezone=UTC",
                "admin", "Admin1234")) {
            //consulta a la bbdd en SQL. LA FORMA MÁS RUDIMENTARIA
            //en SQL las cadenas van siempre con comillas simples '  '
            String sqlQuery = "INSERT INTO cliente (nombre, email, password, edad, activo)"
                    + " VALUES ( '" + nombre + "', '" + email + "' , '" + passwd + "', "
                    + edad + ", " + (activo ? "1" : "0") + ")"; //edad y activo no van entre '' porque no son String
            Statement sentencia = conex.createStatement();
            sentencia.executeUpdate(sqlQuery);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCliente.class.getName()).log(Level.SEVERE, "Error"
                    + "SQL", ex);
            return false;
        }
    }
    
    
    
}



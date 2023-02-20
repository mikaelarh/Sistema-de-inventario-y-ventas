/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita.Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
 /* se crear el metodo del conector el cual va a ser accesible solo por el metodo get*/
public class conexion {
    /* se crean las variables con acceso publico, estaticas y final para que no puedan ser modificables*/
    public static final String URL = "jdbc:mysql://localhost:3306/pvdb?autoreconnect=true";
    public static final String USERNAME = "root"; //si creaste uno ponerlo aqui.
    public static final String PASSWORD = "";//si lo cambiaste para tu usuario ponerlo aqui
 /* creamos el metodo get que nos debe regresar una comunicacion con la base datos*/
    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            /* en caso de tener algun error imprime dicho error en la pantalla del compilador*/
            System.out.println(e);
        }
        /* retorna una coneccion a base de datos*/
        return connection;
    }    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita.Busqueda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import tiendita.Beans.Bean;
import tiendita.Conexiones.conexion;

/**
 *
 * @author asistentedirprod
 */
public class Buscar {
     static Connection con;
    Bean bean = new Bean();
    public void buscar() {
        try {
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT `id` FROM `productos` WHERE producto= '"+bean.getNombre()+"' "
                    + " and precio= '"+bean.getPrecio()+"' ");
            if (rs.next()) { // si tu busqueda produce un resultado * rs.next()*
                bean.setId(rs.getInt("id"));
           	// en este caso estoy guardando los valores de la consulta en un bean pero puedes hacer lo que quieras con los datos recibidos
            } else {
                JOptionPane.showMessageDialog(null, "No existe lo que estas buscando");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
}

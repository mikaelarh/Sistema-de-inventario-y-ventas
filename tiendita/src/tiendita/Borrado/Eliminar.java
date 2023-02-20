/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita.Borrado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import tiendita.Beans.Bean;
import tiendita.Conexiones.conexion;

/**
 *
 * @author asistentedirprod
 */
public class Eliminar {

    static Connection con;
    Bean bean = new Bean();

    public void borrar() {
        try {
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Statement st = con.createStatement();
            int res = st.executeUpdate ("DELETE FROM productos WHERE id = '"+bean.getId()+"'");  
            if (res > 0) {
                JOptionPane.showMessageDialog(null, " eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "a ocurrido un error");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
}

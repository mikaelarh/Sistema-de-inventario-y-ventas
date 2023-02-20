/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita.Guardado;

import tiendita.Busqueda.Buscar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import tiendita.Beans.Bean;
import tiendita.Conexiones.conexion;

/**
 *
 * @author asistentedirprod
 */
public class Guardar {

    static Connection con;
    Bean bean = new Bean();
    Buscar buscar = new Buscar();

    public void guardarProd(int id) {
        try {
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PreparedStatement ps = con.prepareStatement("INSERT INTO `inventario` VALUES ('" + id + "',?, NULL,NULL, NULL, NULL)"); //siempre poner el primer dato NULL
            ps.setString(1, bean.getNombre());// "despues de la "," poner el dato que vas a insertar "
            int res = ps.executeUpdate();
            if (res > 0) { // cuando es mayor que cero significa que se inserto un dato en la base
                JOptionPane.showMessageDialog(null, "Producto guardado tu id es: " + id);

            } else {
                JOptionPane.showMessageDialog(null, "Error revisar datos");
            }
            con.close(); //siempre cerrar las conexiones despues de usarlas
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex); // imprime el error si hay
        }
    }

    public void guardarInv(int id, String sql) {

        try {
            con = conexion.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PreparedStatement ps = con.prepareStatement("UPDATE `inventario` SET " + sql + "  WHERE `Id`='" + id + "'"); //siempre poner el primer dato NULL
            int res = ps.executeUpdate();
            con.close(); //siempre cerrar las conexiones despues de usarlas
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex); // imprime el error si hay
        }
    }

    public int getid() {
        try {
            con = conexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Id FROM `inventario` ORDER BY Id DESC LIMIT 1");
            if (rs.next()) {
                System.out.println(rs.getInt("Id"));
                return rs.getInt("Id") + 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 1;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita.Guardado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import tiendita.Beans.Bean;
import tiendita.Conexiones.conexion;

/**
 *
 * @author asistentedirprod
 */
public class Actualizar {
    // se invoca asi " actualizar(); "  
 static Connection con;
 Bean bean = new Bean();
public void actualizar(){
      try
      {
        this.con = conexion.getConnection();
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        PreparedStatement ps = this.con.prepareStatement("UPDATE productos SET precio ='" +bean.getPrecio()+ " ' where id = '" + bean.getId() + "' ");
        int res = ps.executeUpdate(); //si vas a usar un dato que no sea un valor escrito y sea pedido de una variable se usan '"+varible+"'
        if (res > 0) {
          JOptionPane.showMessageDialog(null, "exito");
        }
	else { JOptionPane.showMessageDialog(null, "revisa tus datos"); }
      }
      catch (Exception ex)
      {
        JOptionPane.showMessageDialog(null, ex);
      }
    }
}

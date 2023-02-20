/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poa.calendario;
import poa.beans.MakeActiv;
import poa.beans.JavaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import poa.beans.UserDataBean;
import poa.database.Conector;

/**
 *
 * @author asistentedirprod
 */
public class CalMetodos {

    static DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    static DecimalFormat formateador = new DecimalFormat("###,###,###.##", simbolo);
    MakeActiv MA = new MakeActiv();
    JavaBean bean = new JavaBean();
    UserDataBean UDB = new UserDataBean();
    static Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;

    void Paso1() {
        try {
            con = Conector.getConnection();
            String query="SELECT * FROM poa where anio='"+MA.getAnio()+"' AND id_usuario='"+UDB.getId_usuario()+"' "
                    + "AND id_datos='" + MA.getIdclave() + "' ORDER BY id_datos ASC";
            System.out.println(query);
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                MA.setId_actividad(rs.getInt("id_actividad"));
                MA.setId_mes(rs.getInt("id_fechas"));
                MA.setIdpercent(rs.getInt("id_porcentaje"));
                percentsexp();
                informeexp();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void informeexp() {
        ArrayList<String> lista = investigar(MA.getId_actividad());
        Float sp = MA.getSuperficie();
        for (int i = 0; i < lista.size(); i++) {
            try {
                con = Conector.getConnection();
                String query="SELECT unid_med, precioxtrab, cod_act, um_ha,almacen FROM descripcion_act "
                        + "where id_actividad='"+MA.getId_actividad()+ "' AND actividad='"+(String)lista.get(i)+"'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                System.out.println(query);
                if (rs.next()) {
                    bean.setPp(rs.getFloat("precioxtrab"));
                    bean.setUmha(rs.getFloat("um_ha"));
                    bean.setCant(bean.getUmha() * bean.getPercent());
                    bean.setTotalum(bean.getCant() * sp);
                    bean.setTotaldin(bean.getTotalum() * bean.getPp());
                    System.out.println(bean.getTotaldin());
                    lista();
                    Calendario.jLabel9.setText(bean.getDinlet());
                }
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }
    }

    public void percentsexp() {
        if (MA.getIdpercent() == 1) {
            bean.setPercent(0.1F);
            MA.setPorcentaje("10%");
        }
        if (MA.getIdpercent() == 2) {
            bean.setPercent(0.2F);
            MA.setPorcentaje("20%");
        }
        if (MA.getIdpercent() == 3) {
            bean.setPercent(0.3F);
            MA.setPorcentaje("30%");
        }
        if (MA.getIdpercent() == 4) {
            bean.setPercent(0.4F);
            MA.setPorcentaje("40%");
        }
        if (MA.getIdpercent() == 5) {
            bean.setPercent(0.5F);
            MA.setPorcentaje("50%");
        }
        if (MA.getIdpercent() == 6) {
            bean.setPercent(0.6F);
            MA.setPorcentaje("60%");
        }
        if (MA.getIdpercent() == 7) {
            bean.setPercent(0.7F);
            MA.setPorcentaje("70%");
        }
        if (MA.getIdpercent() == 8) {
            bean.setPercent(0.8F);
            MA.setPorcentaje("80%");
        }
        if (MA.getIdpercent() == 9) {
            bean.setPercent(0.9F);
            MA.setPorcentaje("90%");
        }
        if (MA.getIdpercent() == 10) {
            bean.setPercent(1.0F);
            MA.setPorcentaje("100%");
        }
    }

    public static ArrayList<String> investigar(int id) {
        ArrayList<String> Actividades = new ArrayList();
        try {
            con = Conector.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT actividad FROM descripcion_act where id_actividad='" + id + "'");
            while (rs.next()) {
                Actividades.add(rs.getString("actividad"));
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return Actividades;
    }

    public void ResetVar() {
        bean.setTotaldin(0.0f);
        bean.setDinero(0.0f);
        bean.setPp(0.0f);
        bean.setPercents(0.0f);
        bean.setUmha(0.0f);
        bean.setCant(0.0f);
        bean.setTotalum(0.0f);
    }

    public void lista() {
        bean.setDinero(bean.getDinero() + bean.getTotaldin());
        bean.setDinlet("$ " + String.valueOf(formateador.format(bean.getDinero())));
    }
}

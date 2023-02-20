/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poa.vaciado;

import poa.database.Conector;
import poa.beans.VaciadoBeans;
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
import static poa.vaciado.Vaciado.jLabel8;
import static poa.vaciado.Vaciado.model;
import static poa.vaciado.Vaciado.tabinf;

/**
 *
 * @author asistentedirprod
 */
public class VaciadoMetodos {

    static DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    static DecimalFormat formateador = new DecimalFormat("###,###,###.##", simbolo);
    GetVar GV = new GetVar();
    static Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    Thread hilo;
    Boolean Condicion = true;

    void Paso1() {
        try {
            String query = "SELECT * FROM poa where anio=" + VaciadoBeans.getAnio() + " "
                    + "AND id_usuario='" + UserDataBean.getId_usuario() + "' ORDER BY id_poa ASC";
            System.out.println("Paso 1 " + query);
            con = Conector.getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                //Obtener las variables de la base de datos
                VaciadoBeans.setId_actividad(rs.getInt("id_actividad"));
                VaciadoBeans.setAnio(rs.getInt("anio"));
                VaciadoBeans.setId_datos(rs.getInt("id_datos"));
                VaciadoBeans.setId_fechas(rs.getInt("id_fechas"));
                VaciadoBeans.setId_porcentaje(rs.getInt("id_porcentaje"));
                System.out.println(VaciadoBeans.getId_actividad());
                System.out.println(VaciadoBeans.getAnio());
                System.out.println(VaciadoBeans.getId_datos());
                System.out.println(VaciadoBeans.getId_fechas());
                System.out.println(VaciadoBeans.getId_porcentaje());
                //Ejecutar los metodos para obtener los datos restantes
                informeexp();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error 1 " + ex);
        }
    }

    public void informeexp() {
        if (VaciadoBeans.getId_fechas() == 999) {
            System.out.println("condicion");
            cuota();
        } else {
            System.out.println("informe");
//          SE PIDEN LAS VARIABLES QUE SE VAN A UTILIZAR 
            ArrayList<String> lista = GetVar.investigar(VaciadoBeans.getId_actividad());
            GV.GetClaveData();
            GV.getPorcentajes();
            GV.FechaData();
//          SE GUARDAN LAS VARIABLES EN 
            Float sp = VaciadoBeans.getTamaño();
            int Gemela = 0;
            if (VaciadoBeans.getClave().equals("1-TEMA0063-46-1-0") || VaciadoBeans.getClave().equals("1-TEMA0074-54-1-0")
                    || VaciadoBeans.getClave().equals("3-TEMA0064-37-1-0") || VaciadoBeans.getClave().equals("5-TEMATB0001-17b-0")) {
                Gemela = 1;
            }
            String idrec = VaciadoBeans.getOrdenerp() + "-" + Gemela + "-" + VaciadoBeans.getId_mes() + "-" + VaciadoBeans.getAnio();
            String receta = "MANEJO " + VaciadoBeans.getMes() + " " + VaciadoBeans.getOrdenerp();
            for (int i = 0; i < lista.size(); i++) {
                try {
                    con = Conector.getConnection();
                    String query = "SELECT unid_med, precioERP, cod_act, um_ha,almacen FROM descripcion_act where id_actividad='"
                            + VaciadoBeans.getId_actividad() + "' AND actividad='" + (String) lista.get(i) + "'";
                    System.out.println((String) lista.get(i));
                    System.out.println("informe " + query);
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        VaciadoBeans.setNombre_act((String) lista.get(i));
                        VaciadoBeans.setCodact(rs.getString("cod_act"));
                        VaciadoBeans.setUm(rs.getString("unid_med"));
                        VaciadoBeans.setPp(Float.parseFloat(rs.getString("precioERP")));
                        VaciadoBeans.setPercent(VaciadoBeans.getPercent());
                        VaciadoBeans.setUmha(Float.parseFloat(rs.getString("um_ha")));
                        VaciadoBeans.setCant(VaciadoBeans.getUmha() * VaciadoBeans.getPercent());
                        VaciadoBeans.setTotalum(VaciadoBeans.getCant() * sp);
                        VaciadoBeans.setTotaldin(VaciadoBeans.getTotalum() * VaciadoBeans.getPp());
                        VaciadoBeans.setAlmacen(rs.getString("almacen"));
                        registros("hectareas", sp, idrec, receta);
                    }
                    con.close();
                } catch (NumberFormatException | SQLException e) {
                    System.out.println("Error 3 " + e);
                    break;
                }
            }
        }
    }

//  repite la actividad cuota fija 12 veces
    public void cuota() {
        GV.GetClaveData();
        GV.getPorcentajes();
        GV.getCuota(VaciadoBeans.getId_actividad());
        for (int i = 1; i < 13; i++) {
            int Gemela = 0;
//          SE PIDEN LAS VARIABLES QUE SE VAN A UTILIZAR 
            GV.GetIdFecha(Vaciado.año.getSelectedIndex(), i);
            GV.FechaData();
//          SE GUARDAN LAS VARIABLES EN 
            Float sp = VaciadoBeans.getTamaño();
            if (VaciadoBeans.getClave().equals("1-TEMA0063-46-1-0") || VaciadoBeans.getClave().equals("1-TEMA0074-54-1-0")
                    || VaciadoBeans.getClave().equals("3-TEMA0064-37-1-0") || VaciadoBeans.getClave().equals("5-TEMATB0001-17b-0")) {
                Gemela = 1;
            }
            String idrec = VaciadoBeans.getOrdenerp() + "-" + Gemela + "-" + VaciadoBeans.getId_mes() + "-" + VaciadoBeans.getAnio();
            String receta = "MANEJO " + VaciadoBeans.getMes() + " " + VaciadoBeans.getOrdenerp();
            try {
                con = Conector.getConnection();
                String query = "SELECT cod_act, precioERP FROM descripcion_act where id_desc='" + VaciadoBeans.getId_actividad() + "' "
                        + "AND id_actividad='" + VaciadoBeans.getId_actividad() + "'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                if (rs.next()) {
                    VaciadoBeans.setCodact(rs.getString("cod_act"));
                    VaciadoBeans.setUm("SVR");
                    VaciadoBeans.setPerp(rs.getFloat("precioERP"));
                    VaciadoBeans.setUmha(0.0f);
                    VaciadoBeans.setTotalum(0.0f);
                    VaciadoBeans.setTotaldin(0.0f);
                    VaciadoBeans.setAlmacen("Servicios");
                    registros("hectareas", sp, idrec, receta);
                }
                con.close();
            } catch (NumberFormatException | SQLException e) {
                System.out.println("Error 4 " + e);
            }
        }
    }

    //     
    public void registros(String unid, Float sp, String idrec, String receta) {
        simbolo.setGroupingSeparator(',');
        simbolo.setDecimalSeparator('.');
        Object[] registros = new Object[18];
        registros[0] = VaciadoBeans.getNombre_act();
        registros[1] = VaciadoBeans.getId_sitio();
        registros[2] = VaciadoBeans.getSitio();
        registros[3] = VaciadoBeans.getLote();
        registros[4] = VaciadoBeans.getOrdenerp();
        registros[5] = unid;
        registros[6] = sp;
        registros[7] = idrec;
        registros[8] = receta;
        registros[9] = VaciadoBeans.getFein();
        registros[10] = VaciadoBeans.getFefi();
        registros[11] = VaciadoBeans.getAlmacen();
        registros[12] = VaciadoBeans.getCodact();
        registros[13] = VaciadoBeans.getUm();
        registros[14] = VaciadoBeans.getPerp();
        registros[15] = VaciadoBeans.getCant();
        registros[16] = VaciadoBeans.getTotalum();
        registros[17] = VaciadoBeans.getTotaldin();
        VaciadoBeans.setDinero(VaciadoBeans.getDinero() + VaciadoBeans.getTotaldin());
        VaciadoBeans.setDinlet("$ " + String.valueOf(formateador.format(VaciadoBeans.getDinero())));
        model.addRow(registros);
        tabinf.setModel(model);
        jLabel8.setText("$ " + String.valueOf(formateador.format(VaciadoBeans.getDinero())));
    }
//

    public void lista() {
        VaciadoBeans.setDinero(VaciadoBeans.getDinero() + VaciadoBeans.getTotaldin());
        VaciadoBeans.setDinlet("$ " + String.valueOf(formateador.format(VaciadoBeans.getDinero())));
    }
}

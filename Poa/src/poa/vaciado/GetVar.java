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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import poa.beans.UserDataBean;

/**
 *
 * @author Mikaela Estefania Ramirez Herrera <Estefania_mikaela@hotmail.com>
 */
public class GetVar {

    VaciadoBeans VB = new VaciadoBeans();
    UserDataBean UDB = new UserDataBean();
    static Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;

//  METODO PARA OBTENER LOS OPERADORES DEL PORCENTAJE
    public void getPorcentajes() {
        if (VaciadoBeans.getId_porcentaje() == 1) {
            VaciadoBeans.setPercent(0.1F);
        }
        if (VaciadoBeans.getId_porcentaje() == 2) {
            VaciadoBeans.setPercent(0.2F);
        }
        if (VaciadoBeans.getId_porcentaje() == 3) {
            VaciadoBeans.setPercent(0.3F);
        }
        if (VaciadoBeans.getId_porcentaje() == 4) {
            VaciadoBeans.setPercent(0.4F);
        }
        if (VaciadoBeans.getId_porcentaje() == 5) {
            VaciadoBeans.setPercent(0.5F);
        }
        if (VaciadoBeans.getId_porcentaje() == 6) {
            VaciadoBeans.setPercent(0.6F);
        }
        if (VaciadoBeans.getId_porcentaje() == 7) {
            VaciadoBeans.setPercent(0.7F);
        }
        if (VaciadoBeans.getId_porcentaje() == 8) {
            VaciadoBeans.setPercent(0.8F);
        }
        if (VaciadoBeans.getId_porcentaje() == 9) {
            VaciadoBeans.setPercent(0.9F);
        }
        if (VaciadoBeans.getId_porcentaje() == 10) {
            VaciadoBeans.setPercent(1.0F);
        }
    }
//      METODO PARA REINICIAR LOS OPERADORES MATEMATICOS    

    public void ResetVar() {
        VaciadoBeans.setTotaldin(0.0f);
        VaciadoBeans.setDinero(0.0f);
        VaciadoBeans.setPp(0.0f);
        VaciadoBeans.setPercents(0.0f);
        VaciadoBeans.setUmha(0.0f);
        VaciadoBeans.setCant(0.0f);
        VaciadoBeans.setTotalum(0.0f);
    }
//     METODO PARA OBTENER LOS DATOS COMPLETOS DE LAS ACTIVIDADES

    public static ArrayList<String> investigar(int id) {
        ArrayList<String> Actividades = new ArrayList();
        try {
            con = Conector.getConnection();
            String query = "SELECT actividad FROM descripcion_act where id_actividad='" + id + "'";
            System.out.println("actividad "+query);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("actividad"));
                Actividades.add(rs.getString("actividad"));
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 5 " + e);
        }
        return Actividades;
    }

    public void FechaData() {
        try {
            con = Conector.getConnection();
            String query = "SELECT mes_id, mes, año, `fein`, `fefi` FROM `fechas` WHERE id_fechas='" + VaciadoBeans.getId_fechas() + "'";
            System.out.println("fecha "+query);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                if (rs.getInt("mes_id") >= 1 && rs.getInt("mes_id") <= 9) {
                    VaciadoBeans.setId_mes("0" + rs.getString("mes_id"));
                } else {
                    VaciadoBeans.setId_mes(rs.getString("mes_id"));
                }
                VaciadoBeans.setMes2(rs.getInt("mes_id"));
                VaciadoBeans.setMes(rs.getString("mes"));
                VaciadoBeans.setAnio(rs.getInt("año"));
                VaciadoBeans.setFein(rs.getString("fein"));
                VaciadoBeans.setFefi(rs.getString("fefi"));
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 6 " + e);
        }
    }

    public void GetClaveData() {
        try {
            con = Conector.getConnection();
            String query = "SELECT datos.id_sitio, sitio.nombre_sitio, lmf, tamanio, orden_erp, clave  "
                    + "FROM datos "
                    + "INNER JOIN sitio ON sitio.id_sitio=datos.id_sitio "
                    + "WHERE id_datos='" + VaciadoBeans.getId_datos() + "' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                VaciadoBeans.setId_sitio(rs.getInt("datos.id_sitio"));
                VaciadoBeans.setSitio(rs.getString("sitio.nombre_sitio"));
                VaciadoBeans.setLote(rs.getString("lmf"));
                VaciadoBeans.setTamaño(rs.getFloat("tamanio"));
                VaciadoBeans.setOrdenerp(rs.getString("orden_erp"));
                VaciadoBeans.setClave(rs.getString("clave"));
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

//    
    public void getCuota(int id) {
        try {
            con = Conector.getConnection();
            String query = "SELECT actividad FROM descripcion_act where id_actividad='" + id + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                VaciadoBeans.setNombre_act(rs.getString("actividad"));
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 5 " + e);
        }
    }

    public void GetIdFecha(int id, int mes) {
        final int base = 8;
        int formula1= base + id;
        int formula2= formula1 + ((id - 2) * 10);
        VaciadoBeans.setId_fechas(mes + formula2 + id);
        System.out.println(VaciadoBeans.getId_fechas());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poa.beans;
/*este metodo sirve para usarse con los metodos exp en la clase Actividades_crear
almacena variables privadas y estaticas para evitar que se pierdan los valores de estas*/

public class MakeActiv {
//  Datos dependientes de la actividad

  private static int idmaster;
  private static int id_actividad;
  private static int id_sitio;
  private static int anio;
  private static String clave;
  private static int idclave;
  private static String clavexp;
  private static int idclavexp;
  private static int id_mes;
  private static int id_fechas;
  private static int idpercent;
  private static String porcentaje;
//  Datos del lote
  private static float superficie;
  private static String sitio;

    public static int getId_actividad() {
        return id_actividad;
    }

    public static void setId_actividad(int id_actividad) {
        MakeActiv.id_actividad = id_actividad;
    }

    public static int getAnio() {
        return anio;
    }

    public static void setAnio(int anio) {
        MakeActiv.anio = anio;
    }

    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) {
        MakeActiv.clave = clave;
    }

    public static int getIdclave() {
        return idclave;
    }

    public static void setIdclave(int idclave) {
        MakeActiv.idclave = idclave;
    }

    public static int getId_mes() {
        return id_mes;
    }

    public static void setId_mes(int id_mes) {
        MakeActiv.id_mes = id_mes;
    }

    public static int getIdpercent() {
        return idpercent;
    }

    public static void setIdpercent(int idpercent) {
        MakeActiv.idpercent = idpercent;
    }

    public static String getPorcentaje() {
        return porcentaje;
    }

    public static void setPorcentaje(String porcentaje) {
        MakeActiv.porcentaje = porcentaje;
    }

    public static float getSuperficie() {
        return superficie;
    }

    public static void setSuperficie(float superficie) {
        MakeActiv.superficie = superficie;
    }

    public static String getSitio() {
        return sitio;
    }

    public static void setSitio(String sitio) {
        MakeActiv.sitio = sitio;
    }

    public static int getIdmaster() {
        return idmaster;
    }

    public static void setIdmaster(int idmaster) {
        MakeActiv.idmaster = idmaster;
    }

    public static int getId_sitio() {
        return id_sitio;
    }

    public static void setId_sitio(int id_sitio) {
        MakeActiv.id_sitio = id_sitio;
    }

    public static int getIdclavexp() {
        return idclavexp;
    }

    public static void setIdclavexp(int idclavexp) {
        MakeActiv.idclavexp = idclavexp;
    }

    public static String getClavexp() {
        return clavexp;
    }

    public static void setClavexp(String clavexp) {
        MakeActiv.clavexp = clavexp;
    }

    public static int getId_fechas() {
        return id_fechas;
    }

    public static void setId_fechas(int id_fechas) {
        MakeActiv.id_fechas = id_fechas;
    }
}

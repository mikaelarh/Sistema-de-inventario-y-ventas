package poa.beans;

import java.io.Serializable;

/**
 *
 * @author machi
 */
public class JavaBean implements Serializable {
//  JavaBean es unicamente usado como el metodo para generar tablas
  private static int sitio;
  private static String lote;
  private static String codigo;
  private static int id_actividad;
  private static String nombre_act;
  private static int anio;
  private static int mes;
  private static String fi;
  private static String ff;
  private static String porcen;
  private static int idporcen;
  private static String meses;
  private static String orden_erp;
  private static Float percent;
  private static String clave;
  private static String n_sitio;
  //Vaciado
  private static String nombre;
  private static String codact;
  private static String um;
  private static String almacen; 
  private static Float totaldin;
  private static String dinlet="Presupuesto";
  private static float dinero;
  private static Float pp;
  private static Float percents;
  private static Float umha;
  private static Float cant;
  private static Float totalum;
  
    public static int getSitio() {
        return sitio;
    }

    public static void setSitio(int sitio) {
        JavaBean.sitio = sitio;
    }

    public static String getLote() {
        return lote;
    }

    public static void setLote(String lote) {
        JavaBean.lote = lote;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        JavaBean.codigo = codigo;
    }

    public static int getId_actividad() {
        return id_actividad;
    }

    public static void setId_actividad(int id_actividad) {
        JavaBean.id_actividad = id_actividad;
    }

    public static String getNombre_act() {
        return nombre_act;
    }

    public static void setNombre_act(String nombre_act) {
        JavaBean.nombre_act = nombre_act;
    }

    public static int getMes() {
        return mes;
    }

    public static void setMes(int mes) {
        JavaBean.mes = mes;
    }

    public static String getFi() {
        return fi;
    }

    public static void setFi(String fi) {
        JavaBean.fi = fi;
    }

    public static String getFf() {
        return ff;
    }

    public static void setFf(String ff) {
        JavaBean.ff = ff;
    }

    public static String getPorcen() {
        return porcen;
    }

    public static void setPorcen(String porcen) {
        JavaBean.porcen = porcen;
    }

    public static int getIdporcen() {
        return idporcen;
    }

    public static void setIdporcen(int idporcen) {
        JavaBean.idporcen = idporcen;
    }

    public static int getAnio() {
        return anio;
    }

    public static void setAnio(int anio) {
        JavaBean.anio = anio;
    }
    
    public static String getMeses() {
        return meses;
    }

    public static void setMeses(String meses) {
        JavaBean.meses = meses;
    }

    public static String getOrden_erp() {
        return orden_erp;
    }

    public static void setOrden_erp(String orden_erp) {
        JavaBean.orden_erp = orden_erp;
    }

    public static Float getPercent() {
        return percent;
    }

    public static void setPercent(Float percent) {
        JavaBean.percent = percent;
    }

    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) {
        JavaBean.clave = clave;
    }

    public static String getN_sitio() {
        return n_sitio;
    }

    public static void setN_sitio(String n_sitio) {
        JavaBean.n_sitio = n_sitio;
    }
    
//    Extra Variables

    public static Float getTotaldin() {
        return totaldin;
    }

    public static void setTotaldin(Float totaldin) {
        JavaBean.totaldin = totaldin;
    }

    public static float getDinero() {
        return dinero;
    }

    public static void setDinero(float dinero) {
        JavaBean.dinero = dinero;
    }

    public static Float getPp() {
        return pp;
    }

    public static void setPp(Float pp) {
        JavaBean.pp = pp;
    }

    public static Float getPercents() {
        return percents;
    }

    public static void setPercents(Float percents) {
        JavaBean.percents = percents;
    }

    public static Float getUmha() {
        return umha;
    }

    public static void setUmha(Float umha) {
        JavaBean.umha = umha;
    }

    public static Float getCant() {
        return cant;
    }

    public static void setCant(Float cant) {
        JavaBean.cant = cant;
    }

    public static Float getTotalum() {
        return totalum;
    }

    public static void setTotalum(Float totalum) {
        JavaBean.totalum = totalum;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        JavaBean.nombre = nombre;
    }

    public static String getCodact() {
        return codact;
    }

    public static void setCodact(String codact) {
        JavaBean.codact = codact;
    }

    public static String getUm() {
        return um;
    }

    public static void setUm(String um) {
        JavaBean.um = um;
    }

    public static String getAlmacen() {
        return almacen;
    }

    public static void setAlmacen(String almacen) {
        JavaBean.almacen = almacen;
    }

    public static String getDinlet() {
        return dinlet;
    }

    public static void setDinlet(String dinlet) {
        JavaBean.dinlet = dinlet;
    }
}

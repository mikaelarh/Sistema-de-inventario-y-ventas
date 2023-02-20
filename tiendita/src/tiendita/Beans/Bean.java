/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita.Beans;

/**
 *
 * @author asistentedirprod
 */
public class Bean {
  private static int id;
  private static int iduser;
  private static String nombre;
  private static Float precio;
  private static String case1;
  private static String case2;
  private static String case3;
  private static String case4;
  private static String case5;

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Bean.nombre = nombre;
    }

    public static Float getPrecio() {
        return precio;
    }

    public static void setPrecio(Float precio) {
        Bean.precio = precio;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Bean.id = id;
    }

    public static String getCase1() {
        return case1;
    }

    public static void setCase1(String case1) {
        Bean.case1 = case1;
    }

    public static String getCase2() {
        return case2;
    }

    public static void setCase2(String case2) {
        Bean.case2 = case2;
    }

    public static String getCase3() {
        return case3;
    }

    public static void setCase3(String case3) {
        Bean.case3 = case3;
    }

    public static String getCase4() {
        return case4;
    }

    public static void setCase4(String case4) {
        Bean.case4 = case4;
    }

    public static String getCase5() {
        return case5;
    }

    public static void setCase5(String case5) {
        Bean.case5 = case5;
    }

    public static int getIduser() {
        return iduser;
    }

    public static void setIduser(int iduser) {
        Bean.iduser = iduser;
    }
}

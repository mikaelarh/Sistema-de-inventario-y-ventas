/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiendita.Usuarios;

/**
 * 
 * @author Mikaela Estefania Ramirez Herrera <Estefania_mikaela@hotmail.com>
 */
public class UserNameBeans {
public static int iduser;
public static String nombre;
public static int Sesion=0;

    public static int getIduser() {
        return iduser;
    }

    public static void setIduser(int iduser) {
        UserNameBeans.iduser = iduser;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        UserNameBeans.nombre = nombre;
    }

    public static int getSesion() {
        return Sesion;
    }

    public static void setSesion(int Sesion) {
        UserNameBeans.Sesion = Sesion;
    }
}

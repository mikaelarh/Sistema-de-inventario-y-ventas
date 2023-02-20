/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poa.beans;

/**
 *
 * @author Mikaela Estefania Ramirez Herrera <Estefania_mikaela@hotmail.com>
 */
public class UserDataBean {

    private static Boolean suiche = true;
    private static int id_usuario;
    private static String usuario;

        public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        UserDataBean.usuario = usuario;
    }
  
    public static int getId_usuario() {
        return id_usuario;
    }

    public static void setId_usuario(int id_usuario) {
        if(suiche){
        UserDataBean.id_usuario = id_usuario;
        suiche=false;
        }
    }
        public static Boolean getSuiche() {
        return suiche;
    }

    public static void setSuiche(Boolean suiche) {
        UserDataBean.suiche = suiche;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poa.beans;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Key {
//  Key maneja si los espacios estan disponibles o no
    private static Boolean key=false;
    private static Boolean keyex=false;

    public static Boolean getKey() {
        return key;
    }

    public static void setKey(Boolean key) {
        Key.key = key;
    }

    public static Boolean getKeyex() {
        return keyex;
    }

    public static void setKeyex(Boolean keyex) {
        Key.keyex = keyex;
    }
}

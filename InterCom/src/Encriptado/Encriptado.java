/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encriptado;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 *
 * @author asistentedirprod
 */
public class Encriptado {
    
    private void Metodo(String Original){ 
        String Encriptada = "";
        try {
            Encriptada = Encriptar(Original);
            String cadenaDesencriptada = Desencriptar(Encriptada);
        } catch (UnsupportedEncodingException uee) {
            System.out.println("Ups!! > "+uee);
        }
}

    private static String Encriptar(String s) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
    
    private static String Desencriptar(String s) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }
    
}

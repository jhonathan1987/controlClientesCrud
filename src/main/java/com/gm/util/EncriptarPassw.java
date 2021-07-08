
package com.gm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class EncriptarPassw {
    public static void main(String[] args) {
        String pass="456";
        System.out.println(pass);
        System.out.println(encriptarPassword(pass));
    }
    
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encriptar=new BCryptPasswordEncoder();
        return encriptar.encode(password);
    }
}

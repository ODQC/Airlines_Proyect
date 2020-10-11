/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.modelo.Interfaces;

import javax.swing.JPasswordField;

/**
 *
 * @author oscardanielquesadacalderon
 */
public interface ConvertirPwd {
    public default String Convertir(JPasswordField pass){
        char[] con = pass.getPassword();
        String s = new String(con);
        return s;
    }

}

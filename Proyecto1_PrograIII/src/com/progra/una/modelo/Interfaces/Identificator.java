/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.modelo.Interfaces;

import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author oscardanielquesadacalderon
 */

public interface Identificator {
    public default String CodeGenerator(int lengthCode){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < lengthCode){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        
        String code = LocalDateTime.now().getYear()+LocalDateTime.now().getDayOfYear()+(sb.toString().substring(0, lengthCode));
        return code;
    }
    
}

//Identificator id = (lengthCode) -> {
//    5
//}
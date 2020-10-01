/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.modelo.Interfaces;

import com.progra.una.modelo.Reporte;
import com.progra.una.modelo.Persistencia;
import java.time.LocalDateTime;
import java.util.Random;


/**
 *
 * @author oscardanielquesadacalderon
 */
public interface Report {
    public default void AddReport(String description){
 try {
        Random random = new Random();
        int val = random.nextInt();
        String idReport = new String();
        idReport = Integer.toHexString(val);
        Reporte report = new Reporte(idReport,description,LocalDateTime.now().toString());
        Persistencia per = new Persistencia();
        per.getListaReportes().add(report);
}
catch(Exception e) {
  System.out.print(e);
}
        
        
}
        
} 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Reporte;
import com.progra.una.modelo.SingletonUsers;
import com.progra.una.vista.VistaReportes;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorReporte implements Initlisteners{
    private Reporte m;
    private VistaReportes v;
     private SingletonUsers sinP;

    public ControladorReporte(Reporte m, VistaReportes v) {
        this.m = m;
        this.v = v;
        this.sinP=SingletonUsers.getSin();
    }

    @Override
    public void InitListeners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

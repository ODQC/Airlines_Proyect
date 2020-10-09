/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Reporte;
import com.progra.una.vista.VistaReportes;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorReporte implements Initlisteners{
    private Reporte m;
    private VistaReportes v;

    public ControladorReporte(Reporte m, VistaReportes v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public void InitListeners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

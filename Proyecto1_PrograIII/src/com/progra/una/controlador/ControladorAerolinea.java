/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.modelo.Aerolinea;
import com.progra.una.vista.VistaAerolineas;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorAerolinea {
    private Aerolinea m;
    private VistaAerolineas v;

    public ControladorAerolinea(Aerolinea m, VistaAerolineas v) {
        this.m = m;
        this.v = v;
    }

   
}

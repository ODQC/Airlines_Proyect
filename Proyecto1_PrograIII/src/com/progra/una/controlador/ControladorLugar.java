/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.modelo.Lugar;
import com.progra.una.vista.VistaLugares;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorLugar {
    private Lugar m;
    private VistaLugares v;

    public ControladorLugar(Lugar m, VistaLugares v) {
        this.m = m;
        this.v = v;
    }
    
}

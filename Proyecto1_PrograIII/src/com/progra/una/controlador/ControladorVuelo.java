/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.modelo.Vuelo;
import com.progra.una.vista.VistaVuelos;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorVuelo {
    Vuelo m;
    VistaVuelos v;

    public ControladorVuelo(Vuelo m, VistaVuelos v) {
        this.m = m;
        this.v = v;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.modelo.Reservacion;
import com.progra.una.vista.VistaReservaciones;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorResevaciones {
    Reservacion m;
    VistaReservaciones r;

    public ControladorResevaciones(Reservacion m, VistaReservaciones r) {
        this.m = m;
        this.r = r;
    }
}

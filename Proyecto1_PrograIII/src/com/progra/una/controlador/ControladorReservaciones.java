/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.modelo.Reservacion;
import com.progra.una.vista.ConsultasVuelos;
import com.progra.una.vista.VistaLugares;
import com.progra.una.vista.VistaReservaciones;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorReservaciones {
    Reservacion m;
    VistaReservaciones v;
    VistaLugares vL;

    public ControladorReservaciones(Reservacion m, VistaReservaciones r) {
        this.m = m;
        this.v = r;
        this.initListeners();
    }
    public void initListeners() {
        this.v.getBtnSiguiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //principal.removeAll();
                vL = new  VistaLugares(v.getPrincipal());
                v.getPrincipal().add("aerolineaForm", vL);
                CardLayout card = (CardLayout) v.getPrincipal().getLayout();
                card.next(v.getPrincipal());
            }
        });
    }
}

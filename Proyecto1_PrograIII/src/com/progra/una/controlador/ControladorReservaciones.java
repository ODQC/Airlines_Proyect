/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Cancelar;
import com.progra.una.modelo.Interfaces.Mantenimiento;
import com.progra.una.modelo.Interfaces.Report;
import com.progra.una.modelo.Reservacion;
import com.progra.una.vista.ConsultasVuelos;
import com.progra.una.vista.PanelBackground;
import com.progra.una.vista.VistaLugares;
import com.progra.una.vista.VistaReservaciones;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorReservaciones implements Cancelar,Report,Mantenimiento {

    private Reservacion m;
    private VistaReservaciones v;
    private VistaLugares vL;
    private PanelBackground background;
   
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
                vL = new VistaLugares(v.getPrincipal(), v.getPer());
                v.getPrincipal().add("aerolineaForm", vL);
                CardLayout card = (CardLayout) v.getPrincipal().getLayout();
                card.next(v.getPrincipal());
            }
        });
        this.v.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               EndTask();
            }
        });
    }
    public void EndTask(){
    this.Cancel(v.getPrincipal());
    }

    @Override
    public void Add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.modelo.Aerolinea;

import com.progra.una.modelo.Interfaces.Mantenimiento;
import com.progra.una.modelo.Persona;
import com.progra.una.modelo.Reporte;
import com.progra.una.modelo.Reservacion;
import com.progra.una.modelo.Vuelo;
import com.progra.una.vista.VistaPersona;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorPersona implements Mantenimiento{
private Persona m;
private VistaPersona v;

    public ControladorPersona(Persona m, VistaPersona v) {
        this.m = m;
        this.v = v;
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

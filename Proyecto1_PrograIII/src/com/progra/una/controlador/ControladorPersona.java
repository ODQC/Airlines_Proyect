/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.modelo.Aerolinea;
import com.progra.una.modelo.Interfaces.Consultas;
import com.progra.una.modelo.Persona;
import com.progra.una.modelo.Reporte;
import com.progra.una.modelo.Reservacion;
import com.progra.una.modelo.Vuelo;
import com.progra.una.vista.VistaPersona;
import java.util.ArrayList;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorPersona implements Consultas {
private Persona m;
private VistaPersona v;

    public ControladorPersona(Persona m, VistaPersona v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public Aerolinea SearchAirline(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vuelo SeachFly(String idFly) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona SearchPersona(String idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reporte SearchReport(String idReport) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reservacion SeachReserv(String idResev) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ShowList(ArrayList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

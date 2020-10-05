/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.modelo;

import java.util.ArrayList;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class Persistencia {
    private ArrayList<Persona> ListaPersonas;
    private ArrayList<Vuelo> ListaVuelos;
    private ArrayList<Aerolinea> ListaAerolineas;
    private ArrayList<Reservacion> ListaReservaciones;
    private ArrayList<Reporte> ListaReportes;

    public Persistencia() {
        this.ListaAerolineas = new ArrayList();
        this.ListaPersonas = new ArrayList();
        this.ListaReportes = new ArrayList();
        this.ListaReservaciones = new ArrayList();
        this.ListaVuelos = new ArrayList();
    }

    public ArrayList<Persona> getListaPersonas() {
        return ListaPersonas;
    }

    public ArrayList<Vuelo> getListaVuelos() {
        return ListaVuelos;
    }

    public ArrayList<Aerolinea> getListaAerolineas() {
        return ListaAerolineas;
    }

    public ArrayList<Reservacion> getListaReservaciones() {
        return ListaReservaciones;
    }

    public ArrayList<Reporte> getListaReportes() {
        return ListaReportes;
    }
    
}

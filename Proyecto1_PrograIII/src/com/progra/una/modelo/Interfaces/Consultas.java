/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.modelo.Interfaces;

import com.progra.una.modelo.Aerolinea;
import com.progra.una.modelo.Persona;
import com.progra.una.modelo.Reporte;
import com.progra.una.modelo.Reservacion;
import com.progra.una.modelo.Vuelo;
import java.util.ArrayList;

/**
 *
 * @author oscardanielquesadacalderon
 */
public interface Consultas {
    public Aerolinea SearchAirline(String id);
    public Vuelo SeachFly(String idFly);
    public Persona SearchPersona(String idPersona);
    public Reporte SearchReport(String idReport);
    public Reservacion SeachReserv(String idResev);
    public void ShowList(ArrayList list);
}

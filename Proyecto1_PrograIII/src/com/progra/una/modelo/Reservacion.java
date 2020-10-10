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
public class Reservacion extends Lugar{
   private String idreservation;
   private String reservStatus;
   private String reservDate;
   private ArrayList<Lugar> placeReserv;

    public Reservacion(String idreservation, String reservStatus, String reservDate, String idPlace, String StatusPlace, String idFly, String source, String destination, String takeOffDate, String arrivalDate, String capacity, String stateFly, String idAirline, String nameAirline) {
        super(idPlace, StatusPlace, idFly, source, destination, takeOffDate, arrivalDate, capacity, stateFly, idAirline, nameAirline);
        this.idreservation = idreservation;
        this.reservStatus = reservStatus;
        this.reservDate = reservDate;
        this.placeReserv = new ArrayList<Lugar>();
    }

    public String getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(String idreservation) {
        this.idreservation = idreservation;
    }

    public String getReservStatus() {
        return reservStatus;
    }

    public void setReservStatus(String reservStatus) {
        this.reservStatus = reservStatus;
    }

    public String getReservDate() {
        return reservDate;
    }

    public void setReservDate(String reservDate) {
        this.reservDate = reservDate;
    }

    public ArrayList<Lugar> getPlaceReserv() {
        return placeReserv;
    }
   
   
}


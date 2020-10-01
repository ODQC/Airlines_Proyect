/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.modelo;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class Lugar extends Vuelo{
  private  String idPlace;
  private String StatusPlace;

    public Lugar(String idPlace, String StatusPlace, String idFly, String source, String destination, String takeOffDate, String arrivalDate, String capacity, String stateFly, String idAirline, String nameAirline) {
        super(idFly, source, destination, takeOffDate, arrivalDate, capacity, stateFly, idAirline, nameAirline);
        this.idPlace = idPlace;
        this.StatusPlace = StatusPlace;
    }
  

    public String getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(String idPlace) {
        this.idPlace = idPlace;
    }

    public String getStatusPlace() {
        return StatusPlace;
    }

    public void setStatusPlace(String StatusPlace) {
        this.StatusPlace = StatusPlace;
    }
          
    
}

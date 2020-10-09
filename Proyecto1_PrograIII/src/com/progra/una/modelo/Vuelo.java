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
public class Vuelo extends  Aerolinea{
    
    
    private String idFly;
    private String source;
    private String destination;
    private String takeOffDate;
    private String arrivalDate;
    private String capacity;
    private String stateFly;

    public Vuelo(String idFly, String source, String destination, String takeOffDate, 
            String arrivalDate, String capacity, String stateFly, String idAirline, 
            String nameAirline) {
        super(idAirline, nameAirline);
        this.idFly = idFly;
        this.source = source;
        this.destination = destination;
        this.takeOffDate = takeOffDate;
        this.arrivalDate = arrivalDate;
        this.capacity = capacity;
        this.stateFly = stateFly;
    }


    @Override
    public String getNameAirline() {
        return super.getNameAirline(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIdAirline() {
        return super.getIdAirline(); //To change body of generated methods, choose Tools | Templates.
    }
    public String getIdFly() {
        return idFly;
    }

    public void setIdFly(String idFly) {
        this.idFly = idFly;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTakeOffDate() {
        return takeOffDate;
    }

    public void setTakeOffDate(String takeOffDate) {
        this.takeOffDate = takeOffDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStatusFly() {
        return stateFly;
    }

    public void setStatusFly(String stateFly) {
        this.stateFly = stateFly;
    }

  
}

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
public class Aerolinea {
    private String idAirline;
    private String nameAirline;

    public Aerolinea(String idAirline, String nameAirline) {
        this.idAirline = idAirline;
        this.nameAirline = nameAirline;
    }
    public Aerolinea(){
    this.idAirline = "";
    this.nameAirline = "";
    }

    public String getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(String idAirline) {
        this.idAirline = idAirline;
    }

    public String getNameAirline() {
        return nameAirline;
    }

    public void setNameAirline(String nameAirline) {
        this.nameAirline = nameAirline;
    }
    
}

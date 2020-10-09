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
public class Reporte {
   private String idReport;
   private String idUsuario;
   private String description ;
   private String date;

    public Reporte(String idReport, String idUsuario, String description, String date) {
        this.idReport = idReport;
        this.idUsuario = idUsuario;
        this.description = description;
        this.date = date;
    }

    public Reporte() {
    }

   

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getIdReport() {
        return idReport;
    }

    public void setIdReport(String idReport) {
        this.idReport = idReport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}

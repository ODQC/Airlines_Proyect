
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
public class Persona {
    private String Id;
    private String Name;
    private String Apellido1;
    private String Apellido2;
    private String Tipo;
    private String password;

    public Persona() {
    }

    public Persona(String Id, String Name, String Apellido1, String Apellido2, String Tipo, String password) {
        this.Id = Id;
        this.Name = Name;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.Tipo = Tipo;
        this.password = password;
    }
    
    // -------------- GETTERS ---------------\\

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getPassword() {
        return password;
    }
    
    // -------------- SETTERS ---------------\\

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}


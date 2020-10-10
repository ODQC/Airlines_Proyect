/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.modelo;

/**
 *
 * @author Anderson
 */
public class SingletonUsers {
    private static SingletonUsers sin;
    private String ID ;
    private SingletonUsers(){
        this.ID = new String("Sin Definir");
    }

    public static SingletonUsers getSin() {
        if(sin == null){
            sin = new SingletonUsers(); 
        }
        return sin;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
}

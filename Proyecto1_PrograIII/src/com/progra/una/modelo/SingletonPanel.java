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
public class SingletonPanel {
    private static SingletonPanel sin;
    private String panelName ;
    private SingletonPanel(){
        this.panelName = new String("Sin Definir");
    }

    public static SingletonPanel getSin() {
        if(sin == null){
            sin = new SingletonPanel(); 
        }
        return sin;
    }

    public String getID() {
        return panelName;
    }

    public void setID(String panelName) {
        this.panelName = panelName;
    }
}

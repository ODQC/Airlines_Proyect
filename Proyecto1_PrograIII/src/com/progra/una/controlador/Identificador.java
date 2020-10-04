/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.modelo.Interfaces.Identificator;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class Identificador implements Identificator {
    public void getID(){
    this.CodeGenerator(0);
    }
}

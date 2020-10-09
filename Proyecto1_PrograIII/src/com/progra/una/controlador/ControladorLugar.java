/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Cancelar;
import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Aerolinea;
import com.progra.una.modelo.Interfaces.Mantenimiento;
import com.progra.una.modelo.Lugar;
import com.progra.una.vista.PanelBackground;
import com.progra.una.vista.VistaLugares;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorLugar implements Cancelar, Mantenimiento,Initlisteners{
    private Lugar m;
    private VistaLugares v;
    private PanelBackground background;
    private Aerolinea airline;
    
    public ControladorLugar(Lugar m, VistaLugares v) {
        this.m = m;
        this.v = v;
        this.InitListeners();
    }
      
    public void EndTask(){
    this.Cancel(v.getPanelPrincipal());
    }

    @Override
    public void Add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InitListeners() {
         this.v.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               EndTask();
            }
        });
        this.v.getBtnReservar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                background = new PanelBackground(v.getPanelPrincipal());
                v.getPanelPrincipal().add("aerolineaForm", background);
                CardLayout card = (CardLayout) v.getPanelPrincipal().getLayout();
                card.next(v.getPanelPrincipal());
            }
        });
    }
    public void AirlineSelected(int pos){
        airline = v.getPer().getListaAerolineas().get(pos);
        
  
    }

   
}
      

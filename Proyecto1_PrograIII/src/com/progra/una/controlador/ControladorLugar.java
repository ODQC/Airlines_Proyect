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
import com.progra.una.modelo.Vuelo;
import com.progra.una.vista.PanelBackground;
import com.progra.una.vista.VistaLugares;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorLugar implements Cancelar, Mantenimiento,Initlisteners{
    private Lugar m;
    private VistaLugares v;
    private PanelBackground background;
    private int  idflySelected;
    private ArrayList<Lugar> PlaceSelected;
    
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
        this.v.getBtnReservar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    public void FlySelected(String id){ 
        v.getPer().getListaVuelos().forEach(
        p->{if(p.getIdFly().equals(id))
         ShowEnablePlaces(p);
        }
        );
        
    }
    
    public void ShowEnablePlaces(Vuelo fly) {
        int i;
        for (i = 0; i <= 89; i++) {
            String nom;
            try {
                nom = fly.getListPlace().get(i).getIdPlace();
                JButton place = new JButton();                
                place.setText(nom);
                place.setMaximumSize(new java.awt.Dimension(60, 60));
                place.setMinimumSize(new java.awt.Dimension(60, 60));
                place.setPreferredSize(new java.awt.Dimension(60, 60));
                place.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        
                       
                    }
                });
                if (fly.getListPlace().get(i).getStatusPlace().equals("Reservado")) {
                    place.setBackground(java.awt.Color.RED);
                    place.setEnabled(false);
                } else {
                    if (i <= 29) {
                        place.setBackground(java.awt.Color.ORANGE);
                        v.getSeccion1().add(place);
                    } else if (30 <= i && i <= 59) {
                        place.setBackground(java.awt.Color.CYAN);
                        v.getSeccion2().add(place);
                    } else if (60 <= i && i <= 89) {
                        place.setBackground(java.awt.Color.BLUE);
                        v.getSeccion3().add(place);
                    }
                }

            } catch (Exception e) {
                System.err.println(e);
            }

        }
    }

    public void ButtonSelected(JButton B, Vuelo fly) {
        fly.getListPlace().forEach(
                p -> {
                    if (p.getIdPlace().equals(B.getText())&& !PlaceSelected.contains(p)) {
                        if (p.getStatusPlace().equals("Disponibe")) {
                            PlaceSelected.add(p);
                        }
                    }else {
                        PlaceSelected.remove(p);
                        //PlaceSelected.re
                    }
                    
                }
        );
        
    }
}

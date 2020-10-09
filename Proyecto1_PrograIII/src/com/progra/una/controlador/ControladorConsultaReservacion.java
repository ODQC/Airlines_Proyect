/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Persistencia;
import com.progra.una.vista.ConsultasReservaciones;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorConsultaReservacion implements Initlisteners {
    private ConsultasReservaciones v;
    private Persistencia per;

    public ControladorConsultaReservacion(ConsultasReservaciones v, Persistencia per) {
        this.v = v;
        this.per = per;
        this.InitListeners();
    }


    @Override
    public void InitListeners() {
       this.v.getBtnAtras().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                 v.getPanelPrincipal().remove(v);
                 CardLayout card = (CardLayout) v.getPanelPrincipal().getLayout();
                 card.previous(v.getPanelPrincipal());
   
            }
        });
        
        this.v.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
       
        this.v.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.modelo.Interfaces.Identificator;
import com.progra.una.modelo.Vuelo;
import com.progra.una.vista.ConsultasAerolineas;
import com.progra.una.vista.ConsultasVuelos;
import com.progra.una.vista.PanelBackground;
import com.progra.una.vista.VistaVuelos;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorVuelo implements Identificator{
  private  Vuelo m;
  private  VistaVuelos v;
  private ConsultasVuelos cV;
  private PanelBackground background;

    public ControladorVuelo(Vuelo m, VistaVuelos v) {
        this.m = m;
        this.v = v;
        this.initListeners();
    }
     public void initListeners() {
        this.v.getBtnVuelos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //principal.removeAll();
                cV = new ConsultasVuelos(v.getPrincipal());
                v.getPrincipal().add("aerolineaForm", cV);
                CardLayout card = (CardLayout) v.getPrincipal().getLayout();
                card.next(v.getPrincipal());
            }
        });
        this.v.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //principal.removeAll();
                background = new PanelBackground(v.getPrincipal());
                v.getPrincipal().add("aerolineaForm", background);
                CardLayout card = (CardLayout) v.getPrincipal().getLayout();
                card.next(v.getPrincipal());
            }
        });
        this.v.getBtnGenerarCodigo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               Code();

            }
        });

    }
      public void Code() {
        v.getTxtidFly().setText(this.CodeGenerator(15));
    }
}

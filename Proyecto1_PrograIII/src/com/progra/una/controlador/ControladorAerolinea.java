/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.modelo.Aerolinea;
import com.progra.una.modelo.Interfaces.Identificator;
import com.progra.una.vista.ConsultasAerolineas;
import com.progra.una.vista.PanelBackground;
import com.progra.una.vista.VistaAerolineas;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorAerolinea implements Identificator {
    
    private Aerolinea m;
    private VistaAerolineas v;
    private ConsultasAerolineas cA;
    private PanelBackground background;
    
    public ControladorAerolinea(Aerolinea m, VistaAerolineas v) {
        this.m = m;
        this.v = v;
        this.initListeners();
        
    }
    
    public void initListeners() {
        this.v.getBtnVerAero().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //principal.removeAll();
                cA = new ConsultasAerolineas(v.getPanelPrincipal());
                v.getPanelPrincipal().add("aerolineaForm", cA);
                CardLayout card = (CardLayout) v.getPanelPrincipal().getLayout();
                card.next(v.getPanelPrincipal());
            }
        });
        this.v.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //principal.removeAll();
                background = new PanelBackground(v.getPanelPrincipal());
                v.getPanelPrincipal().add("aerolineaForm", background);
                CardLayout card = (CardLayout) v.getPanelPrincipal().getLayout();
                card.next(v.getPanelPrincipal());
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
        v.getTxtCodigoAerolinea().setText(this.CodeGenerator(10));
    }
    
}

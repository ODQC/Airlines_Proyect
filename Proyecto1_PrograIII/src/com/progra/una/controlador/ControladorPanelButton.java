/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.vista.JPanelButtonsAdmin;
import com.progra.una.vista.VistaAerolineas;
import com.progra.una.vista.VistaPersona;
import com.progra.una.vista.VistaReservaciones;
import com.progra.una.vista.VistaVuelos;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorPanelButton {
    private JPanelButtonsAdmin v;
    private VistaAerolineas vA;
    private VistaVuelos vV;
    private VistaReservaciones vR;
    private VistaPersona vP;
    private JPanel principal;

    public ControladorPanelButton(JPanelButtonsAdmin v,JPanel p) {
        this.v = v;
        this.initListeners();
        this.principal =  p;
    }
    public void initListeners(){
        this.v.getBtnAdminAerolinea().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //principal.removeAll();
                vA  = new VistaAerolineas(principal);
                principal.add("aerolineaForm", vA);
                CardLayout card = (CardLayout) principal.getLayout();
                card.next(principal);
            }
        });
        this.v.getBtnAdminVuelos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vV  = new VistaVuelos(principal);
                principal.add("vuelosForm", vV);
                CardLayout card = (CardLayout) principal.getLayout();
                card.next(principal);
            }
        });
        this.v.getBtnAdminReserv() .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               vR  = new VistaReservaciones(principal);
                principal.add("reservacionesForm", vR);
                CardLayout card = (CardLayout) principal.getLayout();
                card.next(principal);
            }
        });
        this.v.getBtnAdminUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vP  = new VistaPersona(principal);
                principal.add("vistaPersona", vP);
                CardLayout card = (CardLayout) principal.getLayout();
                card.next(principal);
            }
        });
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Persistencia;
import com.progra.una.modelo.Persona;
import com.progra.una.vista.ConsultasRegistros;
import com.progra.una.vista.JPanelButtonsAdmin;
import com.progra.una.vista.VistaAerolineas;
import com.progra.una.vista.VistaPersona;
import com.progra.una.vista.VistaReservaciones;
import com.progra.una.vista.VistaVuelos;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorPanelButton implements Initlisteners{
    private JPanelButtonsAdmin v;
    private VistaAerolineas vA;
    private VistaVuelos vV;
    private VistaReservaciones vR;
    private VistaPersona vP;
    private ConsultasRegistros vRe;
    private JPanel principal;
    private Persistencia per;
    private String curPanel;


    public ControladorPanelButton(JPanelButtonsAdmin v,Persistencia per,JPanel p) {
        this.v = v;
        this.InitListeners();
        this.principal =  p;
        this.per = per;
        this.curPanel = "Background";
    }
   
    public Persona LocalUser(){
        Persona user = new Persona("207460988","Oscar","Quesada","Calderón","Administrador","123456");
        return user;
    }

    @Override
    public void InitListeners() {
        this.v.getBtnAdminAerolinea().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                vA  = new VistaAerolineas(principal,per);
                principal.add("aerolineaForm", vA);
                CardLayout card = (CardLayout) principal.getLayout();
                card.next(principal);
                 curPanel = "AdminAerolineas";
            }
        });
        this.v.getBtnAdminVuelos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (per.getListaAerolineas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\nNo hay  Aerolineas agreagadas", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    vV = new VistaVuelos(principal, per);
                    principal.add("vuelosForm", vV);
                    CardLayout card = (CardLayout) principal.getLayout();
                    card.next(principal);
                    curPanel = "AdminVuelos";
                }
            }
        });
        this.v.getBtnAdminReserv().addActionListener(new ActionListener() {
            @Override
           
            public void actionPerformed(ActionEvent e) {
                if (per.getListaAerolineas().isEmpty() || per.getListaVuelos().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\nNo hay  Vuelos agreagados para relizar una reservación", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    vR = new VistaReservaciones(principal, per);
                    principal.add("reservacionesForm", vR);
                    CardLayout card = (CardLayout) principal.getLayout();
                    card.next(principal);
                    curPanel = "AdminReserv";
                }
            }
        });
        this.v.getBtnAdminUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vP  = new VistaPersona(principal,per);
                principal.add("vistaPersona", vP);
                CardLayout card = (CardLayout) principal.getLayout();
                card.next(principal);
                curPanel = "AdminUser";
            }
        });
         this.v.getBtnRegistro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if (per.getListaReportes().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\nNo se han agregado reportes aún.", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                } else {
                vRe  = new ConsultasRegistros(principal,per);
                principal.add("Registros", vRe);
                CardLayout card = (CardLayout) principal.getLayout();
                card.next(principal);
                 curPanel = "Registros";
            }
            }
        });
        this.v.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if(curPanel.equals("AdminAerolineas")){vA.getControlerA().Add();}
              else if(curPanel.equals("AdminVuelos")){vV.getControlerV().Add();}
              //else if(curPanel.equals("AdminReserv")){vR.getControlerR().Add();}
              //else if(curPanel.equals("AdminReserv")){vR.getControlerR().Add();}
              else if(curPanel.equals("AdminUser")){vP.getControlerP().Add();}
              else if(curPanel.equals("Background")){JOptionPane.showMessageDialog(null, "\nPrimero seleccione el serivicio que quiere modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);}
            }
        });
        this.v.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(curPanel.equals("AdminAerolineas")){vA.getControlerA().Update();}
              else if(curPanel.equals("AdminVuelos")){vV.getControlerV().GetObject();}
              //else if(curPanel.equals("AdminReserv")){vR.getControlerR().Update();}
              else if(curPanel.equals("AdminReserv")){vP.getControlerP().Update();}
              else if(curPanel.equals("Background")){JOptionPane.showMessageDialog(null, "\nPrimero seleccione el serivicio que quiere modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);}
            
            }
        });
        this.v.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(curPanel.equals("AdminAerolineas")){vA.getControlerA().Delete();}
              else if(curPanel.equals("AdminVuelos")){vV.getControlerV().Delete();}
              //else if(curPanel.equals("AdminReserv")){vR.getControlerR().Delete();}
              else if(curPanel.equals("AdminReserv")){vR.getControlerR();}
               else if(curPanel.equals("AdminUser")){vP.getControlerP().Delete();}
              else if(curPanel.equals("Background")){JOptionPane.showMessageDialog(null, "\nPrimero seleccione el serivicio que quiere modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);}
              
            }
        });
    }
}

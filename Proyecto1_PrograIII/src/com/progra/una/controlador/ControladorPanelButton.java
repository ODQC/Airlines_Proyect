/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Persistencia;
import com.progra.una.modelo.Persona;
import com.progra.una.modelo.SingletonPanel;
import com.progra.una.modelo.SingletonUsers;
import com.progra.una.vista.ConsultasRegistros;
import com.progra.una.vista.ConsultasReservaciones;
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
public class ControladorPanelButton implements Initlisteners {

    private JPanelButtonsAdmin v;
    private VistaAerolineas vA;
    private VistaVuelos vV;
    private VistaReservaciones vR;
    private VistaPersona vP;
    private ConsultasRegistros vRe;
    ConsultasReservaciones cR;
    private JPanel principal;
    private Persistencia per;
    private SingletonUsers sinP;
    private SingletonPanel sinPan;

    public ControladorPanelButton(JPanelButtonsAdmin v, Persistencia per, JPanel p) {
        this.sinP = SingletonUsers.getSin();
        this.sinPan = SingletonPanel.getSin();
        this.v = v;
        this.InitListeners();
        this.principal = p;
        this.per = per;
        this.sinPan.setID("Background");
        this.Privilegios();
    }

    public void Privilegios() {
        per.getListaPersonas().forEach(
                p -> {
                    if (p.getTipo().equals("Administrador de TI")) {
                        v.getBtnAdminAerolinea().setVisible(true);
                        v.getBtnAdminReserv().setVisible(true);
                        v.getBtnAdminUser().setVisible(true);
                        v.getBtnAdminReserv().setVisible(true);
                        v.getBtnAdminVuelos().setVisible(true);
                        v.getBtnRegistro().setVisible(true);

                    } else if (p.getTipo().equals("Administrador de Aerolineas")) {
                        v.getBtnAdminAerolinea().setVisible(true);
                        v.getBtnAdminReserv().setVisible(false);
                        v.getBtnAdminUser().setVisible(false);
                        v.getBtnAdminReserv().setVisible(true);
                        v.getBtnAdminVuelos().setVisible(true);
                        v.getBtnRegistro().setVisible(false);

                    } else if (p.getTipo().equals("Administrador de Reservaciones")) {
                        v.getBtnAdminAerolinea().setVisible(true);
                        v.getBtnAdminReserv().setVisible(true);
                        v.getBtnAdminUser().setVisible(false);
                        v.getBtnAdminReserv().setVisible(true);
                        v.getBtnAdminVuelos().setVisible(true);
                        v.getBtnRegistro().setVisible(false);
                    } else if (p.getTipo().equals("Administrador de Usuarios")) {
                        v.getBtnAdminAerolinea().setVisible(false);
                        v.getBtnAdminReserv().setVisible(false);
                        v.getBtnAdminUser().setVisible(false);
                        v.getBtnAdminReserv().setVisible(true);
                        v.getBtnAdminVuelos().setVisible(true);
                        v.getBtnRegistro().setVisible(true);
                    }

                }
        );
    }

    @Override
    public void InitListeners() {
        this.v.getBtnAdminAerolinea().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vA = new VistaAerolineas(principal, per);
                principal.add("aerolineaForm", vA);
                CardLayout card = (CardLayout) principal.getLayout();
                card.next(principal);
                sinPan.setID("AdminAerolineas");
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
                    sinPan.setID("AdminVuelos");
                    sinPan.setID("AdminVuelos");
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
                    sinPan.setID("AdminReserv");
                }
            }
        });
        this.v.getBtnAdminUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vP = new VistaPersona(principal, per);
                principal.add("vistaPersona", vP);
                CardLayout card = (CardLayout) principal.getLayout();
                card.next(principal);
                sinPan.setID("AdminUser");
            }
        });
        this.v.getBtnRegistro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (per.getListaReportes().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\nNo se han agregado reportes aún.", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    vRe = new ConsultasRegistros(principal, per);
                    principal.add("Registros", vRe);
                    CardLayout card = (CardLayout) principal.getLayout();
                    card.next(principal);
                    sinPan.setID("Registros");

                }
            }
        });
        this.v.getBtnRegistroReserv().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (per.getListaReservaciones().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\nNo se han agregado reresvaciones aún.", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    cR = new ConsultasReservaciones(principal, per);
                    principal.add("ConReservaciones", cR);
                    CardLayout card = (CardLayout) principal.getLayout();
                    card.next(principal);
                    sinPan.setID("ConReservaciones");
                }
            }
        });
        this.v.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sinPan.getID().equals("AdminAerolineas")) {
                    vA.getControlerA().Add();
                } else if (sinPan.getID().equals("AdminVuelos")) {
                    vV.getControlerV().Add();
                } else if (sinPan.getID().equals("ConReservaciones")) {
                    JOptionPane.showMessageDialog(null, "\nsolo en el Panel de lugares se debe hacer las reservaciones", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                } else if (sinPan.getID().equals("AdminUser")) {
                    vP.getControlerP().Add();
                } else if (sinPan.getID().equals("Background")) {
                    JOptionPane.showMessageDialog(null, "\nPrimero seleccione el serivicio que quiere modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        this.v.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sinPan.getID().equals("AdminAerolineas")||sinPan.getID().equals("ConsultaAerolineas")) {
                    vA.getControlerA().Update();
                } else if (sinPan.getID().equals("AdminVuelos")||sinPan.getID().equals("ConsultaVuelos")) {
                    vV.getControlerV().GetObject();
                } //else if(curPanel.equals("ConReservaciones")){vR.getControlerR().Update();}
                else if (sinPan.getID().equals("AdminReserv")) {
                    vP.getControlerP().Update();
                } else if (sinPan.getID().equals("Background")) {
                    JOptionPane.showMessageDialog(null, "\nPrimero seleccione el serivicio que quiere modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        this.v.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sinPan.getID().equals("AdminAerolineas")||sinPan.getID().equals("ConsultaAerolineas")) {
                    vA.getControlerA().Delete();
                } else if (sinPan.getID().equals("AdminVuelos")||sinPan.getID().equals("ConsultaVuelos")) {
                    vV.getControlerV().Delete();
                } else if (sinPan.getID().equals("ConReservaciones")) {
                    JOptionPane.showMessageDialog(null, "\nLas Resevaciones no se deben eliminar solo cancelar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                } else if (sinPan.getID().equals("AdminReserv")) {
                    vR.getControlerR();
                } else if (sinPan.getID().equals("AdminUser")||sinPan.getID().equals("ConsulPersonas")) {
                    vP.getControlerP().Delete();
                } else if (sinPan.getID().equals("Background")) {
                    JOptionPane.showMessageDialog(null, "\nPrimero seleccione el serivicio que quiere modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
    }
}

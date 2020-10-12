/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Cancelar;
import com.progra.una.controlador.InterfacesControl.CleanForm;
import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Aerolinea;
import com.progra.una.modelo.Interfaces.EnablePlaces;
import com.progra.una.modelo.Interfaces.Identificator;
import com.progra.una.modelo.Interfaces.Mantenimiento;
import com.progra.una.modelo.Interfaces.Report;
import com.progra.una.modelo.SingletonUsers;
import com.progra.una.modelo.Vuelo;
import com.progra.una.vista.ConsultasVuelos;
import com.progra.una.vista.PanelBackground;
import com.progra.una.vista.VistaVuelos;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorVuelo implements Identificator, Cancelar, Mantenimiento, Report, CleanForm, Initlisteners,EnablePlaces {

    private Vuelo m;
    private VistaVuelos v;
    private ConsultasVuelos cV;
    private PanelBackground background;
    private String descripcion1;
    private Aerolinea airSelected;
    private SingletonUsers sinP;

    public ControladorVuelo(Vuelo m, VistaVuelos v) {
        this.m = m;
        this.v = v;
        this.InitListeners();
        this.sinP=SingletonUsers.getSin();
    }

    public void Code() {
        v.getTxtidFly().setText(this.CodeGenerator(8));
    }

    public void EndTask() {
        this.Cancel(v.getPrincipal());
    }

    @Override
    public void Add() {
        try {
            Airlineselected();
            m = new Vuelo(v.getTxtidFly().getText(), v.getTxtSource().getText(), v.getTxtDestination().getText(),
                    v.getJdcTakeOff().getText(), v.getJdcArrive().getText(), v.getCmbCapacity().getSelectedItem().toString(),
                    v.getCmbStatus().getSelectedItem().toString(), airSelected.getIdAirline(), airSelected.getNameAirline());
            this.EnableFlyPacles(m);
            v.getPer().getListaVuelos().add(m);
            descripcion1 = "Se creó el vuelo " + v.getTxtidFly().getText();
            CleanForms();
            this.AddReport(descripcion1,sinP.getID(),v.getPer());
            JOptionPane.showMessageDialog(null, "Se ingresó el elemento correctamente", "Transacción exitosa", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " " + "\nNo se pudo agregar el elemento", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void Delete() {
        if (v.getPer().getListaVuelos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "\n No hay elementos para eliminar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int size = v.getPer().getListaVuelos().size();
                for (int i = 0; i < size; i++) {
                    String id = JOptionPane.showInputDialog("Ingrese el Id del vuelo \n" + "que desea Eliminar:");
                    if (v.getPer().getListaVuelos().get(i).getIdFly().equals(id)) {
                        v.getPer().getListaVuelos().remove(i);
                        descripcion1 = "Se Eliminó el vuelo " + v.getPer().getListaVuelos().get(i).getIdFly();
                        this.AddReport(descripcion1,sinP.getID(),v.getPer());
                        JOptionPane.showMessageDialog(null, "Se eliminó elemento correctamente", "Transacción erronea", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, e + " " + "\nNo se pudo eliminar el elemento", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void GetObject() {
        if (v.getPer().getListaVuelos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "\n No hay elementos para modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String id = JOptionPane.showInputDialog("Ingrese el Id del Vuelo \n" + "que desea modificar:");

                v.getPer().getListaVuelos().forEach(
                        p -> {
                            if (p.getIdFly().equals(id)) {
                                CleanForms();
                                v.getCmbAerolineas().setSelectedItem(p.getNameAirline());
                                v.getTxtidFly().setText(p.getIdFly());
                                v.getTxtSource().setText(p.getSource());
                                v.getTxtDestination().setText(p.getDestination());
                                v.getCmbCapacity().setSelectedItem(p.getCapacity());
                                v.getCmbStatus().setSelectedItem(p.getStatusFly());
                                v.getBtnGenerarCodigo().setVisible(false);
                                v.getBtnCambiar().setVisible(true);

                            }

                        }
                );

            } catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, e + " " + "\nNo se pudo modificar el elemento", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);

            }
        }
    }

    @Override
    public void Update() {
        if (v.getPer().getListaVuelos().isEmpty()) {

        } else {
            try {
                v.getPer().getListaVuelos().forEach(
                        p -> {
                            if (p.getIdFly().equals(v.getTxtidFly())) {
                                p.setSource(v.getTxtSource().getText());
                                p.setDestination(v.getTxtDestination().getText());
                                p.setCapacity(v.getCmbCapacity().getSelectedItem().toString());
                                p.setStatusFly(v.getCmbStatus().getSelectedItem().toString());
                                p.setTakeOffDate(v.getJbTakeOff().getText());
                                p.setArrivalDate(v.getJdcArrive().getText());
                                descripcion1 = "Se Modificó el vuelo " + v.getTxtidFly().getText();
                                this.AddReport(descripcion1,sinP.getID(),v.getPer());
                                JOptionPane.showMessageDialog(null, "El elemento se modificó correctamente" + "\n", "Transacción exitosa", JOptionPane.WARNING_MESSAGE);
                                CleanForms();
                                v.getBtnGenerarCodigo().setVisible(true);
                                v.getBtnCambiar().setVisible(false);
                            }

                        }
                );

            } catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, e + " " + "\nNo se pudo modificar el elemento", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);

            }
        }
    }

    public void Airlineselected() {
        if (v.getPer().getListaAerolineas().isEmpty()) {
            JOptionPane.showMessageDialog(null, "\n No hay elementos para modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } else {
            v.getPer().getListaAerolineas().forEach(p -> {
                if (p.getNameAirline().equals(v.getCmbAerolineas().getSelectedItem().toString())) {
                    airSelected = p;
                }
            });
        }
    }

    @Override
    public void CleanForms() {
        v.getCmbAerolineas().setSelectedIndex(0);
        v.getTxtidFly().setText("");
        v.getTxtSource().setText("");
        v.getTxtDestination().setText("");
        v.getCmbCapacity().setSelectedIndex(0);
        v.getCmbStatus().setSelectedIndex(0);
    }

    @Override
    public void InitListeners() {
        this.v.getBtnVuelos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.getPer().getListaVuelos().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    cV = new ConsultasVuelos(v.getPrincipal(), v.getPer());
                    v.getPrincipal().add("aerolineaForm", cV);
                    CardLayout card = (CardLayout) v.getPrincipal().getLayout();
                    card.next(v.getPrincipal());
                }
            }
        });
        this.v.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EndTask();
            }
        });
        this.v.getBtnCambiar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update();
            }
        });
        this.v.getBtnGenerarCodigo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Code();

            }
        });

    }
}

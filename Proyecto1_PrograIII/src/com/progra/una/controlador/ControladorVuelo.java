/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Cancelar;
import com.progra.una.modelo.Aerolinea;
import com.progra.una.modelo.Interfaces.Identificator;
import com.progra.una.modelo.Interfaces.Mantenimiento;
import com.progra.una.modelo.Interfaces.Report;
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
public class ControladorVuelo implements Identificator, Cancelar, Mantenimiento, Report {

    private Vuelo m;
    private VistaVuelos v;
    private ConsultasVuelos cV;
    private PanelBackground background;
    private String descripcion1;
    private Aerolinea airSelected;

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
                cV = new ConsultasVuelos(v.getPrincipal(), v.getPer());
                v.getPrincipal().add("aerolineaForm", cV);
                CardLayout card = (CardLayout) v.getPrincipal().getLayout();
                card.next(v.getPrincipal());
            }
        });
        this.v.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EndTask();
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

    public void EndTask() {
        this.Cancel(v.getPrincipal());
    }

    @Override
    public void Add() {
        try {

            Vuelo Airl = new Vuelo(v.getTxtidFly().getText(), v.getTxtSource().getText(), v.getTxtDestination().getSelectedText(),
                    v.getJdcTakeOff().getText(), v.getJdcArrive().getText(), v.getCmbCapacity().getSelectedItem().toString(),
                    v.getCmbStatus().getSelectedItem().toString(), airSelected.getIdAirline(), airSelected.getNameAirline());

            v.getPer().getListaAerolineas().add(Airl);
            descripcion1 = "Se creó el vuelo" + v.getTxtidFly().getText();
            this.AddReport(descripcion1);
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
                        descripcion1 = "Se Eliminó el vuelo" + v.getPer().getListaVuelos().get(i).getIdFly();
                        this.AddReport(descripcion1);
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

    @Override
    public void Find() {
        if (v.getPer().getListaVuelos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "\n No hay elementos para buscar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } else {
            String id = JOptionPane.showInputDialog("Ingrese el Id del Vuelo \n" + "que desea buscar:");
            v.getPer().getListaVuelos().forEach(p -> {
                if (p.getIdFly().equals(id)) {
                    JOptionPane.showMessageDialog(null, "\n No hay elementos para eliminar"
                    + p.getIdFly() +"\n" 
                    + p.getSource()+"\n"
                    + p.getDestination()+"\n"
                    + p.getCapacity()+"\n"
                    + p.getStatusFly()+"\n"
                    + p.getTakeOffDate()+"\n"
                    + p.getArrivalDate()+"\n"
                    , "ADVERTENCIA!!" , JOptionPane.WARNING_MESSAGE);
                }
            });
        }
    }

    @Override
    public void Update() {
        if (v.getPer().getListaVuelos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "\n No hay elementos para modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int size = v.getPer().getListaVuelos().size();
                for (int i = 0; i < size; i++) {
                    String id = JOptionPane.showInputDialog("Ingrese el Id del Vuelo \n" + "que desea modificar:");
                    if (v.getPer().getListaVuelos().get(i).getIdFly().equals(id)) {
                        String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre Aerolinea:");
                        v.getPer().getListaAerolineas().get(i).setNameAirline(nombre);
                        descripcion1 = "Se Modificó la Aerolinea" + v.getPer().getListaVuelos().get(i).getIdFly();
                        this.AddReport(descripcion1);
                        // Aerolinea Airl = new Aerolinea(v.getTxtCodigoAerolinea().getText(), v.getTxtNombreAerolinea().getText());
                        JOptionPane.showMessageDialog(null, "El elemento se modificó correctamente" + "\n", "Transacción exitosa", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, e + " " + "\nNo se pudo modificar el elemento", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);

            }
        }
    }

    

    public void Airlineselected() {
        if (v.getPer().getListaVuelos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "\n No hay elementos para modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } else {
            v.getPer().getListaAerolineas().forEach(p -> {
                if (p.getNameAirline().equals(v.getCmbAerolineas().getSelectedItem().toString())) {
                    airSelected = p;
                }
            });
        }
    }
}

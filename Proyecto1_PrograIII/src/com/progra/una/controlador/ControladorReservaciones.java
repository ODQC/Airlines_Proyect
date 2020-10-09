/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Cancelar;
import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Interfaces.Mantenimiento;
import com.progra.una.modelo.Interfaces.Report;
import com.progra.una.modelo.Reservacion;
import com.progra.una.vista.ConsultasVuelos;
import com.progra.una.vista.PanelBackground;
import com.progra.una.vista.VistaLugares;
import com.progra.una.vista.VistaReservaciones;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorReservaciones implements Cancelar, Report, Initlisteners {

    private Reservacion m;
    private VistaReservaciones v;
    private VistaLugares vL;
    private PanelBackground background;
   
    public ControladorReservaciones(Reservacion m, VistaReservaciones r) {
        this.m = m;
        this.v = r;
        this.InitListeners();
    }

    public void EndTask() {
        this.Cancel(v.getPrincipal());
    }

    
    public void LoadFlies() {
        try {
            v.getPer().getListaVuelos().forEach( // se llama la lista donde estan los objetos
                    p -> { //se implementa la lamba donde p es el objeto 
                        DefaultTableModel modelo = (DefaultTableModel) v.gettVuelos().getTblVuelos().getModel(); // se crea un modelo para la tabla
                        if (p.getNameAirline().equals(v.getCmbAerolineas().getSelectedItem().toString())) {
                            Object[] colum = new Object[9];// se asigna un vector con la cantidad de colummas que tiene la tabla
                            colum[0] = p.getIdFly(); // se asignan los parametros de los objetos a las columnas
                            colum[1] = p.getSource();
                            colum[2] = p.getDestination();
                            colum[3] = p.getCapacity();
                            colum[4] = p.getStatusFly();
                            colum[5] = p.getTakeOffDate();
                            colum[6] = p.getArrivalDate();

                            modelo.addRow(colum); // se agregan las columnas(el objeto) a una fila de la tabla 
                            v.gettVuelos().getTblVuelos().setModel(modelo);// se agrega el modelo a la tabla
                        }
                    }
            );

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex + " " + "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {

            System.err.println(ex);

        }
    }
    @Override
    public void InitListeners() {
        this.v.getBtnSiguiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.getPer().getListaAerolineas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\nNo hay elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                    
                } else {
                    
                    int  fly = v.gettVuelos().getTblVuelos().getSelectedRow();
                    vL = new VistaLugares(v.getPrincipal(), v.getPer());
                    vL.getC().AirlineSelected(fly);
                    v.getPrincipal().add("aerolineaForm", vL);
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
        this.v.getBtnDesplegar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.getPer().getListaAerolineas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\nNo hay elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    LoadFlies();
                }
            }
        });

//        this.v.getCmbAerolineas().add(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               EndTask();
//            }
//        });
    }

    

    

}

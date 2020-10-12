/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Cancelar;
import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Aerolinea;
import com.progra.una.modelo.Interfaces.Identificator;
import com.progra.una.modelo.Interfaces.Mantenimiento;
import com.progra.una.modelo.Interfaces.Report;
import com.progra.una.modelo.Lugar;
import com.progra.una.modelo.Reservacion;
import com.progra.una.modelo.SingletonUsers;
import com.progra.una.modelo.Vuelo;
import com.progra.una.vista.PanelBackground;
import com.progra.una.vista.VistaLugares;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorLugar implements Cancelar, Mantenimiento,Initlisteners,Identificator,Report{
    private Lugar m;
    private VistaLugares v;
    private PanelBackground background;
    private Vuelo idflySelected;
    private ArrayList<Lugar> PlaceSelected;
    private Reservacion Reserv;
    private SingletonUsers sinP;
    private String descripcion;
   
    
    public ControladorLugar(Lugar m, VistaLugares v) {
        this.m = m;
        this.v = v;
        this.InitListeners();
        this.PlaceSelected = new ArrayList<Lugar>();
        this.sinP=SingletonUsers.getSin();
        
    }
     
    public void EndTask(){
    this.Cancel(v.getPanelPrincipal());
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

                int confirmar;
                confirmar = JOptionPane.showConfirmDialog(null, "Por favor, confirme su reservación ", "Confirmación de Resevación", WIDTH, HEIGHT);

                if (JOptionPane.YES_NO_OPTION == confirmar) {
                   Add();
                }
            }
        });
        this.v.getBtnAtras().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 v.getPanelPrincipal().remove(v);
                 CardLayout card = (CardLayout) v.getPanelPrincipal().getLayout();
                 card.previous(v.getPanelPrincipal());

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

                place.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        ButtonSelected(place, fly, evt);
                        ShowPlaces();
                    }
                });

                if (fly.getListPlace().get(i).getStatusPlace().equals("Reservado")) {
                    place.setBackground(java.awt.Color.RED);
                    
                } else {
                    if (i <= 29) {
                        place.setBackground(java.awt.Color.ORANGE);
                        v.getSeccion1().add(place);
                    } else if (30 <= i && i <= 59) {
                        place.setBackground(java.awt.Color.ORANGE);
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

    public void ButtonSelected(JButton B, Vuelo fly, java.awt.event.MouseEvent evt) {
        // if (B.isSelected()) {
        try {
            int i;
            for (i = 0; i < fly.getListPlace().size(); i++) {
 
               
                if (fly.getListPlace().get(i).getIdPlace().equals(B.getText())) {
                    if (fly.getListPlace().get(i).getStatusPlace().equals("Disponible")) {
                        fly.getListPlace().get(i).setStatusPlace("Reservado");
                        B.repaint();
                        B.setBackground(java.awt.Color.RED);
                        PlaceSelected.add(fly.getListPlace().get(i));
                        
                        
                        break;
                   }
               }else if (fly.getListPlace().get(i).getStatusPlace().equals("Reservado")){
                    JOptionPane.showMessageDialog(null,"Este lugar ya ha sido reservado", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
               }
                else {
                  for (int j = 0; j < PlaceSelected.size(); j++) {
                        if (PlaceSelected.get(j).getIdPlace().equals(B.getText())) {
                            PlaceSelected.remove(j);
                            fly.getListPlace().get(i).setStatusPlace("Disponible");
                            B.setBackground(java.awt.Color.GREEN);
                            
                            break;                        
                        }
                  }

                }
           
            }
           
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void ShowPlaces() {
          try {
              CleanTable();
        PlaceSelected.forEach(
              p -> { //se implementa la lamba donde p es el objeto 
                        DefaultTableModel modelo = (DefaultTableModel) v.getTblPlaces().getModel(); // se crea un modelo para la tabla
                        Object[] colum = new Object[1];// se asigna un vector con la cantidad de colummas que tiene la tabla
                        colum[0] = p.getIdPlace(); // se asignan los parametros de los objetos a las columnas
                        modelo.addRow(colum); // se agregan las columnas(el objeto) a una fila de la tabla 
                        v.getTblPlaces().setModel(modelo);// se agrega el modelo a la tabla
                    }
            );

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex + " " + "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {

            System.err.println(ex);

        }
               

    }

    public void setIdflySelected(Vuelo idflySelected) {
        this.idflySelected = idflySelected;
    }
   
   
    @Override
    public void Add() {
        try {
            if (PlaceSelected.isEmpty()) {
                JOptionPane.showMessageDialog(null, "\nNo hay espacios seleccionados para esta reservación\n ", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
            } else {
                Reservacion newReserv = new Reservacion(this.CodeGenerator(8), "Activo", LocalDateTime.now().toString(), idflySelected.getIdFly(),
                        idflySelected.getSource(), idflySelected.getDestination(), idflySelected.getTakeOffDate(), idflySelected.getArrivalDate(),
                        idflySelected.getCapacity(), idflySelected.getStatusFly(), idflySelected.getIdAirline(), idflySelected.getNameAirline());

                PlaceSelected.forEach(
                        p -> {
                            if(p.getStatusPlace().equals("Reservado")){
                            newReserv.getPlaceReserv().add(p);}
                        }
                );
                 v.getPer().getListaReservaciones().add(newReserv);
                 descripcion = "Se hizo la resevación " + newReserv.getIdreservation();
                                this.AddReport(descripcion,sinP.getID(),v.getPer());
                JOptionPane.showMessageDialog(null, "\nReservación:"
                        + "Codigo de Reservacion:" + newReserv.getIdreservation() + "\n"
                        + "Estado de reservacion:" + newReserv.getReservStatus() + "\n"
                        + "Fecha de Creación:" + newReserv.getReservDate() + "\n"
                        + "Codigo de Vuelo:" + newReserv.getIdFly() + "\n"
                        + "Lugar de Origen:" + newReserv.getSource() + "\n"
                        + "Lugar de Destino:" + newReserv.getDestination() + "\n"
                        + "Capacidad:" + newReserv.getCapacity() + "\n"
                        + "Estado:" + newReserv.getStatusFly() + "\n"
                        + "Fecha de Salida" + newReserv.getTakeOffDate() + "\n"
                        + "Fecha de llegada:" + newReserv.getArrivalDate() + "\n",
                        "Detalle de reservación:", JOptionPane.INFORMATION_MESSAGE);
                        GoHome();
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex, "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {

            System.err.println(ex);

        }
    }

    public void CleanTable() {

        DefaultTableModel modelo = (DefaultTableModel) v.getTblPlaces().getModel(); // se crea un modelo para la tabla
        Object[] colum = new Object[1];// se asigna un vector con la cantidad de colummas que tiene la tabla
        colum[0] = null; // se asignan los parametros de los objetos a las columnas
        modelo.addRow(colum); // se agregan las columnas(el objeto) a una fila de la tabla 
        v.getTblPlaces().setModel(modelo);
    }
    public void GoHome() {
        background = new PanelBackground(v.getPanelPrincipal());
        v.getPanelPrincipal().add("aerolineaForm", background);
        CardLayout card = (CardLayout) v.getPanelPrincipal().getLayout();
        card.next(v.getPanelPrincipal());
    }
}

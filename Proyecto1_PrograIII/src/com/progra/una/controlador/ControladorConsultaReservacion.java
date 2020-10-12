/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Cancelar;
import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Interfaces.FindObject;
import com.progra.una.modelo.Interfaces.Report;
import com.progra.una.modelo.Interfaces.ShowObjects;
import com.progra.una.modelo.Persistencia;
import com.progra.una.modelo.SingletonUsers;
import com.progra.una.vista.ConsultasReservaciones;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorConsultaReservacion implements Initlisteners,Cancelar,FindObject,Report,ShowObjects {
    private ConsultasReservaciones v;
    private Persistencia per;
    private SingletonUsers sinP;

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
               Find();
            }
        });
       
        this.v.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               EndTask();
            }
        });
    }

    @Override
    public void Find() {
         String id = JOptionPane.showInputDialog("Ingrese el Id de la Reservación \n" + "que desea buscar:");
        v.getPer().getListaReservaciones().forEach(
                p -> {
                    if (p.getIdreservation().equals(id)) {
                        JOptionPane.showMessageDialog(null, "\nDetalle de reservación:"
                        + "Codigo de Reservacion:" + p.getIdreservation() + "\n"
                        + "Estado de reservacion:" + p.getReservStatus() + "\n"
                        + "Fecha de Creación:" + p.getReservDate() + "\n"
                        + "Codigo de Vuelo:" + p.getIdFly() + "\n"
                        + "Lugar de Origen:" + p.getSource()+ "\n"
                        + "Lugar de Destino:" + p.getDestination() + "\n"
                        + "Capacidad:" + p.getCapacity() + "\n"
                        + "Estado:" + p.getStatusFly() + "\n"
                        + "Fecha de Salida" + p.getTakeOffDate() + "\n"
                        + "Fecha de llegada:" + p.getArrivalDate() + "\n",
                        "Busqueda", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
        );
    }
    public void EndTask(){
    this.Cancel(v.getPanelPrincipal());
    }
     @Override
    public void ShowObjects() {
       
        try {
            per.getListaReservaciones().forEach( // se llama la lista donde estan los objetos
                    p -> { //se implementa la lamba donde p es el objeto 
                        DefaultTableModel modelo = (DefaultTableModel) v.getTblReserv().getModel(); // se crea un modelo para la tabla
                        Object[] colum = new Object[13];// se asigna un vector con la cantidad de colummas que tiene la tabla
                        colum[0] = p.getIdreservation();// se asignan los parametros de los objetos a las columnas
                        colum[1] =  p.getReservStatus();
                        colum[2] = p.getReservDate();
                        colum[3] =  p.getIdFly();
                        colum[5] = p.getSource();
                        colum[6] = p.getDestination();
                        colum[7] = p.getCapacity();
                        colum[8] = p.getStatusFly() ;
                        colum[9]= p.getIdAirline();
                        colum[10]= p.getNameAirline(); 
                        colum[11] = p.getTakeOffDate() ;
                        colum[12] =p.getArrivalDate();
                        
                        modelo.addRow(colum); // se agregan las columnas(el objeto) a una fila de la tabla 
                        v.getTblReserv().setModel(modelo);// se agrega el modelo a la tabla
                    }
            );

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex + " " + "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {

            System.err.println(ex);

        }
    }
}

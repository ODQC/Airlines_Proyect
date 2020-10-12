/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Cancelar;
import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Interfaces.FindObject;
import com.progra.una.modelo.Persistencia;
import com.progra.una.modelo.SingletonUsers;
import com.progra.una.vista.ConsultasVuelos;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorConsultaVuelo implements FindObject,Cancelar,Initlisteners {
    private ConsultasVuelos v;
     private Persistencia per;
     private SingletonUsers sinP;

    public ControladorConsultaVuelo(ConsultasVuelos v, Persistencia per) {
        this.v = v;
        this.per = per;
        this.InitListeners();
    }
     
     @Override
    public void Find() {
        if (v.getPer().getListaVuelos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "\n No hay elementos para buscar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } else {
            String id = JOptionPane.showInputDialog("Ingrese el Id del Vuelo \n" + "que desea buscar:");
            v.getPer().getListaVuelos().forEach(p -> {
                if (p.getIdFly().equals(id)) {
                    JOptionPane.showMessageDialog(null, "\nResultado busqueda:"
                    +"\nCodigo de Vuelo:"+ p.getIdFly() +"\n" 
                    +"Lugar de Origen:"+ p.getSource()+"\n"
                    +"Lugar de Destino:"+ p.getDestination()+"\n"
                    +"Capacidad:"+ p.getCapacity()+"\n"
                    +"Estado:"+ p.getStatusFly()+"\n"
                    +"Fecha de Salida"+ p.getTakeOffDate()+"\n"
                    +"Fecha de llegada:"+ p.getArrivalDate()+"\n"
                    , "Busqueda" , JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }
    }
    public void Cancelar(){
    this.Cancel(v.getPanelPrincipal());
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
               Cancelar();
            }
        });   
    }
}

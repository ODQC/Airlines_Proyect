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
import com.progra.una.vista.ConsultasAerolineas;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorConsultaAero implements FindObject,Cancelar, Initlisteners {
    private ConsultasAerolineas v;
    private Persistencia per;

    public ControladorConsultaAero(ConsultasAerolineas v, Persistencia per) {
        this.v = v;
        this.per = per;
        this.InitListeners();
    }
   
      @Override
    public void Find() {
        String id = JOptionPane.showInputDialog("Ingrese el Id de la Aerolinea \n" + "que desea buscar:");
        v.getPer().getListaAerolineas().forEach(
                p -> {
                    if (p.getIdAirline().equals(id)) {
                         if (p.getIdAirline().equals(id)) {
                    JOptionPane.showMessageDialog(null, "\nResultado de busqueda:"
                    +"\nNombre de Aerolinea"+ p.getNameAirline() +"\n" 
                    +"Código:"+ p.getIdAirline()+"\n"
                    , "Busqueda" , JOptionPane.INFORMATION_MESSAGE);
                }
                    }
                }
        );
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

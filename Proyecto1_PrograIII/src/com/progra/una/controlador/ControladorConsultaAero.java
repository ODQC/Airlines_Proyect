/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;

import com.progra.una.controlador.InterfacesControl.Cancelar;
import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.modelo.Interfaces.FindObject;
import com.progra.una.modelo.Interfaces.ShowObjects;
import com.progra.una.modelo.Persistencia;
import com.progra.una.vista.ConsultasAerolineas;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorConsultaAero implements FindObject,Cancelar, Initlisteners, ShowObjects {
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

    @Override
    public void ShowObjects() {
       
        try {
            per.getListaAerolineas().forEach( // se llama la lista donde estan los objetos
                    p -> { //se implementa la lamba donde p es el objeto 
                        DefaultTableModel modelo = (DefaultTableModel) v.getTblAirlines().getModel(); // se crea un modelo para la tabla
                        Object[] colum = new Object[2];// se asigna un vector con la cantidad de colummas que tiene la tabla
                        colum[0] = p.getIdAirline(); // se asignan los parametros de los objetos a las columnas
                        colum[1] = p.getNameAirline();
                        modelo.addRow(colum); // se agregan las columnas(el objeto) a una fila de la tabla 
                        v.getTblAirlines().setModel(modelo);// se agrega el modelo a la tabla
                    }
            );

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex + " " + "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {

            System.err.println(ex);

        }
    }
}

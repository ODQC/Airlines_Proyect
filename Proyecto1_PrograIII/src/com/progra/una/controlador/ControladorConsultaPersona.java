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
import com.progra.una.vista.ConsultasPersonas;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorConsultaPersona implements FindObject, Cancelar, Initlisteners{
    private Persistencia per;
    private ConsultasPersonas v;

    public ControladorConsultaPersona(Persistencia per, ConsultasPersonas v) {
        this.per = per;
        this.v = v;
        InitListeners();
    }

          @Override
    public void Find() {
        String id = JOptionPane.showInputDialog("Ingrese el Id de la Persona \n" + "que desea buscar:");
        v.getPer().getListaPersonas().forEach(
                p -> {
                    if (p.getId().equals(id)) {
                        if (p.getId().equals(id)) {
                            JOptionPane.showMessageDialog(null, "\nResultado de busqueda:"
                                    + "\nNombre:" + p.getName() + "\n"
                                    + "ID:" + p.getId()
                                    + "\nPrimer Apellido:" + p.getApellido1() + "\n"
                                    + "Segundo Apellido:" + p.getId() + "\n"
                                    + "Contraseña:" + p.getPassword() + "\n"
                                    + "Tipo de ususario:" + p.getTipo() + "\n",
                                     "Busqueda", JOptionPane.INFORMATION_MESSAGE);
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

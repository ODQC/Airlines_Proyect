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
import com.progra.una.vista.ConsultasRegistros;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorConsultasRegistros implements Initlisteners, Cancelar,FindObject {

    private ConsultasRegistros v;
    private Persistencia per;
    private SingletonUsers sinP;
    

    public ControladorConsultasRegistros(ConsultasRegistros v, Persistencia per) {
        this.v = v;
        this.per = per;
        this.InitListeners();
        this.sinP=SingletonUsers.getSin();
    }

    @Override
    public void InitListeners() {

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

    public void EndTask() {
        this.Cancel(v.getPanelPrincipal());
    }

    @Override
    public void Find() {
         String id = JOptionPane.showInputDialog("Ingrese el Id del reporte \n" + "que desea buscar:");
        v.getPer().getListaReportes().forEach(
                p -> {
                    if (p.getIdReport().equals(id)) {
                         if (p.getIdReport().equals(id)) {
                    JOptionPane.showMessageDialog(null, 
                    "Id Reporte: "+ p.getIdReport()+"\n"
                    +"Id Usuario: "+ p.getIdUsuario()+"\n"
                    +"Descripción: "+ p.getDescription()+"\n"
                    +"Fecha: "+ p.getDate()+"\n"
                    , "Resultado de busqueda:" , JOptionPane.INFORMATION_MESSAGE);
                }
                    }
                }
        );
    }
}

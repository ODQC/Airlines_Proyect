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
import com.progra.una.modelo.Interfaces.ConvertirPwd;

import com.progra.una.modelo.Interfaces.Mantenimiento;
import com.progra.una.modelo.Interfaces.Report;
import com.progra.una.modelo.Persona;
import com.progra.una.modelo.Reporte;
import com.progra.una.modelo.Reservacion;
import com.progra.una.modelo.Vuelo;
import com.progra.una.vista.ConsultasPersonas;
import com.progra.una.vista.VistaPersona;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ControladorPersona implements Mantenimiento, Cancelar, CleanForm, Initlisteners, Report, ConvertirPwd{
private Persona m;
private VistaPersona v;
private String descripcion;
private ConsultasPersonas cP;

    public ControladorPersona(Persona m, VistaPersona v) {
        this.m = m;
        this.v = v;
        InitListeners();
    }    
    
        
    @Override
    public void Add() {
    try {
        if(Convertir(v.getPwdContra1()).equals(Convertir((v.getPwdContra2())))){
        m = new Persona(v.getTxtId().getText(),v.getTxtNombre().getText(),v.getTxtApellido1().getText(),v.getTxtApellido2().getText(),v.getTipoTexto(),Convertir(v.getPwdContra1()));
        v.getPer().getListaPersonas().add(m);
        descripcion = "Se ha creado la persona " + v.getTxtId().getText();
        this.AddReport(descripcion,"207460988", v.getPer());
        CleanForms();
        JOptionPane.showMessageDialog(null, descripcion, "Transaccion Exitosa!!", JOptionPane.WARNING_MESSAGE);
        }else{
                 JOptionPane.showMessageDialog(null, "Las Contraseñas no coinciden", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                }
    } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex + " " + "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
    }
    catch (Exception ex) {
           
            System.err.println(ex);
        JOptionPane.showMessageDialog(null, "\nError de guardado", "Album", JOptionPane.ERROR_MESSAGE);
    }
           
    }

    @Override
    public void Delete() {

        if (v.getPer().getListaPersonas().isEmpty()) {
            JOptionPane.showMessageDialog(null, "\n No hay elementos para eliminar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int size = v.getPer().getListaPersonas().size();
                int i;
                String id = JOptionPane.showInputDialog("Ingrese el Id de la Aerolinea \n" + "que desea Eliminar:");
                for (i = 0; i < size; i++) {

                    if (v.getPer().getListaPersonas().get(i).getId().equals(id)) {
                        v.getPer().getListaPersonas().remove(i);
                        descripcion = "Se Eliminó la Persona " + v.getTxtId().getText();
                        this.AddReport(descripcion, "207460988", v.getPer());
                        JOptionPane.showMessageDialog(null, "Se eliminó la persona correctamente", "Transacción erronea", JOptionPane.WARNING_MESSAGE);
                       
                        break;
                    }
                }
                 if (v.getPer().getListaPersonas().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                            cP.getPanelPrincipal().remove(cP);
                            CardLayout card = (CardLayout) cP.getPanelPrincipal().getLayout();
                            card.previous(cP.getPanelPrincipal());
                            
                        } else {
                            
                                     
                        }

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, ex + " " + "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {

                System.err.println(ex);
                JOptionPane.showMessageDialog(null, ex, "Album", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
  
    
    
        public void GetObject() {
        if (v.getPer().getListaPersonas().isEmpty()) {
            JOptionPane.showMessageDialog(null, "\n No hay elementos para modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String id = JOptionPane.showInputDialog("Ingrese el Id del Vuelo \n" + "que desea modificar:");

                v.getPer().getListaPersonas().forEach(
                        p -> {
                            if (p.getId().equals(id)) {
                                CleanForms();
                                v.getTxtId().setText(p.getId());
                                v.getTxtId().setEditable(false);
                                v.getTxtNombre().setText(p.getName());
                                v.getTxtApellido1().setText(p.getApellido1());
                                v.getTxtApellido2().setText(p.getApellido2());
                                v.getPwdContra1().setText(p.getPassword());
                                v.getPwdContra2().setText(p.getPassword());
                                v.getTipoBG().setSelected(v.getTipoBoton().getModel(),true);

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

 
    }

    @Override
    public void CleanForms() {
        v.getTxtId().setText("");
        v.getTxtNombre().setText("");
        v.getTxtApellido1().setText("");
        v.getTxtApellido2().setText("");
        v.getPwdContra1().setText("");
        v.getPwdContra2().setText("");
        v.getTipoBG().clearSelection();
        
    }

    @Override
    public void InitListeners() {
            this.v.getBtnVerUsuarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                if (v.getPer().getListaPersonas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    cP = new ConsultasPersonas(v.getPrincipal(), v.getPer());
                    v.getPrincipal().add("PeopleForm", cP);
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
    
        
    }
    
    public void EndTask(){
        this.Cancel(v.getPrincipal());
    }

    
    
//    public String UserSelected(){
//
//    }
    
}

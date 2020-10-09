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
import com.progra.una.modelo.Interfaces.Identificator;
import com.progra.una.modelo.Interfaces.Mantenimiento;
import com.progra.una.modelo.Interfaces.Report;
import com.progra.una.vista.ConsultasAerolineas;
import com.progra.una.vista.PanelBackground;
import com.progra.una.vista.VistaAerolineas;
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
public class ControladorAerolinea implements Identificator, Cancelar, Mantenimiento,Report,CleanForm{

    private Aerolinea m;
    private VistaAerolineas v;
    private ConsultasAerolineas cA;
    private PanelBackground background;
    private  String descripcion1 ;
    
    public ControladorAerolinea(Aerolinea m, VistaAerolineas v) {
        this.m = m;
        this.v = v;
        this.initListeners();

    }

    public void initListeners() {
        this.v.getBtnVerAero().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                if (v.getPer().getListaAerolineas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    cA = new ConsultasAerolineas(v.getPanelPrincipal(), v.getPer());
                    v.getPanelPrincipal().add("aerolineaForm", cA);
                    CardLayout card = (CardLayout) v.getPanelPrincipal().getLayout();
                    card.next(v.getPanelPrincipal());
                }
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
        v.getTxtCodigoAerolinea().setText(this.CodeGenerator(8));
    }

    public void EndTask() {
        this.Cancel(v.getPanelPrincipal());
    }

    @Override
    public void Add() {
        try {

            Aerolinea Airl = new Aerolinea(v.getTxtCodigoAerolinea().getText(), v.getTxtNombreAerolinea().getText());
            v.getPer().getListaAerolineas().add(Airl);
            descripcion1 = "Se creó la Aerolinea " + v.getTxtCodigoAerolinea().getText();
            this.AddReport(descripcion1,"207460988",v.getPer());
            CleanForms();
            JOptionPane.showMessageDialog(null, "Se ingresó el elemento correctamente", "Transacción exitosa", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " " + "\nNo se pudo agregar el elemento", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void Delete() {
         if(v.getPer().getListaAerolineas().isEmpty()){
           JOptionPane.showMessageDialog(null, "\n No hay elementos para eliminar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
       }else{ try {
        int size = v.getPer().getListaAerolineas().size();
         String  id = JOptionPane.showInputDialog("Ingrese el Id de la Aerolinea \n"+"que desea Eliminar:");
        for (int i = 0; i < size; i++) {
           
            if (v.getPer().getListaAerolineas().get(i).getIdAirline().equals(id)) {
                v.getPer().getListaAerolineas().remove(i);
                descripcion1 = "Se Eliminó la Aerolinea "+v.getTxtCodigoAerolinea().getText();
                this.AddReport(descripcion1,"207460988",v.getPer());
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
    public void Update() {
        if(v.getPer().getListaAerolineas().isEmpty()){
           JOptionPane.showMessageDialog(null, "\n No hay elementos para modificar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
       }else{try {
        int size = v.getPer().getListaAerolineas().size();
        String  id = JOptionPane.showInputDialog("Ingrese el Id de la Aerolinea \n"+"que desea modificar:");
      v.getPer().getListaAerolineas().forEach(p-> {  
            if (p.getIdAirline().equals(id)) { 
                String  nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre Aerolinea:");
                p.setNameAirline(nombre);
                descripcion1 = "Se Modificó la Aerolinea "+v.getTxtCodigoAerolinea().getText();
                this.AddReport(descripcion1,"207460988",v.getPer());
                JOptionPane.showMessageDialog(null, "El elemento se modificó correctamente" + "\n", "Transacción exitosa", JOptionPane.WARNING_MESSAGE);
                
            } 
        });
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, e + " " + "\nNo se pudo modificar el elemento", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);

        }
        }
    }


   

    public void removeSelectedRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int[] rows = table.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            model.removeRow(rows[i] - i);
        }
    }

    @Override
    public void CleanForms() {
        v.getTxtCodigoAerolinea().setText("");
        v.getTxtNombreAerolinea().setText("");
    }

    
    
//    try {
//    } catch (NullPointerException ex) {
//            JOptionPane.showMessageDialog(null, ex + " " + "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
//    }
//    catch (Exception ex) {
//           
//            System.err.println(ex);
//        JOptionPane.showMessageDialog(null, "\nNo hay mas imagenes siguientes", "Album", JOptionPane.ERROR_MESSAGE);
//    }


}

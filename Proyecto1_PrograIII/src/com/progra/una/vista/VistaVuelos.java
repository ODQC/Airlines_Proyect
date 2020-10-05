/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;

import com.progra.una.controlador.ControladorVuelo;
import datechooser.beans.DateChooserCombo;
import com.progra.una.modelo.Persistencia;
import com.progra.una.modelo.Vuelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class VistaVuelos extends javax.swing.JPanel{
    private JPanel principal;
    private ControladorVuelo c;
    private Vuelo m;
    private Persistencia per;
    private JButton btnCancelar;
    private JButton btnVuelos;
    private JButton  btnGenerarCodigo;
    private JTextField txtidFly;
    private JTextField txtSource;
    private JTextField txtDestination;
    private JComboBox<String> cmbCapacity;
    private JComboBox<String> cmbStatus;
    private JLabel lbId;
    private JLabel lbGenerarcodigo;
    private JLabel lbSource;
    private JLabel lbDestination;
    private JLabel lbCapacity;
    private JLabel lbStatus;
    private JComboBox<String> cmbAerolineas;
    private JLabel lbSelectAirline;
    private javax.swing.JLabel jbTakeOff;
    private javax.swing.JLabel jlArrival;
    private datechooser.beans.DateChooserCombo jdcArrive;
    private datechooser.beans.DateChooserCombo jdcTakeOff;


    public VistaVuelos(JPanel principal,Persistencia per) {
        this.principal = principal;
        this.per = per;
        this.InitComponents();
        this.c = new ControladorVuelo(m,this);
        this.Iniciar();
    }
    public void Iniciar(){
        this.setVisible(true);
    }
    public void FillCombos(){
        ArrayList<String> capacidad = new ArrayList();
            String capacidad0 = "Seleccionar";
            String capacidad1 = "90";
            capacidad.add(capacidad0);
            capacidad.add(capacidad1);
            capacidad.forEach(p -> cmbCapacity.addItem(p) );
            
            ArrayList<String> statusList = new ArrayList();
            String Status0 = "Seleccionar";
            String Status1 = "Activo";
            String Status2 ="Inactivo";
            String Status3 ="Cancelado";
            statusList.add(Status0);
            statusList.add(Status1);
            statusList.add(Status2);
            statusList.add(Status3);
            statusList.forEach(p -> cmbStatus.addItem(p) );
            
    }
     public void FillCombo(){
    
    try {
       if(per.getListaAerolineas().isEmpty()){
           JOptionPane.showMessageDialog(null, "\nNo hay  Aerolineas agreagadas", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
       }else{
           per.getListaAerolineas().forEach(p ->{cmbAerolineas.addItem(p.getNameAirline());});
       }
          
         } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex + " " + "\nNo hay  elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public void InitComponents() {
        try {

            Container con = new Container();
            this.add(con);
            con.setLayout(new BorderLayout());
            this.setBackground(new java.awt.Color(60, 63, 65));

            JPanel panelSuperior = new JPanel();
            panelSuperior.setPreferredSize(new Dimension(900, 100));
            panelSuperior.setLayout(new FlowLayout());
            panelSuperior.setBackground(Color.ORANGE);
            
            JPanel panel1 = new JPanel();
            panel1.setLayout(new BorderLayout());
            panel1.setPreferredSize(new Dimension(600, 520));
            panel1.setMinimumSize(new Dimension(600, 520));
            panel1.setMaximumSize(new Dimension(600, 520));
            panel1.setBackground(new java.awt.Color(65, 70, 72));
            
            JPanel panelCentral = new JPanel();
            panelCentral.setLayout(new GridBagLayout());
            panelCentral.setBackground(new java.awt.Color(65, 70, 72));
            panelCentral.setPreferredSize(new Dimension(600,480));
            panelCentral.setMinimumSize(new Dimension(600, 480));
            panelCentral.setMaximumSize(new Dimension(600, 480));
            panelCentral.setBackground(new java.awt.Color(65, 70, 72));

            JPanel panelL = new JPanel();
            panelL.setBackground(new java.awt.Color(60, 63, 65));
            panelL.setPreferredSize(new Dimension(150, 520));

            JPanel panelR = new JPanel();
            panelR.setBackground(new java.awt.Color(60, 63, 65));
            panelR.setPreferredSize(new Dimension(150, 520));

            JPanel panelInferior = new JPanel();
            panelInferior.setPreferredSize(new Dimension(900, 100));
            panelInferior.setBackground(new java.awt.Color(60, 63, 65));


            JLabel lbTitulo = new JLabel("Agregar Nuevo Vuelo", JLabel.CENTER);
            lbTitulo.setSize(50, 50);
            lbTitulo.setFont(new java.awt.Font("Lucida Grande", 0, 50)); // NOI18N
            lbTitulo.setForeground(new java.awt.Color(35, 49, 67));
            
            
            //se crean elementos gráficos y se agregan al gridbaglayout
           
            GridBagConstraints CentralGrid = new GridBagConstraints();
            CentralGrid.fill = GridBagConstraints.PAGE_START;
            CentralGrid.weightx=0.09;
            lbSelectAirline = new JLabel("Seleccione la Aerolinea:", JLabel.CENTER);
            lbSelectAirline.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 0;
            CentralGrid.gridy = 0;
            panelCentral.add(lbSelectAirline, CentralGrid);
            
            cmbAerolineas = new JComboBox<>();
            cmbAerolineas.setPreferredSize(new Dimension(200, 32));
            cmbAerolineas.setMinimumSize(new Dimension(200, 32));
            cmbAerolineas.setMaximumSize(new Dimension(200, 32));
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 1; //Posición eje y
            panelCentral.add(cmbAerolineas, CentralGrid);
            cmbAerolineas.addItem("Seleccionar");
            this.FillCombo();
            
            lbId = new JLabel("Código de vuelo:", JLabel.CENTER);
            lbId.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 0;
            CentralGrid.gridy = 2;
            panelCentral.add(lbId, CentralGrid);
            
            lbId = new JLabel("Haga click para generar código:", JLabel.CENTER);
            lbId.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 1;
            CentralGrid.gridy = 2;
            panelCentral.add(lbId, CentralGrid);
            
            txtidFly= new JTextField(20);
            txtidFly.setPreferredSize(new Dimension(200, 32));
            txtidFly.setMinimumSize(new Dimension(200, 32));
            txtidFly.setMaximumSize(new Dimension(200, 32));
            txtidFly.setEditable(false);
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 3; //Posición eje y
            panelCentral.add(txtidFly, CentralGrid);
            
            btnGenerarCodigo = new JButton("Generar código");
            btnGenerarCodigo.setPreferredSize(new Dimension(200, 32));
            btnGenerarCodigo.setMinimumSize(new Dimension(200, 32));
            btnGenerarCodigo.setMaximumSize(new Dimension(200, 32));
            CentralGrid.gridx = 1;
            CentralGrid.gridy = 3;
            panelCentral.add(btnGenerarCodigo, CentralGrid);
            
            lbSource = new JLabel("Ingrese la ciudad de salida:", JLabel.CENTER);
            lbSource.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 0;
            CentralGrid.gridy = 4;
            panelCentral.add(lbSource, CentralGrid);
            
            txtSource= new JTextField(20);
            txtSource.setPreferredSize(new Dimension(200, 32));
            txtSource.setMinimumSize(new Dimension(200, 32));
            txtSource.setMaximumSize(new Dimension(200, 32));
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 5; //Posición eje y
            panelCentral.add(txtSource, CentralGrid);

            lbDestination = new JLabel("Ingrese la ciudad de destino:", JLabel.CENTER);
            lbDestination.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 0;
            CentralGrid.gridy = 6;
            panelCentral.add(lbDestination, CentralGrid);
            
            txtDestination= new JTextField(20);
            txtDestination.setPreferredSize(new Dimension(200, 32));
            txtDestination.setMinimumSize(new Dimension(200, 32));
            txtDestination.setMaximumSize(new Dimension(200, 32));
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 7; //Posición eje y
            panelCentral.add(txtDestination, CentralGrid);
            
            lbCapacity = new JLabel("Indique la capacidad:", JLabel.CENTER);
            lbCapacity.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 0;
            CentralGrid.gridy = 8;
            panelCentral.add(lbCapacity, CentralGrid);
            
            cmbCapacity= new JComboBox<>();
            cmbCapacity.setPreferredSize(new Dimension(200, 32));
            cmbCapacity.setMinimumSize(new Dimension(200, 32));
            cmbCapacity.setMaximumSize(new Dimension(200, 32));
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 9; //Posición eje y
            panelCentral.add(cmbCapacity, CentralGrid);
            
            lbStatus = new JLabel("Seleccione el estado del vuelo:", JLabel.CENTER);
            lbStatus.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 0;
            CentralGrid.gridy = 10;
            panelCentral.add(lbStatus, CentralGrid);
            
            cmbStatus= new JComboBox<>();
            cmbStatus.setToolTipText("Seleccionar");
            cmbStatus.setPreferredSize(new Dimension(200, 32));
            cmbStatus.setMinimumSize(new Dimension(200, 32));
            cmbStatus.setMaximumSize(new Dimension(200, 32));
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 11; //Posición eje y
            panelCentral.add(cmbStatus, CentralGrid);
            this.FillCombos();
            
            jbTakeOff = new JLabel("Indique la fecha de salida:", JLabel.CENTER);
            jbTakeOff.setForeground(new java.awt.Color(243, 243, 243));
            jbTakeOff.setFocusable(false);
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 12; //Posición eje y
            panelCentral.add(jbTakeOff, CentralGrid);
           
            
            jdcTakeOff = new datechooser.beans.DateChooserCombo();
            jdcTakeOff.setPreferredSize(new Dimension(200, 32));
            jdcTakeOff.setMinimumSize(new Dimension(200, 32));
            jdcTakeOff.setMaximumSize(new Dimension(200, 32));
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 13; //Posición eje y
            panelCentral.add(jdcTakeOff, CentralGrid);
           
            jlArrival = new JLabel();
            jlArrival.setForeground(new java.awt.Color(243, 243, 243));
            jlArrival.setText("Indique la fecha arrivo:");
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 14; //Posición eje y
            panelCentral.add(jlArrival, CentralGrid);
            
            jdcArrive = new datechooser.beans.DateChooserCombo();
            jdcArrive.setPreferredSize(new Dimension(200, 32));
            jdcArrive.setMinimumSize(new Dimension(200, 32));
            jdcArrive.setMaximumSize(new Dimension(200, 32));
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 15; //Posición eje y
            panelCentral.add(jdcArrive, CentralGrid);
          
            GridBagConstraints GridInferior = new GridBagConstraints();
            GridInferior.gridx = 0; //Posición eje x
            GridInferior.gridy = 0; //Posición eje y
            
            btnCancelar = new JButton("Cancelar");
            btnCancelar.setPreferredSize(new Dimension(200, 40));
            btnCancelar.setMinimumSize(new Dimension(200, 40));
            btnCancelar.setMaximumSize(new Dimension(200, 40));
            GridInferior.gridx = 1; //Posición eje x
            GridInferior.gridy = 0; //Posición eje y
            panelInferior.add(btnCancelar, GridInferior);

            btnVuelos = new JButton("Ver Vuelos");
            btnVuelos.setPreferredSize(new Dimension(200, 40));
            btnVuelos.setMinimumSize(new Dimension(200, 40));
            btnVuelos.setMaximumSize(new Dimension(200, 40));
            GridInferior.gridx = 2; //Posición eje x
            GridInferior.gridy = 0; //Posición eje y
            panelInferior.add(btnVuelos, GridInferior);

            panelSuperior.add(lbTitulo);
            con.add(panelL, BorderLayout.EAST);
            con.add(panelR, BorderLayout.WEST);
            panel1.add(panelCentral, BorderLayout.PAGE_START);
            con.add(panel1, BorderLayout.CENTER);
            con.add(panelSuperior, BorderLayout.PAGE_START);
            con.add(panelInferior, BorderLayout.PAGE_END);

        } catch (NullPointerException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnVuelos() {
        return btnVuelos;
    }

    public JPanel getPrincipal() {
        return principal;
    }

    public JButton getBtnGenerarCodigo() {
        return btnGenerarCodigo;
    }

    public JTextField getTxtidFly() {
        return txtidFly;
    }

    public Persistencia getPer() {
        return per;
    }

    public ControladorVuelo getControlerV() {
        return c;
    }

    public JTextField getTxtSource() {
        return txtSource;
    }

    public JTextField getTxtDestination() {
        return txtDestination;
    }

    public JComboBox<String> getCmbCapacity() {
        return cmbCapacity;
    }

    public JComboBox<String> getCmbStatus() {
        return cmbStatus;
    }

    public JComboBox<String> getCmbAerolineas() {
        return cmbAerolineas;
    }

    public JLabel getJbTakeOff() {
        return jbTakeOff;
    }

    public JLabel getJlArrival() {
        return jlArrival;
    }

    public DateChooserCombo getJdcArrive() {
        return jdcArrive;
    }

    public DateChooserCombo getJdcTakeOff() {
        return jdcTakeOff;
    }

    
}
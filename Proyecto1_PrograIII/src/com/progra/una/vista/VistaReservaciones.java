/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;

import com.progra.una.controlador.ControladorReservaciones;
import com.progra.una.modelo.Aerolinea;
import com.progra.una.modelo.Persistencia;
import com.progra.una.modelo.Reservacion;
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
public class VistaReservaciones extends javax.swing.JPanel {

    private JPanel principal;
    private ControladorReservaciones c;
    private Reservacion m;
    private Persistencia per;
    private JButton btnAnterior;
    private JButton btnCancelar;
    private JButton btnSiguiente;
    private JButton btnGenerarCodigo;
    private JLabel lbSelectAirline;
    private JLabel lbSelectFly;
    private JComboBox<String> cmbAerolineas;

   
    public VistaReservaciones(JPanel principal,Persistencia per) {
        this.InitComponents();
        this.per = per;
        this.principal = principal;
        this.c = new ControladorReservaciones(m, this);
        this.principal = principal;
        principal.setLayout(new CardLayout());
        this.Iniciar();
    }

    public void Iniciar() {
        this.setVisible(true);
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
            this.per = new Persistencia();
            Container con = new Container();
            this.add(con);
            con.setLayout(new BorderLayout());
            this.setBackground(new java.awt.Color(60, 63, 65));

            JPanel panelSuperior = new JPanel();
            panelSuperior.setPreferredSize(new Dimension(900, 100));
            panelSuperior.setLayout(new FlowLayout());
            panelSuperior.setBackground(Color.ORANGE);

            JPanel panelCentral = new JPanel();
            panelCentral.setLayout(new GridBagLayout());
            panelCentral.setBackground(new java.awt.Color(65, 70, 72));
            panelCentral.setPreferredSize(new Dimension(800, 520));

            JPanel panelL = new JPanel();
            panelL.setBackground(new java.awt.Color(60, 63, 65));
            panelL.setPreferredSize(new Dimension(50, 520));

            JPanel panelR = new JPanel();
            panelR.setBackground(new java.awt.Color(60, 63, 65));
            panelR.setPreferredSize(new Dimension(50, 520));

            JPanel panelInferior = new JPanel();
            panelInferior.setPreferredSize(new Dimension(900, 100));
            panelInferior.setLayout(new FlowLayout());
            panelInferior.setBackground(new java.awt.Color(60, 63, 65));

            GridBagConstraints CentralGrid = new GridBagConstraints();
            CentralGrid.fill = GridBagConstraints.PAGE_START;

            JLabel lbTitulo = new JLabel("Crear nueva reservación", JLabel.CENTER);
            lbTitulo.setSize(50, 50);
            lbTitulo.setFont(new java.awt.Font("Lucida Grande", 0, 50)); // NOI18N
            lbTitulo.setForeground(new java.awt.Color(35, 49, 67));
            //se crean elementos gráficos y se agregan al gridbaglayout

            lbSelectAirline = new JLabel("Seleccione la Aerolinea:", JLabel.CENTER);
            lbSelectAirline.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 0;
            CentralGrid.gridy = 0;
            panelCentral.add(lbSelectAirline, CentralGrid);
            
            cmbAerolineas = new JComboBox<>();
            cmbAerolineas.setPreferredSize(new Dimension(200, 32));
            cmbAerolineas.setMinimumSize(new Dimension(200, 32));
            cmbAerolineas.setMaximumSize(new Dimension(200, 32));
            CentralGrid.gridx = 1; //Posición eje x
            CentralGrid.gridy = 0; //Posición eje y
            panelCentral.add(cmbAerolineas, CentralGrid);
            cmbAerolineas.addItem("Seleccional");
            this.FillCombo();
          
            lbSelectFly = new JLabel("Seleccione el vuelo:", JLabel.CENTER);
            lbSelectFly.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 0;
            CentralGrid.gridy = 1;
            panelCentral.add(lbSelectFly, CentralGrid);
            
            TablaVuelos tVuelos = new TablaVuelos();
            tVuelos.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 0;
            CentralGrid.gridy = 2;
            CentralGrid.gridwidth = 3;  // columnas que va a ocupar de ancho/
            CentralGrid.gridheight = 5;   // columnas que va a ocupar de largo
            panelCentral.add(tVuelos, CentralGrid);
            
            GridBagConstraints GridInferior = new GridBagConstraints();

            btnCancelar = new JButton("Cancelar");
            btnCancelar.setPreferredSize(new Dimension(200, 40));
            btnCancelar.setMinimumSize(new Dimension(200, 40));
            btnCancelar.setMaximumSize(new Dimension(200, 40));
            GridInferior.gridx = 0; //Posición eje x
            GridInferior.gridy = 0; //Posición eje y
            panelInferior.add(btnCancelar, GridInferior);

            btnAnterior = new JButton("Anterior");
            btnAnterior.setPreferredSize(new Dimension(200, 40));
            btnAnterior.setMinimumSize(new Dimension(200, 40));
            btnAnterior.setMaximumSize(new Dimension(200, 40));
            GridInferior.gridx = 1; //Posición eje x
            GridInferior.gridy = 0; //Posición eje y

            panelInferior.add(btnAnterior, GridInferior);

            btnSiguiente = new JButton("Siguiente");
            btnSiguiente.setPreferredSize(new Dimension(200, 40));
            btnSiguiente.setMinimumSize(new Dimension(200, 40));
            btnSiguiente.setMaximumSize(new Dimension(200, 40));
            GridInferior.gridx = 2; //Posición eje x
            GridInferior.gridy = 0; //Posición eje y
            panelInferior.add(btnSiguiente, GridInferior);

            panelSuperior.add(lbTitulo);
            
            con.add(panelL, BorderLayout.EAST);
            con.add(panelR, BorderLayout.WEST);
            con.add(panelCentral, BorderLayout.CENTER);
            con.add(panelSuperior, BorderLayout.PAGE_START);
            con.add(panelInferior, BorderLayout.PAGE_END);

        } catch (NullPointerException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public JButton getBtnAnterior() {
        return btnAnterior;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnSiguiente() {
        return btnSiguiente;
    }

    public JButton getBtnGenerarCodigo() {
        return btnGenerarCodigo;
    }

    public JPanel getPrincipal() {
        return principal;
    }

    public Persistencia getPer() {
        return per;
    }

    public ControladorReservaciones getControlerR() {
        return c;
    }
}

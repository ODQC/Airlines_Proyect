/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;

import com.progra.una.controlador.ControladorAerolinea;
import com.progra.una.modelo.Aerolinea;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class VistaAerolineas extends javax.swing.JPanel {

    private  JPanel panelPrincipal;
    private Container con;
    private Aerolinea m;
    private ControladorAerolinea c;
    
    public VistaAerolineas(JPanel panelPrincipal) {
       this.m = new Aerolinea();
       //this.con = new ControladorAerolinea(m,this);
        
       
    }
public void initCompo()
{
    this.panelPrincipal = panelPrincipal;
        //panelPrincipal.setBackground(new Color(0,0,0,64));
        panelPrincipal.add(new Container());
        panelPrincipal.setLayout(new BorderLayout());
        this.Iniciar();
        //panelPrincipal.setLayout(new CardLayout());
   
        
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout()); 
        panelSuperior.setBackground(Color.ORANGE);
       
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.setBackground(Color.gray);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setLayout(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(200,100));
        
        
        
        GridBagConstraints a = new GridBagConstraints();
        a.fill = GridBagConstraints.PAGE_START;
        a.weightx=0.09;
        GridBagConstraints CentralGrid = new GridBagConstraints();
        
        JLabel lbTitulo = new JLabel("Agregar Nueva Aerolinea",JLabel.CENTER);
        
        
        //se crean elementos gráficos y se agregan al gridbaglayout
        JTextField txtNombreAerolinea = new JTextField(20);
        CentralGrid.gridx = 0; //Posición eje x
        CentralGrid.gridy = 1; //Posición eje y
        panel1.add(txtNombreAerolinea,CentralGrid);
        
        JTextField txtCodigoAerolinea = new JTextField(20);
        CentralGrid.gridx = 0; //Posición eje x
        CentralGrid.gridy = 3; //Posición eje y
        panel1.add(txtCodigoAerolinea,CentralGrid);
        
        JLabel lbNombreAerolinea = new JLabel("Ingrese el nombre de la Aerolinea:",JLabel.CENTER);
        CentralGrid.gridx = 0;
        CentralGrid.gridy = 0;
        panel1.add(lbNombreAerolinea,CentralGrid);
        
        JLabel lbCodigoAerolinea = new JLabel("Agregue el código de la aerolinea o haga click en Generar código:",JLabel.CENTER);
        CentralGrid.gridx = 0;
        CentralGrid.gridy = 2;
        panel1.add(lbCodigoAerolinea,CentralGrid);
   
       JButton btnGenerarCodigo = new JButton("Generar código");
        a.fill = GridBagConstraints.HORIZONTAL;
        a.ipady = 0;       
        a.weighty = 0;  
        a.gridx = 1;      
        a.gridy = 3; 
        a.gridwidth = 1; 
        panel1.add(btnGenerarCodigo,a);
       
       
        panelSuperior.add(lbTitulo);
        
        panelPrincipal.add(panelSuperior,BorderLayout.PAGE_START);
        panelPrincipal.add(panel1,BorderLayout.NORTH);
       
        
}
    public void Iniciar()
    {
        this.setVisible(true); 
    }
    
}

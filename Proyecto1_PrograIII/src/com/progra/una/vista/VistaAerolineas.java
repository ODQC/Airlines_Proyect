/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;

import com.progra.una.controlador.ControladorAerolinea;
import com.progra.una.modelo.Aerolinea;
import com.progra.una.modelo.Persistencia;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class VistaAerolineas extends javax.swing.JPanel {

    private JPanel panelPrincipal;
    private Container con;
    private Aerolinea m;
    private ControladorAerolinea c;
    private Persistencia per;
    private JButton btnCancelar;
    private JButton btnVerAero ;
    private JButton btnGenerarCodigo;
    private JTextField txtNombreAerolinea;
    private JTextField txtCodigoAerolinea;


    public VistaAerolineas(JPanel panelPrincipal,Persistencia per) {
        this.per =per;
        this.m = new Aerolinea();
        this.initCompo();
        this.c = new ControladorAerolinea(m, this);
        this.panelPrincipal = panelPrincipal;
        panelPrincipal.setLayout(new CardLayout());
        this.Iniciar();

    }

    public void initCompo() {
        try {

            Container con = new Container();
            this.add(con);
            con.setLayout(new BorderLayout());
            this.setBackground(new java.awt.Color(60, 63, 65));

            JPanel panelSuperior = new JPanel();
            panelSuperior.setPreferredSize(new Dimension(900, 100));
            panelSuperior.setLayout(new FlowLayout());
            panelSuperior.setBackground(Color.ORANGE);

            JPanel panelCentral = new JPanel();
            panelCentral.setLayout(new BorderLayout());
            panelCentral.setBackground(new java.awt.Color(65, 70, 72));
            panelCentral.setPreferredSize(new Dimension(600,520));

            JPanel panelL = new JPanel();
            panelL.setBackground(new java.awt.Color(60, 63, 65));
            panelL.setPreferredSize(new Dimension(150, 520));

            JPanel panelR = new JPanel();
            panelR.setBackground(new java.awt.Color(60, 63, 65));
            panelR.setPreferredSize(new Dimension(150, 520));

            JPanel panel1 = new JPanel();
            panel1.setLayout(new BorderLayout());
            panel1.setLayout(new GridBagLayout());
            panel1.setPreferredSize(new Dimension(400, 300));
            panel1.setMinimumSize(new Dimension(400, 300));
            panel1.setMaximumSize(new Dimension(400, 300));
            panel1.setBackground(new java.awt.Color(65, 70, 72));

            JPanel panelInferior = new JPanel();
            panelInferior.setPreferredSize(new Dimension(900, 50));
            panelInferior.setLayout(new FlowLayout());
            panelInferior.setBackground(new java.awt.Color(60, 63, 65));

            GridBagConstraints CentralGrid = new GridBagConstraints();
            CentralGrid.weightx = 1;
            

            JLabel lbTitulo = new JLabel("Agregar Nueva Aerolinea", JLabel.CENTER);
            lbTitulo.setSize(50, 50);
            lbTitulo.setFont(new java.awt.Font("Lucida Grande", 0, 50)); // NOI18N
            lbTitulo.setForeground(new java.awt.Color(35, 49, 67));
            //se crean elementos gráficos y se agregan al gridbaglayout
            txtNombreAerolinea = new JTextField(20);
            txtNombreAerolinea.setPreferredSize(new Dimension(300, 32));
            txtNombreAerolinea.setMinimumSize(new Dimension(300, 32));
            txtNombreAerolinea.setMaximumSize(new Dimension(300, 32));
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 1; //Posición eje y

            panel1.add(txtNombreAerolinea, CentralGrid);

            txtCodigoAerolinea = new JTextField(20);
            txtCodigoAerolinea.setEditable(false);
            txtCodigoAerolinea.setPreferredSize(new Dimension(300, 32));
            txtCodigoAerolinea.setMinimumSize(new Dimension(300, 32));
            txtCodigoAerolinea.setMaximumSize(new Dimension(300, 32));
            CentralGrid.gridx = 0; //Posición eje x
            CentralGrid.gridy = 3; //Posición eje y

            panel1.add(txtCodigoAerolinea, CentralGrid);

            JLabel lbNombreAerolinea = new JLabel("Ingrese el nombre de la Aerolinea:", JLabel.CENTER);
            lbNombreAerolinea.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 0;
            CentralGrid.gridy = 0;
            panel1.add(lbNombreAerolinea, CentralGrid);
             
            JLabel lbGenereCod = new JLabel("Haga click en Generar código de la aerolinea:", JLabel.CENTER);
            lbGenereCod.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 1;
            CentralGrid.gridy = 2;
            panel1.add(lbGenereCod, CentralGrid);

            JLabel lbCodigoAerolinea = new JLabel("Código de Aerolinea:", JLabel.CENTER);
            lbCodigoAerolinea.setForeground(new java.awt.Color(243, 243, 243));
            CentralGrid.gridx = 0;
            CentralGrid.gridy = 2;
            panel1.add(lbCodigoAerolinea, CentralGrid);

            btnGenerarCodigo = new JButton("Generar código");

            btnGenerarCodigo.setPreferredSize(new Dimension(200, 32));
            btnGenerarCodigo.setMinimumSize(new Dimension(200, 32));
            btnGenerarCodigo.setMaximumSize(new Dimension(200, 32));
            CentralGrid.gridx = 1;
            CentralGrid.gridy = 3;
            panel1.add(btnGenerarCodigo, CentralGrid);

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

            btnVerAero = new JButton("Ver Aerolineas");
            btnVerAero.setPreferredSize(new Dimension(200, 40));
            btnVerAero.setMinimumSize(new Dimension(200, 40));
            btnVerAero.setMaximumSize(new Dimension(200, 40));
            GridInferior.gridx = 2; //Posición eje x
            GridInferior.gridy = 0; //Posición eje y
            panelInferior.add(btnVerAero, GridInferior);

            

            panelSuperior.add(lbTitulo);
            panelCentral.add(panel1, BorderLayout.CENTER);
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

    public void Iniciar() {
        this.setVisible(true);
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnVerAero () {
        return  btnVerAero ;
    }

    public JButton getBtnGenerarCodigo() {
        return btnGenerarCodigo;
    }

    public JTextField getTxtNombreAerolinea() {
        return txtNombreAerolinea;
    }

    public JTextField getTxtCodigoAerolinea() {
        return txtCodigoAerolinea;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public Persistencia getPer() {
        return per;
    }

    public ControladorAerolinea getControlerA() {
        return c;
    }
    
}

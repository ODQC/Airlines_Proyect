/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;

import com.progra.una.controlador.ControladorConsultas;
import com.progra.una.controlador.ControladorVuelo;
import com.progra.una.modelo.Persistencia;
import com.progra.una.modelo.Vuelo;
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
public class VistaConsultas  extends javax.swing.JPanel{
    private JPanel principal;
    private ControladorConsultas c;
    private Persistencia m;
    private JButton btnAnterior;
    private JButton btnCancelar;
    private JButton btnSiguiente;
    private JButton btnGenerarCodigo;

    public VistaConsultas(JPanel principal) {
        this.principal = principal;
        this.c = new ControladorConsultas( m,this);
    }
    public void Iniciar(){
        this.setVisible(true);
        this.principal = principal;
        principal.setLayout(new CardLayout());
        this.InitComponents();
        this.Iniciar();
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

            JPanel panelCentral = new JPanel();
            panelCentral.setLayout(new BorderLayout());
            panelCentral.setBackground(new java.awt.Color(65, 70, 72));
            panelCentral.setPreferredSize(new Dimension(600,500));

            JPanel panelL = new JPanel();
            panelL.setBackground(new java.awt.Color(60, 63, 65));
            panelL.setPreferredSize(new Dimension(150, 500));

            JPanel panelR = new JPanel();
            panelR.setBackground(new java.awt.Color(60, 63, 65));
            panelR.setPreferredSize(new Dimension(150, 500));

            JPanel panel1 = new JPanel();
            panel1.setLayout(new BorderLayout());
            panel1.setLayout(new GridBagLayout());
            panel1.setPreferredSize(new Dimension(400, 300));
            panel1.setMinimumSize(new Dimension(400, 300));
            panel1.setMaximumSize(new Dimension(400, 300));
            panel1.setBackground(new java.awt.Color(65, 70, 72));

            JPanel panelInferior = new JPanel();
            panelInferior.setPreferredSize(new Dimension(900, 100));
            panelInferior.setLayout(new FlowLayout());
            panelInferior.setForeground(new java.awt.Color(35, 49, 67));

            GridBagConstraints CentralGrid = new GridBagConstraints();
            CentralGrid.weightx = 1;

            JLabel lbTitulo = new JLabel("Consultas", JLabel.CENTER);
            lbTitulo.setSize(50, 50);
            lbTitulo.setFont(new java.awt.Font("Lucida Grande", 0, 50)); // NOI18N
            lbTitulo.setForeground(new java.awt.Color(35, 49, 67));
            //se crean elementos gráficos y se agregan al gridbaglayout
          
            
            btnAnterior = new JButton("Anterior");
            btnAnterior.setPreferredSize(new Dimension(100, 32));
            btnAnterior.setMinimumSize(new Dimension(100, 32));
            btnAnterior.setMaximumSize(new Dimension(100, 32));

            GridBagConstraints GridInferior = new GridBagConstraints();
            GridInferior.gridx = 0; //Posición eje x
            GridInferior.gridy = 0; //Posición eje y
            panelInferior.add(btnAnterior, GridInferior);

            btnSiguiente = new JButton("Siguiente");
            btnSiguiente.setPreferredSize(new Dimension(100, 32));
            btnSiguiente.setMinimumSize(new Dimension(100, 32));
            btnSiguiente.setMaximumSize(new Dimension(100, 32));
            GridInferior.gridx = 2; //Posición eje x
            GridInferior.gridy = 0; //Posición eje y
            panelInferior.add(btnSiguiente, GridInferior);

            btnCancelar = new JButton("Cancelar");
            btnCancelar.setPreferredSize(new Dimension(100, 32));
            btnCancelar.setMinimumSize(new Dimension(100, 32));
            btnCancelar.setMaximumSize(new Dimension(100, 32));
            GridInferior.gridx = 1; //Posición eje x
            GridInferior.gridy = 0; //Posición eje y
            panelInferior.add(btnCancelar, GridInferior);

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
}

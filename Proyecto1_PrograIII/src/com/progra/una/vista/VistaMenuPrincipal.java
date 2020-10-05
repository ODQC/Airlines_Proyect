/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;

import com.progra.una.controlador.ControladorPanelButton;
import com.progra.una.modelo.Persistencia;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class VistaMenuPrincipal extends JFrame {

    private JPanel Rpanel;
    private JPanel Lpanel;
    private JPanelButtonsAdmin panelButtons;
    private Persistencia per;
    public VistaMenuPrincipal(Persistencia p) {
        this.per = p;
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(new Color(35, 49, 67));
        this.InitComponents(this.getContentPane());
    }

    //Paso 2. Mostrar visible la ventana
    public void iniciar() {
        this.setVisible(true);

    }

    
    public JPanel getLpanel() {
        return Lpanel;
    }

    public void InitComponents(Container con) {

        con.setLayout(new BorderLayout());

        //Se crea panel Central
        PrincipalRightPanel principalR = new PrincipalRightPanel();
        panelButtons = new JPanelButtonsAdmin(principalR,per);

        con.setLayout(new BorderLayout());
        
        Lpanel = new JPanel();;
        Lpanel.setSize(300,700);
        
       
        principalR.setLayout(new CardLayout());
        JSplitPane sptPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelButtons, principalR);
        sptPane.setResizeWeight(0.5);
        sptPane.setOneTouchExpandable(false);
        sptPane.setContinuousLayout(true);
        sptPane.setDividerLocation(300);
        sptPane.resetToPreferredSizes();
        sptPane.setBackground(new Color(35, 49, 67));

        Component splitPane;
        add(sptPane, BorderLayout.CENTER);
        

    }

}

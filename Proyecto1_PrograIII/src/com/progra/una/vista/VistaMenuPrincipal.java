/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;
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
    

    
    public VistaMenuPrincipal(){
        this.setSize(1200,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground( new Color(35, 49, 67) );
        //Debe estar acá para que sean visibles los componentes
        //agregados
        this.ajustarComponentes(this.getContentPane());
    }
    
    //Paso 2. Mostrar visible la ventana
    public void iniciar(){
        this.setVisible(true);
        
    }
     public void ajustarComponentes(Container con){
        
 con.setLayout(new BorderLayout());
               
        //Se crea panel Central
     
     PrincipalRightPanel principalR = new PrincipalRightPanel();
    JPanelButtonsAdmin panelButtons = new JPanelButtonsAdmin(principalR);
   
       con.setLayout(new BorderLayout());
       JPanel Rpanel = new JPanel();
       Rpanel.setSize(900,700);
       JPanel Lpanel = new JPanel();
       Lpanel.setSize(300,700);
       //Rpanel.setBorder(new Background());
      
        //Lpanel.add(PanelButtons);
        con.add(panelButtons);
    
        JSplitPane sptPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelButtons,principalR );
        sptPane.setResizeWeight(0.5);
        sptPane.setOneTouchExpandable(false);
        sptPane.setContinuousLayout(true);
        sptPane.setDividerLocation(300);
        sptPane.resetToPreferredSizes();
        sptPane.setBackground( new Color(35, 49, 67) );
          
 
      
        Component splitPane;
        add(sptPane, BorderLayout.CENTER);
        GroupLayout gpL = new GroupLayout(Lpanel);
        Lpanel.setLayout(gpL);
         
        
        
     }
      
}

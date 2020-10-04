/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;

import com.progra.una.controlador.ControladorPersona;
import com.progra.una.modelo.Persona;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class VistaPersona extends javax.swing.JPanel {
    private JPanel principal;
    private ControladorPersona c;
    private Persona p;
    
    private JButton btnConfirmar;
    private JTextField txtId;   
    private JTextField txtNombre;   
    private JTextField txtApellido1;   
    private JTextField txtApellido2;     
    
    private JRadioButton btrAdministradorTI;
    private JRadioButton btrAdministradorAero;
    private JRadioButton btrAdministradorRes;
    private JRadioButton btrUsuario;
    
    private JLabel lblRegistro;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblApellido1;
    private JLabel lblApellido2;
    
    
    public VistaPersona(JPanel principal){
        this.InitComponents();
        this.principal = principal;
        this.c = new ControladorPersona(p,this);
        
    }
    
    public void iniciar(){
        this.setVisible(true);
    }
    public void InitComponents(){
        try{
           
            Container con = new Container();
            this.add(con);
            con.setLayout(new GridBagLayout());
            this.setBackground(new java.awt.Color(60, 63, 65));
            
            principal = new JPanel();
            principal.setLayout(new GridBagLayout());
            principal.setBackground(Color.gray);
            principal.setPreferredSize(new Dimension(900, 700));
            principal.setMinimumSize(new Dimension(900, 700));
            principal.setMaximumSize(new Dimension(900, 700));
            GridBagConstraints a = new GridBagConstraints();
            a.fill = GridBagConstraints.PAGE_START;
            a.weightx=0.09;
            
            lblRegistro = new JLabel("Registro", JLabel.CENTER);
            lblRegistro.setForeground(Color.black);
            a.gridx = 0;
            a.gridy = 0;
            a.fill = GridBagConstraints.HORIZONTAL;
            principal.add(lblRegistro, a);
            
            lblId = new JLabel("Usuario", JLabel.CENTER);
            lblId.setForeground(Color.black);
            a.gridx = 0;
            a.gridy = 1;
            principal.add(lblId,a);
            
            lblNombre = new JLabel("Nombre", JLabel.CENTER);
            lblNombre.setForeground(Color.black);
            a.gridx = 0;
            a.gridy = 2;
            principal.add(lblNombre,a);
                    
            lblApellido1 = new JLabel("Primer Apellido", JLabel.CENTER);
            lblApellido1.setForeground(Color.black);
            a.gridx = 0;
            a.gridy = 3;
            principal.add(lblApellido1,a);
            
            lblApellido2 = new JLabel("Segundo Apellido", JLabel.CENTER);
            lblApellido2.setForeground(Color.black);
            a.gridx = 0;
            a.gridy = 4;
            principal.add(lblApellido2,a);
            
            btrAdministradorTI = new JRadioButton("Administrador de TI");
           // btrAdministradorTI.
            
           // btrAdministradorAero = new JRadioButton("Administrador de Aeroplineas");
           // btrAdministradorAero.
            
            //btrAdministradorRes = new JRadioButton("Administrador de Reservaciones");
            //btrAdministradorRes.
            
            //btrUsuario = new JRadioButton("Cliente");
            //btrUsuario.
            
            //btnConfirmar = new JButton("Confirmar");
            //btnConfirmar.
            
            
            
            con.add(principal);
            
            
        }catch (NullPointerException ex){
            System.out.println(ex);
        }catch (Exception e){
            System.out.println(e); 
        }    
            
    }
}

 
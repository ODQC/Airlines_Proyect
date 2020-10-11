/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;



import com.progra.una.controlador.LoginControlador;
import com.progra.una.modelo.Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class VistaLogin extends javax.swing.JFrame {
  
    
    
   private Persistencia m;
   private LoginControlador c;

    public VistaLogin(Persistencia m) {
        initComponents();
        this.m = m;
        this.c = new LoginControlador(this,m);
        this.setVisible(true);
       
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcboUser = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtCedula = new javax.swing.JTextField();
        jPwdContraseña = new javax.swing.JPasswordField();
        jbtnCancelar = new javax.swing.JButton();
        jbtnLimpiar = new javax.swing.JButton();
        jbtnAcceder = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbIcon = new javax.swing.JLabel();
        PanelTitles = new javax.swing.JPanel();
        lbPaneName = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(35, 49, 67));
        setMaximumSize(new java.awt.Dimension(393, 663));
        setMinimumSize(new java.awt.Dimension(393, 663));

        jPanel1.setBackground(new java.awt.Color(35, 49, 67));

        jcboUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador de TI", "Administrador de Aerolineas", "Administrador de Reservaciones", "Administrador de Usuarios", "Usuario" }));
        jcboUser.setMaximumSize(new java.awt.Dimension(200, 26));
        jcboUser.setMinimumSize(new java.awt.Dimension(200, 26));
        jcboUser.setPreferredSize(new java.awt.Dimension(200, 26));

        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Tipo de Usuario ");

        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Cédula:");

        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Contraseña:");

        jtxtCedula.setMaximumSize(new java.awt.Dimension(14, 24));

        jPwdContraseña.setMaximumSize(new java.awt.Dimension(14, 24));

        jbtnCancelar.setIcon(new javax.swing.ImageIcon("/Users/oscardanielquesadacalderon/Desktop/Escritrio/Programación III/Proyecto_Progra_III/Proyecto1_PrograIII/src/com/progra/una/vista/Resources/exit.png")); // NOI18N
        jbtnCancelar.setText("Cancelar");

        jbtnLimpiar.setIcon(new javax.swing.ImageIcon("/Users/oscardanielquesadacalderon/Desktop/Escritrio/Programación III/Proyecto_Progra_III/Proyecto1_PrograIII/src/com/progra/una/vista/Resources/Restart.png")); // NOI18N
        jbtnLimpiar.setText("Limpiar");

        jbtnAcceder.setIcon(new javax.swing.ImageIcon("/Users/oscardanielquesadacalderon/Desktop/Escritrio/Programación III/Proyecto_Progra_III/Proyecto1_PrograIII/src/com/progra/una/vista/Resources/Login_37128.png")); // NOI18N
        jbtnAcceder.setText("Acceder");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnAcceder))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                    .addComponent(jPwdContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcboUser, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPwdContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCancelar)
                    .addComponent(jbtnLimpiar)
                    .addComponent(jbtnAcceder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(35, 49, 67));

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/progra/una/vista/Resources/userImg.png"))); // NOI18N

        PanelTitles.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color2"));

        lbPaneName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lbPaneName.setForeground(new java.awt.Color(243, 243, 243));
        lbPaneName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPaneName.setText("Panel Principal");

        lbTitulo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(243, 243, 243));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Sistema Aeropuertuario");

        javax.swing.GroupLayout PanelTitlesLayout = new javax.swing.GroupLayout(PanelTitles);
        PanelTitles.setLayout(PanelTitlesLayout);
        PanelTitlesLayout.setHorizontalGroup(
            PanelTitlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTitlesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelTitlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPaneName, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        PanelTitlesLayout.setVerticalGroup(
            PanelTitlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTitlesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbPaneName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(PanelTitles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIcon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(PanelTitles, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbIcon)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
  
    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTitles;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPwdContraseña;
    private javax.swing.JButton jbtnAcceder;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnLimpiar;
    private javax.swing.JComboBox<String> jcboUser;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbPaneName;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables

    public Persistencia getM() {
        return m;
    }

    public LoginControlador getC() {
        return c;
    }

    public JPasswordField getjPwdContraseña() {
        return jPwdContraseña;
    }

    public JButton getJbtnAcceder() {
        return jbtnAcceder;
    }

    public JButton getJbtnCancelar() {
        return jbtnCancelar;
    }

    public JButton getJbtnLimpiar() {
        return jbtnLimpiar;
    }

    public JComboBox<String> getJcboUser() {
        return jcboUser;
    }

    public JTextField getJtxtCedula() {
        return jtxtCedula;
    }

   
    }


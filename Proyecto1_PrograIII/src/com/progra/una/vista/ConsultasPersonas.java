/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;

import com.progra.una.controlador.ControladorConsultaAero;
import com.progra.una.controlador.ControladorConsultaPersona;
import com.progra.una.controlador.ControladorPersona;
import com.progra.una.modelo.Interfaces.ShowObjects;
import com.progra.una.modelo.Persistencia;
import com.progra.una.modelo.SingletonPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ConsultasPersonas extends javax.swing.JPanel implements ShowObjects {

    /**
     * Creates new form VistaReportes
     */
    private JPanel panelPrincipal;
    private Persistencia per;
    private ControladorConsultaPersona c;
    private SingletonPanel sinPan; 

    public ConsultasPersonas(JPanel panelPrincipal,Persistencia per) {
        this.sinPan = SingletonPanel.getSin();
        this.per = per; 
        this.panelPrincipal = panelPrincipal;
        this.setLayout(new CardLayout());
        initComponents();
        this.ShowObjects();
        this.c = new ControladorConsultaPersona(per, this);
        this.sinPan.setID("ConsultaPersonas");
 
    }
public void ResetPanel(){
    this.removeAll();
    this.initComponents();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        jlTitlePanel = new javax.swing.JLabel();
        PanelInferior = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelCentral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();

        setBackground(new java.awt.Color(65, 70, 72));
        setMaximumSize(new java.awt.Dimension(900, 700));
        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setLayout(new java.awt.BorderLayout());

        panelSuperior.setBackground(new java.awt.Color(35, 49, 67));
        panelSuperior.setMaximumSize(new java.awt.Dimension(900, 100));
        panelSuperior.setMinimumSize(new java.awt.Dimension(900, 100));

        jlTitlePanel.setBackground(new java.awt.Color(35, 49, 67));
        jlTitlePanel.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jlTitlePanel.setForeground(java.awt.SystemColor.activeCaptionBorder);
        jlTitlePanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitlePanel.setText("Registro de Personas");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(panelSuperior, java.awt.BorderLayout.PAGE_START);

        PanelInferior.setBackground(new java.awt.Color(65, 81, 109));
        PanelInferior.setMaximumSize(new java.awt.Dimension(900, 50));
        PanelInferior.setMinimumSize(new java.awt.Dimension(900, 50));
        PanelInferior.setPreferredSize(new java.awt.Dimension(900, 50));

        btnBuscar.setText("Buscar");
        btnBuscar.setMaximumSize(new java.awt.Dimension(84, 32));
        btnBuscar.setMinimumSize(new java.awt.Dimension(84, 32));
        btnBuscar.setPreferredSize(new java.awt.Dimension(84, 32));

        btnAtras.setText("Atras");
        btnAtras.setMaximumSize(new java.awt.Dimension(84, 32));
        btnAtras.setMinimumSize(new java.awt.Dimension(84, 32));
        btnAtras.setPreferredSize(new java.awt.Dimension(84, 32));

        btnCancelar.setText("Cerrar");

        javax.swing.GroupLayout PanelInferiorLayout = new javax.swing.GroupLayout(PanelInferior);
        PanelInferior.setLayout(PanelInferiorLayout);
        PanelInferiorLayout.setHorizontalGroup(
            PanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInferiorLayout.createSequentialGroup()
                .addContainerGap(548, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        PanelInferiorLayout.setVerticalGroup(
            PanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInferiorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(PanelInferior, java.awt.BorderLayout.PAGE_END);

        panelCentral.setBackground(new java.awt.Color(65, 81, 109));
        panelCentral.setMaximumSize(new java.awt.Dimension(900, 550));
        panelCentral.setMinimumSize(new java.awt.Dimension(900, 550));

        tblPersonas.setBackground(new java.awt.Color(65, 70, 72));
        tblPersonas.setForeground(java.awt.Color.white);
        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Personas", "Nombre ", "Primer Apellido", "Segundo Apellido", "Contraseña", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPersonas);

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        add(panelCentral, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInferior;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlTitlePanel;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tblPersonas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ShowObjects() {

        try {
            per.getListaPersonas().forEach(p -> { //se implementa la lamba donde p es el objeto 
                        DefaultTableModel modelo = (DefaultTableModel) tblPersonas.getModel(); // se crea un modelo para la tabla
                        Object[] colum = new Object[6];// se asigna un vector con la cantidad de colummas que tiene la tabla
                        colum[0] = p.getId(); // se asignan los parametros de los objetos a las columnas
                        colum[1] = p.getName();
                        colum[2] = p.getApellido1();
                        colum[3] = p.getApellido2();
                        colum[4] = p.getPassword();
                        colum[5] = p.getTipo();
                        
                        modelo.addRow(colum); // se agregan las columnas(el objeto) a una fila de la tabla 
                        tblPersonas.setModel(modelo);// se agrega el modelo a la tabla
                    }
            );

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex + " " + "\nNo hay más elementos que mostrar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {

            System.err.println(ex);

        }


    }                 

    private ControladorConsultaAero ControladorConsultaAero(ConsultasPersonas aThis, Persistencia per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public Persistencia getPer() {
        return per;
    }

    public JButton getBtnAtras() {
        return btnAtras;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JTable getTblPersonas() {
        return tblPersonas;
    }
    
}

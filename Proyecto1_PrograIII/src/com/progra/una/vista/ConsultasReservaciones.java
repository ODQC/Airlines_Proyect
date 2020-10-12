/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;

import com.progra.una.controlador.ControladorConsultaReservacion;
import com.progra.una.modelo.Persistencia;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class ConsultasReservaciones extends javax.swing.JPanel {

    /**
     * Creates new form VistaReportes
     */
    private JPanel panelPrincipal;
    private Persistencia per;
    private ControladorConsultaReservacion c;
    public ConsultasReservaciones(JPanel panelPrincipal,Persistencia per) {
        this.per =per;
        this.panelPrincipal = panelPrincipal;
        this.setLayout(new CardLayout());
        initComponents();
        this.c = new ControladorConsultaReservacion(this,per);
        c.ShowObjects();
 
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
        tblReserv = new javax.swing.JTable();

        setBackground(new java.awt.Color(65, 81, 109));
        setMaximumSize(new java.awt.Dimension(900, 700));
        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setLayout(new java.awt.BorderLayout());

        panelSuperior.setBackground(new java.awt.Color(35, 49, 67));

        jlTitlePanel.setBackground(javax.swing.UIManager.getDefaults().getColor("TabbedPane.selected"));
        jlTitlePanel.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jlTitlePanel.setForeground(java.awt.SystemColor.activeCaptionBorder);
        jlTitlePanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitlePanel.setText("Registro de Reservaciones");

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
                .addContainerGap(547, Short.MAX_VALUE)
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

        tblReserv.setBackground(new java.awt.Color(65, 70, 72));
        tblReserv.setForeground(java.awt.Color.white);
        tblReserv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Resevacion", "Estatus", "Fecha Reserv", "id Vuelo", "Origen", "Destino", "Capacidad", "Estado Vuelo", "Id Aerolinea", "Aerolinea", "Fech Llegada", "Fecha Salidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReserv);
        if (tblReserv.getColumnModel().getColumnCount() > 0) {
            tblReserv.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblReserv.getColumnModel().getColumn(1).setResizable(false);
            tblReserv.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCentralLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
    private javax.swing.JTable tblReserv;
    // End of variables declaration//GEN-END:variables

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

    public JTable getTblReserv() {
        return tblReserv;
    }
public void ResetPanel(){
    this.removeAll();
    this.initComponents();
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.vista;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;

/**
 *
 * @author oscardanielquesadacalderon
 */

public class PrincipalRightPanel extends javax.swing.JPanel {
    
       private PanelBackground p1;
       private JPanel principal;
       public PrincipalRightPanel() {
       principal = new JPanel();
        p1 =new PanelBackground(this);
       this.setLayout(new CardLayout());
 
        //Principal.setLayout(new CardLayout());
        this.add(p1);
        CardLayout card = (CardLayout) this.getLayout();
        card.next(this);
       // card.show(Principal, "p1");
        this.setSize(900,700);
        this.setVisible(true);
    }
    
    

   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador.InterfacesControl;

import com.progra.una.vista.PanelBackground;
import java.awt.CardLayout;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author oscardanielquesadacalderon
 */
public interface Cancelar {
   public default void Cancel(JPanel panelPrincipal){
    PanelBackground background;
       int confirmar;
            confirmar =JOptionPane.showConfirmDialog(null, "Esta seguro que desea cancelar? ", "Cancelar transacción" , WIDTH, HEIGHT);



            if(JOptionPane.YES_NO_OPTION==confirmar) {
            background = new PanelBackground(panelPrincipal);
                panelPrincipal.add("aerolineaForm", background);
                CardLayout card = (CardLayout) panelPrincipal.getLayout();
                card.next(panelPrincipal);
            }
}
}

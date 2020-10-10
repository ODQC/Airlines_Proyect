/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.modelo.Interfaces;

import com.progra.una.modelo.Lugar;
import com.progra.una.modelo.Vuelo;
import javax.swing.JOptionPane;

/**
 *
 * @author oscardanielquesadacalderon
 */
public interface EnablePlaces {
   
    public default void EnableFlyPacles(Vuelo v) {
        Integer i;
        String num;
        String idPlace;
        String status = "Disponible";
        try {
            for (i = 1; i <= 90; i++) {
                num = i.toString();
                idPlace = (i <=10) ? "A" + num : (10 < i && i <= 20) ? "B" + num : (20 < i && i <= 30) ? "C" + num : (30 < i && i <= 40) ? "D" + num : (40 < i && i <= 50) ? "E" + num : (50 < i && i <= 60) ? "F" + num : (60 < i && i <= 70) ? "G" + num : (70 < i && i <= 80) ? "H" + num : "I" + num;
                Lugar Place = new Lugar(idPlace, status, v.getIdFly(), v.getSource(), v.getDestination(), v.getTakeOffDate(),
                        v.getArrivalDate(), v.getCapacity(), v.getStatusFly(), v.getIdAirline(), v.getNameAirline());
                v.getListPlace().add(Place);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex + " " + "\nError de Creación de Lugar", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {

            System.err.println(ex);
        }
    }
}

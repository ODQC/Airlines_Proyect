/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_prograiii;

import com.progra.una.modelo.Persistencia;
import com.progra.una.modelo.Persona;
import com.progra.una.vista.VistaLogin;
import com.progra.una.vista.VistaMenuPrincipal;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class Proyecto1_PrograIII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persistencia per = new Persistencia();
        Persona sudo = new Persona("123456789","sudo","sudo1","sudo2","Administrador de TI","1234");
        per.getListaPersonas().add(sudo);
        VistaLogin vL = new VistaLogin(per);

    }
    
}
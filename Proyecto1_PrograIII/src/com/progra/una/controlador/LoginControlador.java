/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.una.controlador;


import com.progra.una.controlador.InterfacesControl.Cancelar;
import com.progra.una.controlador.InterfacesControl.Initlisteners;
import com.progra.una.controlador.InterfacesControl.ValidacionUsuario;
import com.progra.una.modelo.Interfaces.ConvertirPwd;
import com.progra.una.modelo.Interfaces.FindObject;
import com.progra.una.modelo.Interfaces.Report;
import com.progra.una.modelo.Persistencia;
import com.progra.una.modelo.Persona;
import com.progra.una.modelo.SingletonUsers;
import com.progra.una.vista.ConsultasAerolineas;
import com.progra.una.vista.PanelBackground;
import com.progra.una.vista.VistaLogin;
import com.progra.una.vista.VistaMenuPrincipal;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.function.Consumer;
import javax.swing.JOptionPane;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class LoginControlador implements Initlisteners,Report,FindObject, ConvertirPwd{

 private VistaLogin v;
 private Persistencia m;
 private Boolean exist;
 private SingletonUsers sinP;
 private String  descripcion;
 
    

    public LoginControlador(VistaLogin v, Persistencia m) {
        this.v = v;
        this.m = m;
        this.InitListeners();
       
    }
  public void LocalUser(String id){
       sinP = SingletonUsers.getSin();
       sinP.setID(id);
    }
    @Override
    public void InitListeners() {
         this.v.getJbtnAcceder().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             Find();
             
            }
        });
         this.v.getJbtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cancel();
            }
        });
        this.v.getJbtnLimpiar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.getjPwdContraseña().setText("");
                v.getJtxtCedula().setText("");
                v.getJcboUser().setSelectedIndex(0);
            }
        });
    }
    

   
    @Override
    public void Find() {
        try {
           exist = false;
            v.getM().getListaPersonas().forEach(
                p->{
           
                    if (v.getJtxtCedula().getText().equals(p.getId()) && Convertir(v.getjPwdContraseña()).equals(p.getPassword()) && v.getJcboUser().getSelectedItem().equals(p.getTipo())) {
                        LoginControlador.this.v.setVisible(false);
                        VistaMenuPrincipal principal = new VistaMenuPrincipal(m);
                        principal.iniciar();
                        exist = true;
                         LocalUser(p.getId());
                        
                    }
                    
                }
            );
            if(!exist){
                JOptionPane.showMessageDialog(null, "\nEl usuario no fué encontrado verifique que los\n "
                        + "datos se ingresaron correctamente ", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
            }else{
            
              descripcion = "Inicio Session el usuario " +this.sinP.getID();
            this.AddReport(descripcion,sinP.getID(),v.getM());}
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex + " " + "\nDebe de llenar todos los campos", "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {

            System.err.println(ex);
          
        }
    }

   public void Cancel(){
      int confirmar;
            confirmar =JOptionPane.showConfirmDialog(null, "Esta seguro que desea cancelar? ", "Cancelar Ingreso" , WIDTH, HEIGHT);

       if(JOptionPane.YES_NO_OPTION==confirmar) {
          this.v.dispose();
            }
   }
}

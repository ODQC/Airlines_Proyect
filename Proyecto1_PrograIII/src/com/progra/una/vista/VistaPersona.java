package com.progra.una.vista;

import com.progra.una.modelo.Persistencia;
import com.progra.una.controlador.ControladorPersona;
import com.progra.una.modelo.Persona;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author oscardanielquesadacalderon
 */
public class VistaPersona extends javax.swing.JPanel {

    private JPanel principal;
    private JPanel panTitulo;
    private JPanel panTexto;
    private JPanel panRadioBotones;
    private JPanel panBotones;

    private JButton btnVerUsuarios;
    private JButton btnCancelar;

    private ControladorPersona c;
    private Persona p;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtApellido1;
    private JTextField txtApellido2;
    private JPasswordField pwdContra1;
    private JPasswordField pwdContra2;

    private JRadioButton jrbAdministradorTI;
    private JRadioButton jrbAdministradorAero;
    private JRadioButton jrbAdministradorRes;
    private JRadioButton jrbUsuario;

    private JLabel lblRegistro;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblApellido1;
    private JLabel lblApellido2;
    private JLabel lblTipoDeUsuario;
    private JLabel lblContra1;
    private JLabel lblContra2;

    public VistaPersona(JPanel principal, Persistencia per) {
        this.InitComponents();
        this.principal = principal;
        this.c = new ControladorPersona(p, this);

    }

    public void iniciar() {
        this.setVisible(true);
    }

    public void InitComponents() {
        try {

            Container con = new Container();
            this.add(con);
            con.setLayout(new BorderLayout());
            this.setBackground(new java.awt.Color(60, 63, 65));

            principal = new JPanel();
            principal.setLayout(new BorderLayout());
            principal.setBackground(new Color(60, 63, 65));
            principal.setPreferredSize(new Dimension(900, 700));
            principal.setMinimumSize(new Dimension(900, 700));
            principal.setMaximumSize(new Dimension(900, 700));

            panTitulo = new JPanel();
            panTitulo.setLayout(new FlowLayout());
            panTitulo.setBackground(Color.ORANGE);
            panTitulo.setPreferredSize(new Dimension(900, 100));
            panTitulo.setMinimumSize(new Dimension(900, 100));
            panTitulo.setMaximumSize(new Dimension(900, 100));

            panTexto = new JPanel();
            panTexto.setLayout(new GridBagLayout());
            panTexto.setBackground(new Color(60, 63, 65));
            panTexto.setPreferredSize(new Dimension(900, 530));
            panTexto.setMinimumSize(new Dimension(900, 530));
            panTexto.setMaximumSize(new Dimension(900, 530));
            GridBagConstraints a = new GridBagConstraints();
            GridBagConstraints b = new GridBagConstraints();

            panRadioBotones = new JPanel();
            panRadioBotones.setLayout(new GridBagLayout());
            panRadioBotones.setBackground(new Color(60, 63, 65));
            panRadioBotones.setPreferredSize(new Dimension(450, 180));
            panRadioBotones.setMinimumSize(new Dimension(450, 180));
            panRadioBotones.setMaximumSize(new Dimension(450, 180));
            b.gridx = 1;
            b.gridy = 0;
            b.gridheight = 8;
            b.gridwidth = 1;
            panTexto.add(panRadioBotones, b);

            panBotones = new JPanel();
            panBotones.setLayout(new GridBagLayout());
            panBotones.setBackground(new Color(60, 63, 65));
            panBotones.setPreferredSize(new Dimension(900, 100));
            panBotones.setMinimumSize(new Dimension(900, 100));
            panBotones.setMaximumSize(new Dimension(900, 100));

            lblRegistro = new JLabel("Registro", JLabel.CENTER);
            lblRegistro.setForeground(new Color(35, 49, 67));
            lblRegistro.setFont(new Font("Lucida Grande", 0, 50));
            lblRegistro.setForeground(Color.white);
            panTitulo.add(lblRegistro);

            lblTipoDeUsuario = new JLabel("Tipo de Usuario", JLabel.CENTER);
            lblTipoDeUsuario.setFont(new Font("Arial", 1, 20));
            lblTipoDeUsuario.setForeground(Color.white);
            a.gridx = 0;
            a.gridy = 0;
            a.gridwidth = 1;
            panRadioBotones.add(lblTipoDeUsuario, a);

            lblId = new JLabel("Usuario", JLabel.CENTER);
            lblId.setFont(new Font("Arial", 1, 20));
            lblId.setForeground(Color.white);
            a.gridx = 0;
            a.gridy = 0;
            a.gridwidth = 1;
            panTexto.add(lblId, a);

            lblNombre = new JLabel("Nombre", JLabel.CENTER);
            lblNombre.setFont(new Font("Arial", 1, 20));
            lblNombre.setForeground(Color.white);
            a.gridx = 0;
            a.gridy = 2;
            a.gridwidth = 1;
            panTexto.add(lblNombre, a);

            lblApellido1 = new JLabel("Primer Apellido", JLabel.CENTER);
            lblApellido1.setFont(new Font("Arial", 1, 20));
            lblApellido1.setForeground(Color.white);
            a.gridx = 0;
            a.gridy = 4;
            a.gridwidth = 1;
            panTexto.add(lblApellido1, a);

            lblApellido2 = new JLabel("Segundo Apellido", JLabel.CENTER);
            lblApellido2.setFont(new Font("Arial", 1, 20));
            lblApellido2.setForeground(Color.white);
            a.gridx = 0;
            a.gridy = 6;
            a.gridwidth = 1;
            panTexto.add(lblApellido2, a);

            a.insets = new Insets(5, 5, 5, 5);

            btnVerUsuarios = new JButton("Ver usuarios");
            btnVerUsuarios.setPreferredSize(new Dimension(200, 40));
            btnVerUsuarios.setMinimumSize(new Dimension(200, 40));
            btnVerUsuarios.setMaximumSize(new Dimension(200, 40));
            btnVerUsuarios.setForeground(Color.white);
            btnVerUsuarios.setBackground(Color.gray);
            a.gridx = 0;
            a.gridy = 0;
            panBotones.add(btnVerUsuarios, a);

            btnCancelar = new JButton("Cancelar");
            btnCancelar.setPreferredSize(new Dimension(200, 40));
            btnCancelar.setMinimumSize(new Dimension(200, 40));
            btnCancelar.setMaximumSize(new Dimension(200, 40));
            btnCancelar.setForeground(Color.white);
            btnCancelar.setBackground(Color.gray);
            a.gridx = 1;
            a.gridy = 0;
            panBotones.add(btnCancelar, a);

            lblContra1 = new JLabel("Digite la Contraseña", JLabel.CENTER);
            lblContra1.setFont(new Font("Arial", 1, 20));
            lblContra1.setForeground(Color.white);
            a.gridx = 0;
            a.gridy = 8;
            panTexto.add(lblContra1, a);

            lblContra2 = new JLabel("Digite la Contraseña", JLabel.CENTER);
            lblContra2.setFont(new Font("Arial", 1, 20));
            lblContra2.setForeground(Color.white);
            a.gridx = 0;
            a.gridy = 10;
            panTexto.add(lblContra2, a);

            pwdContra1 = new JPasswordField();
            pwdContra1.setPreferredSize(new Dimension(300, 20));
            pwdContra1.setMinimumSize(new Dimension(300, 20));
            pwdContra1.setMaximumSize(new Dimension(300, 20));
            a.gridx = 0;
            a.gridy = 9;
            panTexto.add(pwdContra1, a);

            pwdContra2 = new JPasswordField();
            pwdContra2.setPreferredSize(new Dimension(300, 20));
            pwdContra2.setMinimumSize(new Dimension(300, 20));
            pwdContra2.setMaximumSize(new Dimension(300, 20));
            a.gridx = 0;
            a.gridy = 11;
            panTexto.add(pwdContra2, a);

            txtId = new JTextField();
            txtId.setPreferredSize(new Dimension(300, 20));
            a.gridx = 0;
            a.gridy = 1;
            a.gridwidth = 1;
            panTexto.add(txtId, a);

            txtNombre = new JTextField();
            txtNombre.setPreferredSize(new Dimension(300, 20));
            a.gridx = 0;
            a.gridy = 3;
            a.gridwidth = 1;
            panTexto.add(txtNombre, a);

            txtApellido1 = new JTextField();
            txtApellido1.setPreferredSize(new Dimension(300, 20));
            a.gridx = 0;
            a.gridy = 5;
            a.gridwidth = 1;
            panTexto.add(txtApellido1, a);

            txtApellido2 = new JTextField();
            txtApellido2.setPreferredSize(new Dimension(300, 20));
            a.gridx = 0;
            a.gridy = 7;
            a.gridwidth = 1;
            panTexto.add(txtApellido2, a);

            jrbAdministradorTI = new JRadioButton("Administrador de TI");
            jrbAdministradorTI.setFont(new Font("Arial", 1, 15));
            jrbAdministradorTI.setBackground(new Color(60, 63, 65));
            jrbAdministradorTI.setPreferredSize(new Dimension(300, 32));
            jrbAdministradorTI.setMinimumSize(new Dimension(300, 32));
            jrbAdministradorTI.setMaximumSize(new Dimension(300, 32));
            jrbAdministradorTI.setForeground(Color.white);
            a.gridx = 0;
            a.gridy = 1;
            a.gridwidth = 1;
            panRadioBotones.add(jrbAdministradorTI, a);

            jrbAdministradorAero = new JRadioButton("Administrador de Aerolineas");
            jrbAdministradorAero.setFont(new Font("Arial", 1, 15));
            jrbAdministradorAero.setBackground(new Color(60, 63, 65));
            jrbAdministradorAero.setPreferredSize(new Dimension(300, 32));
            jrbAdministradorAero.setMinimumSize(new Dimension(300, 32));
            jrbAdministradorAero.setMaximumSize(new Dimension(300, 32));
            jrbAdministradorAero.setForeground(Color.white);
            a.gridx = 0;
            a.gridy = 2;
            a.gridwidth = 1;
            panRadioBotones.add(jrbAdministradorAero, a);

            jrbAdministradorRes = new JRadioButton("Administrador de Reservaciones");
            jrbAdministradorRes.setFont(new Font("Arial", 1, 15));
            jrbAdministradorRes.setBackground(new Color(60, 63, 65));
            jrbAdministradorRes.setPreferredSize(new Dimension(300, 32));
            jrbAdministradorRes.setMinimumSize(new Dimension(300, 32));
            jrbAdministradorRes.setMaximumSize(new Dimension(300, 32));
            jrbAdministradorRes.setForeground(Color.white);
            a.gridx = 0;
            a.gridy = 3;
            a.gridwidth = 1;
            panRadioBotones.add(jrbAdministradorRes, a);

            jrbUsuario = new JRadioButton("Administrador de Usuarios");
            jrbUsuario.setFont(new Font("Arial", 1, 15));
            jrbUsuario.setBackground(new Color(60, 63, 65));
            jrbUsuario.setPreferredSize(new Dimension(300, 32));
            jrbUsuario.setMinimumSize(new Dimension(300, 32));
            jrbUsuario.setMaximumSize(new Dimension(300, 32));
            jrbUsuario.setForeground(Color.white);
            a.gridx = 0;
            a.gridy = 4;
            a.gridwidth = 1;
            panRadioBotones.add(jrbUsuario, a);

            principal.add(panTexto, BorderLayout.CENTER);
            principal.add(panTitulo, BorderLayout.PAGE_START);
            principal.add(panBotones, BorderLayout.PAGE_END);

            con.add(principal, BorderLayout.CENTER);
        } catch (NullPointerException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public ControladorPersona getControlerP() {
        return c;
    }

    public JButton getBtnVerUsuarios() {
        return btnVerUsuarios;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public ControladorPersona getC() {
        return c;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtApellido1() {
        return txtApellido1;
    }

    public JTextField getTxtApellido2() {
        return txtApellido2;
    }

    public JPasswordField getPwdContra1() {
        return pwdContra1;
    }

    public JPasswordField getPwdContra2() {
        return pwdContra2;
    }

}

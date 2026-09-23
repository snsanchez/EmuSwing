// by: Santiago Sánchez
package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class IniciarSesion {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IniciarSesion window = new IniciarSesion();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public IniciarSesion() {
        initialize();
    }

    private void initialize() {

        frame = new JFrame();
        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1426, 780);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.getContentPane().setLayout(new BorderLayout());


        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        frame.getContentPane().add(
                panelPrincipal,
                BorderLayout.CENTER
        );

        JPanel panelCentrador = new JPanel();
        panelCentrador.setLayout(new GridBagLayout());

        panelPrincipal.add(
                panelCentrador,
                BorderLayout.CENTER
        );


        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new GridBagLayout());

        panelLogin.setPreferredSize(
                new Dimension(400, 300)
        );

        panelLogin.setBorder(
                new TitledBorder(null, "EmuSwing", TitledBorder.LEADING, TitledBorder.TOP, null, null)
        );

        JLabel lblTitulo = new JLabel("Iniciar Sesión");
        lblTitulo.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        GridBagConstraints gbcTitulo =
                new GridBagConstraints();

        gbcTitulo.gridx = 0;
        gbcTitulo.gridy = 0;
        gbcTitulo.gridwidth = 2;

        gbcTitulo.fill =
                GridBagConstraints.HORIZONTAL;

        gbcTitulo.insets =
                new Insets(10, 25, 15, 25);

        panelLogin.add(
                lblTitulo,
                gbcTitulo
        );

        JLabel lblUsername = new JLabel("Username");

        GridBagConstraints gbcUsername =
                new GridBagConstraints();

        gbcUsername.gridx = 0;
        gbcUsername.gridy = 1;
        gbcUsername.gridwidth = 2;

        gbcUsername.fill =
                GridBagConstraints.HORIZONTAL;

        gbcUsername.insets =
                new Insets(5, 25, 5, 25);

        panelLogin.add(
                lblUsername,
                gbcUsername
        );


        textField = new JTextField();

        GridBagConstraints gbcTextField =
                new GridBagConstraints();

        gbcTextField.gridx = 0;
        gbcTextField.gridy = 2;
        gbcTextField.gridwidth = 2;

        gbcTextField.fill =
                GridBagConstraints.HORIZONTAL;

        gbcTextField.weightx = 1.0;

        gbcTextField.insets =
                new Insets(0, 25, 10, 25);

        panelLogin.add(
                textField,
                gbcTextField
        );
        JLabel lblPassword = new JLabel("Password");

        GridBagConstraints gbcPassword =
                new GridBagConstraints();

        gbcPassword.gridx = 0;
        gbcPassword.gridy = 3;
        gbcPassword.gridwidth = 2;

        gbcPassword.fill =
                GridBagConstraints.HORIZONTAL;

        gbcPassword.insets =
                new Insets(5, 25, 5, 25);

        panelLogin.add(
                lblPassword,
                gbcPassword
        );

        passwordField = new JPasswordField();

        GridBagConstraints gbcPasswordField =
                new GridBagConstraints();

        gbcPasswordField.gridx = 0;
        gbcPasswordField.gridy = 4;
        gbcPasswordField.gridwidth = 2;

        gbcPasswordField.fill =
                GridBagConstraints.HORIZONTAL;

        gbcPasswordField.weightx = 1.0;

        gbcPasswordField.insets =
                new Insets(0, 25, 15, 25);

        panelLogin.add(
                passwordField,
                gbcPasswordField
        );

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        10,
                        5
                )
        );

        JButton btnIngresar =
                new JButton("Ingresar");

        JButton btnCancelar =
                new JButton("Cancelar");

        panelBotones.add(btnIngresar);
        panelBotones.add(btnCancelar);


        GridBagConstraints gbcBotones =
                new GridBagConstraints();

        gbcBotones.gridx = 0;
        gbcBotones.gridy = 5;
        gbcBotones.gridwidth = 2;

        gbcBotones.anchor =
                GridBagConstraints.CENTER;

        gbcBotones.insets =
                new Insets(5, 25, 10, 25);

        panelLogin.add(
                panelBotones,
                gbcBotones
        );


        GridBagConstraints gbcLogin =
                new GridBagConstraints();

        gbcLogin.gridx = 0;
        gbcLogin.gridy = 0;

        gbcLogin.anchor =
                GridBagConstraints.CENTER;

        panelCentrador.add(
                panelLogin,
                gbcLogin
        );
    }
}
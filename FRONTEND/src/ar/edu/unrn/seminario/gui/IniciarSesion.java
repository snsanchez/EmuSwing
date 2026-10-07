// by: Santiago Sánchez
package ar.edu.unrn.seminario.gui;

import ar.edu.unrn.seminario.helpers.UIHelper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class IniciarSesion extends JFrame {

    private JFrame frame;
    private JTextField userField;
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
        frame.setTitle("Login - EmuSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1426, 780);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.getContentPane().setLayout(new BorderLayout());

        // ----------- PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(UIHelper.COLOR_FONDO);

        frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        frame.getContentPane().setBackground(UIHelper.COLOR_FONDO);

        // -------- CENTRADOR
        JPanel panelCentrador = new JPanel();
        panelCentrador.setLayout(new GridBagLayout());
        panelCentrador.setBackground(UIHelper.COLOR_FONDO);
        panelPrincipal.add(panelCentrador, BorderLayout.CENTER);

        // ------- PANEL DE LOGIN
        JPanel panelLogin = new JPanel(new GridBagLayout());

        panelLogin.setPreferredSize(new Dimension(400, 300));
        panelLogin.setBackground(UIHelper.COLOR_TARJETA);
        panelLogin.setBorder(new TitledBorder(new LineBorder(UIHelper.COLOR_ACENTO, 2, true), "EmuSwing",
                TitledBorder.LEADING, TitledBorder.TOP, UIHelper.FONT_SUBTITULO, UIHelper.COLOR_TEXTO));

        JLabel lblTitulo = new JLabel("Iniciar Sesión");
        lblTitulo.setFont(UIHelper.FONT_TITULO);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(UIHelper.COLOR_TEXTO);

        GridBagConstraints gbcTitulo = new GridBagConstraints();

        gbcTitulo.gridx = 0;
        gbcTitulo.gridy = 0;
        gbcTitulo.gridwidth = 2;

        gbcTitulo.fill = GridBagConstraints.HORIZONTAL;

        gbcTitulo.insets = new Insets(10, 25, 15, 25);

        panelLogin.add(lblTitulo, gbcTitulo);

        JLabel lblUsername = new JLabel("Nombre de usuario");
        lblUsername.setFont(UIHelper.FONT_LABEL);
        lblUsername.setForeground(UIHelper.COLOR_TEXTO);

        GridBagConstraints gbcUsername = new GridBagConstraints();

        gbcUsername.gridx = 0;
        gbcUsername.gridy = 1;
        gbcUsername.gridwidth = 2;

        gbcUsername.fill = GridBagConstraints.HORIZONTAL;

        gbcUsername.insets = new Insets(5, 25, 5, 25);

        panelLogin.add(lblUsername, gbcUsername);

        userField = new JTextField();
        /*
        userField.setBackground(UIHelper.COLOR_TARJETA);
        userField.setForeground(UIHelper.COLOR_TEXTO);
        userField.setCaretColor(UIHelper.COLOR_TEXTO);
        userField.setFont(UIHelper.FONT_TEXTFIELDS);
        userField.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(UIHelper.COLOR_BORDE, 1),
				BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        */

        
        GridBagConstraints gbc_userField = new GridBagConstraints();

        gbc_userField.gridx = 0;
        gbc_userField.gridy = 2;
        gbc_userField.gridwidth = 2;

        gbc_userField.fill = GridBagConstraints.HORIZONTAL;

        gbc_userField.weightx = 1.0;

        gbc_userField.insets = new Insets(0, 25, 10, 25);

        panelLogin.add(userField, gbc_userField);
        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setForeground(UIHelper.COLOR_TEXTO);
        lblPassword.setFont(UIHelper.FONT_LABEL);
        GridBagConstraints gbcPassword = new GridBagConstraints();

        gbcPassword.gridx = 0;
        gbcPassword.gridy = 3;
        gbcPassword.gridwidth = 2;

        gbcPassword.fill = GridBagConstraints.HORIZONTAL;

        gbcPassword.insets = new Insets(5, 25, 5, 25);

        panelLogin.add(lblPassword, gbcPassword);

        passwordField = new JPasswordField();

        GridBagConstraints gbcPasswordField = new GridBagConstraints();

        gbcPasswordField.gridx = 0;
        gbcPasswordField.gridy = 4;
        gbcPasswordField.gridwidth = 2;

        gbcPasswordField.fill = GridBagConstraints.HORIZONTAL;

        gbcPasswordField.weightx = 1.0;

        gbcPasswordField.insets = new Insets(0, 25, 15, 25);

        panelLogin.add(passwordField, gbcPasswordField);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        // panelBotones.setBackground(COLOR_TARJETA);
        panelBotones.setOpaque(false);
        JButton btnIngresar = crearBotonAccion("Ingresar", true);

        JButton btnCancelar = crearBotonAccion("Cancelar", false);

        panelBotones.add(btnIngresar);
        panelBotones.add(btnCancelar);

        GridBagConstraints gbcBotones = new GridBagConstraints();

        gbcBotones.gridx = 0;
        gbcBotones.gridy = 5;
        gbcBotones.gridwidth = 2;

        gbcBotones.anchor = GridBagConstraints.CENTER;

        gbcBotones.insets = new Insets(5, 25, 10, 25);

        panelLogin.add(panelBotones, gbcBotones);

        GridBagConstraints gbcLogin = new GridBagConstraints();

        gbcLogin.gridx = 0;
        gbcLogin.gridy = 0;

        gbcLogin.anchor = GridBagConstraints.CENTER;

        panelCentrador.add(panelLogin, gbcLogin);
    }

    private JButton crearBotonAccion(String texto, boolean relleno) {

        final JButton boton = new JButton(texto);

        boton.setFont(UIHelper.FONT_BOTON);
        boton.setFocusPainted(false);
        boton.setOpaque(true);

        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        final Color colorNormal;
        final Color colorHover;

        if (relleno) {

            colorNormal = UIHelper.COLOR_ACENTO;
            colorHover = UIHelper.COLOR_ACENTO_HOVER;

            boton.setForeground(UIHelper.COLOR_FONDO);

            boton.setBorder(new EmptyBorder(10, 28, 10, 28));

        } else {

            colorNormal = UIHelper.COLOR_CONTENIDO;
            colorHover = UIHelper.COLOR_TARJETA_HOVER;

            boton.setForeground(UIHelper.COLOR_TEXTO);

            boton.setBorder(
                    new CompoundBorder(new LineBorder(UIHelper.COLOR_ACENTO, 2, true), new EmptyBorder(8, 26, 8, 26)));
        }

        boton.setBackground(colorNormal);

        boton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(colorHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorNormal);
            }
        });

        return boton;
    }

}

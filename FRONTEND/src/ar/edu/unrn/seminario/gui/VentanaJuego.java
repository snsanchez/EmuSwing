package ar.edu.unrn.seminario.gui;

import ar.edu.unrn.seminario.helpers.UIHelper;
import ar.edu.unrn.seminario.gui.EmuladorWeb;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class VentanaJuego extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String URL_PRUEBA = "https://archive.org/embed/msdos_DOOM_1993";
    private JPanel contentPane;
    private EmuladorWeb emuladorWeb;

    public VentanaJuego() {
        this(URL_PRUEBA);
    }

    public VentanaJuego(String urlJuego) {
        setTitle("EmuSwing - Jugando");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.BLACK);
        setContentPane(contentPane);

        construirPanelSuperior();
        construirPanelJuego(urlJuego);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (emuladorWeb != null) {
                    emuladorWeb.cerrar();
                    emuladorWeb = null;
                }
            }
        });
    }

    private void construirPanelSuperior() {
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(UIHelper.COLOR_FONDO);

        JLabel lblAtras = new JLabel();
        lblAtras.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblAtras.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        java.net.URL imgUrl = getClass().getResource("/img/flecha.png");

        if (imgUrl != null) {
            ImageIcon iconFlecha = new ImageIcon(imgUrl);
            Image imgFlecha = iconFlecha.getImage()
            .getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            lblAtras.setIcon(new ImageIcon(imgFlecha));
        } else {
            lblAtras.setText("\u25C0");
        }

        lblAtras.setText(lblAtras.getText().isEmpty()
                    ? " VOLVER" : lblAtras.getText() + " VOLVER");
        lblAtras.setForeground(UIHelper.COLOR_TEXTO);
        lblAtras.setFont(UIHelper.FONT_SECCION);

        panelSuperior.add(lblAtras, BorderLayout.WEST);

        JPanel panelNavegacion = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
        panelNavegacion.setBackground(UIHelper.COLOR_FONDO);

        String[] menuItems = { "Mi Perfil", "Biblioteca", "Juegos", "Historia", "Controles", "Tienda", "Soporte", "Ajustes" };

        for (String texto : menuItems) {
            JLabel lblMenu = new JLabel(texto);

            if (texto.equals("Juegos")) {
                lblMenu.setForeground(UIHelper.COLOR_TEXTO);
                lblMenu.setFont(UIHelper.FONT_SECCION);
            }
            else {
                lblMenu.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
                lblMenu.setFont(UIHelper.FONT_MENU);
            }

            lblMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));

            if (texto.equals("Controles")) {
                lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        JOptionPane.showMessageDialog(
                            VentanaJuego.this,
                            "Controles Básicos:\n\nMovimiento: Flechas\nAcción 1: Z\nAcción 2: X\nStart: Enter",
                            "Controles del Juego",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                });
            }

            if (texto.equals("Historia")) {
                lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        JOptionPane.showMessageDialog(
                            VentanaJuego.this,
                            "En el año 2145, fuiste enviado a una instalación en Marte...\nTu misión: sobrevivir a la invasión y encontrar la salida.",
                            "Historia del Juego",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                });
            }

            panelNavegacion.add(lblMenu);
        }
        panelSuperior.add(panelNavegacion, BorderLayout.CENTER);

        JLabel contrapeso = new JLabel();
        contrapeso.setPreferredSize(new Dimension(100, 30));
        panelSuperior.add(contrapeso, BorderLayout.EAST);

        contentPane.add(panelSuperior, BorderLayout.NORTH);

    }

    private void construirPanelJuego(String urlJuego) {
        JPanel panelJuego = new JPanel(new BorderLayout());
        panelJuego.setBackground(Color.BLACK);

        try {
            emuladorWeb = new EmuladorWeb(urlJuego);
            panelJuego.add(emuladorWeb, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();

            JLabel lblError = new JLabel(
                "No se pudo iniciar el juego.",
                SwingConstants.CENTER
            );
            lblError.setForeground(Color.WHITE);
            panelJuego.add(lblError, BorderLayout.CENTER);
        }

        contentPane.add(panelJuego, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                VentanaJuego ventana = new VentanaJuego();
                ventana.setVisible(true);
            });
        }
}

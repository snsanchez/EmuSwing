package ar.edu.unrn.seminario.gui;

import javax.swing.*;
import java.awt.*;

public class VentanaJuego extends JFrame {
    private JPanel contentPane;

    public VentanaJuego() {
        setTitle("EmuSwing - Jugando");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.BLACK);
        setContentPane(contentPane);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(PaletaRetro.COLOR_FONDO); 
        
        JLabel lblAtras = new JLabel();
        lblAtras.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        lblAtras.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        
        java.io.File imgFileAtras = new java.io.File("flecha.png");
        if (imgFileAtras.exists()) {
            ImageIcon iconFlecha = new ImageIcon(imgFileAtras.getAbsolutePath());
            Image imgFlecha = iconFlecha.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            lblAtras.setIcon(new ImageIcon(imgFlecha));
        } else {
            lblAtras.setText("◀ VOLVER");
            lblAtras.setForeground(PaletaRetro.COLOR_TEXTO);
            lblAtras.setFont(PaletaRetro.FONT_SECCION);
        }
        panelSuperior.add(lblAtras, BorderLayout.WEST);

        JPanel panelNavegacion = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
        panelNavegacion.setBackground(PaletaRetro.COLOR_FONDO);
        
        String[] menuItems = {"Mi Perfil", "Biblioteca", "Juegos", "Tienda", "Soporte", "Ajustes"};
        for (String texto : menuItems) {
            JLabel lblMenu = new JLabel(texto);
            if(texto.equals("Juegos")) {
                lblMenu.setForeground(PaletaRetro.COLOR_TEXTO);
                lblMenu.setFont(PaletaRetro.FONT_SECCION); 
            } else {
                lblMenu.setForeground(PaletaRetro.COLOR_TEXTO_SECUNDARIO);
                lblMenu.setFont(PaletaRetro.FONT_MENU);
            }
            lblMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
            panelNavegacion.add(lblMenu);
        }
        panelSuperior.add(panelNavegacion, BorderLayout.CENTER);
       
        JLabel contrapeso = new JLabel();
        contrapeso.setPreferredSize(new Dimension(100, 30)); 
        panelSuperior.add(contrapeso, BorderLayout.EAST);

        contentPane.add(panelSuperior, BorderLayout.NORTH);

        JPanel panelJuego = new JPanel() {
            private Image bgImage;
            
            {
                try {
                    java.io.File imgFondo = new java.io.File("juego_fondo.png");
                    if (imgFondo.exists()) {
                        bgImage = new ImageIcon(imgFondo.getAbsolutePath()).getImage();
                    }
                } catch (Exception e) {
                    System.out.println("No se encontró la imagen del juego.");
                }
            }

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (bgImage != null) {
                    g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        
        panelJuego.setBackground(Color.BLACK);
        contentPane.add(panelJuego, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaJuego().setVisible(true);
        });
    }
}
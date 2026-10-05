package ar.edu.unrn.seminario.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaSeleccionarAvatar extends JFrame {
    private JPanel contentPane;

    public VentanaSeleccionarAvatar() {
        setTitle("EmuSwing - Seleccionar Avatar");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 480); 
        setLocationRelativeTo(null); 

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(PaletaRetro.COLOR_FONDO);
        setContentPane(contentPane);

        JPanel panelCabecera = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelCabecera.setBackground(PaletaRetro.COLOR_FONDO);
        panelCabecera.setBorder(new EmptyBorder(20, 0, 10, 0));
        
        JLabel lblTitulo = new JLabel("AVATARES PREDETERMINADOS");
        lblTitulo.setForeground(PaletaRetro.COLOR_TEXTO);
        lblTitulo.setFont(PaletaRetro.FONT_TITULO);
        panelCabecera.add(lblTitulo);
        
        contentPane.add(panelCabecera, BorderLayout.NORTH);

        JPanel panelGrilla = new JPanel(new GridLayout(2, 5, 20, 20));
        panelGrilla.setBackground(PaletaRetro.COLOR_FONDO);
        panelGrilla.setBorder(new EmptyBorder(20, 40, 20, 40));


        String[] archivosAvatares = {
            "AvatarLuna.png", "AvatarMontaña.png", "AvatarEngranaje.png", 
            "AvatarCabRobot.png", "AvatarFlechas.png", "AvatarHoja.png", 
            "AvatarCubo.png", "AvatarCohete.png", "AvatarEstrella.png", "AvatarRayo.png"
        };

        for (String archivo : archivosAvatares) {
            panelGrilla.add(crearCuadroAvatar(archivo));
        }

        contentPane.add(panelGrilla, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        panelInferior.setBackground(PaletaRetro.COLOR_FONDO);
        panelInferior.setBorder(new EmptyBorder(10, 20, 20, 40));

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(PaletaRetro.COLOR_FONDO.darker());
        btnCancelar.setForeground(PaletaRetro.COLOR_TEXTO);
        btnCancelar.setFont(PaletaRetro.FONT_MENU);
        btnCancelar.setBorder(BorderFactory.createLineBorder(PaletaRetro.COLOR_TEXTO_SECUNDARIO, 1));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancelar.setPreferredSize(new Dimension(100, 30));
        btnCancelar.addActionListener(e -> dispose()); 

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setBackground(PaletaRetro.COLOR_FONDO.darker());
        btnSeleccionar.setForeground(PaletaRetro.COLOR_TEXTO);
        btnSeleccionar.setFont(PaletaRetro.FONT_MENU);
        btnSeleccionar.setBorder(BorderFactory.createLineBorder(PaletaRetro.COLOR_ACENTO, 1));
        btnSeleccionar.setFocusPainted(false);
        btnSeleccionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSeleccionar.setPreferredSize(new Dimension(120, 30)); 

        panelInferior.add(btnCancelar);
        panelInferior.add(btnSeleccionar);
        
        contentPane.add(panelInferior, BorderLayout.SOUTH);
    }

    private JPanel crearCuadroAvatar(String rutaImagen) {
        JPanel panelCuadro = new JPanel(new BorderLayout()) {
            private Image bgImage;
            
            {
                try {
                    java.io.File imgFile = new java.io.File(rutaImagen);
                    if (imgFile.exists()) {
                        bgImage = new ImageIcon(imgFile.getAbsolutePath()).getImage();
                    }
                } catch (Exception e) {}
            }

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (bgImage != null) {
                    int margin = getWidth() / 4; 
                    int size = Math.min(getWidth() - (margin * 2), getHeight() - (margin * 2));
                    
                    int x = (getWidth() - size) / 2;
                    int y = (getHeight() - size) / 2;
                    
                    g.drawImage(bgImage, x, y, size, size, this);
                }
            }
        };
        
        panelCuadro.setBackground(PaletaRetro.COLOR_CONTENIDO); 
        panelCuadro.setBorder(BorderFactory.createLineBorder(PaletaRetro.COLOR_ACENTO, 2));
        panelCuadro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        java.io.File checkFile = new java.io.File(rutaImagen);
        if (!checkFile.exists()) {
            JLabel lblError = new JLabel("?", SwingConstants.CENTER);
            lblError.setFont(new Font(PaletaRetro.FONT_MENU.getName(), Font.BOLD, 36));
            lblError.setForeground(PaletaRetro.COLOR_TEXTO_SECUNDARIO);
            panelCuadro.add(lblError, BorderLayout.CENTER);
        }

        return panelCuadro;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaSeleccionarAvatar().setVisible(true);
        });
    }
}
package ar.edu.unrn.seminario.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaTienda extends JFrame {
    private JPanel contentPane;

    public VentanaTienda() {
        setTitle("EmuSwing - Tienda de Puntos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(PaletaRetro.COLOR_FONDO);
        setContentPane(contentPane);

        // --- PANEL SUPERIOR (Navegación + Cabecera de Tienda) ---
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(PaletaRetro.COLOR_FONDO);

        // 1. Barra de Navegación 
        JPanel panelNavegacion = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
        panelNavegacion.setBackground(PaletaRetro.COLOR_FONDO);
        
        String[] menuItems = {"Mi Perfil", "Biblioteca", "Juegos", "Tienda", "Soporte", "Ajustes"};
        for (String texto : menuItems) {
            JLabel lblMenu = new JLabel(texto);
            if(texto.equals("Tienda")) {
                lblMenu.setForeground(PaletaRetro.COLOR_TEXTO);
                lblMenu.setFont(PaletaRetro.FONT_SECCION); 
            } else {
                lblMenu.setForeground(PaletaRetro.COLOR_TEXTO_SECUNDARIO);
                lblMenu.setFont(PaletaRetro.FONT_MENU);
            }
            lblMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
            panelNavegacion.add(lblMenu);
        }
        panelSuperior.add(panelNavegacion, BorderLayout.NORTH);

        // 2. Cabecera (Título y Puntos)
        JPanel panelCabecera = new JPanel(new BorderLayout());
        panelCabecera.setBackground(PaletaRetro.COLOR_FONDO);
        panelCabecera.setBorder(new EmptyBorder(10, 40, 20, 40));

        JLabel lblTitulo = new JLabel("TIENDA DE PUNTOS");
        lblTitulo.setForeground(PaletaRetro.COLOR_TEXTO);
        lblTitulo.setFont(PaletaRetro.FONT_TITULO);
        panelCabecera.add(lblTitulo, BorderLayout.WEST);

        JLabel lblPuntos = new JLabel("Mis Puntos: 2.500 \u25CF"); 
        lblPuntos.setForeground(PaletaRetro.COLOR_ACENTO);
        lblPuntos.setFont(PaletaRetro.FONT_SECCION);
        panelCabecera.add(lblPuntos, BorderLayout.EAST);

        panelSuperior.add(panelCabecera, BorderLayout.SOUTH);
        contentPane.add(panelSuperior, BorderLayout.NORTH);

        // --- CONTENIDO DE LA TIENDA ---
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        panelContenido.setBackground(PaletaRetro.COLOR_FONDO);
        panelContenido.setBorder(new EmptyBorder(0, 40, 20, 40));

        // Nombres actualizados según tu sistema de archivos
        String[][] datosMarcos = {
            {"Marco Dorado", "Marco de avatar", "2.000", "DORADO.png"},
            {"Consola CMD", "Marco de avatar", "500", "ConsolaCmd.png"},
            {"HUD Doom", "Marco de avatar", "1.500", "Doom.png"},
            {"EVD Saver", "Marco de avatar", "500", "EVD.png"},
            {"Espada Pixel", "Marco de avatar", "1.000", "Espada.png"},
            {"Ventana 95", "Marco de avatar", "500", "Ventana 95.png"},
            {"Ventana XP", "Marco de avatar", "1.000", "Ventana XP.png"},
            {"MS Paint", "Marco de avatar", "1.500", "MS Paint.png"},
            {"TV CRT", "Marco de avatar", "1.000", "TV CRT.png"}
        };
        
        panelContenido.add(crearSeccionTienda("MARCOS DE AVATAR", datosMarcos));

        // Relleno invisible que empuja toda la sección hacia arriba para que no flote en el medio de la pantalla
        panelContenido.add(Box.createVerticalGlue());

        contentPane.add(panelContenido, BorderLayout.CENTER);
    }

    private JPanel crearSeccionTienda(String tituloSeccion, String[][] items) {
        JPanel panelSeccion = new JPanel(new BorderLayout(0, 15));
        panelSeccion.setBackground(PaletaRetro.COLOR_FONDO);
        panelSeccion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 320)); 

        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.setBackground(PaletaRetro.COLOR_FONDO);
        
        JLabel lblTitulo = new JLabel(tituloSeccion);
        lblTitulo.setForeground(PaletaRetro.COLOR_TEXTO_SECUNDARIO);
        lblTitulo.setFont(PaletaRetro.FONT_SECCION);
        panelTitulo.add(lblTitulo, BorderLayout.WEST);

        JSeparator separador = new JSeparator();
        separador.setBackground(PaletaRetro.COLOR_CONTENIDO);
        separador.setForeground(PaletaRetro.COLOR_CONTENIDO);
        panelTitulo.add(separador, BorderLayout.SOUTH);

        panelSeccion.add(panelTitulo, BorderLayout.NORTH);

        JPanel panelFila = new JPanel();
        panelFila.setLayout(new BoxLayout(panelFila, BoxLayout.X_AXIS));
        panelFila.setBackground(PaletaRetro.COLOR_FONDO);
        panelFila.setBorder(new EmptyBorder(10, 0, 15, 0));

        for (String[] item : items) {
            panelFila.add(crearTarjetaItem(item[0], item[1], item[2], item[3]));
            panelFila.add(Box.createRigidArea(new Dimension(20, 0))); 
        }

        // Scroll horizontal ESPECÍFICO para esta fila de cartas
        JScrollPane scrollHorizontal = new JScrollPane(panelFila);
        scrollHorizontal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollHorizontal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollHorizontal.setBorder(null);
        scrollHorizontal.getViewport().setBackground(PaletaRetro.COLOR_FONDO);
        scrollHorizontal.getHorizontalScrollBar().setUnitIncrement(16);
        scrollHorizontal.getHorizontalScrollBar().setBackground(PaletaRetro.COLOR_FONDO);

        panelSeccion.add(scrollHorizontal, BorderLayout.CENTER);
        return panelSeccion;
    }

    private JPanel crearTarjetaItem(String nombre, String tipo, String precio, String archivoImg) {
        JPanel tarjeta = new JPanel(new BorderLayout());
        tarjeta.setBackground(PaletaRetro.COLOR_CONTENIDO);
        tarjeta.setBorder(BorderFactory.createLineBorder(PaletaRetro.COLOR_CONTENIDO, 2));
        tarjeta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        tarjeta.setPreferredSize(new Dimension(170, 240));
        tarjeta.setMaximumSize(new Dimension(170, 240));
        tarjeta.setMinimumSize(new Dimension(170, 240));
        tarjeta.setAlignmentY(Component.TOP_ALIGNMENT);

        JPanel imgPlaceholder = new JPanel(new BorderLayout());
        imgPlaceholder.setBackground(PaletaRetro.COLOR_FONDO.darker());
        imgPlaceholder.setPreferredSize(new Dimension(150, 150)); 
        
        try {
            java.io.File imgFile = new java.io.File(archivoImg);
            if (imgFile.exists()) {
                ImageIcon iconOriginal = new ImageIcon(imgFile.getAbsolutePath());
                Image imgEscalada = iconOriginal.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                JLabel lblImg = new JLabel(new ImageIcon(imgEscalada));
                lblImg.setHorizontalAlignment(SwingConstants.CENTER);
                imgPlaceholder.add(lblImg, BorderLayout.CENTER);
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar: " + archivoImg);
        }
        
        tarjeta.add(imgPlaceholder, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(PaletaRetro.COLOR_CONTENIDO);
        infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblNombre = new JLabel(nombre.toUpperCase());
        lblNombre.setForeground(PaletaRetro.COLOR_TEXTO);
        lblNombre.setFont(new Font(PaletaRetro.FONT_MENU.getName(), Font.BOLD, 12));
        infoPanel.add(lblNombre);
        
        infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JLabel lblTipo = new JLabel("\u25A4 " + tipo); 
        lblTipo.setForeground(PaletaRetro.COLOR_TEXTO_SECUNDARIO);
        lblTipo.setFont(new Font(PaletaRetro.FONT_MENU.getName(), Font.PLAIN, 11));
        infoPanel.add(lblTipo);

        infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel precioPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        precioPanel.setBackground(PaletaRetro.COLOR_CONTENIDO);
        JLabel lblPrecio = new JLabel("\u2714 " + precio); 
        lblPrecio.setForeground(PaletaRetro.COLOR_TEXTO);
        lblPrecio.setFont(new Font(PaletaRetro.FONT_MENU.getName(), Font.BOLD, 12));
        precioPanel.add(lblPrecio);

        infoPanel.add(precioPanel);
        tarjeta.add(infoPanel, BorderLayout.CENTER);

        return tarjeta;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaTienda().setVisible(true);
        });
    }
}
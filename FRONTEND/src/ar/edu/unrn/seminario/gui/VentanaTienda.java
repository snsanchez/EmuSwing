package ar.edu.unrn.seminario.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaTienda extends JFrame {
    private JPanel contentPane;

    public static class Articulo {
        private String nombre;
        private String tipo;
        private String precio;
        private String archivoImg;

        public Articulo(String nombre, String tipo, String precio, String archivoImg) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.precio = precio;
            this.archivoImg = archivoImg;
        }

        public String getNombre() { return nombre; }
        public String getTipo() { return tipo; }
        public String getPrecio() { return precio; }
        public String getArchivoImg() { return archivoImg; }
    }

    public VentanaTienda() {
        setTitle("EmuSwing - Tienda de Puntos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(PaletaRetro.COLOR_FONDO);
        setContentPane(contentPane);

        // --- PANEL SUPERIOR ---
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(PaletaRetro.COLOR_FONDO);

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

        JPanel panelCabecera = new JPanel(new BorderLayout());
        panelCabecera.setBackground(PaletaRetro.COLOR_FONDO);
        panelCabecera.setBorder(new EmptyBorder(10, 20, 20, 20));

        JLabel lblTitulo = new JLabel("TIENDA DE PUNTOS", SwingConstants.CENTER);
        lblTitulo.setForeground(PaletaRetro.COLOR_TEXTO);
        lblTitulo.setFont(PaletaRetro.FONT_TITULO);
        lblTitulo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(PaletaRetro.COLOR_ACENTO, 2),
                BorderFactory.createEmptyBorder(10, 30, 10, 30) 
        ));

        JPanel panelContenedorTitulo = new JPanel(new GridBagLayout());
        panelContenedorTitulo.setBackground(PaletaRetro.COLOR_FONDO);
        panelContenedorTitulo.add(lblTitulo);
        panelCabecera.add(panelContenedorTitulo, BorderLayout.CENTER);

        JLabel lblPuntos = new JLabel("Mis Puntos: 2.500 \u25CF"); 
        lblPuntos.setForeground(PaletaRetro.COLOR_ACENTO);
        lblPuntos.setFont(PaletaRetro.FONT_SECCION);
        
        JPanel panelPuntos = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 15));
        panelPuntos.setBackground(PaletaRetro.COLOR_FONDO);
        panelPuntos.add(lblPuntos);
        panelCabecera.add(panelPuntos, BorderLayout.EAST);

        JLabel contrapeso = new JLabel();
        contrapeso.setPreferredSize(new Dimension(170, 30)); 
        panelCabecera.add(contrapeso, BorderLayout.WEST);

        panelSuperior.add(panelCabecera, BorderLayout.SOUTH);
        contentPane.add(panelSuperior, BorderLayout.NORTH);

        // --- CONTENIDO DE LA TIENDA ---
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        panelContenido.setBackground(PaletaRetro.COLOR_FONDO);
        panelContenido.setBorder(new EmptyBorder(0, 40, 20, 40));

        // LISTA 1: MARCOS
        List<Articulo> listaMarcos = new ArrayList<>();
        listaMarcos.add(new Articulo("Marco Dorado", "Marco de avatar", "2.000", "DORADO.png"));
        listaMarcos.add(new Articulo("Consola CMD", "Marco de avatar", "500", "ConsolaCmd.png"));
        listaMarcos.add(new Articulo("HUD Doom", "Marco de avatar", "1.500", "Doom.png"));
        listaMarcos.add(new Articulo("EVD Saver", "Marco de avatar", "500", "EVD.png"));
        listaMarcos.add(new Articulo("Espada Pixel", "Marco de avatar", "1.000", "Espada.png"));
        listaMarcos.add(new Articulo("Ventana 95", "Marco de avatar", "500", "Ventana 95.png"));
        listaMarcos.add(new Articulo("Ventana XP", "Marco de avatar", "1.000", "Ventana XP.png"));
        listaMarcos.add(new Articulo("MS Paint", "Marco de avatar", "1.500", "MS Paint.png"));
        listaMarcos.add(new Articulo("TV CRT", "Marco de avatar", "1.000", "TV CRT.png"));
        
        panelContenido.add(crearSeccionTienda("MARCOS DE AVATAR", listaMarcos));
        
        panelContenido.add(Box.createRigidArea(new Dimension(0, 30))); 

        // LISTA 2: AVATARES 
        List<Articulo> listaAvatares = new ArrayList<>();
        listaAvatares.add(new Articulo("Caballero", "Avatar", "1.000", "AvatarCaballero.png"));
        listaAvatares.add(new Articulo("Cofre", "Avatar", "500", "AvatarCofre.png"));
        listaAvatares.add(new Articulo("Cueva", "Avatar", "500", "AvatarCueva.png"));
        listaAvatares.add(new Articulo("Dragón", "Avatar", "1.500", "AvatarDragon.png"));
        listaAvatares.add(new Articulo("Fantasma", "Avatar", "1.000", "AvatarFantasma.png"));
        listaAvatares.add(new Articulo("Futuro", "Avatar", "1.500", "AvatarFuturo.png"));
        listaAvatares.add(new Articulo("Gameboy", "Avatar", "1.000", "AvatarGameboy.png"));
        listaAvatares.add(new Articulo("Hacha", "Avatar", "500", "AvatarHacha.png"));
        listaAvatares.add(new Articulo("Libro", "Avatar", "500", "AvatarLibro.png"));
        listaAvatares.add(new Articulo("Nave", "Avatar", "1.000", "AvatarNave.png"));
        listaAvatares.add(new Articulo("Robot", "Avatar", "1.500", "AvatarRobot.png"));
        listaAvatares.add(new Articulo("Zorro", "Avatar", "1.000", "AvatarZorro.png"));

        panelContenido.add(crearSeccionTienda("AVATARES", listaAvatares));

        panelContenido.add(Box.createVerticalGlue());
        
        JScrollPane scrollVertical = new JScrollPane(panelContenido);
        scrollVertical.setBorder(null);
        scrollVertical.getViewport().setBackground(PaletaRetro.COLOR_FONDO);
        scrollVertical.getVerticalScrollBar().setUnitIncrement(16);
        scrollVertical.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        contentPane.add(scrollVertical, BorderLayout.CENTER);
    }

    private JPanel crearSeccionTienda(String tituloSeccion, List<Articulo> items) {
        JPanel panelSeccion = new JPanel(new BorderLayout(0, 15));
        panelSeccion.setBackground(PaletaRetro.COLOR_FONDO);

        panelSeccion.setPreferredSize(new Dimension(800, 330));
        panelSeccion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 330));
        panelSeccion.setMinimumSize(new Dimension(400, 330)); 

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
        panelFila.setBorder(new EmptyBorder(5, 5, 5, 5));

        for (Articulo item : items) {
            panelFila.add(crearTarjetaItem(item.getNombre(), item.getTipo(), item.getPrecio(), item.getArchivoImg()));
            panelFila.add(Box.createRigidArea(new Dimension(20, 0))); 
        }

        JScrollPane scrollHorizontal = new JScrollPane(panelFila);
        scrollHorizontal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollHorizontal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollHorizontal.setBorder(null);
        scrollHorizontal.getViewport().setBackground(PaletaRetro.COLOR_FONDO);
        scrollHorizontal.getHorizontalScrollBar().setUnitIncrement(20);
        

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
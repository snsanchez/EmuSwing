
// by: Santiago Sánchez

package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ar.edu.unrn.seminario.api.IApi;
import ar.edu.unrn.seminario.api.MemoryApi;

public class VentanaPrincipal extends JFrame {

    // ---------- PALETA DE COLORES

    private static final Color COLOR_FONDO = new Color(24, 10, 32);
    private static final Color COLOR_CONTENIDO = new Color(50, 22, 66);
    private static final Color COLOR_TARJETA = new Color(64, 30, 82);
    private static final Color COLOR_TARJETA_HOVER = new Color(82, 40, 104);
    private static final Color COLOR_ACENTO = new Color(191, 90, 224);
    private static final Color COLOR_ACENTO_HOVER = new Color(206, 130, 235);
    private static final Color COLOR_TEXTO = new Color(245, 240, 247);
    private static final Color COLOR_TEXTO_SECUNDARIO = new Color(196, 180, 206);

    // ---------- FONT

    private static final Font FONT_TITULO = new Font("Segoe UI", Font.BOLD, 28);
    private static final Font FONT_SUBTITULO = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font FONT_SECCION = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font FONT_MENU = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font FONT_TARJETA = new Font("Segoe UI", Font.BOLD, 13);
    private static final Font FONT_BOTON = new Font("Segoe UI", Font.BOLD, 15);

    // ---------- DIMENSIONES
    // Si se quiere agrandar o achicar las portadas de los juegos ajustar aca
    private static final int ANCHO_PORTADA = 150;
    private static final int ALTO_PORTADA = 180;

    private static final int ANCHO_TARJETA = 180;
    private static final int ALTO_TARJETA = 220;

    private static final int ANCHO_CONTENIDO = 980;
    private static final int ALTO_CONTENIDO = 470;

    private JPanel contentPane;
    // usamos collections
    private final List<JPanel> tarjetas = new ArrayList<JPanel>();

    private String juegoSeleccionado;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IApi api = new MemoryApi();

                    VentanaPrincipal frame = new VentanaPrincipal(api);
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaPrincipal(IApi api) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home - EmuSwing");
        setSize(1426, 780);
        setLocationRelativeTo(null);
        setResizable(false);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(COLOR_FONDO);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        // ---------- BARRA DE NAVEGACIÓN

        JMenuBar menuBar = new JMenuBar();

        menuBar.setBackground(COLOR_FONDO);
        menuBar.setBorder(new EmptyBorder(4, 0, 4, 0));

        contentPane.add(menuBar, BorderLayout.NORTH);

        JPanel panelMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 5));

        panelMenu.setOpaque(false);

        panelMenu.add(crearBotonMenu("Mi Perfil"));
        panelMenu.add(crearBotonMenu("Biblioteca"));
        panelMenu.add(crearBotonMenu("Juegos"));
        panelMenu.add(crearBotonMenu("Tienda"));
        panelMenu.add(crearBotonMenu("Soporte"));

        JButton btnAjustes = crearBotonMenu("Ajustes");
        panelMenu.add(btnAjustes);

        menuBar.add(panelMenu);

        // ---------- PANEL PRINCIPAL

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBackground(COLOR_FONDO);

        contentPane.add(panelPrincipal, BorderLayout.CENTER);

        // ---------- HOME

        JPanel panelHome = new JPanel(new BorderLayout(0, 15));
        panelHome.setOpaque(false);
        panelHome.setBorder(new EmptyBorder(10, 20, 10, 20));

        panelPrincipal.add(panelHome);

        // ---------- LOGO

        JPanel panelLogo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        panelLogo.setOpaque(false);

        URL imgURL = getClass().getResource("/img/esw-logo.png");

        if (imgURL != null) {

            ImageIcon iconOriginal = new ImageIcon(imgURL);
            // escalar la imagen para que no se vea gigante
            Image imagenEscalada = iconOriginal.getImage().getScaledInstance(170, 134, Image.SCALE_SMOOTH);
            JLabel lblLogo = new JLabel(new ImageIcon(imagenEscalada));
            panelLogo.add(lblLogo);

        } else {
            JLabel lblLogo = new JLabel("EmuSwing");
            lblLogo.setFont(FONT_TITULO);
            lblLogo.setForeground(COLOR_TEXTO);
            panelLogo.add(lblLogo);
            System.out.println("No se encontró la imagen: /img/esw-logo.png");
        }

        panelHome.add(panelLogo, BorderLayout.NORTH);

        // ---------- CONTENIDO CENTRAL

        JPanel panelContenido = new JPanel(new BorderLayout(0, 15));
        panelContenido.setPreferredSize(new Dimension(ANCHO_CONTENIDO, ALTO_CONTENIDO));
        panelContenido.setBackground(COLOR_CONTENIDO);
        panelContenido
                .setBorder(new CompoundBorder(new LineBorder(COLOR_ACENTO, 2, true), new EmptyBorder(10, 20, 15, 20)));
        panelHome.add(panelContenido, BorderLayout.CENTER);

        // ---------- BIENVENIDA

        JPanel panelBienvenida = new JPanel(new BorderLayout(0, 4));
        panelBienvenida.setOpaque(false);
        JLabel lblBienvenida = new JLabel("Bienvenido a EmuSwing", SwingConstants.CENTER);
        lblBienvenida.setFont(FONT_TITULO);
        lblBienvenida.setForeground(COLOR_TEXTO);
        JLabel lblSubtitulo = new JLabel("Retomá donde lo dejaste.", SwingConstants.CENTER);
        lblSubtitulo.setFont(FONT_SUBTITULO);
        lblSubtitulo.setForeground(COLOR_TEXTO_SECUNDARIO);
        panelBienvenida.add(lblBienvenida, BorderLayout.NORTH);
        panelBienvenida.add(lblSubtitulo, BorderLayout.SOUTH);
        panelContenido.add(panelBienvenida, BorderLayout.NORTH);

        // ---------- ÚLTIMOS JUEGOS

        JPanel panelUltimosJuegos = new JPanel(new BorderLayout(0, 8));
        panelUltimosJuegos.setOpaque(false);
        JLabel lblUltimoJuegoJugado = new JLabel("Tus últimos juegos");
        lblUltimoJuegoJugado.setFont(FONT_SECCION);
        lblUltimoJuegoJugado.setForeground(COLOR_ACENTO);
        panelUltimosJuegos.add(lblUltimoJuegoJugado, BorderLayout.NORTH);

        // estos son solo datos de prueba, despues habria que cargarlos desde IApi
        // pasando por una base de datos
        String[] nombresJuegos = { "Super Street Fighter II", "Super Mario World", "Doom" };
        String[] imagenesJuegos = { "/img/Street-Fighter-II-USA_cover_1024x705.jpg",
                "/img/Super-Mario-Word_1990_cover_474x332.jpg", "/img/doom_1993_cover_720x1080.jpg" };
        // GridLayout mantiene las tres tarjetas del mismo tamaño
        JPanel panelTarjetas = new JPanel(new GridLayout(1, 3, 20, 0));

        panelTarjetas.setOpaque(false);

        panelTarjetas.setBorder(new EmptyBorder(5, 35, 5, 35));

        for (int i = 0; i < nombresJuegos.length; i++) {

            JPanel tarjeta = crearTarjetaJuego(nombresJuegos[i], imagenesJuegos[i]);

            tarjetas.add(tarjeta);
            panelTarjetas.add(tarjeta);
        }

        panelUltimosJuegos.add(panelTarjetas, BorderLayout.CENTER);
        panelContenido.add(panelUltimosJuegos, BorderLayout.CENTER);

        // ---------- ACCIONES

        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 16, 5));
        panelAcciones.setOpaque(false);
        JButton btnDetalles = crearBotonAccion("Ver detalles", false);
        // el \u25B6 es Unicode para el icono de jugar
        JButton btnJugar = crearBotonAccion("\u25B6  Jugar", true);

        panelAcciones.add(btnDetalles);
        panelAcciones.add(btnJugar);
        panelContenido.add(panelAcciones, BorderLayout.SOUTH);
        // no le pongo ningun listener aun porque por ahora solo es visual

    }

    // ------ MÉTODOS PARA CREAR COMPONENTES

    private JButton crearBotonMenu(String texto) {

        final JButton boton = new JButton(texto);

        boton.setFont(FONT_MENU);
        boton.setForeground(COLOR_TEXTO);

        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setOpaque(false);

        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        boton.setBorder(new EmptyBorder(8, 16, 8, 16));

        boton.addMouseListener(new MouseAdapter() {

            @Override
            // es para hacer el efecto del hover, cuando paso el mouse por arriba cambia el
            // color
            public void mouseEntered(MouseEvent e) {
                boton.setForeground(COLOR_ACENTO);
            }

            @Override
            // para que cuando salga de la seleccion ponga el borde normal
            public void mouseExited(MouseEvent e) {
                boton.setForeground(COLOR_TEXTO);
            }
        });

        return boton;
    }

    private JButton crearBotonAccion(String texto, boolean relleno) {

        final JButton boton = new JButton(texto);

        boton.setFont(FONT_BOTON);
        boton.setFocusPainted(false);
        boton.setOpaque(true);

        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        final Color colorNormal;
        final Color colorHover;

        if (relleno) {

            colorNormal = COLOR_ACENTO;
            colorHover = COLOR_ACENTO_HOVER;

            boton.setForeground(COLOR_FONDO);

            boton.setBorder(new EmptyBorder(10, 28, 10, 28));

        } else {

            colorNormal = COLOR_CONTENIDO;
            colorHover = COLOR_TARJETA_HOVER;

            boton.setForeground(COLOR_TEXTO);

            boton.setBorder(new CompoundBorder(new LineBorder(COLOR_ACENTO, 2, true), new EmptyBorder(8, 26, 8, 26)));
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

    private CompoundBorder bordeTarjeta(Color colorContorno) {

        return new CompoundBorder(new LineBorder(colorContorno, 3, true), new EmptyBorder(10, 10, 10, 10));
    }

    private JPanel crearTarjetaJuego(final String nombreJuego, String rutaImagen) {

        final JPanel tarjeta = new JPanel(new BorderLayout(0, 8));

        tarjeta.setPreferredSize(new Dimension(ANCHO_TARJETA, ALTO_TARJETA));

        tarjeta.setBackground(COLOR_TARJETA);

        tarjeta.setBorder(bordeTarjeta(COLOR_TARJETA));

        tarjeta.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // ---------- PORTADA

        JLabel lblPortada = new JLabel();

        lblPortada.setHorizontalAlignment(SwingConstants.CENTER);

        lblPortada.setVerticalAlignment(SwingConstants.CENTER);

        lblPortada.setPreferredSize(new Dimension(ANCHO_PORTADA, ALTO_PORTADA));

        URL urlImagen = getClass().getResource(rutaImagen);

        if (urlImagen != null) {

            ImageIcon iconoOriginal = new ImageIcon(urlImagen);

            Image imagenOriginal = iconoOriginal.getImage();

            int anchoOriginal = imagenOriginal.getWidth(null);

            int altoOriginal = imagenOriginal.getHeight(null);

            // Ajustamos la imagen para que entre dentro del espacio disponible sin
            // deformarla y sin recortar partes de la portada.
            // Tambien podriamos recortarla fisicamente manteniendo la relacion de aspecto.
            // 3:4?
            double escala = Math.min((double) ANCHO_PORTADA / anchoOriginal, (double) ALTO_PORTADA / altoOriginal);

            int anchoEscalado = (int) (anchoOriginal * escala);

            int altoEscalado = (int) (altoOriginal * escala);

            Image imagenEscalada = imagenOriginal.getScaledInstance(anchoEscalado, altoEscalado, Image.SCALE_SMOOTH);

            lblPortada.setIcon(new ImageIcon(imagenEscalada));

        } else {

            lblPortada.setText("Sin imagen");

            lblPortada.setForeground(COLOR_TEXTO_SECUNDARIO);

            System.out.println("No se encontró la imagen: " + rutaImagen);
        }

        // ---------- NOMBRE

        JLabel lblNombre = new JLabel(nombreJuego);

        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);

        lblNombre.setFont(FONT_TARJETA);
        lblNombre.setForeground(COLOR_TEXTO);

        tarjeta.add(lblPortada, BorderLayout.CENTER);

        tarjeta.add(lblNombre, BorderLayout.SOUTH);

        // ---------- EVENTOS

        MouseAdapter listener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                seleccionarTarjeta(tarjeta, nombreJuego);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                if (!nombreJuego.equals(juegoSeleccionado)) {

                    tarjeta.setBorder(bordeTarjeta(COLOR_TARJETA_HOVER));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

                if (!nombreJuego.equals(juegoSeleccionado)) {

                    tarjeta.setBorder(bordeTarjeta(COLOR_TARJETA));
                }
            }
        };

        tarjeta.addMouseListener(listener);
        lblPortada.addMouseListener(listener);
        lblNombre.addMouseListener(listener);

        return tarjeta;
    }

    private void seleccionarTarjeta(JPanel tarjetaElegida, String nombreJuego) {

        for (JPanel tarjeta : tarjetas) {

            if (tarjeta == tarjetaElegida) {

                tarjeta.setBorder(bordeTarjeta(COLOR_ACENTO));

            } else {

                tarjeta.setBorder(bordeTarjeta(COLOR_TARJETA));
            }
        }

        juegoSeleccionado = nombreJuego;
    }
}

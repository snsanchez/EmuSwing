package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Image;
import java.net.URL;

public class CatalogoLogrosView extends JFrame {

    private JPanel contentPane;

    // Colores definidos para EmuSwing
    private final Color COLOR_FONDO_MAIN = new Color(24, 10, 32); 
    private final Color COLOR_PANEL_BOX  = new Color(50, 22, 66);   
    private final Color COLOR_BORDE_NEON = new Color(169, 65, 196);   
    private final Color COLOR_LETRAS = new Color(245, 240, 247);     

    // Fuente usada para EmuSwing
    private Font fuentePublicPixel;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CatalogoLogrosView frame = new CatalogoLogrosView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CatalogoLogrosView() {
    	cargarFuentePersonalizada();
    	
    	setForeground(new Color(255, 255, 255));
        setTitle("Catálogo de Logros - EmuSwing");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(COLOR_FONDO_MAIN);
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        // ==========================================
        // 1. BARRA DE NAVEGACIÓN SUPERIOR (CLARA) 
        // ==========================================
        JPanel panelNavBar = new JPanel();
        panelNavBar.setBackground(COLOR_FONDO_MAIN);
        panelNavBar.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Botones del home
        String[] botonesHome = {"Mi Perfil", "Biblioteca", "Juegos", "Tienda", "Soporte", "Ajustes"};
        for (String textoBotones : botonesHome) {
            JButton btnHome = new JButton(textoBotones);
            btnHome.setFocusable(false);
            btnHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
           
            // ESTILO DE BOTONES IGUAL QUE EL FONDO 
            btnHome.setBackground(COLOR_FONDO_MAIN);
            btnHome.setForeground(COLOR_LETRAS);
            btnHome.setFont(new Font("Public Pixel", Font.PLAIN, 14));
            
            
            // Configuracion de bordes y estructura de los botones del home
            btnHome.setBorderPainted(false);
            btnHome.setContentAreaFilled(false);
            btnHome.setOpaque(true);
        
            panelNavBar.add(btnHome);
        }
        contentPane.add(panelNavBar, BorderLayout.NORTH);

        // ==========================================
        // 2. PANEL CENTRAL (GRIDBAG LAYOUT PARA CENTRAR)
        // ==========================================
        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(COLOR_FONDO_MAIN);
        panelCentro.setLayout(new GridBagLayout()); // Alinea la caja perfectamente al centro
        contentPane.add(panelCentro, BorderLayout.CENTER);

        // CAJA CENTRADA (MENÚ DE CATÁLOGOS)
        JPanel cajaMenu = new JPanel();
        cajaMenu.setBackground(COLOR_PANEL_BOX);
        cajaMenu.setBorder(new CompoundBorder(
        		new LineBorder(COLOR_BORDE_NEON, 3, true), 
        		new EmptyBorder(15, 20, 15, 20)
        ));
        cajaMenu.setLayout(new GridLayout(3, 1, 10, 15));


        // Título del Menú
        JLabel lblTitulo = new JLabel("Catálogos de Logros");
        lblTitulo.setFont(fuentePublicPixel.deriveFont(Font.BOLD, 15));
        lblTitulo.setForeground(COLOR_LETRAS);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        cajaMenu.add(lblTitulo);

        // Selector y Combo con el catalogo de logros
        String[] catalogosDisponibles = {
            "------ Seleccionar Catálogo -----",
            " Primeros Pasos y Perfil",
            " Tiempo de Juego",
            " Comunidad y Tienda",
            " Secretos y Desafíos"
        };
        
        JComboBox<String> comboCatalogos = new JComboBox<>(catalogosDisponibles);
        comboCatalogos.setFont(new Font("Public Pixel", Font.PLAIN, 16));
        comboCatalogos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cajaMenu.add(comboCatalogos);

        // Boton de ver Logros y Evento 
        JButton btnVerLogros = new JButton("Ver Logros");
        btnVerLogros.setFont(new Font("Public Pixel", Font.BOLD, 12));
        btnVerLogros.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnVerLogros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seleccion = comboCatalogos.getSelectedIndex();
                
                switch (seleccion) {
                    case 1:
                        CatalogoLogrosPerfilyPrimerosPasos ventanaPerfil = new CatalogoLogrosPerfilyPrimerosPasos();
                        ventanaPerfil.setVisible(true);
                        break;
                    case 2:
                        CatalogoLogrosTiempoJuego ventanaTiempo = new CatalogoLogrosTiempoJuego();
                        ventanaTiempo.setVisible(true);
                        break;
                    case 3:
                        CatalogoLogrosComunidadTienda ventanaComunidad = new CatalogoLogrosComunidadTienda();
                        ventanaComunidad.setVisible(true);
                        break;
                    case 4:
                        CatalogoLogrosSecretosDesafios ventanaSecretos = new CatalogoLogrosSecretosDesafios();
                        ventanaSecretos.setVisible(true);
                        break;
                    default:
                        // Si está en 0 ("Seleccionar Catálogo") no hace nada
                        break;
                }
                
                // vuelve a poner el combo en la primera opción tras abrir la ventana
                if(seleccion != 0) {
                    comboCatalogos.setSelectedIndex(0);
                }
            }
        });
      
       // ==========================================
       // CONFIGURACIÓN VISUAL DEL CENTRO (GRILLA)
       // ==========================================
        JPanel panelLogo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelLogo.setOpaque(false);
        
        // Regla para poder ubicar el logo correctamente
        GridBagConstraints gbc_panelLogo = new GridBagConstraints();
        gbc_panelLogo.insets = new Insets(0, 0, 5, 0);
        gbc_panelLogo.gridx = 1;
        gbc_panelLogo.gridy = 0;
        panelCentro.add(panelLogo, gbc_panelLogo);
        panelLogo.setOpaque(false);
        
        // 2. boton de accion
        // se agrega el boton a la caja contenedora del combo 
        cajaMenu.add(btnVerLogros);

      // Ubica la caja en la celda principal (0,0) del GridBagLayout
      GridBagConstraints gbc_cajaMenu = new GridBagConstraints();
      gbc_cajaMenu.gridx = 1;
      gbc_cajaMenu.gridy = 1;
      panelCentro.add(cajaMenu, gbc_cajaMenu);
      
      // ==========================================
      // 		3. LOGO EMUSWING 
      // ==========================================
		URL imgURL = getClass().getResource("/img/esw-logo.png");

		if (imgURL != null) {

			ImageIcon iconOriginal = new ImageIcon(imgURL);

			Image imagenEscalada = iconOriginal.getImage().getScaledInstance(200, 158, java.awt.Image.SCALE_SMOOTH);

			JLabel lbLogo = new JLabel(new ImageIcon(imagenEscalada));

			panelLogo.add(lbLogo);
}
    }
    
  // Forma para poder cargar una fuente externa a Windows/Linux
    private void cargarFuentePersonalizada() {
        try {
            // Busca el archivo en tu carpeta interna
            java.io.InputStream is = getClass().getResourceAsStream("/fonts/PublicPixel.ttf");
            
            if (is != null) {
                // Si lo encuentra, lo convierte en una fuente de Java
                Font baseFont = Font.createFont(Font.TRUETYPE_FONT, is);
                java.awt.GraphicsEnvironment ge = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(baseFont);
                
                // La guarda en tu variable global con tamaño 12 por defecto
                fuentePublicPixel = baseFont.deriveFont(Font.PLAIN, 12f);
            } else {
                // Si falla (por ej. si escribiste mal el nombre), usa Monospaced para que no se rompa el programa
                System.err.println("Aviso: No se encontró PublicPixel.ttf");
                fuentePublicPixel = new Font(Font.MONOSPACED, Font.PLAIN, 12);
            }
        } catch (Exception e) {
            e.printStackTrace();
            fuentePublicPixel = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        }
    }
}


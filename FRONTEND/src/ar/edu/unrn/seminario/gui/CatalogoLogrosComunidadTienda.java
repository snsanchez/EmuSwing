package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class CatalogoLogrosComunidadTienda extends JFrame {

	private JPanel contentPane;

	// Colores definidos EmuSwing
	 private final Color COLOR_FONDO_MAIN = new Color(24, 10, 32);   
	 private final Color COLOR_PANEL_BOX  = new Color(50, 22, 66);   
	 private final Color COLOR_BORDE_NEON = new Color(169, 65, 196);   
	 private final Color COLOR_LETRAS = new Color(245, 240, 247);     
	 private final Color COLOR_PUNTOS = new Color(255, 255, 0); 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogoLogrosComunidadTienda frame = new CatalogoLogrosComunidadTienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CatalogoLogrosComunidadTienda() {
		setTitle("Catálogo De Logros: Comunidad y Tienda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(COLOR_FONDO_MAIN);
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new BorderLayout(0, 15));
		setContentPane(contentPane);

		// 1. ENCABEZADO DE LA VENTANA
		JPanel panelHeader = new JPanel();
		panelHeader.setOpaque(false);
		panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));

		JLabel lblTitulo = new JLabel("CATÁLOGO DE LOGROS");
		lblTitulo.setFont(new Font("Public Pixel", Font.PLAIN, 40)); 
		lblTitulo.setForeground(COLOR_LETRAS);
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel lblSubtitulo = new JLabel("Comunidad y Tienda");
		lblSubtitulo.setFont(new Font("Public Pixel", Font.PLAIN, 20)); 
		lblSubtitulo.setForeground(COLOR_BORDE_NEON);
		lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		panelHeader.add(lblTitulo);
		panelHeader.add(Box.createVerticalStrut(10));
		panelHeader.add(lblSubtitulo);
		contentPane.add(panelHeader, BorderLayout.NORTH);

		// 2. CONTENEDOR PRINCIPAL CON SCROLL
		JPanel panelListaLogros = new JPanel();
		panelListaLogros.setBackground(COLOR_FONDO_MAIN);
		panelListaLogros.setLayout(new BoxLayout(panelListaLogros, BoxLayout.Y_AXIS));
		
		// Corre los logros 100 pixeles hacia abajo (queda mejor visualmente)
		panelListaLogros.add(Box.createVerticalStrut(100));

		// ==========================================
		// --- SECCIÓN 1: INTERACCIÓN ---
		// ==========================================
		
		JLabel lblTituloInteraccion = new JLabel("INTERACCIÓN SOCIAL");
		lblTituloInteraccion.setFont(new Font("Public Pixel", Font.PLAIN, 20));
		lblTituloInteraccion.setForeground(COLOR_BORDE_NEON);
		lblTituloInteraccion.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDE_NEON));
		lblTituloInteraccion.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTituloInteraccion.setMaximumSize(new Dimension(800, 30));
		panelListaLogros.add(lblTituloInteraccion);
		
		panelListaLogros.add(Box.createVerticalStrut(15));

		// --- TARJETA: NO ESTOY SOLO ---
		JPanel panelLogroSolo = new JPanel(new BorderLayout(5, 5));
		panelLogroSolo.setBackground(COLOR_PANEL_BOX);
		panelLogroSolo.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroSolo.setMaximumSize(new Dimension(800, 70));
		panelLogroSolo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupSolo = new JPanel(new BorderLayout());
		panelSupSolo.setOpaque(false);
		JLabel lblTitSolo = new JLabel("No estoy solo");
		lblTitSolo.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitSolo.setForeground(COLOR_LETRAS);
		panelSupSolo.add(lblTitSolo, BorderLayout.WEST);
		JLabel lblPtsSolo = new JLabel("15 PTS");
		lblPtsSolo.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsSolo.setForeground(COLOR_PUNTOS);
		panelSupSolo.add(lblPtsSolo, BorderLayout.EAST);
		JLabel lblDescSolo = new JLabel("Agregar tu primer amigo.");
		lblDescSolo.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescSolo.setForeground(new Color(200, 190, 210));
		
		panelLogroSolo.add(panelSupSolo, BorderLayout.NORTH);
		panelLogroSolo.add(lblDescSolo, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroSolo);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA: SOCIAL MEDIA ---
		JPanel panelLogroSocial = new JPanel(new BorderLayout(5, 5));
		panelLogroSocial.setBackground(COLOR_PANEL_BOX);
		panelLogroSocial.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroSocial.setMaximumSize(new Dimension(800, 70));
		panelLogroSocial.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupSocial = new JPanel(new BorderLayout());
		panelSupSocial.setOpaque(false);
		JLabel lblTitSocial = new JLabel("Social Media");
		lblTitSocial.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitSocial.setForeground(COLOR_LETRAS);
		panelSupSocial.add(lblTitSocial, BorderLayout.WEST);
		JLabel lblPtsSocial = new JLabel("35 PTS");
		lblPtsSocial.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsSocial.setForeground(COLOR_PUNTOS);
		panelSupSocial.add(lblPtsSocial, BorderLayout.EAST);
		JLabel lblDescSocial = new JLabel("Agregar 5 amigos.");
		lblDescSocial.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescSocial.setForeground(new Color(200, 190, 210));
		
		panelLogroSocial.add(panelSupSocial, BorderLayout.NORTH);
		panelLogroSocial.add(lblDescSocial, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroSocial);
		panelListaLogros.add(Box.createVerticalStrut(25));

		// ==========================================
		// --- SECCIÓN 2: ESPECIALES Y TIENDA ---
		// ==========================================
		
		JLabel lblTituloTienda = new JLabel("ESPECIALES Y TIENDA");
		lblTituloTienda.setFont(new Font("Public Pixel", Font.PLAIN, 20));
		lblTituloTienda.setForeground(COLOR_BORDE_NEON);
		lblTituloTienda.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDE_NEON));
		lblTituloTienda.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTituloTienda.setMaximumSize(new Dimension(800, 30));
		panelListaLogros.add(lblTituloTienda);
		
		panelListaLogros.add(Box.createVerticalStrut(15));

		// --- TARJETA: CLIENTE FRECUENTE ---
		JPanel panelLogroCliente = new JPanel(new BorderLayout(5, 5));
		panelLogroCliente.setBackground(COLOR_PANEL_BOX);
		panelLogroCliente.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroCliente.setMaximumSize(new Dimension(800, 70));
		panelLogroCliente.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupCliente = new JPanel(new BorderLayout());
		panelSupCliente.setOpaque(false);
		JLabel lblTitCliente = new JLabel("Cliente Frecuente");
		lblTitCliente.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitCliente.setForeground(COLOR_LETRAS);
		panelSupCliente.add(lblTitCliente, BorderLayout.WEST);
		JLabel lblPtsCliente = new JLabel("50 PTS");
		lblPtsCliente.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsCliente.setForeground(COLOR_PUNTOS);
		panelSupCliente.add(lblPtsCliente, BorderLayout.EAST);
		JLabel lblDescCliente = new JLabel("Renovar la Suscripción (Mes 2).");
		lblDescCliente.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescCliente.setForeground(new Color(200, 190, 210));
		
		panelLogroCliente.add(panelSupCliente, BorderLayout.NORTH);
		panelLogroCliente.add(lblDescCliente, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroCliente);

		// Configuración final del ScrollPane
		JScrollPane scrollPane = new JScrollPane(panelListaLogros);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);

		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
}
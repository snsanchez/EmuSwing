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

public class CatalogoLogrosPerfilyPrimerosPasos extends JFrame {

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
					CatalogoLogrosPerfilyPrimerosPasos frame = new CatalogoLogrosPerfilyPrimerosPasos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CatalogoLogrosPerfilyPrimerosPasos() {
		setTitle("Catálogo De Logros: Primeros Pasos y Perfil");
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
		lblTitulo.setFont(new Font("Public Pixel", Font.BOLD, 40)); // ACORDATE DE CAMBIAR LA FUENTE
		lblTitulo.setForeground(COLOR_LETRAS);
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel lblSubtitulo = new JLabel("Primeros Pasos & Perfil de Usuario");
		lblSubtitulo.setFont(new Font("Public Pixel", Font.ITALIC, 20)); // ACORDATE DE CAMBIAR LA FUENTE
		lblSubtitulo.setForeground(COLOR_BORDE_NEON);
		lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		panelHeader.add(lblTitulo);
		panelHeader.add(Box.createVerticalStrut(5));
		panelHeader.add(lblSubtitulo);
		contentPane.add(panelHeader, BorderLayout.NORTH);

		// 2. CONTENEDOR PRINCIPAL CON SCROLL
		JPanel panelListaLogros = new JPanel();
		panelListaLogros.setBackground(COLOR_FONDO_MAIN);
		panelListaLogros.setLayout(new BoxLayout(panelListaLogros, BoxLayout.Y_AXIS));
		
		// Corre los logros 100 pixeles hacia abajo (queda mejor visualmente)
		panelListaLogros.add(Box.createVerticalStrut(100));

		// ==========================================
		// --- SECCIÓN 1: LOGROS DE PERFIL ---
		// ==========================================
		
		JLabel lblTituloPerfil = new JLabel("LOGROS DE PERFIL");
		lblTituloPerfil.setFont(new Font("Public Pixel", Font.BOLD, 20));
		lblTituloPerfil.setForeground(COLOR_BORDE_NEON);
		lblTituloPerfil.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDE_NEON));
		lblTituloPerfil.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTituloPerfil.setMaximumSize(new Dimension(800, 30));
		panelListaLogros.add(lblTituloPerfil);
		
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA: TESORO ENCONTRADO ---
		JPanel panelLogroTesoroEncontrado = new JPanel(new BorderLayout(5, 5));
		panelLogroTesoroEncontrado.setBackground(COLOR_PANEL_BOX);
		panelLogroTesoroEncontrado.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroTesoroEncontrado.setMaximumSize(new Dimension(800, 70));
		panelLogroTesoroEncontrado.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupTesoroEncontrado = new JPanel(new BorderLayout());
		panelSupTesoroEncontrado.setOpaque(false);
		JLabel lblTitTesoroEncontrado = new JLabel("Tesoro encontrado");
		lblTitTesoroEncontrado.setFont(new Font("Public Pixel", Font.BOLD, 18));
		lblTitTesoroEncontrado.setForeground(COLOR_LETRAS);
		panelSupTesoroEncontrado.add(lblTitTesoroEncontrado, BorderLayout.WEST);
		JLabel lblPtsTesoroEncontrado = new JLabel("10 PTS");
		lblPtsTesoroEncontrado.setFont(new Font("Public Pixel", Font.BOLD, 12));
		lblPtsTesoroEncontrado.setForeground(COLOR_PUNTOS);
		panelSupTesoroEncontrado.add(lblPtsTesoroEncontrado, BorderLayout.EAST);
		JLabel lblDescTesoroEncontrado = new JLabel("Agregar un juego a la lista de favoritos por primera vez.");
		lblDescTesoroEncontrado.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescTesoroEncontrado.setForeground(new Color(200, 190, 210));
		
		panelLogroTesoroEncontrado.add(panelSupTesoroEncontrado, BorderLayout.NORTH);
		panelLogroTesoroEncontrado.add(lblDescTesoroEncontrado, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroTesoroEncontrado);
		
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA: PLAYER 1 READY ---
		JPanel panelLogroPlayer1Ready = new JPanel(new BorderLayout(5, 5));
		panelLogroPlayer1Ready.setBackground(COLOR_PANEL_BOX);
		panelLogroPlayer1Ready.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroPlayer1Ready.setMaximumSize(new Dimension(800, 70));
		panelLogroPlayer1Ready.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupPlayer1Ready = new JPanel(new BorderLayout());
		panelSupPlayer1Ready.setOpaque(false);
		JLabel lblTitPlayer1Ready = new JLabel("Player 1 Ready");
		lblTitPlayer1Ready.setFont(new Font("Public Pixel", Font.BOLD, 18));
		lblTitPlayer1Ready.setForeground(COLOR_LETRAS);
		panelSupPlayer1Ready.add(lblTitPlayer1Ready, BorderLayout.WEST);
		JLabel lblPtsPlayer1Ready = new JLabel("10 PTS");
		lblPtsPlayer1Ready.setFont(new Font("Public Pixel", Font.BOLD, 12));
		lblPtsPlayer1Ready.setForeground(COLOR_PUNTOS);
		panelSupPlayer1Ready.add(lblPtsPlayer1Ready, BorderLayout.EAST);
		JLabel lblDescPlayer1 = new JLabel("Colocar una foto de perfil por primera vez.");
		lblDescPlayer1.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescPlayer1.setForeground(new Color(200, 190, 210));
		
		panelLogroPlayer1Ready.add(panelSupPlayer1Ready, BorderLayout.NORTH);
		panelLogroPlayer1Ready.add(lblDescPlayer1, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroPlayer1Ready);
		
		panelListaLogros.add(Box.createVerticalStrut(25));

		// ==========================================
		// --- SECCIÓN 2: LOGROS INICIALES ---
		// ==========================================
		
		JLabel lblTituloIniciales = new JLabel("LOGROS INICIALES");
		lblTituloIniciales.setFont(new Font("Public Pixel", Font.BOLD, 20));
		lblTituloIniciales.setForeground(COLOR_BORDE_NEON);
		lblTituloIniciales.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDE_NEON));
		lblTituloIniciales.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTituloIniciales.setMaximumSize(new Dimension(800, 30));
		panelListaLogros.add(lblTituloIniciales);
		
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA: PRIMER BOTONAZO ---
		JPanel panelLogroPrimerBotonazo = new JPanel(new BorderLayout(5, 5));
		panelLogroPrimerBotonazo.setBackground(COLOR_PANEL_BOX);
		panelLogroPrimerBotonazo.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroPrimerBotonazo.setMaximumSize(new Dimension(800, 70));
		panelLogroPrimerBotonazo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupPrimerBotonazo = new JPanel(new BorderLayout());
		panelSupPrimerBotonazo.setOpaque(false);
		JLabel lblTitPrimerBotonazo = new JLabel("Primer Botonazo");
		lblTitPrimerBotonazo.setFont(new Font("Public Pixel", Font.BOLD, 18));
		lblTitPrimerBotonazo.setForeground(COLOR_LETRAS);
		panelSupPrimerBotonazo.add(lblTitPrimerBotonazo, BorderLayout.WEST);
		JLabel lblPtsPrimerBotonazo = new JLabel("10 PTS");
		lblPtsPrimerBotonazo.setFont(new Font("Public Pixel", Font.BOLD, 12));
		lblPtsPrimerBotonazo.setForeground(COLOR_PUNTOS);
		panelSupPrimerBotonazo.add(lblPtsPrimerBotonazo, BorderLayout.EAST);
		JLabel lblDescPrimerBotonazo = new JLabel("Iniciar cualquier juego por primera vez desde el emulador.");
		lblDescPrimerBotonazo.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescPrimerBotonazo.setForeground(new Color(200, 190, 210));
		
		panelLogroPrimerBotonazo.add(panelSupPrimerBotonazo, BorderLayout.NORTH);
		panelLogroPrimerBotonazo.add(lblDescPrimerBotonazo, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroPrimerBotonazo);
		
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA: TURISTA DIGITAL ---
		JPanel panelLogroTuristaDigital = new JPanel(new BorderLayout(5, 5));
		panelLogroTuristaDigital.setBackground(COLOR_PANEL_BOX);
		panelLogroTuristaDigital.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroTuristaDigital.setMaximumSize(new Dimension(800, 70));
		panelLogroTuristaDigital.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupTuristaDigital = new JPanel(new BorderLayout());
		panelSupTuristaDigital.setOpaque(false);
		JLabel lblTitTurista = new JLabel("Turista Digital");
		lblTitTurista.setFont(new Font("Public Pixel", Font.BOLD, 18));
		lblTitTurista.setForeground(COLOR_LETRAS);
		panelSupTuristaDigital.add(lblTitTurista, BorderLayout.WEST);
		JLabel lblPtsTuristaDigital = new JLabel("15 PTS");
		lblPtsTuristaDigital.setFont(new Font("Public Pixel", Font.BOLD, 12));
		lblPtsTuristaDigital.setForeground(COLOR_PUNTOS);
		panelSupTuristaDigital.add(lblPtsTuristaDigital, BorderLayout.EAST);
		JLabel lblDescTuristaDigital = new JLabel("Visitar todas las secciones principales de la aplicación.");
		lblDescTuristaDigital.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescTuristaDigital.setForeground(new Color(200, 190, 210));
		
		panelLogroTuristaDigital.add(panelSupTuristaDigital, BorderLayout.NORTH);
		panelLogroTuristaDigital.add(lblDescTuristaDigital, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroTuristaDigital);

		// Configuración final del ScrollPane
		JScrollPane scrollPane = new JScrollPane(panelListaLogros);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);

		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
}
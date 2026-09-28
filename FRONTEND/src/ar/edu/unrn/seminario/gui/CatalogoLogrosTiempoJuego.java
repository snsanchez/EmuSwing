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

public class CatalogoLogrosTiempoJuego extends JFrame {

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
					CatalogoLogrosTiempoJuego frame = new CatalogoLogrosTiempoJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CatalogoLogrosTiempoJuego() {
		setTitle("Catálogo De Logros: Tiempo en Juego");
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

		JLabel lblSubtitulo = new JLabel("Tiempo en Juego");
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
		
		// Corre los logros 80 pixeles hacia abajo (queda mejor visualmente)
		panelListaLogros.add(Box.createVerticalStrut(80));

		// ==========================================
		// --- SECCIÓN: TIEMPO JUGADO ---
		// ==========================================
		
		JLabel lblTituloSeccion = new JLabel("TIEMPO JUGADO");
		lblTituloSeccion.setFont(new Font("Public Pixel", Font.PLAIN, 20));
		lblTituloSeccion.setForeground(COLOR_BORDE_NEON);
		lblTituloSeccion.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDE_NEON));
		lblTituloSeccion.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTituloSeccion.setMaximumSize(new Dimension(800, 30));
		panelListaLogros.add(lblTituloSeccion);
		
		panelListaLogros.add(Box.createVerticalStrut(15));

		// --- TARJETA 1: MONEDA INSERTADA ---
		JPanel panelLogroMoneda = new JPanel(new BorderLayout(5, 5));
		panelLogroMoneda.setBackground(COLOR_PANEL_BOX);
		panelLogroMoneda.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroMoneda.setMaximumSize(new Dimension(800, 70));
		panelLogroMoneda.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupMoneda = new JPanel(new BorderLayout());
		panelSupMoneda.setOpaque(false);
		JLabel lblTitMoneda = new JLabel("Moneda insertada");
		lblTitMoneda.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitMoneda.setForeground(COLOR_LETRAS);
		panelSupMoneda.add(lblTitMoneda, BorderLayout.WEST);
		JLabel lblPtsMoneda = new JLabel("5 PTS");
		lblPtsMoneda.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsMoneda.setForeground(COLOR_PUNTOS);
		panelSupMoneda.add(lblPtsMoneda, BorderLayout.EAST);
		JLabel lblDescMoneda = new JLabel("Acumular 15 minutos totales jugados.");
		lblDescMoneda.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescMoneda.setForeground(new Color(200, 190, 210));
		
		panelLogroMoneda.add(panelSupMoneda, BorderLayout.NORTH);
		panelLogroMoneda.add(lblDescMoneda, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroMoneda);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA 2: HORA DE CALENTAMIENTO ---
		JPanel panelLogroHora = new JPanel(new BorderLayout(5, 5));
		panelLogroHora.setBackground(COLOR_PANEL_BOX);
		panelLogroHora.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroHora.setMaximumSize(new Dimension(800, 70));
		panelLogroHora.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupHora = new JPanel(new BorderLayout());
		panelSupHora.setOpaque(false);
		JLabel lblTitHora = new JLabel("Hora de calentamiento");
		lblTitHora.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitHora.setForeground(COLOR_LETRAS);
		panelSupHora.add(lblTitHora, BorderLayout.WEST);
		JLabel lblPtsHora = new JLabel("10 PTS");
		lblPtsHora.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsHora.setForeground(COLOR_PUNTOS);
		panelSupHora.add(lblPtsHora, BorderLayout.EAST);
		JLabel lblDescHora = new JLabel("Acumular 1 hora total de juego.");
		lblDescHora.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescHora.setForeground(new Color(200, 190, 210));
		
		panelLogroHora.add(panelSupHora, BorderLayout.NORTH);
		panelLogroHora.add(lblDescHora, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroHora);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA 3: GAMER HABITUAL ---
		JPanel panelLogroGamer = new JPanel(new BorderLayout(5, 5));
		panelLogroGamer.setBackground(COLOR_PANEL_BOX);
		panelLogroGamer.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroGamer.setMaximumSize(new Dimension(800, 70));
		panelLogroGamer.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupGamer = new JPanel(new BorderLayout());
		panelSupGamer.setOpaque(false);
		JLabel lblTitGamer = new JLabel("Gamer habitual");
		lblTitGamer.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitGamer.setForeground(COLOR_LETRAS);
		panelSupGamer.add(lblTitGamer, BorderLayout.WEST);
		JLabel lblPtsGamer = new JLabel("50 PTS");
		lblPtsGamer.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsGamer.setForeground(COLOR_PUNTOS);
		panelSupGamer.add(lblPtsGamer, BorderLayout.EAST);
		JLabel lblDescGamer = new JLabel("Acumular 5 horas totales de juego.");
		lblDescGamer.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescGamer.setForeground(new Color(200, 190, 210));
		
		panelLogroGamer.add(panelSupGamer, BorderLayout.NORTH);
		panelLogroGamer.add(lblDescGamer, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroGamer);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA 4: MARATÓN RETRO ---
		JPanel panelLogroMaraton = new JPanel(new BorderLayout(5, 5));
		panelLogroMaraton.setBackground(COLOR_PANEL_BOX);
		panelLogroMaraton.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroMaraton.setMaximumSize(new Dimension(800, 70));
		panelLogroMaraton.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupMaraton = new JPanel(new BorderLayout());
		panelSupMaraton.setOpaque(false);
		JLabel lblTitMaraton = new JLabel("Maratón Retro");
		lblTitMaraton.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitMaraton.setForeground(COLOR_LETRAS);
		panelSupMaraton.add(lblTitMaraton, BorderLayout.WEST);
		JLabel lblPtsMaraton = new JLabel("100 PTS");
		lblPtsMaraton.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsMaraton.setForeground(COLOR_PUNTOS);
		panelSupMaraton.add(lblPtsMaraton, BorderLayout.EAST);
		JLabel lblDescMaraton = new JLabel("Acumular 10 horas totales de juego.");
		lblDescMaraton.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescMaraton.setForeground(new Color(200, 190, 210));
		
		panelLogroMaraton.add(panelSupMaraton, BorderLayout.NORTH);
		panelLogroMaraton.add(lblDescMaraton, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroMaraton);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA 5: VETERANO ARCADE ---
		JPanel panelLogroVeterano = new JPanel(new BorderLayout(5, 5));
		panelLogroVeterano.setBackground(COLOR_PANEL_BOX);
		panelLogroVeterano.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroVeterano.setMaximumSize(new Dimension(800, 70));
		panelLogroVeterano.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupVeterano = new JPanel(new BorderLayout());
		panelSupVeterano.setOpaque(false);
		JLabel lblTitVeterano = new JLabel("Veterano Arcade");
		lblTitVeterano.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitVeterano.setForeground(COLOR_LETRAS);
		panelSupVeterano.add(lblTitVeterano, BorderLayout.WEST);
		JLabel lblPtsVeterano = new JLabel("200 PTS");
		lblPtsVeterano.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsVeterano.setForeground(COLOR_PUNTOS);
		panelSupVeterano.add(lblPtsVeterano, BorderLayout.EAST);
		JLabel lblDescVeterano = new JLabel("Acumular 25 horas totales de juego.");
		lblDescVeterano.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescVeterano.setForeground(new Color(200, 190, 210));
		
		panelLogroVeterano.add(panelSupVeterano, BorderLayout.NORTH);
		panelLogroVeterano.add(lblDescVeterano, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroVeterano);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA 6: LEYENDA DEL EMULADOR ---
		JPanel panelLogroLeyenda = new JPanel(new BorderLayout(5, 5));
		panelLogroLeyenda.setBackground(COLOR_PANEL_BOX);
		panelLogroLeyenda.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroLeyenda.setMaximumSize(new Dimension(800, 70));
		panelLogroLeyenda.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupLeyenda = new JPanel(new BorderLayout());
		panelSupLeyenda.setOpaque(false);
		JLabel lblTitLeyenda = new JLabel("Leyenda del Emulador");
		lblTitLeyenda.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitLeyenda.setForeground(COLOR_LETRAS);
		panelSupLeyenda.add(lblTitLeyenda, BorderLayout.WEST);
		JLabel lblPtsLeyenda = new JLabel("500 PTS");
		lblPtsLeyenda.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsLeyenda.setForeground(COLOR_PUNTOS);
		panelSupLeyenda.add(lblPtsLeyenda, BorderLayout.EAST);
		JLabel lblDescLeyenda = new JLabel("Acumular 50 horas totales de juego.");
		lblDescLeyenda.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescLeyenda.setForeground(new Color(200, 190, 210));
		
		panelLogroLeyenda.add(panelSupLeyenda, BorderLayout.NORTH);
		panelLogroLeyenda.add(lblDescLeyenda, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroLeyenda);

		// Configuración final del ScrollPane por las dudas
		JScrollPane scrollPane = new JScrollPane(panelListaLogros);
		scrollPane.setBorder(null);										// Elimina el borde y fondo gris con lineas que java le pone default
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);

		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
}
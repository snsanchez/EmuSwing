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

public class CatalogoLogrosSecretosDesafios extends JFrame {

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
					CatalogoLogrosSecretosDesafios frame = new CatalogoLogrosSecretosDesafios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CatalogoLogrosSecretosDesafios() {
		setTitle("Catálogo De Logros: Secretos y Desafíos");
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

		JLabel lblSubtitulo = new JLabel("Secretos y Desafíos");
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
		// --- SECCIÓN 1: DESAFÍOS DE PROGRESO ---
		// ==========================================
		
		JLabel lblTituloDesafios = new JLabel("DESAFIOS DE PROGRESO");
		lblTituloDesafios.setFont(new Font("Public Pixel", Font.PLAIN, 20));
		lblTituloDesafios.setForeground(COLOR_BORDE_NEON);
		lblTituloDesafios.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDE_NEON));
		lblTituloDesafios.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTituloDesafios.setMaximumSize(new Dimension(800, 30));
		panelListaLogros.add(lblTituloDesafios);
		
		panelListaLogros.add(Box.createVerticalStrut(15));

		// --- TARJETA: TOMANDO RITMO ---
		JPanel panelLogroRitmo = new JPanel(new BorderLayout(5, 5));
		panelLogroRitmo.setBackground(COLOR_PANEL_BOX);
		panelLogroRitmo.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroRitmo.setMaximumSize(new Dimension(800, 70));
		panelLogroRitmo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupRitmo = new JPanel(new BorderLayout());
		panelSupRitmo.setOpaque(false);
		JLabel lblTitRitmo = new JLabel("Tomando Ritmo");
		lblTitRitmo.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitRitmo.setForeground(COLOR_LETRAS);
		panelSupRitmo.add(lblTitRitmo, BorderLayout.WEST);
		JLabel lblPtsRitmo = new JLabel("25 PTS");
		lblPtsRitmo.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsRitmo.setForeground(COLOR_PUNTOS);
		panelSupRitmo.add(lblPtsRitmo, BorderLayout.EAST);
		JLabel lblDescRitmo = new JLabel("Ingresar 3 días seguidos al emulador.");
		lblDescRitmo.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescRitmo.setForeground(new Color(200, 190, 210));
		
		panelLogroRitmo.add(panelSupRitmo, BorderLayout.NORTH);
		panelLogroRitmo.add(lblDescRitmo, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroRitmo);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA: SEMANA PERFECTA ---
		JPanel panelLogroSemana = new JPanel(new BorderLayout(5, 5));
		panelLogroSemana.setBackground(COLOR_PANEL_BOX);
		panelLogroSemana.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroSemana.setMaximumSize(new Dimension(800, 70));
		panelLogroSemana.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupSemana = new JPanel(new BorderLayout());
		panelSupSemana.setOpaque(false);
		JLabel lblTitSemana = new JLabel("Semana Perfecta");
		lblTitSemana.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitSemana.setForeground(COLOR_LETRAS);
		panelSupSemana.add(lblTitSemana, BorderLayout.WEST);
		JLabel lblPtsSemana = new JLabel("50 PTS");
		lblPtsSemana.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsSemana.setForeground(COLOR_PUNTOS);
		panelSupSemana.add(lblPtsSemana, BorderLayout.EAST);
		JLabel lblDescSemana = new JLabel("Ingresar 7 días seguidos al emulador.");
		lblDescSemana.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescSemana.setForeground(new Color(200, 190, 210));
		
		panelLogroSemana.add(panelSupSemana, BorderLayout.NORTH);
		panelLogroSemana.add(lblDescSemana, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroSemana);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA: LEYENDA LOCAL ---
		JPanel panelLogroLeyendaLocal = new JPanel(new BorderLayout(5, 5));
		panelLogroLeyendaLocal.setBackground(COLOR_PANEL_BOX);
		panelLogroLeyendaLocal.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroLeyendaLocal.setMaximumSize(new Dimension(800, 70));
		panelLogroLeyendaLocal.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupLeyendaLocal = new JPanel(new BorderLayout());
		panelSupLeyendaLocal.setOpaque(false);
		JLabel lblTitLeyendaLocal = new JLabel("Leyenda Local");
		lblTitLeyendaLocal.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitLeyendaLocal.setForeground(COLOR_LETRAS);
		panelSupLeyendaLocal.add(lblTitLeyendaLocal, BorderLayout.WEST);
		JLabel lblPtsLeyendaLocal = new JLabel("100 PTS");
		lblPtsLeyendaLocal.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsLeyendaLocal.setForeground(COLOR_PUNTOS);
		panelSupLeyendaLocal.add(lblPtsLeyendaLocal, BorderLayout.EAST);
		JLabel lblDescLeyendaLocal = new JLabel("Usar el emulador durante 30 días.");
		lblDescLeyendaLocal.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescLeyendaLocal.setForeground(new Color(200, 190, 210));
		
		panelLogroLeyendaLocal.add(panelSupLeyendaLocal, BorderLayout.NORTH);
		panelLogroLeyendaLocal.add(lblDescLeyendaLocal, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroLeyendaLocal);
		panelListaLogros.add(Box.createVerticalStrut(25));

		// ==========================================
		// --- SECCIÓN 2: SECRETOS Y EASTER EGGS ---
		// ==========================================
		
		JLabel lblTituloSecretos = new JLabel("EASTER EGGS");
		lblTituloSecretos.setFont(new Font("Public Pixel", Font.PLAIN, 20));
		lblTituloSecretos.setForeground(COLOR_BORDE_NEON);
		lblTituloSecretos.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDE_NEON));
		lblTituloSecretos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTituloSecretos.setMaximumSize(new Dimension(800, 30));
		panelListaLogros.add(lblTituloSecretos);
		
		panelListaLogros.add(Box.createVerticalStrut(15));

		// --- TARJETA: EL GALLO EMULADOR ---
		JPanel panelLogroGallo = new JPanel(new BorderLayout(5, 5));
		panelLogroGallo.setBackground(COLOR_PANEL_BOX);
		panelLogroGallo.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroGallo.setMaximumSize(new Dimension(800, 70));
		panelLogroGallo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupGallo = new JPanel(new BorderLayout());
		panelSupGallo.setOpaque(false);
		JLabel lblTitGallo = new JLabel("El Gallo Emulador");
		lblTitGallo.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitGallo.setForeground(COLOR_LETRAS);
		panelSupGallo.add(lblTitGallo, BorderLayout.WEST);
		JLabel lblPtsGallo = new JLabel("20 PTS");
		lblPtsGallo.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsGallo.setForeground(COLOR_PUNTOS);
		panelSupGallo.add(lblPtsGallo, BorderLayout.EAST);
		JLabel lblDescGallo = new JLabel("???");
		lblDescGallo.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescGallo.setForeground(new Color(150, 150, 150));
		
		panelLogroGallo.add(panelSupGallo, BorderLayout.NORTH);
		panelLogroGallo.add(lblDescGallo, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroGallo);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA: TURNO NOCTURNO ---
		JPanel panelLogroNocturno = new JPanel(new BorderLayout(5, 5));
		panelLogroNocturno.setBackground(COLOR_PANEL_BOX);
		panelLogroNocturno.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroNocturno.setMaximumSize(new Dimension(800, 70));
		panelLogroNocturno.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupNocturno = new JPanel(new BorderLayout());
		panelSupNocturno.setOpaque(false);
		JLabel lblTitNocturno = new JLabel("Turno Nocturno");
		lblTitNocturno.setFont(new Font("Public Pixel", Font.PLAIN, 18));
		lblTitNocturno.setForeground(COLOR_LETRAS);
		panelSupNocturno.add(lblTitNocturno, BorderLayout.WEST);
		JLabel lblPtsNocturno = new JLabel("20 PTS");
		lblPtsNocturno.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsNocturno.setForeground(COLOR_PUNTOS);
		panelSupNocturno.add(lblPtsNocturno, BorderLayout.EAST);
		JLabel lblDescNocturno = new JLabel("???");
		lblDescNocturno.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescNocturno.setForeground(new Color(150, 150, 150));
		
		panelLogroNocturno.add(panelSupNocturno, BorderLayout.NORTH);
		panelLogroNocturno.add(lblDescNocturno, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroNocturno);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA: TIEMPO BIEN INVERTIDO ---
		JPanel panelLogroTiempo = new JPanel(new BorderLayout(5, 5));
		panelLogroTiempo.setBackground(COLOR_PANEL_BOX);
		panelLogroTiempo.setBorder(new CompoundBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroTiempo.setMaximumSize(new Dimension(800, 70));
		panelLogroTiempo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupTiempo = new JPanel(new BorderLayout());
		panelSupTiempo.setOpaque(false);
		JLabel lblTitTiempo = new JLabel("Tiempo Bien Invertido");
		lblTitTiempo.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblTitTiempo.setForeground(COLOR_LETRAS);
		panelSupTiempo.add(lblTitTiempo, BorderLayout.WEST);
		JLabel lblPtsTiempo = new JLabel("30 PTS");
		lblPtsTiempo.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblPtsTiempo.setForeground(COLOR_PUNTOS);
		panelSupTiempo.add(lblPtsTiempo, BorderLayout.EAST);
		JLabel lblDescTiempo = new JLabel("???");
		lblDescTiempo.setFont(new Font("Public Pixel", Font.PLAIN, 12));
		lblDescTiempo.setForeground(new Color(150, 150, 150));
		
		panelLogroTiempo.add(panelSupTiempo, BorderLayout.NORTH);
		panelLogroTiempo.add(lblDescTiempo, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroTiempo);

		// Configuración final del ScrollPane
		JScrollPane scrollPane = new JScrollPane(panelListaLogros);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(18);

		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
}
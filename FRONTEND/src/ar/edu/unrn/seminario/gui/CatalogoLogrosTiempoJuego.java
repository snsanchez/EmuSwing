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

import ar.edu.unrn.seminario.helpers.UIHelper;

public class CatalogoLogrosTiempoJuego extends JFrame {

	private JPanel contentPane;

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
		contentPane.setBackground(UIHelper.COLOR_FONDO);
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new BorderLayout(0, 15));
		setContentPane(contentPane);

		// 1. ENCABEZADO DE LA VENTANA 
		JPanel panelHeader = new JPanel();
		panelHeader.setOpaque(false);
		panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));

		JLabel lblTitulo = new JLabel("CATÁLOGO DE LOGROS");
		lblTitulo.setFont(UIHelper.FONT_TITULO.deriveFont(40f)); 
		lblTitulo.setForeground(UIHelper.COLOR_TEXTO);
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel lblSubtitulo = new JLabel("Tiempo en Juego");
		lblSubtitulo.setFont(UIHelper.FONT_TITULO);
		lblSubtitulo.setForeground(UIHelper.COLOR_BORDE);
		lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		panelHeader.add(lblTitulo);
		panelHeader.add(Box.createVerticalStrut(10));
		panelHeader.add(lblSubtitulo);
		contentPane.add(panelHeader, BorderLayout.NORTH);

		// 2. CONTENEDOR PRINCIPAL CON SCROLL
		JPanel panelListaLogros = new JPanel();
		panelListaLogros.setBackground(UIHelper.COLOR_FONDO);
		panelListaLogros.setLayout(new BoxLayout(panelListaLogros, BoxLayout.Y_AXIS));
		
		// Corre los logros 80 pixeles hacia abajo (queda mejor visualmente)
		panelListaLogros.add(Box.createVerticalStrut(80));

		// ==========================================
		// --- SECCIÓN: TIEMPO JUGADO ---
		// ==========================================
		
		JLabel lblTituloSeccion = new JLabel("TIEMPO JUGADO");
		lblTituloSeccion.setFont(UIHelper.FONT_TITULO);
		lblTituloSeccion.setForeground(UIHelper.COLOR_BORDE);
		lblTituloSeccion.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIHelper.COLOR_BORDE));
		lblTituloSeccion.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTituloSeccion.setMaximumSize(new Dimension(800, 30));
		panelListaLogros.add(lblTituloSeccion);
		
		panelListaLogros.add(Box.createVerticalStrut(15));

		// --- TARJETA 1: MONEDA INSERTADA ---
		JPanel panelLogroMoneda = new JPanel(new BorderLayout(5, 5));
		panelLogroMoneda.setBackground(UIHelper.COLOR_CONTENIDO);
		panelLogroMoneda.setBorder(new CompoundBorder(BorderFactory.createLineBorder (UIHelper.COLOR_BORDE, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroMoneda.setMaximumSize(new Dimension(800, 70));
		panelLogroMoneda.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupMoneda = new JPanel(new BorderLayout());
		panelSupMoneda.setOpaque(false);
		JLabel lblTitMoneda = new JLabel("Moneda insertada");
		lblTitMoneda.setFont(UIHelper.FONT_MENU.deriveFont(18f)); 
		lblTitMoneda.setForeground(UIHelper.COLOR_TEXTO);
		panelSupMoneda.add(lblTitMoneda, BorderLayout.WEST);
		JLabel lblPtsMoneda = new JLabel("5 PTS");
		lblPtsMoneda.setFont(UIHelper.FONT_TEXTFIELDS);
		lblPtsMoneda.setForeground(UIHelper.COLOR_PUNTOS);
		panelSupMoneda.add(lblPtsMoneda, BorderLayout.EAST);
		JLabel lblDescMoneda = new JLabel("Acumular 15 minutos totales jugados.");
		lblDescMoneda.setFont(UIHelper.FONT_TEXTFIELDS);
		lblDescMoneda.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		
		panelLogroMoneda.add(panelSupMoneda, BorderLayout.NORTH);
		panelLogroMoneda.add(lblDescMoneda, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroMoneda);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA 2: HORA DE CALENTAMIENTO ---
		JPanel panelLogroHora = new JPanel(new BorderLayout(5, 5));
		panelLogroHora.setBackground(UIHelper.COLOR_CONTENIDO);
		panelLogroHora.setBorder(new CompoundBorder(BorderFactory.createLineBorder(UIHelper.COLOR_BORDE, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroHora.setMaximumSize(new Dimension(800, 70));
		panelLogroHora.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupHora = new JPanel(new BorderLayout());
		panelSupHora.setOpaque(false);
		JLabel lblTitHora = new JLabel("Hora de calentamiento");
		lblTitHora.setFont(UIHelper.FONT_MENU.deriveFont(18f)); 
		lblTitHora.setForeground(UIHelper.COLOR_TEXTO);
		panelSupHora.add(lblTitHora, BorderLayout.WEST);
		JLabel lblPtsHora = new JLabel("10 PTS");
		lblPtsHora.setFont(UIHelper.FONT_TEXTFIELDS);
		lblPtsHora.setForeground(UIHelper.COLOR_PUNTOS);
		panelSupHora.add(lblPtsHora, BorderLayout.EAST);
		JLabel lblDescHora = new JLabel("Acumular 1 hora total de juego.");
		lblDescHora.setFont(UIHelper.FONT_TEXTFIELDS);
		lblDescHora.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		
		panelLogroHora.add(panelSupHora, BorderLayout.NORTH);
		panelLogroHora.add(lblDescHora, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroHora);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA 3: GAMER HABITUAL ---
		JPanel panelLogroGamer = new JPanel(new BorderLayout(5, 5));
		panelLogroGamer.setBackground(UIHelper.COLOR_CONTENIDO);
		panelLogroGamer.setBorder(new CompoundBorder(BorderFactory.createLineBorder(UIHelper.COLOR_BORDE, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroGamer.setMaximumSize(new Dimension(800, 70));
		panelLogroGamer.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupGamer = new JPanel(new BorderLayout());
		panelSupGamer.setOpaque(false);
		JLabel lblTitGamer = new JLabel("Gamer habitual");
		lblTitGamer.setFont(UIHelper.FONT_MENU.deriveFont(18f)); 
		lblTitGamer.setForeground(UIHelper.COLOR_TEXTO);
		panelSupGamer.add(lblTitGamer, BorderLayout.WEST);
		JLabel lblPtsGamer = new JLabel("50 PTS");
		lblPtsGamer.setFont(UIHelper.FONT_TEXTFIELDS);
		lblPtsGamer.setForeground(UIHelper.COLOR_PUNTOS);
		panelSupGamer.add(lblPtsGamer, BorderLayout.EAST);
		JLabel lblDescGamer = new JLabel("Acumular 5 horas totales de juego.");
		lblDescGamer.setFont(UIHelper.FONT_TEXTFIELDS);
		lblDescGamer.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		
		panelLogroGamer.add(panelSupGamer, BorderLayout.NORTH);
		panelLogroGamer.add(lblDescGamer, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroGamer);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA 4: MARATÓN RETRO ---
		JPanel panelLogroMaraton = new JPanel(new BorderLayout(5, 5));
		panelLogroMaraton.setBackground(UIHelper.COLOR_CONTENIDO);
		panelLogroMaraton.setBorder(new CompoundBorder(BorderFactory.createLineBorder(UIHelper.COLOR_BORDE, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroMaraton.setMaximumSize(new Dimension(800, 70));
		panelLogroMaraton.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupMaraton = new JPanel(new BorderLayout());
		panelSupMaraton.setOpaque(false);
		JLabel lblTitMaraton = new JLabel("Maratón Retro");
		lblTitMaraton.setFont(UIHelper.FONT_MENU.deriveFont(18f)); 
		lblTitMaraton.setForeground(UIHelper.COLOR_TEXTO);
		panelSupMaraton.add(lblTitMaraton, BorderLayout.WEST);
		JLabel lblPtsMaraton = new JLabel("100 PTS");
		lblPtsMaraton.setFont(UIHelper.FONT_TEXTFIELDS);
		lblPtsMaraton.setForeground(UIHelper.COLOR_PUNTOS);
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
		panelLogroVeterano.setBackground(UIHelper.COLOR_CONTENIDO);
		panelLogroVeterano.setBorder(new CompoundBorder(BorderFactory.createLineBorder(UIHelper.COLOR_BORDE, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroVeterano.setMaximumSize(new Dimension(800, 70));
		panelLogroVeterano.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupVeterano = new JPanel(new BorderLayout());
		panelSupVeterano.setOpaque(false);
		JLabel lblTitVeterano = new JLabel("Veterano Arcade");
		lblTitVeterano.setFont(UIHelper.FONT_MENU.deriveFont(18f)); 
		lblTitVeterano.setForeground(UIHelper.COLOR_TEXTO);
		panelSupVeterano.add(lblTitVeterano, BorderLayout.WEST);
		JLabel lblPtsVeterano = new JLabel("200 PTS");
		lblPtsVeterano.setFont(UIHelper.FONT_TEXTFIELDS);
		lblPtsVeterano.setForeground(UIHelper.COLOR_PUNTOS);
		panelSupVeterano.add(lblPtsVeterano, BorderLayout.EAST);
		JLabel lblDescVeterano = new JLabel("Acumular 25 horas totales de juego.");
		lblDescVeterano.setFont(UIHelper.FONT_TEXTFIELDS);
		lblDescVeterano.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		
		panelLogroVeterano.add(panelSupVeterano, BorderLayout.NORTH);
		panelLogroVeterano.add(lblDescVeterano, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroVeterano);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA 6: LEYENDA DEL EMULADOR ---
		JPanel panelLogroLeyenda = new JPanel(new BorderLayout(5, 5));
		panelLogroLeyenda.setBackground(UIHelper.COLOR_CONTENIDO);
		panelLogroLeyenda.setBorder(new CompoundBorder(BorderFactory.createLineBorder(UIHelper.COLOR_BORDE, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroLeyenda.setMaximumSize(new Dimension(800, 70));
		panelLogroLeyenda.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupLeyenda = new JPanel(new BorderLayout());
		panelSupLeyenda.setOpaque(false);
		JLabel lblTitLeyenda = new JLabel("Leyenda del Emulador");
		lblTitLeyenda.setFont(UIHelper.FONT_MENU.deriveFont(18f)); 
		lblTitLeyenda.setForeground(UIHelper.COLOR_TEXTO);
		panelSupLeyenda.add(lblTitLeyenda, BorderLayout.WEST);
		JLabel lblPtsLeyenda = new JLabel("500 PTS");
		lblPtsLeyenda.setFont(UIHelper.FONT_TEXTFIELDS);
		lblPtsLeyenda.setForeground(UIHelper.COLOR_PUNTOS);
		panelSupLeyenda.add(lblPtsLeyenda, BorderLayout.EAST);
		JLabel lblDescLeyenda = new JLabel("Acumular 50 horas totales de juego.");
		lblDescLeyenda.setFont(UIHelper.FONT_TEXTFIELDS);
		lblDescLeyenda.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		
		panelLogroLeyenda.add(panelSupLeyenda, BorderLayout.NORTH);
		panelLogroLeyenda.add(lblDescLeyenda, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroLeyenda);

		// Configuración final del ScrollPane 
		JScrollPane scrollPane = new JScrollPane(panelListaLogros);
		scrollPane.setBorder(null);										// Elimina el borde y fondo gris con lineas que java le pone default
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);

		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
}
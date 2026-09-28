package ar.edu.unrn.seminario.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Biblioteca {

	private JFrame frame;
	private JTable table;

	// Paleta de colores EmuSwing
	private static final Color COLOR_FONDO = new Color(20, 10, 28);
	private static final Color COLOR_TARJETA = new Color(36, 18, 48);
	private static final Color COLOR_BORDE = new Color(140, 50, 160);
	private static final Color COLOR_BOTON_PRIMARIO = new Color(180, 70, 210);
	private static final Color COLOR_BOTON_SECUNDARIO = new Color(55, 30, 75);
	private static final Color COLOR_TEXTO = new Color(245, 240, 247);
	private static final Color COLOR_TEXTO_MUTED = new Color(170, 150, 185);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biblioteca window = new Biblioteca();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Biblioteca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("EmuSwing - Biblioteca");
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(COLOR_FONDO);

		// Barra Superior de Navegación estilo Home
		// JMenuBar centrado estilo Home
				JMenuBar menuBar = new JMenuBar();
				menuBar.setBackground(COLOR_FONDO);
				//menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_PANEL));
				menuBar.setBorder(BorderFactory.createEmptyBorder());
				// Espaciador para centrar las opciones
				menuBar.add(javax.swing.Box.createHorizontalGlue());

				JMenu mnPerfil = new JMenu("Mi Perfil");
				mnPerfil.setForeground(COLOR_TEXTO);
				mnPerfil.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnPerfil);

				JMenu mnBiblioteca = new JMenu("Biblioteca");
				mnBiblioteca.setForeground(COLOR_TEXTO);
				mnBiblioteca.setFont(new Font("SansSerif", Font.BOLD, 13));
				menuBar.add(mnBiblioteca);

				JMenu mnJuegos = new JMenu("Juegos");
				mnJuegos.setForeground(COLOR_TEXTO);
				mnJuegos.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnJuegos);

				JMenu mnTienda = new JMenu("Tienda");
				mnTienda.setForeground(COLOR_TEXTO);
				mnTienda.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnTienda);

				JMenu mnSoporte = new JMenu("Soporte");
				mnSoporte.setForeground(COLOR_TEXTO);
				mnSoporte.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnSoporte);

				JMenu mnAjustes = new JMenu("Ajustes");
				mnAjustes.setForeground(COLOR_TEXTO);
				mnAjustes.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnAjustes);

				// Espaciador derecho para empujar todo al centro
				menuBar.add(javax.swing.Box.createHorizontalGlue());

				frame.setJMenuBar(menuBar);

		// Contenedor principal estilo tarjeta EmuSwing
		JPanel panel = new JPanel();
		panel.setBounds(190, 40, 900, 560);
		panel.setBackground(COLOR_TARJETA);
		panel.setBorder(new LineBorder(COLOR_BORDE, 2, true));
		panel.setLayout(null);
		frame.getContentPane().add(panel);

		JLabel lblBiblioteca = new JLabel("Mi Biblioteca");
		lblBiblioteca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiblioteca.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblBiblioteca.setForeground(COLOR_TEXTO);
		lblBiblioteca.setBounds(50, 25, 800, 35);
		panel.add(lblBiblioteca);

		JLabel lblSubtitulo = new JLabel("Listado general de juegos guardados.");
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblSubtitulo.setForeground(COLOR_TEXTO_MUTED);
		lblSubtitulo.setBounds(50, 62, 800, 20);
		panel.add(lblSubtitulo);

		// Configuración de Tabla
		DefaultTableModel modelo = new DefaultTableModel(
			new Object[][]{
				{"Super Street Fighter II", "SNES-001"},
				{"Super Mario World", "SNES-002"},
				{"Doom", "PC-003"}
			},
			new Object[]{"Nombre", "Código"}
		);

		table = new JTable(modelo);
		table.setBackground(new Color(25, 12, 35));
		table.setForeground(COLOR_TEXTO);
		table.setGridColor(COLOR_BORDE);
		table.setRowHeight(30);
		table.setFont(new Font("SansSerif", Font.PLAIN, 14));
		table.getTableHeader().setBackground(COLOR_BOTON_SECUNDARIO);
		table.getTableHeader().setForeground(COLOR_TEXTO);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(80, 105, 740, 350);
		scrollPane.setBorder(new LineBorder(COLOR_BORDE, 1));
		scrollPane.getViewport().setBackground(new Color(25, 12, 35));
		panel.add(scrollPane);

		// Botones
		JButton btnPlay = new JButton("▶ Jugar");
		btnPlay.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnPlay.setBounds(300, 480, 130, 40);
		btnPlay.setBackground(COLOR_BOTON_PRIMARIO);
		btnPlay.setForeground(COLOR_TEXTO);
		btnPlay.setFocusPainted(false);
		btnPlay.setBorder(new LineBorder(COLOR_BORDE, 1, true));
		panel.add(btnPlay);

		JButton btnRemove = new JButton("Quitar");
		btnRemove.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnRemove.setBounds(470, 480, 130, 40);
		btnRemove.setBackground(COLOR_BOTON_SECUNDARIO);
		btnRemove.setForeground(COLOR_TEXTO);
		btnRemove.setFocusPainted(false);
		btnRemove.setBorder(new LineBorder(COLOR_BORDE, 1, true));
		panel.add(btnRemove);

		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
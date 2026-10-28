package ar.edu.unrn.seminario.gui;

import ar.edu.unrn.seminario.dto.RegistroJuegoDTO;
import ar.edu.unrn.seminario.helpers.UIHelper;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class Biblioteca2 {

	private JFrame frame;
	private JTextField txtBuscarRapido;
	
	// Referencia a la API de memoria / gestión
	private Object memoryApi; 
	
	// Índice y títulos de los juegos de ejemplo provisionales
	private int indiceJuegoActual = 0;
	private final String[] titulosJuegos = {
		"Super Street Fighter II", 
		"DOOM", 
		"Wolfenstein 3D"
	};

	// Componentes dinámicos
	private JLabel lblNombreJuego;
	private JLabel lblVistaPrevia;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biblioteca2 window = new Biblioteca2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 1. Constructor por defecto (sin parámetros) para que el main funcione sin errores
	public Biblioteca2() {
		this.memoryApi = null;
		initialize();
	}

	// 2. Constructor con parámetros por si se inyecta desde otra clase
	public Biblioteca2(Object memoryApi) {
		this.memoryApi = memoryApi;
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Biblioteca (Vista Detalle) - EmuSwing");
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(UIHelper.COLOR_FONDO);

		// Barra de Menú
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIHelper.COLOR_FONDO);
		menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIHelper.COLOR_TARJETA));

		menuBar.add(javax.swing.Box.createHorizontalGlue());

		JMenu mnPerfil = new JMenu("Mi Perfil");
		mnPerfil.setForeground(UIHelper.COLOR_TEXTO);
		mnPerfil.setFont(UIHelper.FONT_MENU);
		menuBar.add(mnPerfil);

		JMenu mnBiblioteca = new JMenu("Menu principal");
		mnBiblioteca.setForeground(UIHelper.COLOR_TEXTO);
		mnBiblioteca.setFont(UIHelper.FONT_MENU);
		menuBar.add(mnBiblioteca);

		JMenu mnJuegos = new JMenu("Juegos");
		mnJuegos.setForeground(UIHelper.COLOR_TEXTO);
		mnJuegos.setFont(UIHelper.FONT_MENU);
		menuBar.add(mnJuegos);

		JMenu mnTienda = new JMenu("Tienda");
		mnTienda.setForeground(UIHelper.COLOR_TEXTO);
		mnTienda.setFont(UIHelper.FONT_MENU);
		menuBar.add(mnTienda);

		JMenu mnSoporte = new JMenu("Soporte");
		mnSoporte.setForeground(UIHelper.COLOR_TEXTO);
		mnSoporte.setFont(UIHelper.FONT_MENU);
		menuBar.add(mnSoporte);

		JMenu mnAjustes = new JMenu("Ajustes");
		mnAjustes.setForeground(UIHelper.COLOR_TEXTO);
		mnAjustes.setFont(UIHelper.FONT_MENU);
		menuBar.add(mnAjustes);

		menuBar.add(javax.swing.Box.createHorizontalGlue());
		frame.setJMenuBar(menuBar);

		// Panel Principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(190, 40, 900, 580);
		panelPrincipal.setBackground(UIHelper.COLOR_TARJETA);
		panelPrincipal.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1, true));
		panelPrincipal.setLayout(null);
		frame.getContentPane().add(panelPrincipal);

		// Título de la vista
		JLabel lblTitulo = new JLabel("Explorar Biblioteca");
		lblTitulo.setFont(UIHelper.FONT_TITULO);
		lblTitulo.setForeground(UIHelper.COLOR_TEXTO);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 43, 900, 35);
		panelPrincipal.add(lblTitulo);

		// Botón de búsqueda rápida en la esquina superior derecha
		txtBuscarRapido = new JTextField();
		txtBuscarRapido.setBounds(657, 12, 150, 28);
		txtBuscarRapido.setFont(UIHelper.FONT_TEXTFIELDS);
		txtBuscarRapido.setBackground(UIHelper.COLOR_FONDO);
		txtBuscarRapido.setForeground(UIHelper.COLOR_TEXTO);
		txtBuscarRapido.setCaretColor(UIHelper.COLOR_TEXTO);
		txtBuscarRapido.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1, true));
		panelPrincipal.add(txtBuscarRapido);

		JButton btnBuscarRapido = new JButton("🔍");
		btnBuscarRapido.setFont(UIHelper.FONT_BOTON);
		btnBuscarRapido.setBounds(817, 11, 50, 28);
		btnBuscarRapido.setBackground(UIHelper.COLOR_ACENTO);
		btnBuscarRapido.setForeground(UIHelper.COLOR_TEXTO);
		btnBuscarRapido.setFocusPainted(false);
		btnBuscarRapido.setBorder(BorderFactory.createEmptyBorder());
		panelPrincipal.add(btnBuscarRapido);

		// Botón Anterior (<-)
		JButton btnPrev = new JButton("◄");
		btnPrev.setFont(UIHelper.FONT_BOTON);
		btnPrev.setBounds(120, 200, 60, 180);
		btnPrev.setBackground(UIHelper.COLOR_CONTENIDO);
		btnPrev.setForeground(UIHelper.COLOR_TEXTO);
		btnPrev.setFocusPainted(false);
		btnPrev.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelPrincipal.add(btnPrev);

		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indiceJuegoActual--;
				if (indiceJuegoActual < 0) {
					indiceJuegoActual = titulosJuegos.length - 1;
				}
				actualizarJuegoActual();
			}
		});

		// Card central del juego
		JPanel panelCard = new JPanel();
		panelCard.setBackground(UIHelper.COLOR_CONTENIDO);
		panelCard.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1, true));
		panelCard.setBounds(230, 90, 440, 380);
		panelCard.setLayout(null);
		panelPrincipal.add(panelCard);

		lblNombreJuego = new JLabel();
		lblNombreJuego.setFont(UIHelper.FONT_SUBTITULO);
		lblNombreJuego.setForeground(UIHelper.COLOR_TEXTO);
		lblNombreJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJuego.setBounds(20, 320, 400, 30);
		panelCard.add(lblNombreJuego);

		lblVistaPrevia = new JLabel();
		lblVistaPrevia.setHorizontalAlignment(SwingConstants.CENTER);
		lblVistaPrevia.setBounds(20, 20, 400, 280);
		lblVistaPrevia.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelCard.add(lblVistaPrevia);

		// Botón Siguiente (->)
		JButton btnNext = new JButton("►");
		btnNext.setFont(UIHelper.FONT_BOTON);
		btnNext.setBounds(720, 200, 60, 180);
		btnNext.setBackground(UIHelper.COLOR_CONTENIDO);
		btnNext.setForeground(UIHelper.COLOR_TEXTO);
		btnNext.setFocusPainted(false);
		btnNext.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelPrincipal.add(btnNext);

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indiceJuegoActual++;
				if (indiceJuegoActual >= titulosJuegos.length) {
					indiceJuegoActual = 0;
				}
				actualizarJuegoActual();
			}
		});

		// Acciones inferiores
		JButton btnPlay = new JButton("Jugar");
		btnPlay.setFont(UIHelper.FONT_BOTON);
		btnPlay.setBounds(369, 500, 160, 42);
		btnPlay.setBackground(UIHelper.COLOR_ACENTO);
		btnPlay.setForeground(UIHelper.COLOR_TEXTO);
		btnPlay.setFocusPainted(false);
		btnPlay.setBorder(BorderFactory.createEmptyBorder());
		panelPrincipal.add(btnPlay);
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroJuegoDTO juegoActual = obtenerJuegoActualEnVista();
				if (juegoActual != null) {
					JOptionPane.showMessageDialog(frame, 
						"¡Iniciando el juego exitosamente!\n" + juegoActual.getTitulo(), 
						"Jugar", 
						JOptionPane.INFORMATION_MESSAGE
					);
				}
			}
		});

		JButton btnRemove = new JButton("Quitar");
		btnRemove.setFont(UIHelper.FONT_BOTON);
		btnRemove.setBounds(553, 500, 160, 42);
		btnRemove.setBackground(UIHelper.COLOR_CONTENIDO);
		btnRemove.setForeground(UIHelper.COLOR_TEXTO);
		btnRemove.setFocusPainted(false);
		btnRemove.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelPrincipal.add(btnRemove);
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroJuegoDTO juegoActual = obtenerJuegoActualEnVista();
				if (juegoActual != null) {
					JOptionPane.showMessageDialog(frame, 
						"El juego fue quitado de la biblioteca correctamente.", 
						"Quitar", 
						JOptionPane.INFORMATION_MESSAGE
					);
					actualizarJuegoActual(); 
				}
			}
		});
		
		JButton btnVerInfo = new JButton("Ver Info");
		btnVerInfo.setFont(UIHelper.FONT_BOTON);
		btnVerInfo.setBounds(190, 500, 160, 42);
		btnVerInfo.setBackground(UIHelper.COLOR_CONTENIDO);
		btnVerInfo.setForeground(UIHelper.COLOR_TEXTO);
		btnVerInfo.setFocusPainted(false);
		btnVerInfo.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelPrincipal.add(btnVerInfo);

		// Cargar la primera imagen y título inicial al abrir la ventana
		actualizarJuegoActual();

		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroJuegoDTO juegoActual = obtenerJuegoActualEnVista();
				if (juegoActual != null) {
					JOptionPane.showMessageDialog(frame, 
						"Información detallada:\n" + 
						"Título: " + juegoActual.getTitulo() + "\n" +
						"Código / ID: " + juegoActual.getId(), 
						"Ver Info", 
						JOptionPane.INFORMATION_MESSAGE
					);
				}
			}
		});
		
		btnBuscarRapido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Búsqueda realizada con éxito.", "Buscar", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	private RegistroJuegoDTO obtenerJuegoActualEnVista() {
		int idJuego = indiceJuegoActual + 1;
		String titulo = titulosJuegos[indiceJuegoActual];
		return new RegistroJuegoDTO(idJuego, titulo);
	}

	private void actualizarJuegoActual() {
		int idJuego = indiceJuegoActual + 1; 
		String nombreArchivo = "esw-logo.png"; 

		if (idJuego == 1) {
			nombreArchivo = "Street-Fighter-II-USA_cover_1024x705.jpg";
		} else if (idJuego == 2) {
			nombreArchivo = "doom_1993_cover_720x1080.jpg"; 
		} else if (idJuego == 3) {
			nombreArchivo = "Wolfenstein 3D (PC Version).jpg"; 
		}

		String ruta = "/img/" + nombreArchivo;
		URL imgURL = getClass().getResource(ruta);

		if (imgURL != null) {
			ImageIcon iconOriginal = new ImageIcon(imgURL);
			Image imagenEscalada = iconOriginal.getImage().getScaledInstance(
					400, 
					280, 
					Image.SCALE_SMOOTH
			);
			lblVistaPrevia.setIcon(new ImageIcon(imagenEscalada));
			lblVistaPrevia.setText(""); 
		} else {
			lblVistaPrevia.setIcon(null);
			lblVistaPrevia.setText("Sin Imagen");
			lblVistaPrevia.setFont(UIHelper.FONT_TARJETA);
			lblVistaPrevia.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
			System.out.println("No se encontró la imagen: " + ruta);
		}
		
		lblNombreJuego.setText(titulosJuegos[indiceJuegoActual]);
	}
}
package ar.edu.unrn.seminario.gui;

import ar.edu.unrn.seminario.dto.RegistroJuegoDTO;
import ar.edu.unrn.seminario.helpers.UIHelper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class Biblioteca2 {

	private JFrame frame;
	private JTextField txtBuscarRapido;
	
	private Object memoryApi; 

	// Listas paralelas para mantener los datos de los juegos de ejemplo
	private List<RegistroJuegoDTO> listaJuegos;
	private List<String> listaTitulos;
	private List<Integer> listaAnios;
	
	private int indiceJuegoActual = 0;

	// Componentes dinámicos
	private JLabel lblNombreJuego;
	private JLabel lblVistaPrevia;
	private JPanel panelDetalle;
	private JPanel panelMatriz;
	private boolean modoMatriz = false;

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

	public Biblioteca2() {
		this.memoryApi = null;
		inicializarJuegosEjemplo();
		initialize();
	}

	public Biblioteca2(Object memoryApi) {
		this.memoryApi = memoryApi;
		inicializarJuegosEjemplo();
		initialize();
	}

	private void inicializarJuegosEjemplo() {
		listaJuegos = new ArrayList<>();
		listaTitulos = new ArrayList<>();
		listaAnios = new ArrayList<>();

		// El DTO recibe (Integer idJuego, Integer horas)
		listaJuegos.add(new RegistroJuegoDTO(1, 15));
		listaTitulos.add("Super Street Fighter II");
		listaAnios.add(1993);

		listaJuegos.add(new RegistroJuegoDTO(2, 42));
		listaTitulos.add("DOOM");
		listaAnios.add(1993);

		listaJuegos.add(new RegistroJuegoDTO(3, 8));
		listaTitulos.add("Wolfenstein 3D");
		listaAnios.add(1992);
	}

	private void initialize() {
		frame = new JFrame("Biblioteca - EmuSwing");
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

		// Botón de búsqueda rápida
		txtBuscarRapido = new JTextField();
		txtBuscarRapido.setBounds(648, 39, 150, 28);
		txtBuscarRapido.setFont(UIHelper.FONT_TEXTFIELDS);
		txtBuscarRapido.setBackground(UIHelper.COLOR_FONDO);
		txtBuscarRapido.setForeground(UIHelper.COLOR_TEXTO);
		txtBuscarRapido.setCaretColor(UIHelper.COLOR_TEXTO);
		txtBuscarRapido.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1, true));
		panelPrincipal.add(txtBuscarRapido);

		JButton btnBuscarRapido = new JButton("🔍");
		btnBuscarRapido.setFont(UIHelper.FONT_BOTON);
		btnBuscarRapido.setBounds(809, 38, 50, 28);
		btnBuscarRapido.setBackground(UIHelper.COLOR_ACENTO);
		btnBuscarRapido.setForeground(UIHelper.COLOR_TEXTO);
		btnBuscarRapido.setFocusPainted(false);
		btnBuscarRapido.setBorder(BorderFactory.createEmptyBorder());
		panelPrincipal.add(btnBuscarRapido);

		
		panelDetalle = new JPanel();
		panelDetalle.setBounds(0, 60, 900, 520);
		panelDetalle.setBackground(UIHelper.COLOR_TARJETA);
		panelDetalle.setLayout(null);
		panelPrincipal.add(panelDetalle);

		JButton btnPrev = new JButton("◄");
		btnPrev.setFont(UIHelper.FONT_BOTON);
		btnPrev.setBounds(120, 140, 60, 180);
		btnPrev.setBackground(UIHelper.COLOR_CONTENIDO);
		btnPrev.setForeground(UIHelper.COLOR_TEXTO);
		btnPrev.setFocusPainted(false);
		btnPrev.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelDetalle.add(btnPrev);

		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaJuegos.isEmpty()) return;
				indiceJuegoActual--;
				if (indiceJuegoActual < 0) {
					indiceJuegoActual = listaJuegos.size() - 1;
				}
				actualizarJuegoActual();
			}
		});

		JPanel panelCard = new JPanel();
		panelCard.setBackground(UIHelper.COLOR_CONTENIDO);
		panelCard.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1, true));
		panelCard.setBounds(230, 30, 440, 380);
		panelCard.setLayout(null);
		panelDetalle.add(panelCard);

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

		JButton btnNext = new JButton("►");
		btnNext.setFont(UIHelper.FONT_BOTON);
		btnNext.setBounds(720, 140, 60, 180);
		btnNext.setBackground(UIHelper.COLOR_CONTENIDO);
		btnNext.setForeground(UIHelper.COLOR_TEXTO);
		btnNext.setFocusPainted(false);
		btnNext.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelDetalle.add(btnNext);

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaJuegos.isEmpty()) return;
				indiceJuegoActual++;
				if (indiceJuegoActual >= listaJuegos.size()) {
					indiceJuegoActual = 0;
				}
				actualizarJuegoActual();
			}
		});

		JButton btnVerInfo = new JButton("Ver Info");
		btnVerInfo.setFont(UIHelper.FONT_BOTON);
		btnVerInfo.setBounds(190, 440, 160, 42);
		btnVerInfo.setBackground(UIHelper.COLOR_CONTENIDO);
		btnVerInfo.setForeground(UIHelper.COLOR_TEXTO);
		btnVerInfo.setFocusPainted(false);
		btnVerInfo.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelDetalle.add(btnVerInfo);

		JButton btnPlay = new JButton("Jugar");
		btnPlay.setFont(UIHelper.FONT_BOTON);
		btnPlay.setBounds(369, 440, 160, 42);
		btnPlay.setBackground(UIHelper.COLOR_ACENTO);
		btnPlay.setForeground(UIHelper.COLOR_TEXTO);
		btnPlay.setFocusPainted(false);
		btnPlay.setBorder(BorderFactory.createEmptyBorder());
		panelDetalle.add(btnPlay);

		JButton btnRemove = new JButton("Quitar");
		btnRemove.setFont(UIHelper.FONT_BOTON);
		btnRemove.setBounds(553, 440, 160, 42);
		btnRemove.setBackground(UIHelper.COLOR_CONTENIDO);
		btnRemove.setForeground(UIHelper.COLOR_TEXTO);
		btnRemove.setFocusPainted(false);
		btnRemove.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelDetalle.add(btnRemove);


	
		panelMatriz = new JPanel();
		panelMatriz.setBounds(0, 60, 900, 520);
		panelMatriz.setBackground(UIHelper.COLOR_TARJETA);
		panelMatriz.setLayout(null);
		panelMatriz.setVisible(false);
		panelPrincipal.add(panelMatriz);
		
				// Título de la vista
				JLabel lblTitulo = new JLabel("Explorar Biblioteca");
				lblTitulo.setBounds(12, 0, 900, 35);
				panelPrincipal.add(lblTitulo);
				lblTitulo.setFont(UIHelper.FONT_TITULO);
				lblTitulo.setForeground(UIHelper.COLOR_TEXTO);
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

	
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaJuegos.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "No hay juegos en la biblioteca.", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(frame, 
					"¡Iniciando el juego exitosamente!\n" + listaTitulos.get(indiceJuegoActual), 
					"Jugar", 
					JOptionPane.INFORMATION_MESSAGE
				);
			}
		});

		// BORRADO LÓGICO AL QUITAR
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaJuegos.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "No hay juegos para quitar.", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}

				String tituloQuitado = listaTitulos.get(indiceJuegoActual);

				listaJuegos.remove(indiceJuegoActual);
				listaTitulos.remove(indiceJuegoActual);
				listaAnios.remove(indiceJuegoActual);

				JOptionPane.showMessageDialog(frame, 
					"El juego '" + tituloQuitado + "' fue quitado de la biblioteca correctamente.", 
					"Quitar", 
					JOptionPane.INFORMATION_MESSAGE
				);

				if (indiceJuegoActual >= listaJuegos.size() && indiceJuegoActual > 0) {
					indiceJuegoActual--;
				}

				actualizarJuegoActual();
			}
		});

		// MOSTRAR INFORMACIÓN DETALLADA DEL JUEGO
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaJuegos.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "No hay juegos disponibles.", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}
				RegistroJuegoDTO juegoActual = listaJuegos.get(indiceJuegoActual);
				String titulo = listaTitulos.get(indiceJuegoActual);
				int anio = listaAnios.get(indiceJuegoActual);

				JOptionPane.showMessageDialog(frame, 
					"Información del Juego:\n" + 
					"• Título: " + titulo + "\n" +
					"• Año de salida: " + anio + "\n" +
					"• ID de Registro: " + juegoActual.getIdJuego() + "\n" +
					"• Horas jugadas: " + juegoActual.getHoras() + " hrs", 
					"Ver Info", 
					JOptionPane.INFORMATION_MESSAGE
				);
			}
		});
		
		btnBuscarRapido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Búsqueda realizada con éxito.", "Buscar", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// Cargar primer juego inicial
		actualizarJuegoActual();
	}

	private void actualizarJuegoActual() {
		if (listaJuegos.isEmpty()) {
			lblVistaPrevia.setIcon(null);
			lblVistaPrevia.setText("Biblioteca Vacía");
			lblNombreJuego.setText("Sin juegos disponibles");
			return;
		}

		RegistroJuegoDTO juegoActual = listaJuegos.get(indiceJuegoActual);
		int idJuego = juegoActual.getIdJuego();
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
		}
		
		lblNombreJuego.setText(listaTitulos.get(indiceJuegoActual));
	}

	private void actualizarPanelMatriz() {
		panelMatriz.removeAll();

		JPanel gridTarjetas = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 20));
		gridTarjetas.setBackground(UIHelper.COLOR_TARJETA);
		
		if (listaJuegos.isEmpty()) {
			JLabel lblVacio = new JLabel("No hay juegos en la biblioteca.");
			lblVacio.setFont(UIHelper.FONT_SUBTITULO);
			lblVacio.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
			gridTarjetas.add(lblVacio);
		} else {
			for (int i = 0; i < listaJuegos.size(); i++) {
				int id = listaJuegos.get(i).getIdJuego();
				String titulo = listaTitulos.get(i);
				String archivo = "esw-logo.png";
				if (id == 1) archivo = "Street-Fighter-II-USA_cover_1024x705.jpg";
				else if (id == 2) archivo = "doom_1993_cover_720x1080.jpg";
				else if (id == 3) archivo = "Wolfenstein 3D (PC Version).jpg";

				gridTarjetas.add(crearTarjetaMatriz(id, titulo, archivo));
			}
		}

		JScrollPane scrollMatriz = new JScrollPane(gridTarjetas);
		scrollMatriz.setBounds(50, 20, 800, 470);
		scrollMatriz.setBorder(BorderFactory.createEmptyBorder());
		scrollMatriz.getViewport().setBackground(UIHelper.COLOR_TARJETA);
		panelMatriz.add(scrollMatriz);
		panelMatriz.revalidate();
		panelMatriz.repaint();
	}

	private JPanel crearTarjetaMatriz(int id, String titulo, String nombreArchivo) {
		JPanel tarjeta = new JPanel(new BorderLayout());
		tarjeta.setPreferredSize(new Dimension(UIHelper.ANCHO_TARJETA, UIHelper.ALTO_TARJETA));
		tarjeta.setBackground(UIHelper.COLOR_CONTENIDO);
		tarjeta.setBorder(BorderFactory.createLineBorder(UIHelper.COLOR_BORDE, 2));

		String ruta = "/img/" + nombreArchivo;
		URL imgURL = getClass().getResource(ruta);
		
		JLabel lblImagen = new JLabel();
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setPreferredSize(new Dimension(UIHelper.ANCHO_PORTADA, UIHelper.ALTO_PORTADA));

		if (imgURL != null) {
			ImageIcon iconOriginal = new ImageIcon(imgURL);
			Image imagenEscalada = iconOriginal.getImage().getScaledInstance(
					UIHelper.ANCHO_PORTADA, 
					UIHelper.ALTO_PORTADA, 
					Image.SCALE_SMOOTH
			);
			lblImagen.setIcon(new ImageIcon(imagenEscalada));
		} else {
			lblImagen.setText("Sin Imagen");
			lblImagen.setFont(UIHelper.FONT_TARJETA);
			lblImagen.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		}
		
		tarjeta.add(lblImagen, BorderLayout.CENTER);

		JPanel panelDatos = new JPanel(new BorderLayout());
		panelDatos.setBackground(UIHelper.COLOR_CONTENIDO);
		panelDatos.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JLabel lblTituloTarjeta = new JLabel(titulo, SwingConstants.CENTER);
		lblTituloTarjeta.setFont(UIHelper.FONT_TARJETA);
		lblTituloTarjeta.setForeground(UIHelper.COLOR_TEXTO);
		panelDatos.add(lblTituloTarjeta, BorderLayout.CENTER);

		tarjeta.add(panelDatos, BorderLayout.SOUTH);

		return tarjeta;
	}
}
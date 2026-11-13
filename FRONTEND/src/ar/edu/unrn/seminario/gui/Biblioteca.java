package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ar.edu.unrn.seminario.api.IApi;
import ar.edu.unrn.seminario.dto.JuegoDTO;
import ar.edu.unrn.seminario.exception.CatalogoVacioException;
import ar.edu.unrn.seminario.helpers.UIHelper;

public class Biblioteca extends JFrame {

	private IApi api;
	private JPanel panelListaJuegos;
	
	// Variables para manejar la selección
	private JuegoDTO juegoSeleccionado;
	private final List<JPanel> filasJuegos = new ArrayList<>();

	// Atributos necesarios para el buscador y lista en memoria.
	private List<JuegoDTO> listaCompletaJuegos = new ArrayList<>();
	private JTextField txtBuscador;
	private JPanel panelSugerencias;
	//Constante para el texto del placeholder
	private static final String PLACEHOLDER_BUSCADOR = "Buscar Juego";
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			try {
				IApi apiPrueba = new ar.edu.unrn.seminario.api.MemoryApi();
				Biblioteca frame = new Biblioteca(apiPrueba);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Biblioteca(IApi api) {
		this.api = api;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Catálogo General - EmuSwing");
		setSize(1000, 700);
		setLocationRelativeTo(null);

		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setBackground(UIHelper.COLOR_FONDO);
		setContentPane(contentPane);

		// ---------- ENCABEZADO (TÍTULOS) ----------
		JPanel panelEncabezado = new JPanel(new BorderLayout());
		panelEncabezado.setBackground(UIHelper.COLOR_FONDO);
		panelEncabezado.setBorder(new EmptyBorder(20, 0, 20, 0));

		JLabel lblTitulo = new JLabel("Biblioteca de Juegos", SwingConstants.CENTER);
		lblTitulo.setFont(UIHelper.FONT_TITULO);
		lblTitulo.setForeground(UIHelper.COLOR_TEXTO);
		
		JLabel lblSubtitulo = new JLabel("Explorá todos los títulos disponibles", SwingConstants.CENTER);
		lblSubtitulo.setFont(UIHelper.FONT_SUBTITULO);
		lblSubtitulo.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);

		panelEncabezado.add(lblTitulo, BorderLayout.NORTH);
		panelEncabezado.add(lblSubtitulo, BorderLayout.SOUTH);
		contentPane.add(panelEncabezado, BorderLayout.NORTH);

		// ---------- CONTENEDOR CENTRAL (LISTA DE JUEGOS) ----------
		panelListaJuegos = new JPanel();
		panelListaJuegos.setLayout(new BoxLayout(panelListaJuegos, BoxLayout.Y_AXIS));
		panelListaJuegos.setBackground(UIHelper.COLOR_CONTENIDO);
		panelListaJuegos.setBorder(new EmptyBorder(15, 15, 15, 15));

		JScrollPane scrollPane = new JScrollPane(panelListaJuegos);
		scrollPane.setBorder(new LineBorder(UIHelper.COLOR_ACENTO, 2, true));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.getViewport().setBackground(UIHelper.COLOR_CONTENIDO);
		
		JPanel panelMargen = new JPanel(new BorderLayout());
		panelMargen.setBackground(UIHelper.COLOR_FONDO);
		panelMargen.setBorder(new EmptyBorder(0, 50, 20, 50));

		// Bloque de barra de búsqueda y desplegable de sugerencias.
		JPanel panelBusquedaContenedor = new JPanel(new BorderLayout());
		panelBusquedaContenedor.setBackground(UIHelper.COLOR_FONDO);
		panelBusquedaContenedor.setBorder(new EmptyBorder(0, 0, 15, 0));

		// Se inicializa con el placeholder y color de texto secundario
		txtBuscador = new JTextField(PLACEHOLDER_BUSCADOR);
		txtBuscador.setFont(UIHelper.FONT_MENU);
		txtBuscador.setBackground(UIHelper.COLOR_TARJETA_HOVER);
		txtBuscador.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		txtBuscador.setCaretColor(UIHelper.COLOR_ACENTO);
		txtBuscador.setBorder(new CompoundBorder(
			new LineBorder(UIHelper.COLOR_ACENTO, 2, true),
			new EmptyBorder(8, 12, 8, 12)
		));

		panelSugerencias = new JPanel();
		panelSugerencias.setLayout(new BoxLayout(panelSugerencias, BoxLayout.Y_AXIS));
		panelSugerencias.setBackground(UIHelper.COLOR_TARJETA);
		panelSugerencias.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1, true));
		panelSugerencias.setVisible(false);

		// Listener para ocultar/mostrar el placeholder al hacer clic o salir
		txtBuscador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtBuscador.getText().equals(PLACEHOLDER_BUSCADOR)) {
					txtBuscador.setText("");
					txtBuscador.setForeground(UIHelper.COLOR_TEXTO);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtBuscador.getText().trim().isEmpty()) {
					txtBuscador.setText(PLACEHOLDER_BUSCADOR);
					txtBuscador.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
				}
			}
		});

		txtBuscador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				actualizarBusqueda();
			}
		});

		panelBusquedaContenedor.add(txtBuscador, BorderLayout.NORTH);
		panelBusquedaContenedor.add(panelSugerencias, BorderLayout.CENTER);
		panelMargen.add(panelBusquedaContenedor, BorderLayout.NORTH);

		panelMargen.add(scrollPane, BorderLayout.CENTER);
		
		contentPane.add(panelMargen, BorderLayout.CENTER);

		// ---------- PANEL INFERIOR (BOTONES ÚNICOS) ----------
		JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
		panelAcciones.setBackground(UIHelper.COLOR_FONDO);
		
		JButton btnInfo = crearBotonAccion("Info", false);
		JButton btnAgregar = crearBotonAccion("Agregar a Favoritos", false);
		JButton btnJugar = crearBotonAccion("\u25B6 Jugar", true);
		JButton btnVerFavoritos = crearBotonAccion("★ Ver Favoritos", false);
		
		// Lógica del nuevo botón "Ver Favoritos"
		btnVerFavoritos.addActionListener(e -> {
			try {
				// Instanciamos la ventana que vamos a crear en el próximo paso
				BibliotecaFavoritos ventanaFavoritos = new BibliotecaFavoritos(api);
				ventanaFavoritos.setVisible(true);
						
				// Opcional: cerramos esta ventana para no apilar muchas pantallas
				dispose(); 
			} catch (Exception ex) {
				ex.printStackTrace();
				javax.swing.JOptionPane.showMessageDialog(this, "Error al abrir favoritos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		});

		// Lógica del botón Jugar
		btnJugar.addActionListener(e -> {
			if (juegoSeleccionado == null) {
				javax.swing.JOptionPane.showMessageDialog(this, "Seleccioná un juego primero.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
				return;
			}
			String urlJuego = api.getUrlJuegoByTitulo(juegoSeleccionado.getTitulo());
			if (urlJuego != null) {
				try {
					VentanaJuego ventana = new VentanaJuego(urlJuego);
					ventana.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
					javax.swing.JOptionPane.showMessageDialog(this, "Error al iniciar el juego.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			} else {
				javax.swing.JOptionPane.showMessageDialog(this, "Enlace no disponible.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		});

		// Lógica del botón Info
		btnInfo.addActionListener(e -> {
			if (juegoSeleccionado == null) {
				javax.swing.JOptionPane.showMessageDialog(this, "Seleccioná un juego primero.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
				return;
			}
			mostrarInfoJuego(juegoSeleccionado);
		});
		
		// Lógica del botón Agregar a Favoritos
		btnAgregar.addActionListener(e -> {
			if (juegoSeleccionado == null) {
				javax.swing.JOptionPane.showMessageDialog(this, "Seleccioná un juego primero.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// Llamamos al método del backend para guardar el ID
			api.agregarAFavoritos(juegoSeleccionado.getId());
			
			javax.swing.JOptionPane.showMessageDialog(this, 
				"¡" + juegoSeleccionado.getTitulo() + " se agregó a tus favoritos!", 
				"Éxito", 
				javax.swing.JOptionPane.INFORMATION_MESSAGE);
		});

		panelAcciones.add(btnVerFavoritos);
		panelAcciones.add(btnInfo);
		panelAcciones.add(btnAgregar);
		panelAcciones.add(btnJugar);
		contentPane.add(panelAcciones, BorderLayout.SOUTH);


		// ---------- CARGA DE JUEGOS ----------
		cargarJuegos();

		// Evita que el buscador tome foco automático al abrir la ventana
		panelEncabezado.setFocusable(true);
		javax.swing.SwingUtilities.invokeLater(() -> panelEncabezado.requestFocusInWindow());
	}

	private void cargarJuegos() {
		try {
			// Guardamos los juegos en memoria y delegamos el dibujado
			listaCompletaJuegos = api.obtenerJuegos();
			renderizarListaJuegos(listaCompletaJuegos);
		} catch (CatalogoVacioException e) {
			JLabel lblVacio = new JLabel(e.getMessage(), SwingConstants.CENTER);
			lblVacio.setFont(UIHelper.FONT_SUBTITULO);
			lblVacio.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
			panelListaJuegos.add(lblVacio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Métodos nuevos para dibujar dinámicamente y filtrar con stream
	private void renderizarListaJuegos(List<JuegoDTO> juegosAMostrar) {
		panelListaJuegos.removeAll();
		filasJuegos.clear();
		juegoSeleccionado = null;

		for (JuegoDTO j : juegosAMostrar) {
			JPanel filaJuego = crearFilaJuego(j);
			panelListaJuegos.add(filaJuego);
			filasJuegos.add(filaJuego);
			panelListaJuegos.add(javax.swing.Box.createRigidArea(new Dimension(0, 15)));
		}

		panelListaJuegos.revalidate();
		panelListaJuegos.repaint();
	}

	private void actualizarBusqueda() {
		String textoRaw = txtBuscador.getText().trim();
		String texto = textoRaw.toLowerCase();
		panelSugerencias.removeAll();

		// Si está vacío o tiene el placeholder, mostramos toda la lista
		if (texto.isEmpty() || textoRaw.equals(PLACEHOLDER_BUSCADOR)) {
			panelSugerencias.setVisible(false);
			renderizarListaJuegos(listaCompletaJuegos);
			return;
		}

		List<JuegoDTO> coincidencias = listaCompletaJuegos.stream()
				.filter(j -> j.getTitulo().toLowerCase().contains(texto))
				.collect(Collectors.toList());

		if (coincidencias.isEmpty()) {
			panelSugerencias.setVisible(false);
		} else {
			for (JuegoDTO juego : coincidencias) {
				JLabel lblSugerencia = new JLabel(juego.getTitulo());
				lblSugerencia.setFont(UIHelper.FONT_MENU);
				lblSugerencia.setForeground(UIHelper.COLOR_TEXTO);
				lblSugerencia.setBorder(new EmptyBorder(6, 12, 6, 12));
				lblSugerencia.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblSugerencia.setOpaque(true);
				lblSugerencia.setBackground(UIHelper.COLOR_TARJETA);

				lblSugerencia.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						txtBuscador.setText(juego.getTitulo());
						txtBuscador.setForeground(UIHelper.COLOR_TEXTO);
						panelSugerencias.setVisible(false);
						filtrarYSeleccionar(juego);
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						lblSugerencia.setBackground(UIHelper.COLOR_TARJETA_HOVER);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblSugerencia.setBackground(UIHelper.COLOR_TARJETA);
					}
				});

				panelSugerencias.add(lblSugerencia);
			}
			panelSugerencias.setVisible(true);
		}

		panelSugerencias.revalidate();
		panelSugerencias.repaint();
		renderizarListaJuegos(coincidencias);
	}

	private void filtrarYSeleccionar(JuegoDTO juegoElegido) {
		List<JuegoDTO> unicoJuego = listaCompletaJuegos.stream()
				.filter(j -> j.getId().equals(juegoElegido.getId()))
				.collect(Collectors.toList());

		renderizarListaJuegos(unicoJuego);

		if (!filasJuegos.isEmpty()) {
			seleccionarFila(filasJuegos.get(0), juegoElegido);
		}
	}

	private JPanel crearFilaJuego(JuegoDTO juego) {
		JPanel fila = new JPanel(new BorderLayout(15, 0));
		fila.setBackground(UIHelper.COLOR_TARJETA);
		fila.setBorder(new CompoundBorder(new LineBorder(UIHelper.COLOR_BORDE, 2, true), new EmptyBorder(10, 10, 10, 10)));
		fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
		fila.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

		JLabel lblPortada = new JLabel();
		lblPortada.setPreferredSize(new Dimension(80, 100)); 
		
		String nombreArchivo = "esw-logo.png"; 
		if (juego.getId().equals(api.getIdJuegoPorTitulo("Super Street Fighter II"))) nombreArchivo = "Street-Fighter-II-USA_cover_1024x705.jpg";
		else if (juego.getId().equals(api.getIdJuegoPorTitulo("DOOM"))) nombreArchivo = "doom_1993_cover_720x1080.jpg"; 
		else if (juego.getId().equals(api.getIdJuegoPorTitulo("Wolfenstein 3D"))) nombreArchivo = "Wolfenstein 3D (PC Version).jpg";
		else if (juego.getId().equals(api.getIdJuegoPorTitulo("Super Mario World"))) nombreArchivo = "Super-Mario-Word_1990_cover_474x332.jpg"; 

		URL imgURL = getClass().getResource("/img/" + nombreArchivo);
		if (imgURL != null) {
			ImageIcon iconOriginal = new ImageIcon(imgURL);
			Image imagenEscalada = iconOriginal.getImage().getScaledInstance(80, 100, Image.SCALE_SMOOTH);
			lblPortada.setIcon(new ImageIcon(imagenEscalada));
		} else {
			lblPortada.setText("Sin IMG");
			lblPortada.setForeground(Color.GRAY);
		}
		fila.add(lblPortada, BorderLayout.WEST);

		JLabel lblTitulo = new JLabel(juego.getTitulo());
		lblTitulo.setFont(UIHelper.FONT_TARJETA);
		lblTitulo.setForeground(UIHelper.COLOR_TEXTO);
		fila.add(lblTitulo, BorderLayout.CENTER);

		// Eventos de selección de la fila
		fila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionarFila(fila, juego);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if (juegoSeleccionado == null || !juegoSeleccionado.getId().equals(juego.getId())) {
					fila.setBorder(new CompoundBorder(new LineBorder(UIHelper.COLOR_TARJETA_HOVER, 2, true), new EmptyBorder(10, 10, 10, 10)));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (juegoSeleccionado == null || !juegoSeleccionado.getId().equals(juego.getId())) {
					fila.setBorder(new CompoundBorder(new LineBorder(UIHelper.COLOR_BORDE, 2, true), new EmptyBorder(10, 10, 10, 10)));
				}
			}
		});

		return fila;
	}

	private void seleccionarFila(JPanel filaElegida, JuegoDTO juego) {
		for (JPanel fila : filasJuegos) {
			if (fila == filaElegida) {
				fila.setBorder(new CompoundBorder(new LineBorder(UIHelper.COLOR_ACENTO, 2, true), new EmptyBorder(10, 10, 10, 10)));
			} else {
				fila.setBorder(new CompoundBorder(new LineBorder(UIHelper.COLOR_BORDE, 2, true), new EmptyBorder(10, 10, 10, 10)));
			}
		}
		juegoSeleccionado = juego;
	}

	private void mostrarInfoJuego(JuegoDTO juego) {
		String historia = "";
		
		if (juego.getId() == 1) { 
			historia = "El World Warrior Tournament sigue en pie, pero la paz es frágil: cuatro jefes malignos aún controlan el submundo del combate.\n Nuevos retadores llegan para desafiar al orden, y tú eres uno de ellos. \n Tu misión: derrotar a Balrog, Vega, Sagat y M. Bison, y reclamar el trono.";
		} else if (juego.getId() == 2) {
			historia = "En el año 2145, fuiste enviado a una instalación de investigación en el planeta Marte.\n Un experimento fallido abrió un portal al infierno y tu misión es lograr sobrevivir a la invasión demoníaca.\n Hallar la salida por el planeta del polvo mezclado con destrucción y eliminando a quien se cruce.";
		} else if (juego.getId() == 3) { 
			historia = "Atrapado tras las oscuras líneas enemigas en plena guerra nazi, tomas el papel del espía aliado B.J. Blazkowicz.\n Tu misión comienza como un desesperado escape de los lúgubres calabozos del Castillo Wolfenstein, pero rápidamente se convierte en una cacería contrarreloj.\n Armado sólo con lo que logres arrebatarle a tus captores, deberás sobrevivir a laberintos plagados de tropas implacables.";
		} else if (juego.getId() == 4) {
			historia = "Unas merecidas vacaciones en la misteriosa Isla de los Dinosaurios se transforman en una nueva misión de rescate cuando el despiadado Bowser secuestra a la Princesa Peach.\n Montado por primera vez en tu fiel y hambriento amigo Yoshi, y usando el poder de vuelo de la capa mágica, deberás descubrir salidas secretas.";
		} else {
			historia = "Historia no disponible para este título.";
		}
		
		javax.swing.JOptionPane.showMessageDialog(this, historia, "Historia: " + juego.getTitulo(), javax.swing.JOptionPane.INFORMATION_MESSAGE);
	}

	private JButton crearBotonAccion(String texto, boolean relleno) {
		final JButton boton = new JButton(texto);
		boton.setFont(UIHelper.FONT_BOTON);
		boton.setFocusPainted(false);
		boton.setOpaque(true);
		boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		final Color colorNormal = relleno ? UIHelper.COLOR_ACENTO : UIHelper.COLOR_CONTENIDO;
		final Color colorHover = relleno ? UIHelper.COLOR_ACENTO_HOVER : UIHelper.COLOR_TARJETA_HOVER;

		boton.setForeground(relleno ? UIHelper.COLOR_FONDO : UIHelper.COLOR_TEXTO);
		
		if (relleno) {
			boton.setBorder(new EmptyBorder(8, 20, 8, 20));
		} else {
			boton.setBorder(new CompoundBorder(new LineBorder(UIHelper.COLOR_ACENTO, 2, true), new EmptyBorder(6, 18, 6, 18)));
		}
		
		boton.setBackground(colorNormal);

		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { boton.setBackground(colorHover); }
			@Override
			public void mouseExited(MouseEvent e) { boton.setBackground(colorNormal); }
		});

		return boton;
	}
}
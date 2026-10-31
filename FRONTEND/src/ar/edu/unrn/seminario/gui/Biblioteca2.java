package ar.edu.unrn.seminario.gui;

import ar.edu.unrn.seminario.api.IApi;
import ar.edu.unrn.seminario.api.MemoryApi;
import ar.edu.unrn.seminario.dto.JuegoDTO;
import ar.edu.unrn.seminario.exception.JuegoNoEncontradoException;
import ar.edu.unrn.seminario.helpers.UIHelper;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	private IApi memoryApi; 

	private Set<JuegoDTO> juegosSet;
	private List<JuegoDTO> listaJuegos;
	
	private int indiceJuegoActual = 0;

	private JLabel lblNombreJuego;
	private JLabel lblVistaPrevia;
	private JPanel panelDetalle;
	private JPanel panelMatriz;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biblioteca2 window = new Biblioteca2(new MemoryApi());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Biblioteca2() {
		this.memoryApi = new MemoryApi();
		inicializarJuegosDesdeApi();
		initialize();
	}

	public Biblioteca2(Object memoryApi) {
		if (memoryApi instanceof IApi) {
			this.memoryApi = (IApi) memoryApi;
		} else {
			this.memoryApi = new MemoryApi();
		}
		inicializarJuegosDesdeApi();
		initialize();
	}

	private void inicializarJuegosDesdeApi() {
		juegosSet = new HashSet<>();
		try {
			
			juegosSet.addAll(this.memoryApi.obtenerFavoritos());
			
		} catch (Exception e) {
			juegosSet.add(new JuegoDTO(1, "Super Street Fighter II", "Lucha", "Capcom", "SNES", 1993));
			juegosSet.add(new JuegoDTO(2, "DOOM", "FPS", "id Software", "MS-DOS", 1993));
			juegosSet.add(new JuegoDTO(3, "Wolfenstein 3D", "FPS", "id Software", "MS-DOS", 1992));
		}
		listaJuegos = new ArrayList<>(juegosSet);
	}

	private void initialize() {
		frame = new JFrame("Biblioteca - EmuSwing");
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(UIHelper.COLOR_FONDO);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIHelper.COLOR_FONDO);
		menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIHelper.COLOR_TARJETA));

		menuBar.add(javax.swing.Box.createHorizontalGlue());

		JMenu mnPerfil = new JMenu("Mi Perfil");
		mnPerfil.setForeground(UIHelper.COLOR_TEXTO);
		mnPerfil.setFont(UIHelper.FONT_MENU);
		mnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				frame.dispose();
				new VentanaMiPerfil().setVisible(true);
			}
		});
		menuBar.add(mnPerfil);

		JMenu mnBiblioteca = new JMenu("Menu principal");
		mnBiblioteca.setForeground(UIHelper.COLOR_TEXTO);
		mnBiblioteca.setFont(UIHelper.FONT_MENU);
		mnBiblioteca.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				frame.dispose();
				new Biblioteca2(memoryApi).frame.setVisible(true);
			}
		});
		menuBar.add(mnBiblioteca);

		JMenu mnJuegos = new JMenu("Juegos");
		mnJuegos.setForeground(UIHelper.COLOR_TEXTO);
		mnJuegos.setFont(UIHelper.FONT_MENU);
		mnJuegos.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				frame.dispose();
				JOptionPane.showMessageDialog(frame, "Sección de Juegos disponible próximamente.", "Juegos", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuBar.add(mnJuegos);

		JMenu mnTienda = new JMenu("Tienda");
		mnTienda.setForeground(UIHelper.COLOR_TEXTO);
		mnTienda.setFont(UIHelper.FONT_MENU);
		mnTienda.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				frame.dispose();
				new VentanaTienda().setVisible(true);
			}
		});
		menuBar.add(mnTienda);

		menuBar.add(javax.swing.Box.createHorizontalGlue());
		frame.setJMenuBar(menuBar);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(190, 40, 900, 580);
		panelPrincipal.setBackground(UIHelper.COLOR_TARJETA);
		panelPrincipal.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1, true));
		panelPrincipal.setLayout(null);
		frame.getContentPane().add(panelPrincipal);

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
					"¡Iniciando el juego exitosamente!\n" + listaJuegos.get(indiceJuegoActual).getTitulo(), 
					"Jugar", 
					JOptionPane.INFORMATION_MESSAGE
				);
			}
		});

		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaJuegos.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "No hay juegos para quitar.", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}

				JuegoDTO juegoQuitado = listaJuegos.get(indiceJuegoActual);

				juegosSet.remove(juegoQuitado);
				listaJuegos.remove(indiceJuegoActual);
				
				if (memoryApi != null) {
					memoryApi.quitarFavorito(juegoQuitado);
				}

				JOptionPane.showMessageDialog(frame, 
					"El juego '" + juegoQuitado.getTitulo() + "' fue quitado de la biblioteca correctamente.", 
					"Quitar", 
					JOptionPane.INFORMATION_MESSAGE
				);

				if (indiceJuegoActual >= listaJuegos.size() && indiceJuegoActual > 0) {
					indiceJuegoActual--;
				}

				actualizarJuegoActual();
			}
		});

		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaJuegos.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "No hay juegos disponibles.", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}
				JuegoDTO juegoActual = listaJuegos.get(indiceJuegoActual);
				String info = memoryApi.getInfoJuego(juegoActual);

				JOptionPane.showMessageDialog(frame, 
					"Información del Juego:\n" + info, 
					"Ver Info", 
					JOptionPane.INFORMATION_MESSAGE
				);
			}
		});
		
		btnBuscarRapido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoBusqueda = txtBuscarRapido.getText().trim();
				if (textoBusqueda.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Ingrese un título para buscar.", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}

				try {
					boolean encontrado = false;
					int indexEncontrado = -1;
					
					for (int i = 0; i < listaJuegos.size(); i++) {
						if (listaJuegos.get(i).getTitulo().equalsIgnoreCase(textoBusqueda) || 
							listaJuegos.get(i).getTitulo().toLowerCase().contains(textoBusqueda.toLowerCase())) {
							indexEncontrado = i;
							encontrado = true;
							break;
						}
					}

					if (encontrado) {
						indiceJuegoActual = indexEncontrado;
						actualizarJuegoActual();
						JOptionPane.showMessageDialog(frame, "¡Juego encontrado y seleccionado con éxito!", "Buscar", JOptionPane.INFORMATION_MESSAGE);
					} else {
						throw new JuegoNoEncontradoException("El juego '" + textoBusqueda + "' no fue encontrado.");
					}
				} catch (JuegoNoEncontradoException ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage(), "Juego No Encontrado", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		actualizarJuegoActual();
	}

	private void actualizarJuegoActual() {
		if (listaJuegos.isEmpty()) {
			lblVistaPrevia.setIcon(null);
			lblVistaPrevia.setText("Biblioteca Vacía");
			lblNombreJuego.setText("Sin juegos disponibles");
			return;
		}

		JuegoDTO juegoActual = listaJuegos.get(indiceJuegoActual);
		int idJuego = juegoActual.getId();
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
		
		lblNombreJuego.setText(juegoActual.getTitulo());
	}
}
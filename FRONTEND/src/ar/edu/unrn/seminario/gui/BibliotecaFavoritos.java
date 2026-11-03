package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ar.edu.unrn.seminario.api.IApi;
import ar.edu.unrn.seminario.dto.JuegoDTO;
import ar.edu.unrn.seminario.exception.CatalogoVacioException;
import ar.edu.unrn.seminario.helpers.UIHelper;

public class BibliotecaFavoritos extends JFrame {

	private IApi api;
	private JPanel panelListaJuegos;
	
	private JuegoDTO juegoSeleccionado;
	private final List<JPanel> filasJuegos = new ArrayList<>();
	
	public static void main(String[] args) {
	    java.awt.EventQueue.invokeLater(() -> {
	        try {
	            IApi apiPrueba = new ar.edu.unrn.seminario.api.MemoryApi();
	            BibliotecaFavoritos frame = new BibliotecaFavoritos(apiPrueba);
	            frame.setVisible(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    });
	}

	public BibliotecaFavoritos(IApi api) {
		this.api = api;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Mis Favoritos - EmuSwing");
		setSize(1000, 700);
		setLocationRelativeTo(null); // Centrar en pantalla

		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setBackground(UIHelper.COLOR_FONDO);
		setContentPane(contentPane);

		// ---------- ENCABEZADO ----------
		JPanel panelEncabezado = new JPanel(new BorderLayout());
		panelEncabezado.setBackground(UIHelper.COLOR_FONDO);
		panelEncabezado.setBorder(new EmptyBorder(20, 0, 20, 0));

		JLabel lblTitulo = new JLabel("Mis Favoritos", SwingConstants.CENTER);
		lblTitulo.setFont(UIHelper.FONT_TITULO);
		lblTitulo.setForeground(UIHelper.COLOR_TEXTO);
		
		JLabel lblSubtitulo = new JLabel("Tus juegos seleccionados", SwingConstants.CENTER);
		lblSubtitulo.setFont(UIHelper.FONT_SUBTITULO);
		lblSubtitulo.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);

		panelEncabezado.add(lblTitulo, BorderLayout.NORTH);
		panelEncabezado.add(lblSubtitulo, BorderLayout.SOUTH);
		contentPane.add(panelEncabezado, BorderLayout.NORTH);

		// ---------- CONTENEDOR CENTRAL ----------
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
		panelMargen.add(scrollPane, BorderLayout.CENTER);
		
		contentPane.add(panelMargen, BorderLayout.CENTER);

		// ---------- PANEL INFERIOR ----------
		JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
		panelAcciones.setBackground(UIHelper.COLOR_FONDO);
		
		JButton btnInfo = crearBotonAccion("Info", false);
		JButton btnQuitar = crearBotonAccion("Quitar de Favoritos", false);
		JButton btnJugar = crearBotonAccion("\u25B6 Jugar", true);
		JButton btnVolver = crearBotonAccion("← Volver", false);

		// Lógica Jugar
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

		// Lógica Info
		btnInfo.addActionListener(e -> {
			if (juegoSeleccionado == null) {
				javax.swing.JOptionPane.showMessageDialog(this, "Seleccioná un juego primero.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
				return;
			}
			mostrarInfoJuego(juegoSeleccionado);
		});
		
		// Lógica Quitar de Favoritos
		btnQuitar.addActionListener(e -> {
			if (juegoSeleccionado == null) {
				javax.swing.JOptionPane.showMessageDialog(this, "Seleccioná un juego primero.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// Quitamos el ID de la memoria
			api.quitarDeFavoritos(juegoSeleccionado.getId());
			
			javax.swing.JOptionPane.showMessageDialog(this, "Juego eliminado de tus favoritos.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			
			// Recargamos la interfaz para que desaparezca visualmente
			juegoSeleccionado = null;
			recargarLista();
		});
		
		// Logica volver hacia atras (ventana biblitoca)
		btnVolver.addActionListener(e -> {
			Biblioteca catalogo = new Biblioteca(api);
			catalogo.setVisible(true);
			dispose();
		});

		panelAcciones.add(btnVolver);
		panelAcciones.add(btnInfo);
		panelAcciones.add(btnQuitar);
		panelAcciones.add(btnJugar);
		contentPane.add(panelAcciones, BorderLayout.SOUTH);

		// ---------- CARGA INICIAL ----------
		cargarJuegos();
	}

	private void recargarLista() {
		panelListaJuegos.removeAll();
		filasJuegos.clear();
		cargarJuegos();
		panelListaJuegos.revalidate();
		panelListaJuegos.repaint();
	}

	private void cargarJuegos() {
		try {
			List<JuegoDTO> misFavoritos = api.obtenerJuegosFavoritos();
			for (JuegoDTO j : misFavoritos) {
				JPanel filaJuego = crearFilaJuego(j);
				panelListaJuegos.add(filaJuego);
				filasJuegos.add(filaJuego); 
				panelListaJuegos.add(javax.swing.Box.createRigidArea(new Dimension(0, 15)));
			}
		} catch (CatalogoVacioException e) {
			JLabel lblVacio = new JLabel(e.getMessage(), SwingConstants.CENTER);
			lblVacio.setFont(UIHelper.FONT_SUBTITULO);
			lblVacio.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
			panelListaJuegos.add(lblVacio);
		} catch (Exception e) {
			e.printStackTrace();
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
		if (juego.getId() == 1) nombreArchivo = "Street-Fighter-II-USA_cover_1024x705.jpg";
		else if (juego.getId() == 2) nombreArchivo = "doom_1993_cover_720x1080.jpg"; 
		else if (juego.getId() == 3) nombreArchivo = "Wolfenstein 3D (PC Version).jpg";
		else if (juego.getId() == 4) nombreArchivo = "Super-Mario-Word_1990_cover_474x332.jpg"; 

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
		if (juego.getId() == 1) historia = "El World Warrior Tournament sigue en pie...";
		else if (juego.getId() == 2) historia = "En el año 2145, fuiste enviado a Marte...";
		else if (juego.getId() == 3) historia = "Atrapado tras las oscuras líneas enemigas...";
		else if (juego.getId() == 4) historia = "Unas merecidas vacaciones en la misteriosa Isla...";
		else historia = "Historia no disponible.";
		
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
		
		if (relleno) boton.setBorder(new EmptyBorder(8, 20, 8, 20));
		else boton.setBorder(new CompoundBorder(new LineBorder(UIHelper.COLOR_ACENTO, 2, true), new EmptyBorder(6, 18, 6, 18)));
		
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

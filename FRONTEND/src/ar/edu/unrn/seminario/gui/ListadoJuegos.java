package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import ar.edu.unrn.seminario.api.IApi;
import ar.edu.unrn.seminario.api.PersistenceApi;
import ar.edu.unrn.seminario.dao.ConnectionManager;
import ar.edu.unrn.seminario.dao.JuegoDAOJDBC;
import ar.edu.unrn.seminario.dto.JuegoDTO;
import ar.edu.unrn.seminario.exception.CatalogoVacioException;
import ar.edu.unrn.seminario.helpers.ImagenHelper;
import ar.edu.unrn.seminario.helpers.UIHelper;

public class ListadoJuegos extends JFrame {

	public ListadoJuegos(IApi api) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Catálogo de Juegos");
		setSize(UIHelper.ANCHO_CONTENIDO, UIHelper.ALTO_CONTENIDO);
		setLocationRelativeTo(null);

		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setBackground(UIHelper.COLOR_FONDO);
		setContentPane(contentPane);

		JLabel lblTituloPantalla = new JLabel("CATÁLOGO DE JUEGOS", SwingConstants.CENTER);
		lblTituloPantalla.setFont(UIHelper.FONT_TITULO);
		lblTituloPantalla.setForeground(UIHelper.COLOR_TEXTO);
		lblTituloPantalla.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		contentPane.add(lblTituloPantalla, BorderLayout.NORTH);

		JPanel panelGrilla = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelGrilla.setBackground(UIHelper.COLOR_FONDO);

		// Solicitamos los juegos a la API (simulacion con los juegos de prueba cargados)
				try {
					List<JuegoDTO> juegos = api.obtenerJuegos();
					
					for (JuegoDTO j : juegos) {
						JPanel tarjeta = crearTarjetaJuego(j);
						
						tarjeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
						
						tarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
							
							@Override
							public void mouseClicked(java.awt.event.MouseEvent evt) {
								String urlJuego = j.getUrlEmulador();
								
								if (urlJuego != null) {
									try {
										VentanaJuego ventanaJuego = new VentanaJuego(api, j.getId(), urlJuego);
										ventanaJuego.setVisible(true);
									} catch (Exception ex) {
										ex.printStackTrace();
										javax.swing.JOptionPane.showMessageDialog(ListadoJuegos.this, 
											"Error al intentar iniciar el emulador web.", 
											"Error", javax.swing.JOptionPane.ERROR_MESSAGE);
									}
								} else {
									javax.swing.JOptionPane.showMessageDialog(ListadoJuegos.this, 
										"El enlace para este juego no está disponible.", 
										"Juego no disponible", javax.swing.JOptionPane.WARNING_MESSAGE);
								}
							}
						});

						panelGrilla.add(tarjeta);
					}
				} catch (CatalogoVacioException e) {
					JLabel lblVacio = new JLabel(e.getMessage());
					lblVacio.setFont(UIHelper.FONT_SUBTITULO);
					lblVacio.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
					panelGrilla.add(lblVacio);
		            
				} catch (Exception e) {
					javax.swing.JOptionPane.showMessageDialog(this, 
						"Ocurrió un error al cargar los juegos.", 
						"Error", javax.swing.JOptionPane.ERROR_MESSAGE);
				}
				
		// ScrollPane para navegacion mas comoda entre los juegos
		JScrollPane scrollPane = new JScrollPane(panelGrilla);
		scrollPane.setBorder(null); 
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); 
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(UIHelper.COLOR_FONDO);
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.setFont(UIHelper.FONT_BOTON);
		btnCerrar.setBackground(UIHelper.COLOR_CONTENIDO);
		btnCerrar.setForeground(UIHelper.COLOR_TEXTO);
		btnCerrar.setFocusPainted(false);
		btnCerrar.addActionListener(e -> dispose());
		panelBotones.add(btnCerrar);
		
		contentPane.add(panelBotones, BorderLayout.SOUTH);
	}

	
	// LOGICA TEMPORAL PARA CARGAR LAS IMAGENES 
	private JPanel crearTarjetaJuego(JuegoDTO juego) {
		JPanel tarjeta = new JPanel(new BorderLayout());
		tarjeta.setPreferredSize(new Dimension(UIHelper.ANCHO_TARJETA, UIHelper.ALTO_TARJETA));
		tarjeta.setBackground(UIHelper.COLOR_TARJETA);
		tarjeta.setBorder(BorderFactory.createLineBorder(UIHelper.COLOR_BORDE, 2));

		JLabel lblImagen = new JLabel();
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setPreferredSize(new Dimension(UIHelper.ANCHO_PORTADA, UIHelper.ALTO_PORTADA));
		ImagenHelper.cargarImagen(juego.getUrlPortada(), juego.getTitulo(), lblImagen,
				UIHelper.ANCHO_PORTADA, UIHelper.ALTO_PORTADA);
		
		tarjeta.add(lblImagen, BorderLayout.CENTER);

		JPanel panelDatos = new JPanel(new BorderLayout());
		panelDatos.setBackground(UIHelper.COLOR_TARJETA);
		panelDatos.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JLabel lblTitulo = new JLabel(juego.getTitulo(), SwingConstants.CENTER);
		lblTitulo.setFont(UIHelper.FONT_TARJETA);
		lblTitulo.setForeground(UIHelper.COLOR_TEXTO);
		panelDatos.add(lblTitulo, BorderLayout.CENTER);

		tarjeta.add(panelDatos, BorderLayout.SOUTH);

		return tarjeta;
	}

	// Método MAIN temporal hasta que biblioteca este listo
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			try {
				ConnectionManager.getConnection();
				IApi api = new PersistenceApi(new JuegoDAOJDBC());
				ListadoJuegos frame = new ListadoJuegos(api);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
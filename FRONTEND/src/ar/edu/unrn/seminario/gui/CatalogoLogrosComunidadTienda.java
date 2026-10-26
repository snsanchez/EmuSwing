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

public class CatalogoLogrosComunidadTienda extends JFrame {

	private JPanel contentPane;
     
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogoLogrosComunidadTienda frame = new CatalogoLogrosComunidadTienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CatalogoLogrosComunidadTienda() {
		setTitle("Catálogo De Logros: Comunidad y Tienda");
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
		lblTitulo.setFont (UIHelper.FONT_TITULO); 
		lblTitulo.setForeground(UIHelper.COLOR_TEXTO);
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setFont(UIHelper.FONT_TITULO.deriveFont(40f));	

		JLabel lblSubtitulo = new JLabel("Comunidad y Tienda");
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
		
		// Corre los logros 100 pixeles hacia abajo (queda mejor visualmente)
		panelListaLogros.add(Box.createVerticalStrut(100));

		// ==========================================
		// --- SECCIÓN 1: INTERACCIÓN ---
		// ==========================================
		
		JLabel lblTituloInteraccion = new JLabel("INTERACCIÓN SOCIAL");
		lblTituloInteraccion.setFont(UIHelper.FONT_TITULO);
		lblTituloInteraccion.setForeground(UIHelper.COLOR_BORDE);
		lblTituloInteraccion.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIHelper.COLOR_BORDE));
		lblTituloInteraccion.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTituloInteraccion.setMaximumSize(new Dimension(800, 30));
		panelListaLogros.add(lblTituloInteraccion);
		
		panelListaLogros.add(Box.createVerticalStrut(15));

		// --- TARJETA: NO ESTOY SOLO ---
		JPanel panelLogroSolo = new JPanel(new BorderLayout(5, 5));
		panelLogroSolo.setBackground(UIHelper.COLOR_CONTENIDO);
		panelLogroSolo.setBorder(new CompoundBorder(BorderFactory.createLineBorder(UIHelper.COLOR_BORDE, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroSolo.setMaximumSize(new Dimension(800, 70));
		panelLogroSolo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupSolo = new JPanel(new BorderLayout());
		panelSupSolo.setOpaque(false);
		JLabel lblTitSolo = new JLabel("No estoy solo");
		lblTitSolo.setFont(UIHelper.FONT_MENU.deriveFont(18f)); 
		lblTitSolo.setForeground(UIHelper.COLOR_TEXTO);
		panelSupSolo.add(lblTitSolo, BorderLayout.WEST);
		JLabel lblPtsSolo = new JLabel("15 PTS");
		lblPtsSolo.setFont(UIHelper.FONT_TEXTFIELDS);
		lblPtsSolo.setForeground(UIHelper.COLOR_PUNTOS);
		panelSupSolo.add(lblPtsSolo, BorderLayout.EAST);
		JLabel lblDescSolo = new JLabel("Agregar tu primer amigo.");
		lblDescSolo.setFont(UIHelper.FONT_TEXTFIELDS);
		lblDescSolo.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		
		panelLogroSolo.add(panelSupSolo, BorderLayout.NORTH);
		panelLogroSolo.add(lblDescSolo, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroSolo);
		panelListaLogros.add(Box.createVerticalStrut(10));

		// --- TARJETA: SOCIAL MEDIA ---
		JPanel panelLogroSocial = new JPanel(new BorderLayout(5, 5));
		panelLogroSocial.setBackground(UIHelper.COLOR_CONTENIDO);
		panelLogroSocial.setBorder(new CompoundBorder(BorderFactory.createLineBorder(UIHelper.COLOR_BORDE, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroSocial.setMaximumSize(new Dimension(800, 70));
		panelLogroSocial.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupSocial = new JPanel(new BorderLayout());
		panelSupSocial.setOpaque(false);
		JLabel lblTitSocial = new JLabel("Social Media");
		lblTitSocial.setFont(UIHelper.FONT_MENU.deriveFont(18f));
		lblTitSocial.setForeground(UIHelper.COLOR_TEXTO);
		panelSupSocial.add(lblTitSocial, BorderLayout.WEST);
		JLabel lblPtsSocial = new JLabel("35 PTS");
		lblPtsSocial.setFont(UIHelper.FONT_TEXTFIELDS);
		lblPtsSocial.setForeground(UIHelper.COLOR_PUNTOS);
		panelSupSocial.add(lblPtsSocial, BorderLayout.EAST);
		JLabel lblDescSocial = new JLabel("Agregar 5 amigos.");
		lblDescSocial.setFont(UIHelper.FONT_TEXTFIELDS);
		lblDescSocial.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		
		panelLogroSocial.add(panelSupSocial, BorderLayout.NORTH);
		panelLogroSocial.add(lblDescSocial, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroSocial);
		panelListaLogros.add(Box.createVerticalStrut(25));

		// ==========================================
		// --- SECCIÓN 2: ESPECIALES Y TIENDA ---
		// ==========================================
		
		JLabel lblTituloTienda = new JLabel("ESPECIALES Y TIENDA");
		lblTituloTienda.setFont(UIHelper.FONT_TITULO);
		lblTituloTienda.setForeground(UIHelper.COLOR_BORDE);
		lblTituloTienda.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIHelper.COLOR_BORDE));
		lblTituloTienda.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTituloTienda.setMaximumSize(new Dimension(800, 30));
		panelListaLogros.add(lblTituloTienda);
		
		panelListaLogros.add(Box.createVerticalStrut(15));

		// --- TARJETA: CLIENTE FRECUENTE ---
		JPanel panelLogroCliente = new JPanel(new BorderLayout(5, 5));
		panelLogroCliente.setBackground(UIHelper.COLOR_CONTENIDO);
		panelLogroCliente.setBorder(new CompoundBorder(BorderFactory.createLineBorder(UIHelper.COLOR_BORDE, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogroCliente.setMaximumSize(new Dimension(800, 70));
		panelLogroCliente.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panelSupCliente = new JPanel(new BorderLayout());
		panelSupCliente.setOpaque(false);
		JLabel lblTitCliente = new JLabel("Cliente Frecuente");
		lblTitCliente.setFont(UIHelper.FONT_MENU.deriveFont(18f));
		lblTitCliente.setForeground(UIHelper.COLOR_TEXTO);
		panelSupCliente.add(lblTitCliente, BorderLayout.WEST);
		JLabel lblPtsCliente = new JLabel("50 PTS");
		lblPtsCliente.setFont(UIHelper.FONT_TEXTFIELDS);
		lblPtsCliente.setForeground(UIHelper.COLOR_PUNTOS);
		panelSupCliente.add(lblPtsCliente, BorderLayout.EAST);
		JLabel lblDescCliente = new JLabel("Renovar la Suscripción (Mes 2).");
		lblDescCliente.setFont(UIHelper.FONT_TEXTFIELDS);
		lblDescCliente.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		
		panelLogroCliente.add(panelSupCliente, BorderLayout.NORTH);
		panelLogroCliente.add(lblDescCliente, BorderLayout.CENTER);
		panelListaLogros.add(panelLogroCliente);

		// Configuración final del ScrollPane
		JScrollPane scrollPane = new JScrollPane(panelListaLogros);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);

		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
}
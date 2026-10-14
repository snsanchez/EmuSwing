package ar.edu.unrn.seminario.gui;
import ar.edu.unrn.seminario.helpers.UIHelper;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;

public class Biblioteca2 {

	private JFrame frame;

	// Paleta de colores EmuSwing

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
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Biblioteca (Vista Detalle) - EmuSwing");
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(UIHelper.COLOR_FONDO_PRINCIPAL);

		// Barra de Menú
		// JMenuBar centrado estilo Home
				JMenuBar menuBar = new JMenuBar();
				menuBar.setBackground(UIHelper.COLOR_FONDO_PRINCIPAL);
				menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIHelper.COLOR_PANEL));

				// Espaciador para centrar las opciones
				menuBar.add(javax.swing.Box.createHorizontalGlue());

				JMenu mnPerfil = new JMenu("Mi Perfil");
				mnPerfil.setForeground(UIHelper.COLOR_TEXTO);
				mnPerfil.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnPerfil);

				JMenu mnBiblioteca = new JMenu("Biblioteca");
				mnBiblioteca.setForeground(UIHelper.COLOR_TEXTO);
				mnBiblioteca.setFont(new Font("SansSerif", Font.BOLD, 13));
				menuBar.add(mnBiblioteca);

				JMenu mnJuegos = new JMenu("Juegos");
				mnJuegos.setForeground(UIHelper.COLOR_TEXTO);
				mnJuegos.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnJuegos);

				JMenu mnTienda = new JMenu("Tienda");
				mnTienda.setForeground(UIHelper.COLOR_TEXTO);
				mnTienda.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnTienda);

				JMenu mnSoporte = new JMenu("Soporte");
				mnSoporte.setForeground(UIHelper.COLOR_TEXTO);
				mnSoporte.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnSoporte);

				JMenu mnAjustes = new JMenu("Ajustes");
				mnAjustes.setForeground(UIHelper.COLOR_TEXTO);
				mnAjustes.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnAjustes);

				// Espaciador derecho para empujar todo al centro
				menuBar.add(javax.swing.Box.createHorizontalGlue());

				frame.setJMenuBar(menuBar);			// Panel Principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(190, 40, 900, 580);
		panelPrincipal.setBackground(UIHelper.COLOR_PANEL);
		panelPrincipal.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1, true));
		panelPrincipal.setLayout(null);
		frame.getContentPane().add(panelPrincipal);

		// Título de la vista
		JLabel lblTitulo = new JLabel("Explorar Biblioteca");
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblTitulo.setForeground(UIHelper.COLOR_TEXTO);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 25, 900, 35);
		panelPrincipal.add(lblTitulo);

		// Botón Anterior (<-)
		JButton btnPrev = new JButton("◄");
		btnPrev.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnPrev.setBounds(120, 200, 60, 180);
		btnPrev.setBackground(UIHelper.COLOR_TARJETA);
		btnPrev.setForeground(UIHelper.COLOR_TEXTO);
		btnPrev.setFocusPainted(false);
		btnPrev.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelPrincipal.add(btnPrev);

		// Card central del juego
		JPanel panelCard = new JPanel();
		panelCard.setBackground(UIHelper.COLOR_TARJETA);
		panelCard.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1, true));
		panelCard.setBounds(230, 90, 440, 380);
		panelCard.setLayout(null);
		panelPrincipal.add(panelCard);

		JLabel lblNombreJuego = new JLabel("Super Mario World");
		lblNombreJuego.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNombreJuego.setForeground(UIHelper.COLOR_TEXTO);
		lblNombreJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJuego.setBounds(20, 320, 400, 30);
		panelCard.add(lblNombreJuego);

		JLabel lblVistaPrevia = new JLabel("[ Imagen / Carátula ]");
		lblVistaPrevia.setFont(new Font("SansSerif", Font.ITALIC, 14));
		lblVistaPrevia.setForeground(UIHelper.COLOR_TEXTO_MUTED);
		lblVistaPrevia.setHorizontalAlignment(SwingConstants.CENTER);
		lblVistaPrevia.setBounds(20, 20, 400, 280);
		lblVistaPrevia.setBorder(new LineBorder(UIHelper.COLOR_PANEL, 1));
		panelCard.add(lblVistaPrevia);

		// Botón Siguiente (->)
		JButton btnNext = new JButton("►");
		btnNext.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNext.setBounds(720, 200, 60, 180);
		btnNext.setBackground(UIHelper.COLOR_TARJETA);
		btnNext.setForeground(UIHelper.COLOR_TEXTO);
		btnNext.setFocusPainted(false);
		btnNext.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelPrincipal.add(btnNext);

		// Acciones inferiores
		JButton btnPlay = new JButton("► Jugar");
		btnPlay.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnPlay.setBounds(280, 500, 160, 42);
		btnPlay.setBackground(UIHelper.COLOR_ACCENTO);
		btnPlay.setForeground(UIHelper.COLOR_TEXTO);
		btnPlay.setFocusPainted(false);
		btnPlay.setBorder(BorderFactory.createEmptyBorder());
		panelPrincipal.add(btnPlay);

		JButton btnRemove = new JButton("Quitar");
		btnRemove.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnRemove.setBounds(460, 500, 160, 42);
		btnRemove.setBackground(UIHelper.COLOR_TARJETA);
		btnRemove.setForeground(UIHelper.COLOR_TEXTO);
		btnRemove.setFocusPainted(false);
		btnRemove.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelPrincipal.add(btnRemove);

		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}

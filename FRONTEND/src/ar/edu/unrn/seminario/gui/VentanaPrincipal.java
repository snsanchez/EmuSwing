// by: Santiago Sánchez
package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ar.edu.unrn.seminario.api.IApi;
import ar.edu.unrn.seminario.api.MemoryApi;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IApi api = new MemoryApi();
					VentanaPrincipal frame = new VentanaPrincipal(api);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal(IApi api) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Home - EmuSwing");
		setSize(1426, 780);
		setLocationRelativeTo(null);
		setResizable(false);

		// --------- CONTENT PANE

		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		
		contentPane.setBackground(
		        new Color(35, 15, 45)
		);
		
		setContentPane(contentPane);
		

		// ---------- BARRA DE NAVEGACIÓN

		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);

		JPanel panelMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

		JButton btnMiPerfil = new JButton("Mi Perfil");
		panelMenu.add(btnMiPerfil);

		JButton btnBiblioteca = new JButton("Biblioteca");
		panelMenu.add(btnBiblioteca);

		JButton btnJuegos = new JButton("Juegos");
		panelMenu.add(btnJuegos);

		JButton btnTienda = new JButton("Tienda");
		panelMenu.add(btnTienda);

		JButton btnSoporte = new JButton("Soporte");
		panelMenu.add(btnSoporte);

		JButton btnAjustes = new JButton("Ajustes");
		panelMenu.add(btnAjustes);

		menuBar.add(panelMenu);

		// ---------- PANEL PRINCIPAL

		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.setBackground(
		        new Color(35, 15, 45)
		);
		contentPane.add(panelPrincipal, BorderLayout.CENTER);


		JPanel panelCentrador = new JPanel(new GridBagLayout());
		panelCentrador.setBackground(
		        new Color(35, 15, 45)
		);

		panelPrincipal.add(panelCentrador, BorderLayout.CENTER);

		GridBagConstraints gbcPanelHome = new GridBagConstraints();
		gbcPanelHome.gridx = 0;
		gbcPanelHome.gridy = 0;
		gbcPanelHome.anchor = GridBagConstraints.CENTER;

		// ------------------- HOME

		JPanel panelHome = new JPanel(new BorderLayout(0, 20));

		panelHome.setBorder(new EmptyBorder(20, 40, 20, 40));

		panelHome.setBackground(new Color(35, 15, 45));

		panelCentrador.add(panelHome, gbcPanelHome);

		// ------------ LOGO

		JPanel panelLogo = new JPanel(new FlowLayout(FlowLayout.CENTER));

		panelLogo.setOpaque(false);

		URL imgURL = getClass().getResource("/img/esw-logo.png");

		if (imgURL != null) {

			ImageIcon iconOriginal = new ImageIcon(imgURL);

			Image imagenEscalada = iconOriginal.getImage().getScaledInstance(200, 158, java.awt.Image.SCALE_SMOOTH);

			JLabel lblLogo = new JLabel(new ImageIcon(imagenEscalada));

			panelLogo.add(lblLogo);

		} else {

			JLabel lblLogo = new JLabel("EmuSwing");

			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);

			panelLogo.add(lblLogo);

			System.out.println("No se encontró la imagen: /img/esw-logo.png");
		}

		panelHome.add(panelLogo, BorderLayout.NORTH);

		// ----------- CONTENIDO

		JPanel panelContenido = new JPanel(new BorderLayout(0, 20));
		panelContenido.setBackground(
		        new Color(74, 36, 92)
		);

		panelContenido.setBorder(new LineBorder(
                new Color(169, 65, 196),
                2,
                true
        ));

		panelHome.add(panelContenido, BorderLayout.CENTER);

		// ------------ BIENVENIDA
		
		JPanel panelBienvenida = new JPanel(new FlowLayout(FlowLayout.CENTER));

		panelBienvenida.setOpaque(false);

		JLabel lblBienvenida = new JLabel("Bienvenido a EmuSwing");
		lblBienvenida.setForeground(
		        new Color(245, 240, 247)
		);

		panelBienvenida.add(lblBienvenida);

		panelContenido.add(panelBienvenida, BorderLayout.NORTH);

		// ------------ ÚLTIMOS JUEGOS

		JPanel panelUltimosJuegos = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

		panelUltimosJuegos.setOpaque(false);

		JLabel lblUltimoJuegoJugado = new JLabel("Últimos juegos");
		lblUltimoJuegoJugado.setForeground(
		        new Color(245, 240, 247)
		);
		
		panelUltimosJuegos.add(lblUltimoJuegoJugado);

		// datos de prueba 

		String[] ultimosJuegos = { "Super Street Fighter II", "Super Mario World", "Doom" };

		JComboBox<String> comboUltimosJuegos = new JComboBox<String>(ultimosJuegos);

		comboUltimosJuegos.setPreferredSize(new java.awt.Dimension(250, 25));

		panelUltimosJuegos.add(comboUltimosJuegos);

		panelContenido.add(panelUltimosJuegos, BorderLayout.CENTER);

		// --------- ACCIONES
	
		JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

		panelAcciones.setOpaque(false);

		JButton btnJugar = new JButton("Jugar");

		panelAcciones.add(btnJugar);

		panelContenido.add(panelAcciones, BorderLayout.SOUTH);

		// -------- EVENTOS
		
		btnJugar.addActionListener(e -> {

			String juegoSeleccionado = (String) comboUltimosJuegos.getSelectedItem();

			System.out.println("Jugar: " + juegoSeleccionado);
		});

		btnAjustes.addActionListener(e -> {

			System.out.println("Abrir Ajustes");
		});
	}
}
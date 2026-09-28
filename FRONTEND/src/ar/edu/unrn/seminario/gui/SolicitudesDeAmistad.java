package ar.edu.unrn.seminario.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;

public class SolicitudesDeAmistad extends JFrame {
	private final JLabel lblNewLabel = new JLabel("Solicitudes de amistad");
	private final JLabel lblContador = new JLabel("Solicitudes pendientes: 7");

	private final Color COLOR_FONDO_MAIN = new Color(35, 15, 45);
	private final Color COLOR_PANEL_BOX = new Color(74, 36, 92);
	private final Color COLOR_BORDE_NEON = new Color(169, 65, 196);
	private final Color COLOR_LETRAS = new Color(245, 240, 247);

	public SolicitudesDeAmistad() {
		getContentPane().setBackground(COLOR_FONDO_MAIN);

		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
		panelSuperior.setBackground(COLOR_FONDO_MAIN);
		panelSuperior.setBorder(BorderFactory.createEmptyBorder(20, 0, 15, 0));

		lblNewLabel.setText("SOLICITUDES DE AMISTAD");
		lblNewLabel.setAlignmentX(CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(COLOR_FONDO_MAIN);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));

		lblContador.setText("Solicitudes pendientes: 7");
		lblContador.setAlignmentX(CENTER_ALIGNMENT);
		lblContador.setHorizontalAlignment(SwingConstants.CENTER);
		lblContador.setForeground(COLOR_BORDE_NEON);
		lblContador.setBackground(COLOR_FONDO_MAIN);
		lblContador.setOpaque(true);
		lblContador.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblContador.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 12));
		lblContador.setPreferredSize(new Dimension(300, 25));

		panelSuperior.add(lblNewLabel);
		panelSuperior.add(lblContador);

		getContentPane().add(panelSuperior, BorderLayout.NORTH);

		JPanel panelSolicitudes = new JPanel();
		panelSolicitudes.setLayout(new BoxLayout(panelSolicitudes, BoxLayout.Y_AXIS));
		panelSolicitudes.setBackground(COLOR_FONDO_MAIN);

		JScrollPane scrollPane = new JScrollPane(panelSolicitudes);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(COLOR_FONDO_MAIN);
		scrollPane.getViewport().setBackground(COLOR_FONDO_MAIN);
		scrollPane.setBorder(BorderFactory.createLineBorder(COLOR_BORDE_NEON));

		getContentPane().add(scrollPane, BorderLayout.CENTER);

		// Solicitud 1
		JPanel panel = new JPanel();
		panelSolicitudes.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.setBackground(COLOR_PANEL_BOX);
		panel.setPreferredSize(new Dimension(0, 80));
		panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

		TitledBorder bordeSolicitud1 = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON),
				"Solicitud"
		);
		bordeSolicitud1.setTitleColor(COLOR_LETRAS);
		panel.setBorder(bordeSolicitud1);

		JLabel lblUsuario = new JLabel("messipro");
		estilizarLabelUsuario(lblUsuario);
		panel.add(lblUsuario);

		JButton btnVerPerfil = new JButton("Ver perfil");
		estilizarBoton(btnVerPerfil);
		panel.add(btnVerPerfil);

		JButton btnAceptar = new JButton("Aceptar");
		estilizarBoton(btnAceptar);
		panel.add(btnAceptar);

		JButton btnRechazar = new JButton("Rechazar");
		estilizarBoton(btnRechazar);
		panel.add(btnRechazar);

		// Solicitud 2
		JPanel panel_2 = new JPanel();
		panelSolicitudes.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_2.setBackground(COLOR_PANEL_BOX);
		panel_2.setPreferredSize(new Dimension(0, 80));
		panel_2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

		TitledBorder bordeSolicitud2 = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON),
				"Solicitud"
		);
		bordeSolicitud2.setTitleColor(COLOR_LETRAS);
		panel_2.setBorder(bordeSolicitud2);

		JLabel lblUsuario2 = new JLabel("ennervalencia3");
		estilizarLabelUsuario(lblUsuario2);
		panel_2.add(lblUsuario2);

		JButton btnVerPerfil2 = new JButton("Ver perfil");
		estilizarBoton(btnVerPerfil2);
		panel_2.add(btnVerPerfil2);

		JButton btnAceptar2 = new JButton("Aceptar");
		estilizarBoton(btnAceptar2);
		panel_2.add(btnAceptar2);

		JButton btnRechazar2 = new JButton("Rechazar");
		estilizarBoton(btnRechazar2);
		panel_2.add(btnRechazar2);

		// Solicitud 3
		JPanel panel_3 = new JPanel();
		panelSolicitudes.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_3.setBackground(COLOR_PANEL_BOX);
		panel_3.setPreferredSize(new Dimension(0, 80));
		panel_3.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

		TitledBorder bordeSolicitud3 = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON),
				"Solicitud"
		);
		bordeSolicitud3.setTitleColor(COLOR_LETRAS);
		panel_3.setBorder(bordeSolicitud3);

		JLabel lblUsuario3 = new JLabel("ronaldogamer7");
		estilizarLabelUsuario(lblUsuario3);
		panel_3.add(lblUsuario3);

		JButton btnVerPerfil3 = new JButton("Ver perfil");
		estilizarBoton(btnVerPerfil3);
		panel_3.add(btnVerPerfil3);

		JButton btnAceptar3 = new JButton("Aceptar");
		estilizarBoton(btnAceptar3);
		panel_3.add(btnAceptar3);

		JButton btnRechazar3 = new JButton("Rechazar");
		estilizarBoton(btnRechazar3);
		panel_3.add(btnRechazar3);

		// Solicitud 4
		JPanel panel_4 = new JPanel();
		panelSolicitudes.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_4.setBackground(COLOR_PANEL_BOX);
		panel_4.setPreferredSize(new Dimension(0, 80));
		panel_4.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

		TitledBorder bordeSolicitud4 = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON),
				"Solicitud"
		);
		bordeSolicitud4.setTitleColor(COLOR_LETRAS);
		panel_4.setBorder(bordeSolicitud4);

		JLabel lblUsuario4 = new JLabel("tuquini");
		estilizarLabelUsuario(lblUsuario4);
		panel_4.add(lblUsuario4);

		JButton btnVerPerfil4 = new JButton("Ver perfil");
		estilizarBoton(btnVerPerfil4);
		panel_4.add(btnVerPerfil4);

		JButton btnAceptar4 = new JButton("Aceptar");
		estilizarBoton(btnAceptar4);
		panel_4.add(btnAceptar4);

		JButton btnRechazar4 = new JButton("Rechazar");
		estilizarBoton(btnRechazar4);
		panel_4.add(btnRechazar4);

		// Solicitud 5
		JPanel panel_5 = new JPanel();
		panelSolicitudes.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_5.setBackground(COLOR_PANEL_BOX);
		panel_5.setPreferredSize(new Dimension(0, 80));
		panel_5.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

		TitledBorder bordeSolicitud5 = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON),
				"Solicitud"
		);
		bordeSolicitud5.setTitleColor(COLOR_LETRAS);
		panel_5.setBorder(bordeSolicitud5);

		JLabel lblUsuario5 = new JLabel("ramiya11");
		estilizarLabelUsuario(lblUsuario5);
		panel_5.add(lblUsuario5);

		JButton btnVerPerfil5 = new JButton("Ver perfil");
		estilizarBoton(btnVerPerfil5);
		panel_5.add(btnVerPerfil5);

		JButton btnAceptar5 = new JButton("Aceptar");
		estilizarBoton(btnAceptar5);
		panel_5.add(btnAceptar5);

		JButton btnRechazar5 = new JButton("Rechazar");
		estilizarBoton(btnRechazar5);
		panel_5.add(btnRechazar5);

		// Solicitud 6
		JPanel panel_6 = new JPanel();
		panelSolicitudes.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_6.setBackground(COLOR_PANEL_BOX);
		panel_6.setPreferredSize(new Dimension(0, 80));
		panel_6.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

		TitledBorder bordeSolicitud6 = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON),
				"Solicitud"
		);
		bordeSolicitud6.setTitleColor(COLOR_LETRAS);
		panel_6.setBorder(bordeSolicitud6);

		JLabel lblUsuario6 = new JLabel("elpepe67");
		estilizarLabelUsuario(lblUsuario6);
		panel_6.add(lblUsuario6);

		JButton btnVerPerfil6 = new JButton("Ver perfil");
		estilizarBoton(btnVerPerfil6);
		panel_6.add(btnVerPerfil6);

		JButton btnAceptar6 = new JButton("Aceptar");
		estilizarBoton(btnAceptar6);
		panel_6.add(btnAceptar6);

		JButton btnRechazar6 = new JButton("Rechazar");
		estilizarBoton(btnRechazar6);
		panel_6.add(btnRechazar6);

		// Solicitud 7
		JPanel panel_7 = new JPanel();
		panelSolicitudes.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_7.setBackground(COLOR_PANEL_BOX);
		panel_7.setPreferredSize(new Dimension(0, 80));
		panel_7.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

		TitledBorder bordeSolicitud7 = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON),
				"Solicitud"
		);
		bordeSolicitud7.setTitleColor(COLOR_LETRAS);
		panel_7.setBorder(bordeSolicitud7);

		JLabel lblUsuario7 = new JLabel("santwo");
		estilizarLabelUsuario(lblUsuario7);
		panel_7.add(lblUsuario7);

		JButton btnVerPerfil7 = new JButton("Ver perfil");
		estilizarBoton(btnVerPerfil7);
		panel_7.add(btnVerPerfil7);

		JButton btnAceptar7 = new JButton("Aceptar");
		estilizarBoton(btnAceptar7);
		panel_7.add(btnAceptar7);

		JButton btnRechazar7 = new JButton("Rechazar");
		estilizarBoton(btnRechazar7);
		panel_7.add(btnRechazar7);

		// Panel inferior con botón cerrar
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(COLOR_FONDO_MAIN);
		getContentPane().add(panelInferior, BorderLayout.SOUTH);

		JButton btnCerrar = new JButton("Cerrar");
		estilizarBoton(btnCerrar);
		panelInferior.add(btnCerrar);

		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	private void estilizarBoton(JButton boton) {
		boton.setUI(new BasicButtonUI());

		boton.setBackground(COLOR_FONDO_MAIN);
		boton.setForeground(COLOR_LETRAS);

		boton.setFont(new Font("Tahoma", Font.BOLD, 11));

		boton.setFocusPainted(false);
		boton.setOpaque(true);
		boton.setContentAreaFilled(true);
		boton.setBorderPainted(true);

		boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		boton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));

		boton.setPreferredSize(new Dimension(105, 30));
	}

	private void estilizarLabelUsuario(JLabel label) {
		label.setForeground(COLOR_LETRAS);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setPreferredSize(new Dimension(180, 30));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
	}

	public static void main(String[] args) {
		SolicitudesDeAmistad ventana = new SolicitudesDeAmistad();
		ventana.setSize(500, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ventana.setVisible(true);
	}
}

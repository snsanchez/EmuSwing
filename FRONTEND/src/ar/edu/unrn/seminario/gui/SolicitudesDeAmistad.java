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
import java.awt.EventQueue;

public class SolicitudesDeAmistad extends JFrame {

	private static final long serialVersionUID = 1L;

	private final JLabel lblNewLabel = new JLabel("Solicitudes de amistad");
	private final JLabel lblContador = new JLabel("Solicitudes pendientes: 7");

	private final Color COLOR_FONDO_MAIN = new Color(35, 15, 45);
	private final Color COLOR_PANEL_BOX = new Color(74, 36, 92);
	private final Color COLOR_BORDE_NEON = new Color(169, 65, 196);
	private final Color COLOR_LETRAS = new Color(245, 240, 247);

	public SolicitudesDeAmistad() {
		setTitle("Solicitudes de amistad");
		setBounds(100, 100, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

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
		lblUsuario.setForeground(COLOR_LETRAS);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setPreferredSize(new Dimension(180, 30));
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblUsuario);

		JButton btnVerPerfil = new JButton("Ver perfil");
		btnVerPerfil.setUI(new BasicButtonUI());
		btnVerPerfil.setBackground(COLOR_FONDO_MAIN);
		btnVerPerfil.setForeground(COLOR_LETRAS);
		btnVerPerfil.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerPerfil.setFocusPainted(false);
		btnVerPerfil.setOpaque(true);
		btnVerPerfil.setContentAreaFilled(true);
		btnVerPerfil.setBorderPainted(true);
		btnVerPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVerPerfil.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnVerPerfil.setPreferredSize(new Dimension(105, 30));
		panel.add(btnVerPerfil);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setUI(new BasicButtonUI());
		btnAceptar.setBackground(COLOR_FONDO_MAIN);
		btnAceptar.setForeground(COLOR_LETRAS);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setFocusPainted(false);
		btnAceptar.setOpaque(true);
		btnAceptar.setContentAreaFilled(true);
		btnAceptar.setBorderPainted(true);
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnAceptar.setPreferredSize(new Dimension(105, 30));
		panel.add(btnAceptar);

		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.setUI(new BasicButtonUI());
		btnRechazar.setBackground(COLOR_FONDO_MAIN);
		btnRechazar.setForeground(COLOR_LETRAS);
		btnRechazar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechazar.setFocusPainted(false);
		btnRechazar.setOpaque(true);
		btnRechazar.setContentAreaFilled(true);
		btnRechazar.setBorderPainted(true);
		btnRechazar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRechazar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnRechazar.setPreferredSize(new Dimension(105, 30));
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
		lblUsuario2.setForeground(COLOR_LETRAS);
		lblUsuario2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario2.setPreferredSize(new Dimension(180, 30));
		lblUsuario2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblUsuario2);

		JButton btnVerPerfil2 = new JButton("Ver perfil");
		btnVerPerfil2.setUI(new BasicButtonUI());
		btnVerPerfil2.setBackground(COLOR_FONDO_MAIN);
		btnVerPerfil2.setForeground(COLOR_LETRAS);
		btnVerPerfil2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerPerfil2.setFocusPainted(false);
		btnVerPerfil2.setOpaque(true);
		btnVerPerfil2.setContentAreaFilled(true);
		btnVerPerfil2.setBorderPainted(true);
		btnVerPerfil2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVerPerfil2.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnVerPerfil2.setPreferredSize(new Dimension(105, 30));
		panel_2.add(btnVerPerfil2);

		JButton btnAceptar2 = new JButton("Aceptar");
		btnAceptar2.setUI(new BasicButtonUI());
		btnAceptar2.setBackground(COLOR_FONDO_MAIN);
		btnAceptar2.setForeground(COLOR_LETRAS);
		btnAceptar2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar2.setFocusPainted(false);
		btnAceptar2.setOpaque(true);
		btnAceptar2.setContentAreaFilled(true);
		btnAceptar2.setBorderPainted(true);
		btnAceptar2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAceptar2.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnAceptar2.setPreferredSize(new Dimension(105, 30));
		panel_2.add(btnAceptar2);

		JButton btnRechazar2 = new JButton("Rechazar");
		btnRechazar2.setUI(new BasicButtonUI());
		btnRechazar2.setBackground(COLOR_FONDO_MAIN);
		btnRechazar2.setForeground(COLOR_LETRAS);
		btnRechazar2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechazar2.setFocusPainted(false);
		btnRechazar2.setOpaque(true);
		btnRechazar2.setContentAreaFilled(true);
		btnRechazar2.setBorderPainted(true);
		btnRechazar2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRechazar2.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnRechazar2.setPreferredSize(new Dimension(105, 30));
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
		lblUsuario3.setForeground(COLOR_LETRAS);
		lblUsuario3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario3.setPreferredSize(new Dimension(180, 30));
		lblUsuario3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblUsuario3);

		JButton btnVerPerfil3 = new JButton("Ver perfil");
		btnVerPerfil3.setUI(new BasicButtonUI());
		btnVerPerfil3.setBackground(COLOR_FONDO_MAIN);
		btnVerPerfil3.setForeground(COLOR_LETRAS);
		btnVerPerfil3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerPerfil3.setFocusPainted(false);
		btnVerPerfil3.setOpaque(true);
		btnVerPerfil3.setContentAreaFilled(true);
		btnVerPerfil3.setBorderPainted(true);
		btnVerPerfil3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVerPerfil3.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnVerPerfil3.setPreferredSize(new Dimension(105, 30));
		panel_3.add(btnVerPerfil3);

		JButton btnAceptar3 = new JButton("Aceptar");
		btnAceptar3.setUI(new BasicButtonUI());
		btnAceptar3.setBackground(COLOR_FONDO_MAIN);
		btnAceptar3.setForeground(COLOR_LETRAS);
		btnAceptar3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar3.setFocusPainted(false);
		btnAceptar3.setOpaque(true);
		btnAceptar3.setContentAreaFilled(true);
		btnAceptar3.setBorderPainted(true);
		btnAceptar3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAceptar3.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnAceptar3.setPreferredSize(new Dimension(105, 30));
		panel_3.add(btnAceptar3);

		JButton btnRechazar3 = new JButton("Rechazar");
		btnRechazar3.setUI(new BasicButtonUI());
		btnRechazar3.setBackground(COLOR_FONDO_MAIN);
		btnRechazar3.setForeground(COLOR_LETRAS);
		btnRechazar3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechazar3.setFocusPainted(false);
		btnRechazar3.setOpaque(true);
		btnRechazar3.setContentAreaFilled(true);
		btnRechazar3.setBorderPainted(true);
		btnRechazar3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRechazar3.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnRechazar3.setPreferredSize(new Dimension(105, 30));
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
		lblUsuario4.setForeground(COLOR_LETRAS);
		lblUsuario4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario4.setPreferredSize(new Dimension(180, 30));
		lblUsuario4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblUsuario4);

		JButton btnVerPerfil4 = new JButton("Ver perfil");
		btnVerPerfil4.setUI(new BasicButtonUI());
		btnVerPerfil4.setBackground(COLOR_FONDO_MAIN);
		btnVerPerfil4.setForeground(COLOR_LETRAS);
		btnVerPerfil4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerPerfil4.setFocusPainted(false);
		btnVerPerfil4.setOpaque(true);
		btnVerPerfil4.setContentAreaFilled(true);
		btnVerPerfil4.setBorderPainted(true);
		btnVerPerfil4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVerPerfil4.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnVerPerfil4.setPreferredSize(new Dimension(105, 30));
		panel_4.add(btnVerPerfil4);

		JButton btnAceptar4 = new JButton("Aceptar");
		btnAceptar4.setUI(new BasicButtonUI());
		btnAceptar4.setBackground(COLOR_FONDO_MAIN);
		btnAceptar4.setForeground(COLOR_LETRAS);
		btnAceptar4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar4.setFocusPainted(false);
		btnAceptar4.setOpaque(true);
		btnAceptar4.setContentAreaFilled(true);
		btnAceptar4.setBorderPainted(true);
		btnAceptar4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAceptar4.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnAceptar4.setPreferredSize(new Dimension(105, 30));
		panel_4.add(btnAceptar4);

		JButton btnRechazar4 = new JButton("Rechazar");
		btnRechazar4.setUI(new BasicButtonUI());
		btnRechazar4.setBackground(COLOR_FONDO_MAIN);
		btnRechazar4.setForeground(COLOR_LETRAS);
		btnRechazar4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechazar4.setFocusPainted(false);
		btnRechazar4.setOpaque(true);
		btnRechazar4.setContentAreaFilled(true);
		btnRechazar4.setBorderPainted(true);
		btnRechazar4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRechazar4.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnRechazar4.setPreferredSize(new Dimension(105, 30));
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
		lblUsuario5.setForeground(COLOR_LETRAS);
		lblUsuario5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario5.setPreferredSize(new Dimension(180, 30));
		lblUsuario5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblUsuario5);

		JButton btnVerPerfil5 = new JButton("Ver perfil");
		btnVerPerfil5.setUI(new BasicButtonUI());
		btnVerPerfil5.setBackground(COLOR_FONDO_MAIN);
		btnVerPerfil5.setForeground(COLOR_LETRAS);
		btnVerPerfil5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerPerfil5.setFocusPainted(false);
		btnVerPerfil5.setOpaque(true);
		btnVerPerfil5.setContentAreaFilled(true);
		btnVerPerfil5.setBorderPainted(true);
		btnVerPerfil5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVerPerfil5.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnVerPerfil5.setPreferredSize(new Dimension(105, 30));
		panel_5.add(btnVerPerfil5);

		JButton btnAceptar5 = new JButton("Aceptar");
		btnAceptar5.setUI(new BasicButtonUI());
		btnAceptar5.setBackground(COLOR_FONDO_MAIN);
		btnAceptar5.setForeground(COLOR_LETRAS);
		btnAceptar5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar5.setFocusPainted(false);
		btnAceptar5.setOpaque(true);
		btnAceptar5.setContentAreaFilled(true);
		btnAceptar5.setBorderPainted(true);
		btnAceptar5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAceptar5.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnAceptar5.setPreferredSize(new Dimension(105, 30));
		panel_5.add(btnAceptar5);

		JButton btnRechazar5 = new JButton("Rechazar");
		btnRechazar5.setUI(new BasicButtonUI());
		btnRechazar5.setBackground(COLOR_FONDO_MAIN);
		btnRechazar5.setForeground(COLOR_LETRAS);
		btnRechazar5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechazar5.setFocusPainted(false);
		btnRechazar5.setOpaque(true);
		btnRechazar5.setContentAreaFilled(true);
		btnRechazar5.setBorderPainted(true);
		btnRechazar5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRechazar5.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnRechazar5.setPreferredSize(new Dimension(105, 30));
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
		lblUsuario6.setForeground(COLOR_LETRAS);
		lblUsuario6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario6.setPreferredSize(new Dimension(180, 30));
		lblUsuario6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblUsuario6);

		JButton btnVerPerfil6 = new JButton("Ver perfil");
		btnVerPerfil6.setUI(new BasicButtonUI());
		btnVerPerfil6.setBackground(COLOR_FONDO_MAIN);
		btnVerPerfil6.setForeground(COLOR_LETRAS);
		btnVerPerfil6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerPerfil6.setFocusPainted(false);
		btnVerPerfil6.setOpaque(true);
		btnVerPerfil6.setContentAreaFilled(true);
		btnVerPerfil6.setBorderPainted(true);
		btnVerPerfil6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVerPerfil6.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnVerPerfil6.setPreferredSize(new Dimension(105, 30));
		panel_6.add(btnVerPerfil6);

		JButton btnAceptar6 = new JButton("Aceptar");
		btnAceptar6.setUI(new BasicButtonUI());
		btnAceptar6.setBackground(COLOR_FONDO_MAIN);
		btnAceptar6.setForeground(COLOR_LETRAS);
		btnAceptar6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar6.setFocusPainted(false);
		btnAceptar6.setOpaque(true);
		btnAceptar6.setContentAreaFilled(true);
		btnAceptar6.setBorderPainted(true);
		btnAceptar6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAceptar6.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnAceptar6.setPreferredSize(new Dimension(105, 30));
		panel_6.add(btnAceptar6);

		JButton btnRechazar6 = new JButton("Rechazar");
		btnRechazar6.setUI(new BasicButtonUI());
		btnRechazar6.setBackground(COLOR_FONDO_MAIN);
		btnRechazar6.setForeground(COLOR_LETRAS);
		btnRechazar6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechazar6.setFocusPainted(false);
		btnRechazar6.setOpaque(true);
		btnRechazar6.setContentAreaFilled(true);
		btnRechazar6.setBorderPainted(true);
		btnRechazar6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRechazar6.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnRechazar6.setPreferredSize(new Dimension(105, 30));
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
		lblUsuario7.setForeground(COLOR_LETRAS);
		lblUsuario7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario7.setPreferredSize(new Dimension(180, 30));
		lblUsuario7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_7.add(lblUsuario7);

		JButton btnVerPerfil7 = new JButton("Ver perfil");
		btnVerPerfil7.setUI(new BasicButtonUI());
		btnVerPerfil7.setBackground(COLOR_FONDO_MAIN);
		btnVerPerfil7.setForeground(COLOR_LETRAS);
		btnVerPerfil7.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerPerfil7.setFocusPainted(false);
		btnVerPerfil7.setOpaque(true);
		btnVerPerfil7.setContentAreaFilled(true);
		btnVerPerfil7.setBorderPainted(true);
		btnVerPerfil7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVerPerfil7.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnVerPerfil7.setPreferredSize(new Dimension(105, 30));
		panel_7.add(btnVerPerfil7);

		JButton btnAceptar7 = new JButton("Aceptar");
		btnAceptar7.setUI(new BasicButtonUI());
		btnAceptar7.setBackground(COLOR_FONDO_MAIN);
		btnAceptar7.setForeground(COLOR_LETRAS);
		btnAceptar7.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar7.setFocusPainted(false);
		btnAceptar7.setOpaque(true);
		btnAceptar7.setContentAreaFilled(true);
		btnAceptar7.setBorderPainted(true);
		btnAceptar7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAceptar7.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnAceptar7.setPreferredSize(new Dimension(105, 30));
		panel_7.add(btnAceptar7);

		JButton btnRechazar7 = new JButton("Rechazar");
		btnRechazar7.setUI(new BasicButtonUI());
		btnRechazar7.setBackground(COLOR_FONDO_MAIN);
		btnRechazar7.setForeground(COLOR_LETRAS);
		btnRechazar7.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechazar7.setFocusPainted(false);
		btnRechazar7.setOpaque(true);
		btnRechazar7.setContentAreaFilled(true);
		btnRechazar7.setBorderPainted(true);
		btnRechazar7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRechazar7.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnRechazar7.setPreferredSize(new Dimension(105, 30));
		panel_7.add(btnRechazar7);
		
		// Panel inferior con botón cerrar
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(COLOR_FONDO_MAIN);
		getContentPane().add(panelInferior, BorderLayout.SOUTH);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setUI(new BasicButtonUI());
		btnCerrar.setBackground(COLOR_FONDO_MAIN);
		btnCerrar.setForeground(COLOR_LETRAS);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.setFocusPainted(false);
		btnCerrar.setOpaque(true);
		btnCerrar.setContentAreaFilled(true);
		btnCerrar.setBorderPainted(true);
		btnCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCerrar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		btnCerrar.setPreferredSize(new Dimension(105, 30));
		panelInferior.add(btnCerrar);

		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitudesDeAmistad frame = new SolicitudesDeAmistad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
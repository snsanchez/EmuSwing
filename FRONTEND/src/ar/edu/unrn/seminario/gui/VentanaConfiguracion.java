package ar.edu.unrn.seminario.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class VentanaConfiguracion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelLateral;
	private JPanel panelPrincipal;
	
	public static final Color FONDO_OSCURO = new Color(35, 15, 45);
	public static final Color FONDO_CLARO  = new Color(74, 36, 92);
	public static final Color COLOR_BORDE  = new Color(169, 65, 196);
	public static final Color COLOR_TEXTO  = new Color(245, 240, 247);
	
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfiguracion frame = new VentanaConfiguracion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaConfiguracion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 767, 452);
		
		contentPane = new JPanel();
		contentPane.setBackground(FONDO_OSCURO);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelLateral = new JPanel();
		panelLateral.setBackground(FONDO_OSCURO);
		panelLateral.setBorder(new LineBorder(COLOR_BORDE, 1));
		panelLateral.setBounds(10, 10, 160, 451);
		contentPane.add(panelLateral);
		panelLateral.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONFIGURACION");
		lblNewLabel.setForeground(COLOR_TEXTO);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 15, 120, 14);
		panelLateral.add(lblNewLabel);
		
		JButton btnSuscripcion = new JButton("Suscripción");
		btnSuscripcion.setBackground(FONDO_CLARO);
		btnSuscripcion.setForeground(COLOR_TEXTO);
		btnSuscripcion.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnSuscripcion.setFocusPainted(false);
		btnSuscripcion.setBounds(10, 45, 140, 35);
		panelLateral.add(btnSuscripcion);
		
		JButton btnSonido = new JButton("Sonido");
		btnSonido.setBackground(FONDO_CLARO);
		btnSonido.setForeground(COLOR_TEXTO);
		btnSonido.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnSonido.setFocusPainted(false);
		btnSonido.setBounds(10, 95, 140, 35);
		panelLateral.add(btnSonido);
		
		JButton btnEmulador = new JButton("Emulador");
		btnEmulador.setBackground(FONDO_CLARO);
		btnEmulador.setForeground(COLOR_TEXTO);
		btnEmulador.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnEmulador.setFocusPainted(false);
		btnEmulador.setBounds(10, 145, 140, 35);
		panelLateral.add(btnEmulador);
		
		JButton btnNewButton_1 = new JButton("Control Parental");
		btnNewButton_1.setBackground(FONDO_CLARO);
		btnNewButton_1.setForeground(COLOR_TEXTO);
		btnNewButton_1.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBounds(10, 195, 140, 35);
		panelLateral.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Por Defecto");
		btnNewButton_2.setBackground(FONDO_CLARO);
		btnNewButton_2.setForeground(COLOR_TEXTO);
		btnNewButton_2.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBounds(10, 245, 140, 35);
		panelLateral.add(btnNewButton_2);

		// AGREGADO: Botón lateral para Cerrar Sesión
		JButton btnNewButton_9 = new JButton("Cerrar Sesión");
		btnNewButton_9.setBackground(FONDO_CLARO);
		btnNewButton_9.setForeground(COLOR_TEXTO);
		btnNewButton_9.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton_9.setFocusPainted(false);
		btnNewButton_9.setBounds(10, 295, 140, 35);
		panelLateral.add(btnNewButton_9);

		// AGREGADO: Botón lateral para Cancelar Suscripción
		JButton btnNewButton_10 = new JButton("Cancelar Susc.");
		btnNewButton_10.setBackground(FONDO_CLARO);
		btnNewButton_10.setForeground(COLOR_TEXTO);
		btnNewButton_10.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton_10.setFocusPainted(false);
		btnNewButton_10.setBounds(10, 345, 140, 35);
		panelLateral.add(btnNewButton_10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(FONDO_OSCURO);
		scrollPane.getViewport().setBackground(FONDO_OSCURO);
		scrollPane.setBorder(new LineBorder(COLOR_BORDE, 1));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBounds(180, 10, 561, 392);
		contentPane.add(scrollPane);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(FONDO_OSCURO);
		panelPrincipal.setPreferredSize(new Dimension(520, 893));
		scrollPane.setViewportView(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(FONDO_CLARO);
		panel_1.setBorder(BorderFactory.createTitledBorder(new LineBorder(COLOR_BORDE, 1), "Plan & Suscripción", TitledBorder.LEADING, TitledBorder.TOP, null, COLOR_TEXTO));
		panel_1.setBounds(15, 15, 490, 130);
		panelPrincipal.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("EmuSwing Premium");
		lblNewLabel_2.setForeground(COLOR_TEXTO);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(15, 25, 200, 20);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Desbloqueá partidas en la nube, cero anuncios y juego online sin límites.");
		lblNewLabel_3.setForeground(COLOR_TEXTO);
		lblNewLabel_3.setBounds(15, 50, 460, 15);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("¡Mejorar a Premium por solo $0,99/mes!");
		btnNewButton_3.setBackground(new Color(130, 40, 150));
		btnNewButton_3.setForeground(COLOR_TEXTO);
		btnNewButton_3.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBounds(15, 80, 460, 32);
		panel_1.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(FONDO_CLARO);
		panel.setBorder(BorderFactory.createTitledBorder(new LineBorder(COLOR_BORDE, 1), "Sonido del Emulador", TitledBorder.LEADING, TitledBorder.TOP, null, COLOR_TEXTO));
		panel.setBounds(15, 155, 490, 115);
		panelPrincipal.add(panel);
		panel.setLayout(null);
		
		JSlider sliderVolumen = new JSlider();
		sliderVolumen.setBackground(FONDO_CLARO);
		sliderVolumen.setForeground(COLOR_TEXTO);
		sliderVolumen.setPaintTicks(true);
		sliderVolumen.setMajorTickSpacing(25);
		sliderVolumen.setValue(70);
		sliderVolumen.setBounds(15, 40, 460, 35);
		panel.add(sliderVolumen);
		
		lblNewLabel_1 = new JLabel("Volumen: 70%");
		lblNewLabel_1.setForeground(COLOR_TEXTO);
		lblNewLabel_1.setBounds(380, 20, 95, 14);
		panel.add(lblNewLabel_1);
		
		JCheckBox chckbxMute = new JCheckBox("Silenciar Volumen");
		chckbxMute.setBackground(FONDO_CLARO);
		chckbxMute.setForeground(COLOR_TEXTO);
		chckbxMute.setFocusPainted(false);
		chckbxMute.setBounds(15, 80, 150, 23);
		panel.add(chckbxMute);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(FONDO_CLARO);
		panel_2.setBorder(BorderFactory.createTitledBorder(new LineBorder(COLOR_BORDE, 1), "Ruta del Ejecutable", TitledBorder.LEADING, TitledBorder.TOP, null, COLOR_TEXTO));
		panel_2.setBounds(15, 280, 490, 100);
		panelPrincipal.add(panel_2);
		panel_2.setLayout(null);
		
		JTextField txtRutaEmulador = new JTextField();
		txtRutaEmulador.setBackground(Color.WHITE);
		txtRutaEmulador.setForeground(Color.BLACK);
		txtRutaEmulador.setBorder(new LineBorder(COLOR_BORDE, 1));
		txtRutaEmulador.setText("C:\\Emulador\\JavaSwing.exe");
		txtRutaEmulador.setBounds(15, 30, 355, 25);
		panel_2.add(txtRutaEmulador);
		
		JButton btnNewButton = new JButton("Examinar");
		btnNewButton.setBackground(FONDO_OSCURO);
		btnNewButton.setForeground(COLOR_TEXTO);
		btnNewButton.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(380, 30, 95, 25);
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(FONDO_CLARO);
		panel_3.setBorder(BorderFactory.createTitledBorder(new LineBorder(COLOR_BORDE, 1), "Control Parental", TitledBorder.LEADING, TitledBorder.TOP, null, COLOR_TEXTO));
		panel_3.setBounds(15, 390, 490, 95);
		panelPrincipal.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Establecé un límite diario de horas de juego");
		lblNewLabel_4.setForeground(COLOR_TEXTO);
		lblNewLabel_4.setBounds(15, 25, 300, 14);
		panel_3.add(lblNewLabel_4);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLACK);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sin límite", "1 hora al día", "2 horas al día", "3 horas al día"}));
		comboBox.setBounds(330, 45, 145, 25);
		panel_3.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(FONDO_CLARO);
		panel_4.setBorder(BorderFactory.createTitledBorder(new LineBorder(COLOR_BORDE, 1), "Establecer Configuración por Defecto", TitledBorder.LEADING, TitledBorder.TOP, null, COLOR_TEXTO));
		panel_4.setBounds(15, 495, 490, 75);
		panelPrincipal.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Se restablecerán todas las configuraciones por defecto");
		lblNewLabel_5.setForeground(COLOR_TEXTO);
		lblNewLabel_5.setBounds(15, 30, 320, 14);
		panel_4.add(lblNewLabel_5);
		
		JButton btnNewButton_6 = new JButton("Restablecer");
		btnNewButton_6.setBackground(FONDO_OSCURO);
		btnNewButton_6.setForeground(COLOR_TEXTO);
		btnNewButton_6.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton_6.setFocusPainted(false);
		btnNewButton_6.setBounds(350, 25, 125, 25);
		panel_4.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("Cancelar");
		btnNewButton_5.setBackground(FONDO_OSCURO);
		btnNewButton_5.setForeground(COLOR_TEXTO);
		btnNewButton_5.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.setBounds(245, 807, 110, 28);
		panelPrincipal.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Aplicar Cambios");
		btnNewButton_4.setBackground(FONDO_OSCURO);
		btnNewButton_4.setForeground(COLOR_TEXTO);
		btnNewButton_4.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setBounds(365, 807, 140, 28);
		panelPrincipal.add(btnNewButton_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(FONDO_CLARO);
		panel_5.setBorder(BorderFactory.createTitledBorder(new LineBorder(COLOR_BORDE, 1), "Cerrar Sesion", TitledBorder.LEADING, TitledBorder.TOP, null, COLOR_TEXTO));
		panel_5.setBounds(15, 586, 490, 76);
		panelPrincipal.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Se cerrara la sesion actual");
		lblNewLabel_6.setForeground(COLOR_TEXTO);
		lblNewLabel_6.setBounds(10, 31, 149, 14);
		panel_5.add(lblNewLabel_6);
		
		JButton btnNewButton_7 = new JButton("Cerrar Sesion");
		btnNewButton_7.setBackground(FONDO_OSCURO);
		btnNewButton_7.setForeground(COLOR_TEXTO);
		btnNewButton_7.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton_7.setFocusPainted(false);
		btnNewButton_7.setBounds(318, 42, 162, 23);
		panel_5.add(btnNewButton_7);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(FONDO_CLARO);
		panel_6.setBorder(BorderFactory.createTitledBorder(new LineBorder(COLOR_BORDE, 1), "Cancelar Suscripcion Premium", TitledBorder.LEADING, TitledBorder.TOP, null, COLOR_TEXTO));
		panel_6.setBounds(15, 686, 490, 75);
		panelPrincipal.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Se cancleara la suscripcion automaticamente");
		lblNewLabel_7.setForeground(COLOR_TEXTO);
		lblNewLabel_7.setBounds(10, 29, 263, 14);
		panel_6.add(lblNewLabel_7);
		
		JButton btnNewButton_8 = new JButton("Cancelar Suscripcion");
		btnNewButton_8.setBackground(FONDO_OSCURO);
		btnNewButton_8.setForeground(COLOR_TEXTO);
		btnNewButton_8.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton_8.setFocusPainted(false);
		btnNewButton_8.setBounds(324, 41, 156, 23);
		panel_6.add(btnNewButton_8);
	}
}
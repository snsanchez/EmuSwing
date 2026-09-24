package ar.edu.unrn.seminario.gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaConfiguracion extends JFrame {

	private JPanel contentPane;
	private JPanel panelLateral;
	private JPanel panelPrincipal;
	private JButton btnSonido;
	private JButton btnEmulador;
	private JButton btnSuscripcion;
	private JTextField txtRutaEmulador;

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
		setTitle("\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 744, 488);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); // Layout libre general

		// Panel lateral con layout libre
		panelLateral = new JPanel();
		panelLateral.setBounds(10, 10, 160, 440);
		panelLateral.setBackground(new Color(230, 230, 230));
		panelLateral.setLayout(null); // Layout libre adentro
		contentPane.add(panelLateral);

		// Botones con posición y tamaño libre inicial
		btnSonido = new JButton("Sonido");
		btnSonido.setBounds(10, 82, 140, 35);
		panelLateral.add(btnSonido);

		btnEmulador = new JButton("Emulador");
		btnEmulador.setBounds(10, 128, 140, 35);
		panelLateral.add(btnEmulador);

		btnSuscripcion = new JButton("Suscripción");
		btnSuscripcion.setBounds(10, 33, 140, 35);
		panelLateral.add(btnSuscripcion);
		
		JLabel lblNewLabel = new JLabel("CONFIGURACION");
		lblNewLabel.setBounds(33, 8, 98, 14);
		panelLateral.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Control Parental");
		btnNewButton_1.setBounds(10, 174, 140, 35);
		panelLateral.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Restablecer Configuracion");
		btnNewButton_2.setBounds(0, 362, 160, 35);
		panelLateral.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		scrollPane.setBounds(180, 10, 548, 440);
		contentPane.add(scrollPane);

		// Panel principal con layout libre
		panelPrincipal = new JPanel();
		panelPrincipal.setPreferredSize(new java.awt.Dimension(520, 650));
		scrollPane.setViewportView(panelPrincipal);
		panelPrincipal.setBackground(new Color(245, 245, 245));
		panelPrincipal.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Sonido del Emulador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(37, 146, 454, 116);
		panelPrincipal.add(panel);
		panel.setLayout(null);
		
		JSlider sliderVolumen = new JSlider();
		sliderVolumen.setPaintTicks(true);
		sliderVolumen.setMinorTickSpacing(25);
		sliderVolumen.setMajorTickSpacing(25);
		sliderVolumen.setValue(70);
		sliderVolumen.setBounds(10, 48, 434, 31);
		panel.add(sliderVolumen);
		
		JLabel lblNewLabel_1 = new JLabel("Volumen: ");
		lblNewLabel_1.setBounds(335, 11, 60, 14);
		panel.add(lblNewLabel_1);
		
		JCheckBox chckbxMute = new JCheckBox("Silenciar Volumen");
		chckbxMute.setBounds(10, 86, 142, 23);
		panel.add(chckbxMute);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Plan & Suscripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(37, 11, 454, 116);
		panelPrincipal.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("EmuSwing Premium ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 21, 149, 20);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Desbloqueá partidas en la nube, cero anuncios y juego online sin límites.");
		lblNewLabel_3.setBounds(10, 40, 358, 34);
		panel_1.add(lblNewLabel_3);
		
		JButton btnSuscribirse = new JButton("¡Mejorar a Premium por solo $0,99/mes!");
		btnSuscribirse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSuscribirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSuscribirse.setBounds(10, 85, 434, 20);
		panel_1.add(btnSuscribirse);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ruta del Ejecutable", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(37, 291, 454, 94);
		panelPrincipal.add(panel_2);
		panel_2.setLayout(null);
		
		txtRutaEmulador = new JTextField();
		txtRutaEmulador.setText("C:\\Emulador\\JavaSwing.exe");
		txtRutaEmulador.setBounds(10, 34, 434, 20);
		panel_2.add(txtRutaEmulador);
		txtRutaEmulador.setColumns(10);
		
		JButton btnNewButton = new JButton("Examinar");
		btnNewButton.setBounds(345, 65, 99, 23);
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Control Parental", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(37, 404, 454, 83);
		panelPrincipal.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Establecé un límite diario de horas de juego.");
		lblNewLabel_4.setBounds(10, 21, 377, 28);
		panel_3.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sin límite", "1 hora al día", "2 horas al día", "3 horas al día"}));
		comboBox.setBounds(307, 50, 105, 22);
		panel_3.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Establecer Configuracion por Defecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(37, 513, 454, 54);
		panelPrincipal.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Se estableceran todas las configuraciones por defecto");
		lblNewLabel_5.setBounds(10, 23, 319, 14);
		panel_4.add(lblNewLabel_5);
		
		JButton btnNewButton_3 = new JButton("Restablecer");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(339, 19, 105, 23);
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Aplicar Cambios");
		btnNewButton_4.setBounds(379, 605, 141, 23);
		panelPrincipal.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Cancelar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(280, 605, 89, 23);
		panelPrincipal.add(btnNewButton_5);
	}
}
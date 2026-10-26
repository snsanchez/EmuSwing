package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicButtonUI;

public class GestionarSuscripcion {

	private JFrame frame;

	private final Color COLOR_FONDO_MAIN = new Color(35, 15, 45);
	private final Color COLOR_PANEL_BOX = new Color(74, 36, 92);
	private final Color COLOR_BORDE_NEON = new Color(169, 65, 196);
	private final Color COLOR_LETRAS = new Color(245, 240, 247);

	private JComboBox<String> comboDuracion;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JComboBox<String> comboMedioPago;
	private JTextField txtNumeroTarjeta;
	private JTextField txtTitular;
	private JTextField txtVencimiento;
	private JPasswordField txtCodigoSeguridad;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionarSuscripcion window = new GestionarSuscripcion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GestionarSuscripcion() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gestionar suscripción");
		frame.setBounds(100, 100, 850, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().setBackground(COLOR_FONDO_MAIN);

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(COLOR_FONDO_MAIN);
		panelSuperior.setBorder(BorderFactory.createEmptyBorder(20, 0, 15, 0));
		frame.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));

		JLabel lblTitulo = new JLabel("GESTIONAR SUSCRIPCIÓN");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("OCR A Extended", Font.BOLD, 28));
		panelSuperior.add(lblTitulo, BorderLayout.NORTH);

		JLabel lblSubtitulo = new JLabel("Completá tus datos para activar tu suscripción");
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setForeground(COLOR_BORDE_NEON);
		lblSubtitulo.setFont(new Font("Tahoma", Font.ITALIC, 16));
		panelSuperior.add(lblSubtitulo, BorderLayout.SOUTH);

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(COLOR_FONDO_MAIN);
		panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		JPanel panelFormulario = new JPanel();
		panelFormulario.setBackground(COLOR_PANEL_BOX);
		panelFormulario.setPreferredSize(new Dimension(580, 360));
		panelFormulario.setLayout(new GridLayout(9, 2, 10, 10));

		TitledBorder bordeFormulario = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON),
				"Datos de suscripción"
		);
		bordeFormulario.setTitleColor(COLOR_LETRAS);

		panelFormulario.setBorder(BorderFactory.createCompoundBorder(
				bordeFormulario,
				BorderFactory.createEmptyBorder(20, 35, 20, 35)
		));

		panelCentral.add(panelFormulario);

		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracion.setForeground(COLOR_LETRAS);
		lblDuracion.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblDuracion);

		comboDuracion = new JComboBox<String>();
		comboDuracion.addItem("1 mes - USD 0,99");
		comboDuracion.addItem("3 meses - USD 2,82 (5% descuento)");
		comboDuracion.addItem("6 meses - USD 5,35 (10% descuento)");
		comboDuracion.addItem("1 año - USD 10,10 (15% descuento)");
		panelFormulario.add(comboDuracion);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setForeground(COLOR_LETRAS);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		panelFormulario.add(txtNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setForeground(COLOR_LETRAS);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		panelFormulario.add(txtApellido);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(COLOR_LETRAS);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		panelFormulario.add(txtEmail);

		JLabel lblMedioPago = new JLabel("Medio de pago:");
		lblMedioPago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMedioPago.setForeground(COLOR_LETRAS);
		lblMedioPago.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblMedioPago);

		comboMedioPago = new JComboBox<String>();
		comboMedioPago.addItem("Tarjeta de crédito");
		comboMedioPago.addItem("Tarjeta de débito");
		comboMedioPago.addItem("Mercado Pago");
		comboMedioPago.addItem("Transferencia");
		panelFormulario.add(comboMedioPago);

		JLabel lblNumeroTarjeta = new JLabel("Número de tarjeta:");
		lblNumeroTarjeta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTarjeta.setForeground(COLOR_LETRAS);
		lblNumeroTarjeta.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblNumeroTarjeta);

		txtNumeroTarjeta = new JTextField();
		txtNumeroTarjeta.setColumns(10);
		panelFormulario.add(txtNumeroTarjeta);

		JLabel lblTitular = new JLabel("Titular:");
		lblTitular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitular.setForeground(COLOR_LETRAS);
		lblTitular.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblTitular);

		txtTitular = new JTextField();
		txtTitular.setColumns(10);
		panelFormulario.add(txtTitular);

		JLabel lblVencimiento = new JLabel("Vencimiento:");
		lblVencimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVencimiento.setForeground(COLOR_LETRAS);
		lblVencimiento.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblVencimiento);

		txtVencimiento = new JTextField();
		txtVencimiento.setColumns(10);
		panelFormulario.add(txtVencimiento);

		JLabel lblCodigoSeguridad = new JLabel("Código de seguridad:");
		lblCodigoSeguridad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoSeguridad.setForeground(COLOR_LETRAS);
		lblCodigoSeguridad.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblCodigoSeguridad);

		txtCodigoSeguridad = new JPasswordField();
		panelFormulario.add(txtCodigoSeguridad);

		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(COLOR_FONDO_MAIN);
		frame.getContentPane().add(panelInferior, BorderLayout.SOUTH);

		JButton btnConfirmar = new JButton("Confirmar pago");
		btnConfirmar.setUI(new BasicButtonUI());
		btnConfirmar.setBackground(COLOR_FONDO_MAIN);
		btnConfirmar.setForeground(COLOR_LETRAS);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setFocusPainted(false);
		btnConfirmar.setOpaque(true);
		btnConfirmar.setContentAreaFilled(true);
		btnConfirmar.setBorderPainted(true);
		btnConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConfirmar.setPreferredSize(new Dimension(150, 30));
		btnConfirmar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		panelInferior.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setUI(new BasicButtonUI());
		btnCancelar.setBackground(COLOR_FONDO_MAIN);
		btnCancelar.setForeground(COLOR_LETRAS);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setContentAreaFilled(true);
		btnCancelar.setBorderPainted(true);
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancelar.setPreferredSize(new Dimension(150, 30));
		btnCancelar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)
		));
		panelInferior.add(btnCancelar);

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Pago solicitado correctamente");
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}